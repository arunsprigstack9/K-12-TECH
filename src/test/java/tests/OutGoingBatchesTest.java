package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.ManageTicketPage;

public class OutGoingBatchesTest extends BaseTest {
    @Test
    public void createShipping() throws InterruptedException {
        String batchid="234";
        String devicetype="Chromebook/Laptop";
        String weight="10";
        String labelsize="PAPER_4X6";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'OutGoing Batches')]")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("svg[batchid$='"+batchid+"']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("textarea[name='notes']")).sendKeys("notes added");
        Select device=new Select(driver.findElement(By.xpath("(//select)[2]")));
        device.selectByVisibleText(devicetype);
        Thread.sleep(3000);
        WebElement weighelm =driver.findElement(By.cssSelector("input[name$='weight']"));
        weighelm.clear();
        weighelm.sendKeys(weight);
        Thread.sleep(3000);
        Select boxsize= new Select(driver.findElement(By.xpath("(//select)[3]")));
        boxsize.selectByVisibleText("Custom");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[name='width']")).sendKeys("15");
        driver.findElement(By.cssSelector("input[name='height']")).sendKeys("8");
        driver.findElement(By.cssSelector("input[name='depth']")).sendKeys("2");
        Select label=new Select(driver.findElement(By.xpath("(//select)[4]")));
        label.selectByVisibleText(labelsize);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Preview Shipping']")).click();
        Thread.sleep(7000);
//        driver.findElement(By.xpath("//button[normalize-space()='Create Shipping']")).click();


    }
    @Test
    public void deleteBatch() throws InterruptedException {
        String batchid="150";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'OutGoing Batches')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("img[batchid$='"+batchid+"']:nth-child(1)")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Yes, Delete It!']")).click();

    }
}
