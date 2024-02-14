package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Set;

public class StoreAndSkipLogin {
    protected static WebDriver driver;
    static String storedCookieValue;
    @BeforeMethod
    public void base() throws InterruptedException {
        // First Test: Store the Cookie Value
        if(storedCookieValue == null){
            storeCookieValue();
        }else{
            // Second Test: Use the Stored Cookie Value to Skip Login
            skipLoginWithStoredCookie();
        }


    }

    // First Test: Store the Cookie Value
    private static void storeCookieValue() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
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

        // Perform login or any action to obtain the cookie
        // ...

        // Retrieve the cookie by name
        Cookie authCookie = driver.manage().getCookieNamed("ciphertext");

        if (authCookie != null) {
            // Store the cookie value in a variable or a file or any storage mechanism
            String storedCookieValue = authCookie.getValue();

            // Print or use the stored value as needed
            System.out.println("Stored Cookie Value: " + storedCookieValue);

            // Close the browser
//            driver.quit();
        } else {
            System.out.println("Authentication cookie not found.");
            // Handle the case when the cookie is not found
            // Close the browser
//            driver.quit();
        }
    }

    // Second Test: Use the Stored Cookie Value to Skip Login
    private static void skipLoginWithStoredCookie() {

        // Create a new instance of the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Navigate to a page where login is required
        driver.get("https://rocket-dev.k12techrepairs.com/");

        // Create a new cookie using the stored value
        Cookie storedCookie = new Cookie("ciphertext", storedCookieValue);

        // Add the stored cookie to the browser
        driver.manage().addCookie(storedCookie);

        // Refresh the page to apply the stored cookie and potentially skip the login
        driver.navigate().refresh();

        // Continue with your automation, and the browser should be in a logged-in state

        // Close the browser
//        driver.quit();
    }
}
