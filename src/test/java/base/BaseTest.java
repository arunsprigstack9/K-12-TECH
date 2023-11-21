package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Set;

public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void startDriver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rocket-dev.k12techrepairs.com/");
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
        emailInput.sendKeys("arun.sprigstack@gmail.com");
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

    }
//    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
}
