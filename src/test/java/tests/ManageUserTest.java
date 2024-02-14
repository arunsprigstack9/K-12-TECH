package tests;

import base.BaseTest;
import objects.UserDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ManageUserPage;
import utils.JacksonUtils;

import java.io.IOException;

public class ManageUserTest extends BaseTest {

    @Test
    public void addNewUser() throws IOException, InterruptedException {
        ManageUserPage manageUserPage = new ManageUserPage(driver);
        manageUserPage.clickOnDeviceUser().clickOnManageUsers().clickOnAddUser();
        UserDetails userDetails = JacksonUtils.deserializeJson("userdetails1.json", UserDetails.class);
        manageUserPage.enterFirstName(userDetails.getFname()).
                enterMiddleName(userDetails.getMiddlename()).
                enterLastName(userDetails.getLname()).
                enterStudentID(userDetails.getUserid()).
                enterGrade(userDetails.getGrade()).
                enterGuardianEmail(userDetails.getParentemail()).
                enterGuardianName(userDetails.getParentname()).
                enterPhoneNumber(userDetails.getParentnumber());

        //enter Parentel coverage
        driver.findElement(By.cssSelector("div[class='form-check ms-5'] input[name='ParentalCoverage']")).click();
        //click save user
        manageUserPage.clickSaveUser();


    }

    @Test
    public void checkUserexistsAlready() throws IOException, InterruptedException {
        ManageUserPage manageUserPage = new ManageUserPage(driver);
        manageUserPage.clickOnDeviceUser().clickOnManageUsers().clickOnAddUser();
        UserDetails userDetails = JacksonUtils.deserializeJson("userdetails.json", UserDetails.class);
        manageUserPage.enterFirstName(userDetails.getFname()).
                enterMiddleName(userDetails.getMiddlename()).
                enterLastName(userDetails.getLname()).
                enterStudentID(userDetails.getUserid()).
                enterGrade(userDetails.getGrade()).
                enterGuardianEmail(userDetails.getParentemail()).
                enterGuardianName(userDetails.getParentname()).
                enterPhoneNumber(userDetails.getParentnumber());

        //enter Parentel coverage
        driver.findElement(By.cssSelector("div[class='form-check ms-5'] input[name='ParentalCoverage']")).click();
        //click save user
        manageUserPage.clickSaveUser();
        Thread.sleep(3000);
        String alertMessage = driver.findElement(By.cssSelector("div[role='alert']")).getText();
        Assert.assertEquals(alertMessage, "Student Number already exists");


    }

    @Test
    public void editUser() throws InterruptedException, IOException {
        String utilizerid="35368";
        ManageUserPage manageUserPage = new ManageUserPage(driver);
        manageUserPage.clickOnDeviceUser().clickOnManageUsers();
        //waiting for users to load
        Thread.sleep(3000);
        //click on user to edit
        driver.findElement(By.cssSelector("img[utilizerid$='"+utilizerid+"']:nth-child(1)")).click();
        Thread.sleep(3000);
        //filing user details
        UserDetails userDetails = JacksonUtils.deserializeJson("userdetails1.json", UserDetails.class);
        manageUserPage.enterFirstName(userDetails.getFname()).
                enterMiddleName(userDetails.getMiddlename()).
                enterLastName(userDetails.getLname()).
                enterStudentID(userDetails.getUserid()).
                enterGrade(userDetails.getGrade()).
                enterGuardianEmail(userDetails.getParentemail()).
                enterGuardianName(userDetails.getParentname()).
                enterPhoneNumber(userDetails.getParentnumber());
        //click on update user
        driver.findElement(By.cssSelector(".SaveBtn")).click();

    }

    @Test
    public void showUserDetails() throws InterruptedException {
        String utilizerid="35368";
        ManageUserPage manageUserPage = new ManageUserPage(driver);
        manageUserPage.clickOnDeviceUser().clickOnManageUsers();
        //waiting for users to load
        Thread.sleep(3000);
        //click on show user history
        driver.findElement(By.cssSelector("img[utilizerid$='"+utilizerid+"']:nth-child(3)")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='User History']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Parental Coverage History']")).click();
    }


    @Test
    public void attachDeviceToUser() throws InterruptedException {
        String utilizerid="35368";
        String deviceSerialno="D4";
        ManageUserPage manageUserPage = new ManageUserPage(driver);
        manageUserPage.clickOnDeviceUser().clickOnManageUsers();
        //waiting for users to load
        Thread.sleep(3000);
        //click on user to edit
        driver.findElement(By.cssSelector("img[utilizerid$='"+utilizerid+"']:nth-child(1)")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[normalize-space()='Attach a new Device']")).click();
        //waiting for attach new device popup
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[placeholder='Search Device']")).sendKeys(deviceSerialno, Keys.ENTER);
        //waiting for devices to appear
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("div[serialnumber$='"+deviceSerialno+"']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Attach Device']")).click();
        Thread.sleep(3000);

    }


   @Test
    public void deleteUserAttachedDevice() throws InterruptedException {
        String utilizeid="35368";
       ManageUserPage manageUserPage = new ManageUserPage(driver);
       manageUserPage.clickOnDeviceUser().clickOnManageUsers();
       Thread.sleep(3000);
       //click on user to edit
       driver.findElement(By.cssSelector("img[utilizerid$='"+utilizeid+"']:nth-child(1)")).click();
       Thread.sleep(3000);
       //delete attached device
       driver.findElement(By.cssSelector("img[title='Delete Device']")).click();
       Thread.sleep(3000);
       //confirm deletion
       driver.findElement(By.cssSelector(".deleteBtn")).click();
   }
    @Test
    public void deleteUser() throws InterruptedException {
        String utilizerid="35368";

        ManageUserPage manageUserPage = new ManageUserPage(driver);
        manageUserPage.clickOnDeviceUser().clickOnManageUsers();
        //waiting for users to load
        Thread.sleep(3000);
        //click on user to edit
        driver.findElement(By.cssSelector("img[utilizerid$='"+utilizerid+"']:nth-child(2)")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".deleteBtn")).click();
        Thread.sleep(3000);
    }


   @Test
    public void sortBy() throws InterruptedException {
       ManageUserPage manageUserPage = new ManageUserPage(driver);
       manageUserPage.clickOnDeviceUser().clickOnManageUsers();
       Thread.sleep(3000);
       //click on name
       driver.findElement(By.cssSelector("th[title$='Sort by Name']")).click();
       Thread.sleep(3000);
       //click on grade
       driver.findElement(By.cssSelector("th[title$='Sort by created at']")).click();
       Thread.sleep(3000);
       //click on device serial
//       driver.findElement(By.cssSelector("th[title$='Sort by']:nth-child(4)")).click();
//       Thread.sleep(3000);
   }
   @Test
    public void search() throws InterruptedException {
        String username="Aru";
       ManageUserPage manageUserPage = new ManageUserPage(driver);
       manageUserPage.clickOnDeviceUser().clickOnManageUsers();
       Thread.sleep(3000);
       driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(username,Keys.ENTER);


   }
   @Test
    public void paginaTion() throws InterruptedException {
       ManageUserPage manageUserPage = new ManageUserPage(driver);
       manageUserPage.clickOnDeviceUser().clickOnManageUsers();
       Thread.sleep(3000);
       driver.findElement(By.cssSelector("a[aria-label='Go to next page']")).click();
       Thread.sleep(3000);

   }
    @Test
    public void exportUsers() throws InterruptedException {
        ManageUserPage manageUserPage = new ManageUserPage(driver);
        manageUserPage.clickOnDeviceUser().clickOnManageUsers();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div[class='row my-2 pe-0 align-items-center'] div:nth-child(2)")).click();

    }
   @Test
    public void exportUsersHistory() throws InterruptedException {
       ManageUserPage manageUserPage = new ManageUserPage(driver);
       manageUserPage.clickOnDeviceUser().clickOnManageUsers();
       Thread.sleep(3000);
       driver.findElement(By.xpath("//div[normalize-space()='Export User History']")).click();

   }


}
