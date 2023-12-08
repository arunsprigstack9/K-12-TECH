package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ReportsTest extends BaseTest {
    @Test
    public void pageLoad() throws InterruptedException {
        String buildingname="BLOCK-D";
        String gradevalue="FIRST";
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@urlpath='/reports']")).click();
        Thread.sleep(5000);
        Select building=new Select(driver.findElement(By.xpath("(//select)[2]")));
        building.selectByVisibleText(buildingname);
        Select grade=new Select(driver.findElement(By.xpath("(//select)[1]")));
        grade.selectByVisibleText(gradevalue);
    }
}
