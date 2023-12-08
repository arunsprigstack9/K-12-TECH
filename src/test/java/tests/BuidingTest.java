package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BuidingTest extends BaseTest {
    @Test
    public void addBuilding() throws InterruptedException {
        String buildingname="Building-A";
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Configurations']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'Buildings')]")).click();
        driver.findElement(By.cssSelector("label[title='Add Building']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[name='building']")).sendKeys(buildingname);

    }
    @Test
    public void editBuilding() throws InterruptedException {
        String buildingid="289";
        String buildingname="SouthBlock-A";
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Configurations']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'Buildings')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("img[buildingid$='"+buildingid+"']")).click();
        Thread.sleep(3000);
        WebElement elm =driver.findElement(By.xpath("//input[@name='building']"));
        elm.clear();
        elm.sendKeys(buildingname);
        driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();


    }
    @Test
    public void search() throws InterruptedException {
        String buildingname="BLOCK-A";
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Configurations']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'Buildings')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(buildingname);
    }
    @Test
    public void sortBy() throws InterruptedException {
        String buildingname="BLOCK-A";
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Configurations']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'Buildings')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("th[title='Sort by Name']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("th[title='Sort by Created at']")).click();
    }
}
