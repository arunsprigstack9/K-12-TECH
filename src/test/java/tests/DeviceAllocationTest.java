package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ManageDevicePage;

public class DeviceAllocationTest extends BaseTest {
    @Test
    public void allocateDeviceToUser() throws InterruptedException {
        String username="shalin";
        String userid="35365";
        String deviceserialno="A10";
        String serialno="A10";
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser();
        driver.findElement(By.xpath("//div[normalize-space()='Device Allocation']")).click();
        Thread.sleep(3000);
        //search user
        driver.findElement(By.cssSelector("input[placeholder='Search User']")).sendKeys(username);
        Thread.sleep(3000);
        //wait for dropdown of users
        driver.findElement(By.cssSelector("div[userid$='"+userid+"']")).click();
        //search device
        driver.findElement(By.xpath("(//input[@placeholder='Search Device'])[1]")).sendKeys(deviceserialno);
        //wait for dropdown
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("div[serialnumber$='"+serialno+"']")).click();
        //wait for dropdown
        Thread.sleep(3000);
        //click on allocate device
        driver.findElement(By.xpath("//button[normalize-space()='Allocate Device']")).click();

    }
    @Test
    public void allocateDeviceToUserCheckNotes() throws InterruptedException {
        String username="taylor";
        String userid="35172";
        String deviceserialno="SSN";
        String serialno="SSN1775";
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser();
        driver.findElement(By.xpath("//div[normalize-space()='Device Allocation']")).click();
        Thread.sleep(3000);
        //search user
        driver.findElement(By.cssSelector("input[placeholder='Search User']")).sendKeys(username);
        Thread.sleep(3000);
        //wait for dropdown of users
        driver.findElement(By.cssSelector("div[userid$='"+userid+"']")).click();
        //search device
        driver.findElement(By.xpath("(//input[@placeholder='Search Device'])[1]")).sendKeys(deviceserialno);
        //wait for dropdown
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("div[serialnumber$='"+serialno+"']")).click();
        //wait for dropdown
        Thread.sleep(3000);
        //click on allocate device
        driver.findElement(By.xpath("//button[normalize-space()='Allocate Device']")).click();

    }
    @Test
    public void deallocateDevice() throws InterruptedException {
        String devicesn="A10";
        String deviceserialno="A10";
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser();
        driver.findElement(By.xpath("//div[normalize-space()='Device Allocation']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[@placeholder='Search Device'])[2]")).sendKeys(devicesn);
        //wait for dropdown
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div[serialnumber$='"+deviceserialno+"']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Deallocate Device']")).click();
        //click on device broken
        driver.findElement(By.xpath("(//input[@name='AssignDevice'])[1]")).click();

    }
    @Test
    public void checkDeviceAllocatedUser(){
        
    }

}
