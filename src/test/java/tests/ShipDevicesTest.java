package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.ManageTicketPage;

public class ShipDevicesTest extends BaseTest {

    @Test
    public void createBatchesOpenTickets() throws InterruptedException {
        String ticketid="2352";
        String ticketid1="2351";
        String batchname="testbatch-1";
        String devicetype="iPad";
        String weight="10";
        String labelsize="PAPER_4X6";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'Ship Devices')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='All Open Tickets']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[ticketid$='"+ticketid+"']")).click();
        driver.findElement(By.cssSelector("input[ticketid$='"+ticketid1+"']")).click();
        driver.findElement(By.xpath("//label[normalize-space()='Create Batch']")).click();
        Thread.sleep(3000);
        WebElement batchnamelm=driver.findElement(By.cssSelector("input[name$='batchname']"));
        batchnamelm.clear();
        batchnamelm.sendKeys(batchname);
        driver.findElement(By.cssSelector("textarea[name='notes']")).sendKeys(batchname);
        //click on ship devices
        driver.findElement(By.xpath("(//input[@class='form-check-input mt-0 me-2 ms-0 cursor-pointer'])[1]")).click();
        Thread.sleep(3000);
//        Recipients Name*
        driver.findElement(By.cssSelector("input[name='recname']")).sendKeys("arun");
        driver.findElement(By.cssSelector("input[name='recphone']")).sendKeys("9787036441");
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
        driver.findElement(By.xpath("//button[normalize-space()='Create Batch']")).click();

    }
    @Test
    public void searchBatch() throws InterruptedException {
        String batchid="b";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'OutGoing Batches')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='SearchInvoiceId']")).sendKeys(batchid);
    }

}
