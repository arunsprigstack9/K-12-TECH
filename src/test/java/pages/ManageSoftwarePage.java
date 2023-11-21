package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ManageSoftwarePage extends BasePage {
    private final By deviceUser=By.xpath("//aside[@class='sidebar-wrapper']//li[3]//a[1]");
    private final By manageSoftware=By.xpath("//div[contains(text(),'Manage Software')]");
    private final By addSoftware=By.xpath("//label[normalize-space()='Add Software']");
    private final By softwareName=By.cssSelector("input[name='SoftwareName']");
    private final By purchaseDate=By.xpath("//input[@name='PurchaseDate']");
    private final By lenghthOfLicense=By.cssSelector("input[name='LengthOfLicenses']");
    private final By renewalDate=By.cssSelector("input[name='EndDate']");
    private final By cost=By.cssSelector("input[name$='Cost']");
    private final By buildingName=By.cssSelector("input[name='BuildingsUsed']");
    private final By quantity=By.cssSelector("input[name='Quantity']");
    private final By grade=By.cssSelector("input[name='Grade']");
    private final By subject=By.cssSelector("input[name='Subject']");

    public ManageSoftwarePage(WebDriver driver) {
        super(driver);
    }

    public ManageSoftwarePage clickOnDeviceUser(){
        wait.until(ExpectedConditions.elementToBeClickable(deviceUser)).click();
        return this;
    }
    public ManageSoftwarePage clickOnManageSoftware(){
        wait.until(ExpectedConditions.elementToBeClickable(manageSoftware)).click();
        return this;
    }
    public ManageSoftwarePage clickOnAddSoftware(){
        wait.until(ExpectedConditions.elementToBeClickable(addSoftware)).click();
        return this;
    }
    public ManageSoftwarePage enterSoftwareName(String name){
        WebElement e =wait.until(ExpectedConditions.elementToBeClickable(softwareName));
        e.clear();
        e.sendKeys(name);
        return this;
    }
    public ManageSoftwarePage enterSoftwarePurchaseDate(String date){
        WebElement e=driver.findElement(By.xpath("//input[@name='PurchaseDate']"));
        e.clear();
        e.sendKeys(date);
        return this;
    }
    public ManageSoftwarePage enterSoftwareRenewalDate(String date){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(renewalDate));
        e.clear();
        e.sendKeys(date);
        return this;
    }
    public ManageSoftwarePage enterLengthOfLicense(String length){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(lenghthOfLicense));
        e.clear();
        e.sendKeys(length);
        return this;
    }
    public ManageSoftwarePage enterCost(String costprice){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(cost));
        e.clear();
        e.sendKeys(costprice);
        return this;
    }
    public ManageSoftwarePage enterBuildingName(String bname){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(buildingName));
        e.clear();
        e.sendKeys(bname);
        return this;
    }
    public ManageSoftwarePage enterQuantity(String quant){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(quantity));
        e.clear();
        e.sendKeys(quant);
        return this;
    }
    public ManageSoftwarePage enterGrade(String gr){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(grade));
        e.clear();
        e.sendKeys(gr);
        return this;
    }
    public ManageSoftwarePage enterSubject(String subjectname){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(subject));
        e.clear();
        e.sendKeys(subjectname);
        return this;
    }


}
