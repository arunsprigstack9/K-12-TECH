package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class MicrosoftLoginTest {
    @Test
    public void chceckSuccessFulLogin() throws InterruptedException {
        String url="https://rocket-dev.k12techrepairs.com/";
        String emailid="arun.sprigstack@outlook.com";
        String pws="arun@#1234";
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        String mainWindowHandle = driver.getWindowHandle();
        WebElement siginClick=driver.findElement(By.xpath("//span[normalize-space()='Sign in with Microsoft']"));
        siginClick.click();
        //waiting for email login window open
        Thread.sleep(5000);
        // Switch to the new window
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        WebElement emailInput= driver.findElement(By.cssSelector("input[id$='i0116']"));
        emailInput.sendKeys(emailid, Keys.ENTER);
        Thread.sleep(5000);
        WebElement pwInput= driver.findElement(By.cssSelector("input[id$='i0118']"));
        pwInput.sendKeys(pws,Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#idSIButton9")).click();
        //wait for sigin process to complete
        Thread.sleep(7000);
        driver.switchTo().window(mainWindowHandle);
        Thread.sleep(7000);
        //js code to check page is loaded successfully
        // Javascript executor to return value
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("return document.readyState")
                .toString().equals("complete");
        // get the current URL
        String s = driver.getCurrentUrl();
        // checking condition if the URL is loaded
        if (s.equals(url)) {
            System.out.println("Page Loaded");
            System.out.println("Current Url: " + s);
        }
        else {
            System.out.println("Page did not load");
        }



    }


}
