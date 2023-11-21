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
    public void addNewUser() throws IOException {
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

        //enetr Parentel coverage
        driver.findElement(By.cssSelector("div[class='form-check ms-5'] input[name='ParentalCoverage']")).click();
        //click save user
        manageUserPage.clickSaveUser();

//     String alertMessage=driver.findElement(By.cssSelector("div[role='alert']")).getText();
//      Assert.assertEquals(alertMessage,"User Added Successfully");

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
        ManageUserPage manageUserPage = new ManageUserPage(driver);
        manageUserPage.clickOnDeviceUser().clickOnManageUsers();
        //waiting for users to load
        Thread.sleep(3000);
        //click on user to edit
        driver.findElement(By.cssSelector("img[utilizerid$='35094']:nth-child(1)")).click();
        Thread.sleep(3000);
        //filing user details
        UserDetails userDetails = JacksonUtils.deserializeJson("userdetails.json", UserDetails.class);
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
        ManageUserPage manageUserPage = new ManageUserPage(driver);
        manageUserPage.clickOnDeviceUser().clickOnManageUsers();
        //waiting for users to load
        Thread.sleep(3000);
        //click on user to edit
        driver.findElement(By.cssSelector("img[utilizerid$='35094']:nth-child(3)")).click();
        Thread.sleep(3000);
    }

    @Test
    public void deleteUser() throws InterruptedException {
        ManageUserPage manageUserPage = new ManageUserPage(driver);
        manageUserPage.clickOnDeviceUser().clickOnManageUsers();
        //waiting for users to load
        Thread.sleep(3000);
        //click on user to edit
        driver.findElement(By.cssSelector("img[utilizerid$='35094']:nth-child(2)")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".deleteBtn")).click();
        Thread.sleep(3000);
    }

    @Test
    public void editUserAttachDevice() throws InterruptedException, IOException {
        ManageUserPage manageUserPage = new ManageUserPage(driver);
        manageUserPage.clickOnDeviceUser().clickOnManageUsers();
        //waiting for users to load
        Thread.sleep(3000);
        //click on user to edit
        driver.findElement(By.cssSelector("img[utilizerid$='35091']:nth-child(1)")).click();
        Thread.sleep(3000);
        //filing user details
        UserDetails userDetails = JacksonUtils.deserializeJson("userdetails.json", UserDetails.class);
        manageUserPage.enterFirstName(userDetails.getFname()).
                enterMiddleName(userDetails.getMiddlename()).
                enterLastName(userDetails.getLname()).
                enterStudentID(userDetails.getUserid()).
                enterGrade(userDetails.getGrade()).
                enterGuardianEmail(userDetails.getParentemail()).
                enterGuardianName(userDetails.getParentname()).
                enterPhoneNumber(userDetails.getParentnumber());
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[normalize-space()='Attach a new Device']")).click();
        //waiting for attach new device popup
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[placeholder='Search Device']")).sendKeys("DRMNDS3", Keys.ENTER);
        //waiting for devices to appear
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("div[serialnumber$='DRMNDS3']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Attach Device']")).click();
        Thread.sleep(3000);

    }

   @Test
    public void deleteUserAttachedDevice() throws InterruptedException {
       ManageUserPage manageUserPage = new ManageUserPage(driver);
       manageUserPage.clickOnDeviceUser().clickOnManageUsers();
       Thread.sleep(3000);
       //click on user to edit
       driver.findElement(By.cssSelector("img[utilizerid$='35092']:nth-child(1)")).click();
       Thread.sleep(3000);
       //delete attached device
       driver.findElement(By.cssSelector("img[title='Delete Device']")).click();
       Thread.sleep(3000);
       //confirm deletion
       driver.findElement(By.cssSelector(".deleteBtn")).click();
   }

}
