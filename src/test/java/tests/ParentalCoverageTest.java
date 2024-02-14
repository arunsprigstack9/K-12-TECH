package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ParentalCoverageTest extends BaseTest {
    @Test
    public void createPlan() throws InterruptedException {
        String planname="plan-302";
        String planstartDate="25-01-2024";
        String estimatestudent="30";
        String devicesgohomepercent="30";
        String potentialdevicescovered="iPad Chargers,Chromebook Chargers,Macbook Chargers";
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Parental Coverage']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@urlpath='/setup']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[normalize-space()='Create Plan']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[name='planName']")).sendKeys(planname);
        driver.findElement(By.cssSelector("input[name$='startDate']")).sendKeys(planstartDate);
        driver.findElement(By.cssSelector("input[name='Enrollment']")).sendKeys(estimatestudent);
        driver.findElement(By.cssSelector("input[name='GoHomeWithStudents']")).sendKeys(devicesgohomepercent);
        driver.findElement(By.cssSelector("textarea[name='devicemodels']")).sendKeys(potentialdevicescovered);
        driver.findElement(By.cssSelector("input[name='iPad Chargers']")).click();
        driver.findElement(By.cssSelector("input[name='Chromebook Chargers']")).click();
        driver.findElement(By.cssSelector(".SaveBtn")).click();
        Thread.sleep(3000);


    }
    @Test
    public void confirmContarct() throws InterruptedException {
        String planid="48";
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[normalize-space()='Parental Coverage']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@urlpath='/setup']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("img[planid$='"+planid+"']:nth-child(2)")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Confirm Offer']")).click();
        Thread.sleep(3000);

    }
    @Test
    public void updatePlan() throws InterruptedException {
        String planid="62";
        String planname="plan-310";
        String planstartDate="10-01-2024";
        String estimatestudent="30";
        String devicesgohomepercent="30";
        String potentialdevicescovered="iPad Chargers,Chromebook Chargers,Macbook Chargers";
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Parental Coverage']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@urlpath='/setup']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("img[planid$='"+planid+"']")).click();
        Thread.sleep(3000);
        WebElement plannameLm=driver.findElement(By.cssSelector("input[name='planName']"));
        plannameLm.clear();
        plannameLm.sendKeys(planname);
        driver.findElement(By.cssSelector("input[name$='startDate']")).sendKeys(planstartDate);
        WebElement estimatestudentELm=driver.findElement(By.cssSelector("input[name='Enrollment']"));
        estimatestudentELm.clear();
        estimatestudentELm.sendKeys(estimatestudent);
        WebElement devicesgohomepercentElm=driver.findElement(By.cssSelector("input[name='GoHomeWithStudents']"));
        devicesgohomepercentElm.clear();
        devicesgohomepercentElm.sendKeys(devicesgohomepercent);
        WebElement potentialdevicescoveredElm=driver.findElement(By.cssSelector("textarea[name='devicemodels']"));
        potentialdevicescoveredElm.clear();
        potentialdevicescoveredElm.sendKeys(potentialdevicescovered);

        driver.findElement(By.xpath("//button[normalize-space()='Update Plan']")).click();
        Thread.sleep(3000);
    }
    @Test
    public void searchplan() throws InterruptedException {
        String plananme="plan-5";
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Parental Coverage']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@urlpath='/setup']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(plananme, Keys.ENTER);
        Thread.sleep(3000);
    }
}
