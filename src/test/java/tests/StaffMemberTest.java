package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class StaffMemberTest extends BaseTest {
    @Test
    public void addStaffMember() throws InterruptedException {
        String firstname="David";
        String lastname="warner";
        String email="david@gmail.com";
        String profession="Teacher";
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Configurations']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Staff Members')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[normalize-space()='Add Staff Member']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[@name='firstname'])[1]")).sendKeys(firstname);
        driver.findElement(By.xpath("(//input[@name='firstname'])[2]")).sendKeys(lastname);
        Select access=new Select(driver.findElement(By.xpath("(//select)[2]")));
        access.selectByVisibleText(profession);
        driver.findElement(By.cssSelector("input[name='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[normalize-space()='Create New Member']")).click();
    }
    @Test
    public void editStaffMember() throws InterruptedException {
        String staffmemberid="690";
        String firstname="Riya";
        String lastname="warner";
        String email="riya@gmail.com";
        String profession="Admin";
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Configurations']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Staff Members')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("img[staffmemberid$='"+staffmemberid+"']")).click();
        Thread.sleep(3000);
        WebElement firstnameElm =driver.findElement(By.xpath("(//input[@name='firstname'])[1]"));
        firstnameElm.clear();
        firstnameElm.sendKeys(firstname);
        WebElement lastnameElm=driver.findElement(By.xpath("(//input[@name='firstname'])[2]"));
        lastnameElm.clear();
        lastnameElm.sendKeys(lastname);
        Select access=new Select(driver.findElement(By.xpath("(//select)[2]")));
        access.selectByVisibleText(profession);
        WebElement emailELm=driver.findElement(By.cssSelector("input[name='Email']"));
        emailELm.clear();
        emailELm.sendKeys(email);
        driver.findElement(By.xpath("//button[normalize-space()='Update Member']")).click();
    }
    @Test
    public void changeStatus() throws InterruptedException {
        String memberid="690";
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Configurations']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Staff Members')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[memberid$='"+memberid+"']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();

    }
    @Test
    public void search() throws InterruptedException {
        String staffname="David";
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Configurations']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Staff Members')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(staffname);
    }
    @Test
    public void sortBy() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Configurations']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Staff Members')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("th[title='Sort by Name']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("th[title='Sort by Access']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("th[title='Sort by Email']")).click();
    }

}
