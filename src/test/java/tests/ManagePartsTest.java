package tests;

import base.BaseTest;
import objects.PartsDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.ManageTicketPage;
import utils.JacksonUtils;

import java.io.IOException;

public class ManagePartsTest extends BaseTest {
    @Test
    public void addInventory() throws InterruptedException, IOException {
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs();
        driver.findElement(By.xpath("//div[contains(text(),'Manage Parts')]")).click();
        Thread.sleep(3000);
        PartsDetails partsDetails= JacksonUtils.deserializeJson("parts/partsdetails.json", PartsDetails.class);
        driver.findElement(By.xpath("//label[normalize-space()='Add Inventory']")).click();
        Thread.sleep(3000);
        WebElement partname=driver.findElement(By.cssSelector("input[name='partName']"));
        partname.clear();
        partname.sendKeys(partsDetails.getPartname());
        WebElement pricefld=driver.findElement(By.cssSelector("input[name$='variantPrice']"));
        pricefld.clear();
        pricefld.sendKeys(partsDetails.getPrice());
        WebElement quantityfld=driver.findElement(By.cssSelector("input[name$='Quantity']"));
        quantityfld.clear();
        quantityfld.sendKeys(partsDetails.getQuantity());
        WebElement reorderfld=driver.findElement(By.xpath("(//input[@placeholder='0'])[2]"));
        reorderfld.clear();
        reorderfld.sendKeys(partsDetails.getReorderquantity());
        WebElement brandnamefld=driver.findElement(By.cssSelector("input[name='brandName']"));
        brandnamefld.clear();
        brandnamefld.sendKeys(partsDetails.getBrandname());

        //click on add inventory
        driver.findElement(By.cssSelector(".SaveBtn")).click();

    }
    @Test
    public void addMasterInventoryPartToSchoolInventory() throws InterruptedException {
        String partid="1455";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs();
        driver.findElement(By.xpath("//div[contains(text(),'Manage Parts')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Master Inventory']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//img[@partid='"+partid+"' and @title='Add to School Inventory']")).click();
        WebElement quantityfld=driver.findElement(By.cssSelector("input[name$='Quantity']"));
        quantityfld.clear();
        quantityfld.sendKeys("30");
        //click on save inventory
        driver.findElement(By.cssSelector(".SaveBtn")).click();

    }
    @Test
    public void editPart() throws InterruptedException, IOException {
        String partid="1788";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs();
        driver.findElement(By.xpath("//div[contains(text(),'Manage Parts')]")).click();
        Thread.sleep(3000);
        //click on part edit
        driver.findElement(By.cssSelector("img[partid$='"+partid+"']:nth-child(1)")).click();
        Thread.sleep(3000);
        PartsDetails partsDetails= JacksonUtils.deserializeJson("parts/editpartsdetails.json", PartsDetails.class);
        Thread.sleep(3000);
        WebElement partname=driver.findElement(By.cssSelector("input[name='partName']"));
        partname.clear();
        partname.sendKeys(partsDetails.getPartname());
        WebElement pricefld=driver.findElement(By.cssSelector("input[name$='variantPrice']"));
        pricefld.clear();
        pricefld.sendKeys(partsDetails.getPrice());
        WebElement quantityfld=driver.findElement(By.cssSelector("input[name$='Quantity']"));
        quantityfld.clear();
        quantityfld.sendKeys(partsDetails.getQuantity());
        WebElement reorderfld=driver.findElement(By.xpath("(//input[@placeholder='0'])[2]"));
        reorderfld.clear();
        reorderfld.sendKeys(partsDetails.getReorderquantity());
        WebElement brandnamefld=driver.findElement(By.cssSelector("input[name='brandName']"));
        brandnamefld.clear();
        brandnamefld.sendKeys(partsDetails.getBrandname());

        //click on add inventory
        driver.findElement(By.cssSelector(".SaveBtn")).click();

    }
    @Test
    public void deletePart() throws InterruptedException {
        String partid="1788";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs();
        driver.findElement(By.xpath("//div[contains(text(),'Manage Parts')]")).click();
        Thread.sleep(3000);
        //click on delete part edit
        driver.findElement(By.cssSelector("img[partid$='"+partid+"']:nth-child(2)")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".deleteBtn")).click();
    }
    @Test
    public void search() throws InterruptedException {
        String searchpart="Lenovo";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs();
        driver.findElement(By.xpath("//div[contains(text(),'Manage Parts')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Master Inventory']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(searchpart);
    }
    @Test
    public void reorder() throws InterruptedException {
        String partid="1776";
        String reorderqnt="7";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs();
        driver.findElement(By.xpath("//div[contains(text(),'Manage Parts')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("img[partid$='"+partid+"']:nth-child(1)")).click();
        Thread.sleep(3000);
        WebElement elm=driver.findElement(By.xpath("(//input[@placeholder='0'])[2]"));
        elm.clear();
        elm.sendKeys(reorderqnt);

        driver.findElement(By.cssSelector(".SaveBtn")).click();
    }
    @Test
    public void pagination() throws InterruptedException {
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs();
        driver.findElement(By.xpath("//div[contains(text(),'Manage Parts')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Master Inventory']")).click();
        Thread.sleep(3000);
        scrollElementIntoView(driver,driver.findElement(By.xpath("//a[normalize-space()='2']")));
        driver.findElement(By.xpath("//a[normalize-space()='2']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='3']")).click();

    }
    public static void scrollElementIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'start', inline: 'nearest' });", element);
    }
}
