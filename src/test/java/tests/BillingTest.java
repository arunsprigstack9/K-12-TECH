package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BillingTest extends BaseTest {
    //new test
    @Test
    public void generateinvoice() throws InterruptedException {
      String totalcost="100";
     Thread.sleep(4000);
     driver.findElement(By.xpath("//div[contains(text(),'Billing')]")).click();
     Thread.sleep(3000);
     driver.findElement(By.cssSelector("//a[normalize-space()='Pending Closed Tickets']")).click();
     Thread.sleep(4000);
     driver.findElement(By.cssSelector("(//*[name()='svg'][@role='img'])[17]")).click();
     Thread.sleep(4000);
     driver.findElement(By.xpath("(//img[@title='Generate Invoice'])[1]")).click();
     driver.findElement(By.cssSelector("input[name$='totalcost']")).sendKeys(totalcost);
     driver.findElement(By.xpath("//button[normalize-space()='Preview']")).click();
     Thread.sleep(4000);
     driver.findElement(By.xpath("//button[normalize-space()='Generate Invoice']")).click();

    }

}
