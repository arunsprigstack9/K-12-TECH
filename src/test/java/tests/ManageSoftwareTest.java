package tests;

import base.BaseTest;
import objects.SoftwareDetails;
import org.openqa.selenium.By;
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
}
