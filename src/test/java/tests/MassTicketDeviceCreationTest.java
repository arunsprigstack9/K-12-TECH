package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.ManageUserPage;

public class MassTicketDeviceCreationTest extends BaseTest {
    @Test
    public void massDeviceWithTicketBatch() throws InterruptedException {
        String device1="MD11";
        String device2="MD21";
        String device3="MD31";
        String batchname="Testbatch-1";
        ManageUserPage manageUserPage = new ManageUserPage(driver);
        manageUserPage.clickOnDeviceUser();
        driver.findElement(By.xpath("//a[@urlpath='/mass-tickets']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[placeholder='Serial Number 1']")).sendKeys(device1);
        driver.findElement(By.cssSelector("input[placeholder='Serial Number 2']")).sendKeys(device2);
        driver.findElement(By.cssSelector("input[placeholder='Serial Number 3']")).sendKeys(device3);
        Thread.sleep(3000);
        scrollElementIntoView(driver,driver.findElement(By.xpath("//button[normalize-space()='Save & Next']")));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Save & Next']")).click();
        Thread.sleep(3000);
        //Create Device with Tickets and Batch Them
        driver.findElement(By.cssSelector("label[for$='opt-3']")).click();
        Thread.sleep(3000);
        WebElement batchnameElm=driver.findElement(By.xpath("//input[@name='batchname']"));
        batchnameElm.clear();
        Thread.sleep(3000);
        batchnameElm.sendKeys(batchname);
        driver.findElement(By.cssSelector("textarea[name='notes']")).sendKeys("arun school batch");
        //click on save
        driver.findElement(By.cssSelector(".SaveBtn.ms-3")).click();
        Thread.sleep(3000);

    }
    public static void scrollElementIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'start', inline: 'nearest' });", element);
    }
}
