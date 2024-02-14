package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TechnologySupportTicketTest extends BaseTest {
    @Test
    public void attachComment() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Support Ticket']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Technology']")).click();
        Thread.sleep(3000);


    }
}
