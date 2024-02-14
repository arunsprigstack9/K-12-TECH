package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SkipGoogleLoginTest {
    @Test
    public void Login() throws InterruptedException {
        String url="https://rocket-dev.k12techrepairs.com/";
        String emailid="arun.sprigstack@gmail.com";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("proxy-server=106.122.8.54:3128");
        options.addArguments("C:\\Users\\kruna\\AppData\\Local\\Google\\Chrome\\User Data\\Profile");


        WebDriver driver =new ChromeDriver(options);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
        String mainWindowHandle = driver.getWindowHandle();
        WebElement siginClick=driver.findElement(By.cssSelector(".MicrosoftGoogleBtn"));
        siginClick.click();
        //waiting for email login window open
        Thread.sleep(2000);
        // Switch to the new window
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        WebElement emailInput= driver.findElement(By.cssSelector("#identifierId"));
        emailInput.sendKeys(emailid);
//        emailInput.sendKeys(Keys.RETURN);
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        //waiting for load of pasword field
        Thread.sleep(7000);

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("8249107977");
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(7000);
        //wait for sigin process to complete
        driver.switchTo().window(mainWindowHandle);
        Thread.sleep(7000);

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
