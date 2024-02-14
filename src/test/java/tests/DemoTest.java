package tests;

import base.BaseTest;
import base.StoreAndSkipLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import pages.ManageDevicePage;
import pages.ManageSoftwarePage;
import pages.ManageUserPage;

public class DemoTest extends StoreAndSkipLogin {
    @Test
    public void manageDevice() throws InterruptedException {
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        Thread.sleep(3000);
        // Retrieve the cookie by name
        Cookie retrievedCookie = driver.manage().getCookieNamed("ciphertext");

        // Extract the ciphertext value from the cookie
        String ciphertextValue = retrievedCookie.getValue();

        // Perform any decryption or parsing on the ciphertext value as needed
        // For example, you might use a decryption algorithm or decoding method

        // Print the extracted value
        System.out.println("Extracted Ciphertext Value: " + ciphertextValue);

    }
    @Test
    public void manageUser() throws InterruptedException {
        ManageUserPage manageUserPage=new ManageUserPage(driver);
        manageUserPage.clickOnDeviceUser().clickOnManageUsers();
        Thread.sleep(3000);
    }
    @Test
    public void manageTicket() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Repairs']")).click();
        driver.findElement(By.xpath("//div[normalize-space()='Manage Tickets']")).click();
        Thread.sleep(3000);
    }
    @Test
    public void checkingTabsManageDevice() throws InterruptedException {
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        Thread.sleep(3000);
        //click on loaner device
        driver.findElement(By.xpath("//a[normalize-space()='Loaner Devices']")).click();
        Thread.sleep(3000);
        //click on decommissioned device
        driver.findElement(By.xpath("//a[normalize-space()='Decommissioned Devices']")).click();
        //click on loaner device
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Loaner Devices']")).click();
        //click on active device
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Active Devices']")).click();
    }
    @Test
    public void manageSoftware(){
        ManageSoftwarePage manageSoftwarePage=new ManageSoftwarePage(driver);
        manageSoftwarePage.clickOnDeviceUser().clickOnManageSoftware();
    }


}
