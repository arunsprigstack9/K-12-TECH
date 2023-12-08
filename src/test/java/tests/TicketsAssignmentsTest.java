package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TicketsAssignmentsTest extends BaseTest {
    @Test
    public void assignBuildingToStaffMember() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Configurations']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'Ticket Assignments')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("label[title='Assign Building to Staff Member']")).click();
        Thread.sleep(3000);
        Select building=new Select(driver.findElement(By.xpath("(//select[@class='form-select custom-width inline-dropdown mx-2'])[1]")));
        building.selectByVisibleText("BLOCK-A");
        Select category=new Select(driver.findElement(By.xpath("(//select[@class='form-select custom-width inline-dropdown mx-2'])[2]")));
        category.selectByVisibleText("Maintenance");
        Select staffmember=new Select(driver.findElement(By.xpath("(//select[@class='form-select custom-width inline-dropdown'])[1]")));
        staffmember.selectByVisibleText("arun rout");
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
    }
    @Test
    public void editTicketAssignment() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Configurations']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'Ticket Assignments')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//img[@title='Edit Ticket Assignments'])[2]")).click();
        Select s1=new Select(driver.findElement(By.xpath("(//select[@class='form-select custom-width inline-dropdown mx-2'])[1]")));
        s1.selectByVisibleText("Technology");
        Select s2=new Select(driver.findElement(By.xpath("(//select[@class='form-select custom-width inline-dropdown'])[1]")));
        s2.selectByVisibleText("Riya123 Darji");
        driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();
    }
    @Test
    public void search() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Configurations']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'Ticket Assignments')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("BLOCK-A", Keys.ENTER);
    }

}
