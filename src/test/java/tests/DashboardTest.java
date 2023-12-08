package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    @Test
    public void graphloading() throws InterruptedException {
        Thread.sleep(7000);
    }
    @Test
    public void tableLoading() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//div[@class='tabView p-2 cursor-pointer display-center'])[2]")).click();
        Thread.sleep(3000);
    }
    @Test
    public void arrange() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//div[@class='tabView p-2 cursor-pointer display-center'])[3]")).click();
        Thread.sleep(3000);
        //WebElement on which drag and drop operation needs to be performed
        WebElement fromElement = driver.findElement(By.xpath("//div[contains(text(),'Breakage Rate')]"));

       //WebElement to which the above object is dropped
        WebElement toElement = driver.findElement(By.xpath("(//div[@class='col-12 text-center'][normalize-space()='Support Ticket'])[1]"));

        //Creating object of Actions class to build composite actions
        Actions builder = new Actions(driver);

        //Building a drag and drop action
        Action dragAndDrop = builder.clickAndHold(fromElement)
                .moveToElement(toElement)
                .release(toElement)
                .build();

//        //Performing the drag and drop action
        dragAndDrop.perform();
        driver.findElement(By.xpath("(//button[@class='btn btn-secondary w-100 filter-apply'][normalize-space()='Apply'])[1]")).click();

    }

    @Test
    public void filter() throws InterruptedException {
        String startdate="11/05/2022";
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[contains(@class,'tabView p-2 cursor-pointer display-center')])[4]")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('input[value='11/06/2023']').value=''");

    }

    public static void scrollElementIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'start', inline: 'nearest' });", element);
    }
}
