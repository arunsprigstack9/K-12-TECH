package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;

public class ImprtExportTest extends BaseTest {
    @Test
    public void importTemplate() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'Import/Export')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[href='/Csv/inventory_withStudent.csv']")).click();
    }
    @Test
    public void uploadDevicesWithUsers() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(),'Import/Export')]")).click();
        File uploadFile = new File("C:\\Users\\kruna\\Downloads\\inventory_withStudent (9).csv");

        WebElement fileInput = driver.findElement(By.cssSelector("#UploadFileId"));
        System.out.println(fileInput);
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        //click on upload
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > main:nth-child(3) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > input:nth-child(3)")).click();
        Thread.sleep(5000);

    }


}
