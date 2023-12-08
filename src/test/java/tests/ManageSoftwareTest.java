package tests;

import base.BaseTest;
import objects.SoftwareDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.ManageSoftwarePage;
import utils.JacksonUtils;

import java.io.File;
import java.io.IOException;

public class ManageSoftwareTest extends BaseTest {
    @Test
    public void addNewSoftware() throws InterruptedException, IOException {
        ManageSoftwarePage manageSoftwarePage=new ManageSoftwarePage(driver);
        manageSoftwarePage.clickOnDeviceUser().clickOnManageSoftware().clickOnAddSoftware();
        //wait for add software popup
        Thread.sleep(3000);
        SoftwareDetails softwareDetails= JacksonUtils.deserializeJson("softwaredetails.json",SoftwareDetails.class);
        manageSoftwarePage.enterSoftwareName(softwareDetails.getName()).
                          enterSoftwarePurchaseDate(softwareDetails.getPurchasedate()).
                          enterLengthOfLicense(softwareDetails.getLength()).
                          enterSoftwareRenewalDate(softwareDetails.getRenewaldate()).
                          enterCost(softwareDetails.getCost()).
                          enterBuildingName(softwareDetails.getBuildingname()).
                          enterQuantity(softwareDetails.getQuantity()).
                          enterGrade(softwareDetails.getGrade()).
                          enterSubject(softwareDetails.getSubject());

        File uploadFile = new File("C:\\Users\\kruna\\Downloads\\hardik.pdf");

        WebElement fileInput = driver.findElement(By.cssSelector("#UploadFileId"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        driver.findElement(By.cssSelector("textarea[name='Notes']")).sendKeys("notes added");
        driver.findElement(By.cssSelector(".SaveBtn")).click();
        Thread.sleep(3000);


    }
    @Test
    public void editSoftware() throws IOException, InterruptedException {
        String softwareid="72";
        ManageSoftwarePage manageSoftwarePage=new ManageSoftwarePage(driver);
        manageSoftwarePage.clickOnDeviceUser().clickOnManageSoftware();
        Thread.sleep(3000);
        //wait for add software popup
       driver.findElement(By.cssSelector("img[softwareid$='"+softwareid+"']:nth-child(1)")).click();
        Thread.sleep(3000);
        SoftwareDetails softwareDetails= JacksonUtils.deserializeJson("editsoftwaredetails.json",SoftwareDetails.class);
        manageSoftwarePage.enterSoftwareName(softwareDetails.getName()).
                enterSoftwarePurchaseDate(softwareDetails.getPurchasedate()).
                enterLengthOfLicense(softwareDetails.getLength()).
                enterSoftwareRenewalDate(softwareDetails.getRenewaldate()).
                enterCost(softwareDetails.getCost()).
                enterBuildingName(softwareDetails.getBuildingname()).
                enterQuantity(softwareDetails.getQuantity()).
                enterGrade(softwareDetails.getGrade()).
                enterSubject(softwareDetails.getSubject());


        WebElement noteELm=driver.findElement(By.cssSelector("textarea[name='Notes']"));
        noteELm.clear();
        noteELm.sendKeys("notes added");
        driver.findElement(By.cssSelector(".SaveBtn")).click();
        Thread.sleep(3000);
    }
    @Test
    public void showSoftwareDetails() throws InterruptedException {
        String softwareid="72";
        ManageSoftwarePage manageSoftwarePage=new ManageSoftwarePage(driver);
        manageSoftwarePage.clickOnDeviceUser().clickOnManageSoftware();
        Thread.sleep(3000);
        //wait for add software popup
        driver.findElement(By.cssSelector("img[softwareid$='"+softwareid+"']:nth-child(3)")).click();
        Thread.sleep(3000);
    }
    @Test
    public void search() throws InterruptedException {
        String softwarename="skype";
        ManageSoftwarePage manageSoftwarePage=new ManageSoftwarePage(driver);
        manageSoftwarePage.clickOnDeviceUser().clickOnManageSoftware();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(softwarename);
    }
    @Test
    public void sortBy() throws InterruptedException {
        ManageSoftwarePage manageSoftwarePage=new ManageSoftwarePage(driver);
        manageSoftwarePage.clickOnDeviceUser().clickOnManageSoftware();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("th[title='Sort by Name']")).click();
        driver.findElement(By.cssSelector("th[title='Sort by Name']")).click();

        Thread.sleep(3000);


    }
    @Test
    public void pagination() throws InterruptedException {
        ManageSoftwarePage manageSoftwarePage=new ManageSoftwarePage(driver);
        manageSoftwarePage.clickOnDeviceUser().clickOnManageSoftware();
        Thread.sleep(3000);
        scrollElementIntoView(driver,driver.findElement(By.cssSelector("a[aria-label='Go to page number 2']")));
        driver.findElement(By.cssSelector("a[aria-label='Go to page number 2']")).click();
    }
    public static void scrollElementIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'start', inline: 'nearest' });", element);
    }

}
