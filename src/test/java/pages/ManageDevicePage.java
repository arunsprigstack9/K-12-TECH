package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ManageDevicePage extends BasePage {
    private final By deviceUser=By.xpath("//aside[@class='sidebar-wrapper']//li[3]//a[1]");
    private final By manageDevices=By.xpath("//div[contains(text(),'Manage Devices')]");
    private final By addDevice=By.xpath("//label[normalize-space()='Add Device']");
    private final By serialNumberfld=By.cssSelector("input[name='serialnumber']");
    private final By buildingDropdown =By.cssSelector("div[class='col-12'] select");
    private final By deviceModelfld=By.cssSelector("input[name='devicemodel']");
    private final By deviceMfcfld=By.cssSelector("input[name='devicemanufacturer']");
    private final By deviceMpnfld=By.cssSelector("input[name='devicempn']");
    private final By assetTagfld=By.cssSelector("input[name='assettag']");
    private final By repairCapfld=By.name("repaircap");
    private final By deviceOSfld=By.cssSelector("input[name='deviceos']");
    private final By saveBtn=By.cssSelector(".SaveBtn");

    public ManageDevicePage(WebDriver driver) {
        super(driver);
    }
    public ManageDevicePage clickOnDeviceUser(){
        wait.until(ExpectedConditions.elementToBeClickable(deviceUser)).click();
        return this;
    }
    public ManageDevicePage clickOnManageDevices(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(manageDevices)).click();
        return this;
    }
    public ManageDevicePage clickAddDevice(){
        wait.until(ExpectedConditions.elementToBeClickable(addDevice)).click();
        return this;
    }
    public ManageDevicePage enterSerialNumber(String serialnum){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(serialNumberfld));
        e.clear();
        e.sendKeys(serialnum);
        return this;
    }
    public ManageDevicePage enterBuilding(String buildingname){
        wait.until(ExpectedConditions.elementToBeClickable(buildingDropdown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//option[contains(text(),'"+buildingname+"')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        return this;
    }
    public ManageDevicePage createNewBuilding(String buildingname){
        wait.until(ExpectedConditions.elementToBeClickable(buildingDropdown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//option[contains(text(),'Other')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",e);
        e.click();
        WebElement newBuilding=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='Enter Building']")));
        newBuilding.clear();
        newBuilding.sendKeys(buildingname);
        return this;
    }
    public ManageDevicePage enterDeviceModel(String devicemodelname){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(deviceModelfld));
        e.clear();
        e.sendKeys(devicemodelname);
        return this;
    }
    public ManageDevicePage enterDeviceMfc(String devicemfcname){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(deviceMfcfld));
        e.clear();
        e.sendKeys(devicemfcname);
        return this;
    }
    public ManageDevicePage enterDeviceMpn(String devicempnName){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(deviceMpnfld));
        e.clear();
        e.sendKeys(devicempnName);
        return this;
    }
    public ManageDevicePage enterAssetTag(String assetTagname){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(assetTagfld));
        e.clear();
        e.sendKeys(assetTagname);
        return this;
    }
    public ManageDevicePage enterrepairCap(String repaircapPrice){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(repairCapfld));
        e.clear();
        e.sendKeys(repaircapPrice);
        return this;
    }
    public ManageDevicePage enterDeviceOS(String deviceos){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(deviceOSfld));
        e.clear();
        e.sendKeys(deviceos);
        return this;
    }
    public ManageDevicePage clickOnSaveDevice(){
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
        return this;
    }


}
