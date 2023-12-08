package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ManageDevicePage;
import pages.ManageSoftwarePage;
import pages.ManageUserPage;

public class DemoTest extends BaseTest {
    @Test
    public void manageDevice() throws InterruptedException {
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        Thread.sleep(3000);

    }
    @Test
    public void manageUser() throws InterruptedException {
        ManageUserPage manageUserPage=new ManageUserPage(driver);
        manageUserPage.clickOnDeviceUser().clickOnManageUsers();
        Thread.sleep(3000);
    }
    @Test
    public void manageTicket() throws InterruptedException {
//        Thread.sleep(3000);
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
