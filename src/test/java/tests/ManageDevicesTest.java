package tests;

import base.BaseTest;
import objects.NewDeviceDetails;
import objects.NewDeviceWarrantyDetails;
import objects.UserDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ManageDevicePage;
import utils.JacksonUtils;

import java.io.IOException;

public class ManageDevicesTest extends BaseTest {
    @Test
    public void checkingTabsManageDevice() throws InterruptedException {
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        Thread.sleep(3000);
        //click on loaner device
        driver.findElement(By.xpath("//a[normalize-space()='Loaner Devices']")).click();
        Thread.sleep(3000);
        //click on decommissioned device
        driver.findElement(By.xpath("//a[normalize-space()='Decommissioned Devices']")).click();
        //click on loaner device
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Loaner Devices']")).click();
        //click on active device
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Active Devices']")).click();
    }
    @Test
    public void addNewDeviceWithOnlySerialID() throws IOException, InterruptedException {
        //click on device/users
        NewDeviceDetails newDeviceDetails= JacksonUtils.deserializeJson("newdevicedata1.json", NewDeviceDetails.class);
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices().clickAddDevice();
        manageDevicePage.enterSerialNumber(newDeviceDetails.getSerialnumber());
        //click on save device
        manageDevicePage.clickOnSaveDevice();
        Thread.sleep(3000);

    }
    @Test
    public void addNewDevice() throws IOException, InterruptedException {
        //click on device/users
        NewDeviceDetails newDeviceDetails= JacksonUtils.deserializeJson("newdevicedata.json", NewDeviceDetails.class);
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices().clickAddDevice();
        manageDevicePage.enterSerialNumber(newDeviceDetails.getSerialnumber()).
                         enterBuilding(newDeviceDetails.getBuildingname()).
                        enterDeviceModel(newDeviceDetails.getDevicemodel()).
                        enterDeviceMfc(newDeviceDetails.getDevicemfc()).
                        enterDeviceMpn(newDeviceDetails.getDevicempn()).
                        enterAssetTag(newDeviceDetails.getAssettag()).
                        enterrepairCap(newDeviceDetails.getRepaircap()).
                        enterDeviceOS(newDeviceDetails.getDeviceOS());
        //filling notes
        driver.findElement(By.cssSelector("textarea[name='deviceos']")).sendKeys("New device added");
        //filling warranty details
        NewDeviceWarrantyDetails newDeviceWarrantyDetails=JacksonUtils.deserializeJson("devicewarrantydetails.json",NewDeviceWarrantyDetails.class);

        String purchasedate=newDeviceWarrantyDetails.getPurchasedate();
        String deviceretirement=newDeviceWarrantyDetails.getDeviceretirement();
        String mfgwarranty=newDeviceWarrantyDetails.getMfgwarranty();
        String mfgadp=newDeviceWarrantyDetails.getMfgadp();
        String tdpextwarranty=newDeviceWarrantyDetails.getTdpextwarranty();
        String tdpadp=newDeviceWarrantyDetails.getTdpadp();
        Thread.sleep(3000);
        //filling waranty details
        driver.findElement(By.cssSelector("input[name='PurchaseDate']")).sendKeys(purchasedate);
        driver.findElement(By.cssSelector("input[name='expectedretirement']")).sendKeys(deviceretirement);
        driver.findElement(By.cssSelector("input[name='ManufacturerWarrentyUntil']")).sendKeys(mfgwarranty);
        driver.findElement(By.cssSelector("input[name='ManufacturerADPUntil']")).sendKeys(mfgadp);
        driver.findElement(By.cssSelector("input[name='ThirdPartywarrantyuntil']")).sendKeys(tdpextwarranty);
        driver.findElement(By.cssSelector("input[name='thirdpartyadpuntil']")).sendKeys(tdpadp);
       //click on save device
        manageDevicePage.clickOnSaveDevice();
        Thread.sleep(3000);
//        String alertmsg=driver.findElement(By.cssSelector(".reactalert-success")).getText();
//        Assert.assertEquals(alertmsg,"Device Added Successfully.");


    }
    @Test
    public void addNewDeviceWithNewBuilding() throws IOException, InterruptedException {
        //click on device/users
        NewDeviceDetails newDeviceDetails= JacksonUtils.deserializeJson("newdevicedata1.json", NewDeviceDetails.class);
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices().clickAddDevice();
        manageDevicePage.enterSerialNumber(newDeviceDetails.getSerialnumber()).
                createNewBuilding("NewBuilding-A").
                enterDeviceModel(newDeviceDetails.getDevicemodel()).
                enterDeviceMfc(newDeviceDetails.getDevicemfc()).
                enterDeviceMpn(newDeviceDetails.getDevicempn()).
                enterAssetTag(newDeviceDetails.getAssettag()).
                enterrepairCap(newDeviceDetails.getRepaircap()).
                enterDeviceOS(newDeviceDetails.getDeviceOS());
        //filling notes
        driver.findElement(By.cssSelector("textarea[name='deviceos']")).sendKeys("New device added");
        //filling warranty details
        NewDeviceWarrantyDetails newDeviceWarrantyDetails=JacksonUtils.deserializeJson("devicewarrantydetails.json",NewDeviceWarrantyDetails.class);

        String purchasedate=newDeviceWarrantyDetails.getPurchasedate();
        String deviceretirement=newDeviceWarrantyDetails.getDeviceretirement();
        String mfgwarranty=newDeviceWarrantyDetails.getMfgwarranty();
        String mfgadp=newDeviceWarrantyDetails.getMfgadp();
        String tdpextwarranty=newDeviceWarrantyDetails.getTdpextwarranty();
        String tdpadp=newDeviceWarrantyDetails.getTdpadp();
        Thread.sleep(3000);
        //filling waranty details
        driver.findElement(By.cssSelector("input[name='PurchaseDate']")).sendKeys(purchasedate);
        driver.findElement(By.cssSelector("input[name='expectedretirement']")).sendKeys(deviceretirement);
        driver.findElement(By.cssSelector("input[name='ManufacturerWarrentyUntil']")).sendKeys(mfgwarranty);
        driver.findElement(By.cssSelector("input[name='ManufacturerADPUntil']")).sendKeys(mfgadp);
        driver.findElement(By.cssSelector("input[name='ThirdPartywarrantyuntil']")).sendKeys(tdpextwarranty);
        driver.findElement(By.cssSelector("input[name='thirdpartyadpuntil']")).sendKeys(tdpadp);
        //click on save device
        manageDevicePage.clickOnSaveDevice();
        Thread.sleep(3000);
//        String alertmsg=driver.findElement(By.cssSelector(".reactalert-success")).getText();
//        Assert.assertEquals(alertmsg,"Device Added Successfully.");


    }
    @Test
    public void addNewDeviceAsLoanerDevice() throws IOException, InterruptedException {
        //click on device/users
        NewDeviceDetails newDeviceDetails= JacksonUtils.deserializeJson("newdevicedata1.json", NewDeviceDetails.class);
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices().clickAddDevice();
        manageDevicePage.enterSerialNumber(newDeviceDetails.getSerialnumber()).
                enterBuilding(newDeviceDetails.getBuildingname()).
                enterDeviceModel(newDeviceDetails.getDevicemodel()).
                enterDeviceMfc(newDeviceDetails.getDevicemfc()).
                enterDeviceMpn(newDeviceDetails.getDevicempn()).
                enterAssetTag(newDeviceDetails.getAssettag()).
                enterrepairCap(newDeviceDetails.getRepaircap()).
                enterDeviceOS(newDeviceDetails.getDeviceOS());
        //filling notes
        driver.findElement(By.cssSelector("textarea[name='deviceos']")).sendKeys("New device added");
        //filling warranty details
        NewDeviceWarrantyDetails newDeviceWarrantyDetails=JacksonUtils.deserializeJson("devicewarrantydetails.json",NewDeviceWarrantyDetails.class);

        String purchasedate=newDeviceWarrantyDetails.getPurchasedate();
        String deviceretirement=newDeviceWarrantyDetails.getDeviceretirement();
        String mfgwarranty=newDeviceWarrantyDetails.getMfgwarranty();
        String mfgadp=newDeviceWarrantyDetails.getMfgadp();
        String tdpextwarranty=newDeviceWarrantyDetails.getTdpextwarranty();
        String tdpadp=newDeviceWarrantyDetails.getTdpadp();
        //filling device warranty details
        driver.findElement(By.cssSelector("input[name='PurchaseDate']")).sendKeys(purchasedate);
        driver.findElement(By.cssSelector("input[name='expectedretirement']")).sendKeys(deviceretirement);
        driver.findElement(By.cssSelector("input[name='ManufacturerWarrentyUntil']")).sendKeys(mfgwarranty);
        driver.findElement(By.cssSelector("input[name='ManufacturerADPUntil']")).sendKeys(mfgadp);
        driver.findElement(By.cssSelector("input[name='ThirdPartywarrantyuntil']")).sendKeys(tdpextwarranty);
        driver.findElement(By.cssSelector("input[name='thirdpartyadpuntil']")).sendKeys(tdpadp);

        //click as loaner device
        driver.findElement(By.cssSelector("div[class='form-check'] input[name='LoanerDevice']")).click();
        //click on save device
        manageDevicePage.clickOnSaveDevice();


    }
    @Test
    public void addDeviceAsLoanerDeviceExists() throws IOException, InterruptedException {
        //click on device/users
        NewDeviceDetails newDeviceDetails= JacksonUtils.deserializeJson("newdevicedata3.json", NewDeviceDetails.class);
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices().clickAddDevice();
        manageDevicePage.enterSerialNumber(newDeviceDetails.getSerialnumber()).
                enterBuilding(newDeviceDetails.getBuildingname()).
                enterDeviceModel(newDeviceDetails.getDevicemodel()).
                enterDeviceMfc(newDeviceDetails.getDevicemfc()).
                enterDeviceMpn(newDeviceDetails.getDevicempn()).
                enterAssetTag(newDeviceDetails.getAssettag()).
                enterrepairCap(newDeviceDetails.getRepaircap()).
                enterDeviceOS(newDeviceDetails.getDeviceOS());
        //filling notes
        driver.findElement(By.cssSelector("textarea[name='deviceos']")).sendKeys("New device added");
        //filling warranty details
        NewDeviceWarrantyDetails newDeviceWarrantyDetails=JacksonUtils.deserializeJson("devicewarrantydetails.json",NewDeviceWarrantyDetails.class);

        String purchasedate=newDeviceWarrantyDetails.getPurchasedate();
        String deviceretirement=newDeviceWarrantyDetails.getDeviceretirement();
        String mfgwarranty=newDeviceWarrantyDetails.getMfgwarranty();
        String mfgadp=newDeviceWarrantyDetails.getMfgadp();
        String tdpextwarranty=newDeviceWarrantyDetails.getTdpextwarranty();
        String tdpadp=newDeviceWarrantyDetails.getTdpadp();

        //filling device warranty details
        driver.findElement(By.cssSelector("input[name='PurchaseDate']")).sendKeys(purchasedate);
        driver.findElement(By.cssSelector("input[name='expectedretirement']")).sendKeys(deviceretirement);
        driver.findElement(By.cssSelector("input[name='ManufacturerWarrentyUntil']")).sendKeys(mfgwarranty);
        driver.findElement(By.cssSelector("input[name='ManufacturerADPUntil']")).sendKeys(mfgadp);
        driver.findElement(By.cssSelector("input[name='ThirdPartywarrantyuntil']")).sendKeys(tdpextwarranty);
        driver.findElement(By.cssSelector("input[name='thirdpartyadpuntil']")).sendKeys(tdpadp);

        //click as loaner device
        driver.findElement(By.cssSelector("div[class='form-check'] input[name='LoanerDevice']")).click();
        //click on save device
        manageDevicePage.clickOnSaveDevice();
        //check device already msg appear successfully
        Thread.sleep(3000);
        String alertmsg=driver.findElement(By.cssSelector(".alert")).getText();
        Assert.assertEquals(alertmsg,"Serial Number already exists");

    }

    @Test
    public void addDeviceNewUser() throws IOException, InterruptedException {
        //click on device/users
        NewDeviceDetails newDeviceDetails= JacksonUtils.deserializeJson("newdevicedata3.json", NewDeviceDetails.class);
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices().clickAddDevice();
        manageDevicePage.enterSerialNumber(newDeviceDetails.getSerialnumber()).
                enterBuilding(newDeviceDetails.getBuildingname()).
                enterDeviceModel(newDeviceDetails.getDevicemodel()).
                enterDeviceMfc(newDeviceDetails.getDevicemfc()).
                enterDeviceMpn(newDeviceDetails.getDevicempn()).
                enterAssetTag(newDeviceDetails.getAssettag()).
                enterrepairCap(newDeviceDetails.getRepaircap()).
                enterDeviceOS(newDeviceDetails.getDeviceOS());
        //filling notes
        driver.findElement(By.cssSelector("textarea[name='deviceos']")).sendKeys("New device added");
        //filling warranty details
        NewDeviceWarrantyDetails newDeviceWarrantyDetails=JacksonUtils.deserializeJson("devicewarrantydetails.json",NewDeviceWarrantyDetails.class);

        String purchasedate=newDeviceWarrantyDetails.getPurchasedate();
        String deviceretirement=newDeviceWarrantyDetails.getDeviceretirement();
        String mfgwarranty=newDeviceWarrantyDetails.getMfgwarranty();
        String mfgadp=newDeviceWarrantyDetails.getMfgadp();
        String tdpextwarranty=newDeviceWarrantyDetails.getTdpextwarranty();
        String tdpadp=newDeviceWarrantyDetails.getTdpadp();

        //filling device warranty details
        driver.findElement(By.cssSelector("input[name='PurchaseDate']")).sendKeys(purchasedate);
        driver.findElement(By.cssSelector("input[name='expectedretirement']")).sendKeys(deviceretirement);
        driver.findElement(By.cssSelector("input[name='ManufacturerWarrentyUntil']")).sendKeys(mfgwarranty);
        driver.findElement(By.cssSelector("input[name='ManufacturerADPUntil']")).sendKeys(mfgadp);
        driver.findElement(By.cssSelector("input[name='ThirdPartywarrantyuntil']")).sendKeys(tdpextwarranty);
        driver.findElement(By.cssSelector("input[name='thirdpartyadpuntil']")).sendKeys(tdpadp);
        //asign a new user
        driver.findElement(By.cssSelector("div[class='form-check'] input[name='AssignDevice']")).click();
        //filling details of a new user
        UserDetails userDetails=JacksonUtils.deserializeJson("userdetails.json", UserDetails.class);

        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys(userDetails.getFname());
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(userDetails.getLname());
        driver.findElement(By.cssSelector("input[name='middleName']")).sendKeys(userDetails.getMiddlename());
        driver.findElement(By.cssSelector("input[name='studentID']")).sendKeys(userDetails.getUserid());
        driver.findElement(By.cssSelector("input[name='grade']")).sendKeys(userDetails.getGrade());
        driver.findElement(By.cssSelector("input[name='guardianemail']")).sendKeys(userDetails.getParentemail());
        driver.findElement(By.cssSelector("input[name='guardianName']")).sendKeys(userDetails.getParentname());
        driver.findElement(By.cssSelector("input[name='parentphonenumber']")).sendKeys(userDetails.getParentnumber());

        //click on save device
        manageDevicePage.clickOnSaveDevice();
        Thread.sleep(3000);
    }
    @Test
    public void addDeviceExistingUser() throws IOException, InterruptedException {
        String utilizeid="35172";
        //click on device/users
        NewDeviceDetails newDeviceDetails= JacksonUtils.deserializeJson("newdevicedata3.json", NewDeviceDetails.class);
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices().clickAddDevice();
        manageDevicePage.enterSerialNumber(newDeviceDetails.getSerialnumber()).
                enterBuilding(newDeviceDetails.getBuildingname()).
                enterDeviceModel(newDeviceDetails.getDevicemodel()).
                enterDeviceMfc(newDeviceDetails.getDevicemfc()).
                enterDeviceMpn(newDeviceDetails.getDevicempn()).
                enterAssetTag(newDeviceDetails.getAssettag()).
                enterrepairCap(newDeviceDetails.getRepaircap()).
                enterDeviceOS(newDeviceDetails.getDeviceOS());
        //filling notes
        driver.findElement(By.cssSelector("textarea[name='deviceos']")).sendKeys("New device added");
        //filling warranty details
        NewDeviceWarrantyDetails newDeviceWarrantyDetails=JacksonUtils.deserializeJson("devicewarrantydetails.json",NewDeviceWarrantyDetails.class);

        String purchasedate=newDeviceWarrantyDetails.getPurchasedate();
        String deviceretirement=newDeviceWarrantyDetails.getDeviceretirement();
        String mfgwarranty=newDeviceWarrantyDetails.getMfgwarranty();
        String mfgadp=newDeviceWarrantyDetails.getMfgadp();
        String tdpextwarranty=newDeviceWarrantyDetails.getTdpextwarranty();
        String tdpadp=newDeviceWarrantyDetails.getTdpadp();

        //filling waranty details
        driver.findElement(By.cssSelector("input[name='PurchaseDate']")).sendKeys(purchasedate);
        driver.findElement(By.cssSelector("input[name='expectedretirement']")).sendKeys(deviceretirement);
        driver.findElement(By.cssSelector("input[name='ManufacturerWarrentyUntil']")).sendKeys(mfgwarranty);
        driver.findElement(By.cssSelector("input[name='ManufacturerADPUntil']")).sendKeys(mfgadp);
        driver.findElement(By.cssSelector("input[name='ThirdPartywarrantyuntil']")).sendKeys(tdpextwarranty);
        driver.findElement(By.cssSelector("input[name='thirdpartyadpuntil']")).sendKeys(tdpadp);
        //asign a new user
        driver.findElement(By.cssSelector("div[class='form-check'] input[name='AssignDevice']")).click();
        //click on existing user
        driver.findElement(By.cssSelector("div[class='form-check'] input[name='existingnew']")).click();
        //search for existing user
        driver.findElement(By.cssSelector("input[placeholder='Search User']")).sendKeys("john");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div[utilizerid='"+utilizeid+"']")).click();
        Thread.sleep(3000);

        //click on save device
        manageDevicePage.clickOnSaveDevice();
        Thread.sleep(3000);
    }

    @Test
    public void editDevice() throws IOException, InterruptedException {
        String inventoryid="555348";
        NewDeviceDetails newDeviceDetails= JacksonUtils.deserializeJson("editdevicedata.json", NewDeviceDetails.class);
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        Thread.sleep(5000);
        //click on edit device
        driver.findElement(By.cssSelector("img[inventoryid$='"+inventoryid+"']:nth-child(1)")).click();
        //edit device info
        Thread.sleep(5000);
        manageDevicePage.
                enterBuilding(newDeviceDetails.getBuildingname()).
                enterDeviceModel(newDeviceDetails.getDevicemodel()).
                enterDeviceMfc(newDeviceDetails.getDevicemfc()).
                enterDeviceMpn(newDeviceDetails.getDevicempn()).
                enterAssetTag(newDeviceDetails.getAssettag()).
                enterrepairCap(newDeviceDetails.getRepaircap()).
                enterDeviceOS(newDeviceDetails.getDeviceOS());
        //filling notes
        WebElement noteElm=driver.findElement(By.cssSelector("textarea[name='deviceos']"));
        noteElm.clear();
        noteElm.sendKeys("Edited Device");
        //filling warranty details
        NewDeviceWarrantyDetails newDeviceWarrantyDetails=JacksonUtils.deserializeJson("newdevicewarrantydetails.json",NewDeviceWarrantyDetails.class);

        String purchasedate=newDeviceWarrantyDetails.getPurchasedate();
        String deviceretirement=newDeviceWarrantyDetails.getDeviceretirement();
        String mfgwarranty=newDeviceWarrantyDetails.getMfgwarranty();
        String mfgadp=newDeviceWarrantyDetails.getMfgadp();
        String tdpextwarranty=newDeviceWarrantyDetails.getTdpextwarranty();
        String tdpadp=newDeviceWarrantyDetails.getTdpadp();
        Thread.sleep(3000);
        //filling waranty details
        driver.findElement(By.cssSelector("input[name='PurchaseDate']")).sendKeys(purchasedate);
        driver.findElement(By.cssSelector("input[name='expectedretirement']")).sendKeys(deviceretirement);
        driver.findElement(By.cssSelector("input[name='ManufacturerWarrentyUntil']")).sendKeys(mfgwarranty);
        driver.findElement(By.cssSelector("input[name='ManufacturerADPUntil']")).sendKeys(mfgadp);
        driver.findElement(By.cssSelector("input[name='ThirdPartywarrantyuntil']")).sendKeys(tdpextwarranty);
        driver.findElement(By.cssSelector("input[name='thirdpartyadpuntil']")).sendKeys(tdpadp);
        //click on save device
        manageDevicePage.clickOnSaveDevice();
        Thread.sleep(3000);
    }
    @Test
    public void editDeviceWithNewUser() throws IOException, InterruptedException {
        NewDeviceDetails newDeviceDetails= JacksonUtils.deserializeJson("editdevicedata.json", NewDeviceDetails.class);
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        Thread.sleep(5000);
        //click on edit device
        driver.findElement(By.cssSelector("img[inventoryid$='266133']:nth-child(1)")).click();
        //edit device info
        Thread.sleep(5000);
        manageDevicePage.
                enterBuilding(newDeviceDetails.getBuildingname()).
                enterDeviceModel(newDeviceDetails.getDevicemodel()).
                enterDeviceMfc(newDeviceDetails.getDevicemfc()).
                enterDeviceMpn(newDeviceDetails.getDevicempn()).
                enterAssetTag(newDeviceDetails.getAssettag()).
                enterrepairCap(newDeviceDetails.getRepaircap()).
                enterDeviceOS(newDeviceDetails.getDeviceOS());
        //filling notes
        driver.findElement(By.cssSelector("textarea[name='deviceos']")).sendKeys("Edited Device");
        //filling warranty details
        NewDeviceWarrantyDetails newDeviceWarrantyDetails=JacksonUtils.deserializeJson("newdevicewarrantydetails.json",NewDeviceWarrantyDetails.class);

        String purchasedate=newDeviceWarrantyDetails.getPurchasedate();
        String deviceretirement=newDeviceWarrantyDetails.getDeviceretirement();
        String mfgwarranty=newDeviceWarrantyDetails.getMfgwarranty();
        String mfgadp=newDeviceWarrantyDetails.getMfgadp();
        String tdpextwarranty=newDeviceWarrantyDetails.getTdpextwarranty();
        String tdpadp=newDeviceWarrantyDetails.getTdpadp();
        Thread.sleep(3000);
        //filling waranty details
        driver.findElement(By.cssSelector("input[name='PurchaseDate']")).sendKeys(purchasedate);
        driver.findElement(By.cssSelector("input[name='expectedretirement']")).sendKeys(deviceretirement);
        driver.findElement(By.cssSelector("input[name='ManufacturerWarrentyUntil']")).sendKeys(mfgwarranty);
        driver.findElement(By.cssSelector("input[name='ManufacturerADPUntil']")).sendKeys(mfgadp);
        driver.findElement(By.cssSelector("input[name='ThirdPartywarrantyuntil']")).sendKeys(tdpextwarranty);
        driver.findElement(By.cssSelector("input[name='thirdpartyadpuntil']")).sendKeys(tdpadp);

        //asign a new user
        driver.findElement(By.cssSelector("div[class='form-check'] input[name='AssignDevice']")).click();
        //filling details of a new user
        UserDetails userDetails=JacksonUtils.deserializeJson("userdetails.json", UserDetails.class);

        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys(userDetails.getFname());
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(userDetails.getLname());
        driver.findElement(By.cssSelector("input[name='middleName']")).sendKeys(userDetails.getMiddlename());
        driver.findElement(By.cssSelector("input[name='studentID']")).sendKeys(userDetails.getUserid());
        driver.findElement(By.cssSelector("input[name='grade']")).sendKeys(userDetails.getGrade());
        driver.findElement(By.cssSelector("input[name='guardianemail']")).sendKeys(userDetails.getParentemail());
        driver.findElement(By.cssSelector("input[name='guardianName']")).sendKeys(userDetails.getParentname());
        driver.findElement(By.cssSelector("input[name='parentphonenumber']")).sendKeys(userDetails.getParentnumber());
        //click on save device
        manageDevicePage.clickOnSaveDevice();
        Thread.sleep(3000);
    }
    @Test
    public void editDeviceWithExistingUser() throws IOException, InterruptedException {
        NewDeviceDetails newDeviceDetails= JacksonUtils.deserializeJson("editdevicedata.json", NewDeviceDetails.class);
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        Thread.sleep(5000);
        //click on edit device
        driver.findElement(By.cssSelector("img[inventoryid$='266133']:nth-child(1)")).click();
        //edit device info
        Thread.sleep(5000);
        manageDevicePage.
                enterBuilding(newDeviceDetails.getBuildingname()).
                enterDeviceModel(newDeviceDetails.getDevicemodel()).
                enterDeviceMfc(newDeviceDetails.getDevicemfc()).
                enterDeviceMpn(newDeviceDetails.getDevicempn()).
                enterAssetTag(newDeviceDetails.getAssettag()).
                enterrepairCap(newDeviceDetails.getRepaircap()).
                enterDeviceOS(newDeviceDetails.getDeviceOS());
        //filling notes
        driver.findElement(By.cssSelector("textarea[name='deviceos']")).sendKeys("Edited Device");
        //filling warranty details
        NewDeviceWarrantyDetails newDeviceWarrantyDetails=JacksonUtils.deserializeJson("newdevicewarrantydetails.json",NewDeviceWarrantyDetails.class);

        String purchasedate=newDeviceWarrantyDetails.getPurchasedate();
        String deviceretirement=newDeviceWarrantyDetails.getDeviceretirement();
        String mfgwarranty=newDeviceWarrantyDetails.getMfgwarranty();
        String mfgadp=newDeviceWarrantyDetails.getMfgadp();
        String tdpextwarranty=newDeviceWarrantyDetails.getTdpextwarranty();
        String tdpadp=newDeviceWarrantyDetails.getTdpadp();
        Thread.sleep(3000);
        //filling waranty details
        driver.findElement(By.cssSelector("input[name='PurchaseDate']")).sendKeys(purchasedate);
        driver.findElement(By.cssSelector("input[name='expectedretirement']")).sendKeys(deviceretirement);
        driver.findElement(By.cssSelector("input[name='ManufacturerWarrentyUntil']")).sendKeys(mfgwarranty);
        driver.findElement(By.cssSelector("input[name='ManufacturerADPUntil']")).sendKeys(mfgadp);
        driver.findElement(By.cssSelector("input[name='ThirdPartywarrantyuntil']")).sendKeys(tdpextwarranty);
        driver.findElement(By.cssSelector("input[name='thirdpartyadpuntil']")).sendKeys(tdpadp);
        //asign a new user
        driver.findElement(By.cssSelector("div[class='form-check'] input[name='AssignDevice']")).click();
        //click on existing user
        driver.findElement(By.cssSelector("div[class='form-check'] input[name='existingnew']")).click();
        //search for existing user
        driver.findElement(By.cssSelector("input[placeholder='Search User']")).sendKeys("shan");
        Thread.sleep(3000);
        //select existing user
        driver.findElement(By.cssSelector("div[utilizerid='35070']")).click();
        Thread.sleep(3000);
        //click on save device
        manageDevicePage.clickOnSaveDevice();
        Thread.sleep(3000);
    }

    @Test
    public void editDeviceNewModalWithAttachedUser() throws IOException, InterruptedException {
        NewDeviceDetails newDeviceDetails= JacksonUtils.deserializeJson("editdevicedata.json", NewDeviceDetails.class);
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        Thread.sleep(3000);

        //click on show device details
        driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(7) img:nth-child(3)")).click();
        //edit device info
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div[class='modal-body'] button:nth-child(1)")).click();
        Thread.sleep(5000);
        manageDevicePage.
                enterBuilding(newDeviceDetails.getBuildingname()).
                enterDeviceModel(newDeviceDetails.getDevicemodel()).
                enterDeviceMfc(newDeviceDetails.getDevicemfc()).
                enterDeviceMpn(newDeviceDetails.getDevicempn()).
                enterAssetTag(newDeviceDetails.getAssettag()).
                enterrepairCap(newDeviceDetails.getRepaircap()).
                enterDeviceOS(newDeviceDetails.getDeviceOS());
        //filling notes
        WebElement noteElmfld =driver.findElement(By.cssSelector("textarea[name='deviceos']"));
        noteElmfld.clear();
        noteElmfld.sendKeys("Device Edited");
        //filling warranty details
        NewDeviceWarrantyDetails newDeviceWarrantyDetails=JacksonUtils.deserializeJson("newdevicewarrantydetails.json",NewDeviceWarrantyDetails.class);

        String purchasedate=newDeviceWarrantyDetails.getPurchasedate();
        String deviceretirement=newDeviceWarrantyDetails.getDeviceretirement();
        String mfgwarranty=newDeviceWarrantyDetails.getMfgwarranty();
        String mfgadp=newDeviceWarrantyDetails.getMfgadp();
        String tdpextwarranty=newDeviceWarrantyDetails.getTdpextwarranty();
        String tdpadp=newDeviceWarrantyDetails.getTdpadp();
        Thread.sleep(3000);
       //filling waranty details
        driver.findElement(By.cssSelector("input[name='PurchaseDate']")).sendKeys(purchasedate);
        driver.findElement(By.cssSelector("input[name='expectedretirement']")).sendKeys(deviceretirement);
        driver.findElement(By.cssSelector("input[name='ManufacturerWarrentyUntil']")).sendKeys(mfgwarranty);
        driver.findElement(By.cssSelector("input[name='ManufacturerADPUntil']")).sendKeys(mfgadp);
        driver.findElement(By.cssSelector("input[name='ThirdPartywarrantyuntil']")).sendKeys(tdpextwarranty);
        driver.findElement(By.cssSelector("input[name='thirdpartyadpuntil']")).sendKeys(tdpadp);
        //click on save device
        manageDevicePage.clickOnSaveDevice();
        Thread.sleep(3000);

    }
    @Test
    public void showDeviceDetails() throws InterruptedException {
        String deviceid="555349";
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        //waiting for all devices loading
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("img[inventoryid$='"+deviceid+"']:nth-child(3)")).click();
        Thread.sleep(3000);


    }

    @Test
    public void activeToLoanerDevice() throws IOException, InterruptedException {
        String deviceid="D13";
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[name='"+deviceid+"']")).click();
        //waiting for dropdown
        Thread.sleep(3000);
       Select select = new Select(driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > main:nth-child(3) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > select:nth-child(1)")));
       select.selectByVisibleText("Loaner");
       Thread.sleep(3000);
    }

    @Test
    public void activeToDecommissionedDevices() throws IOException, InterruptedException {
        String deviceid="D12";
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[name='"+deviceid+"']")).click();
        //waiting for dropdown
        Thread.sleep(3000);
        Select select = new Select(driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > main:nth-child(3) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > select:nth-child(1)")));
        select.selectByVisibleText("Decommission");
        //click on continue
        driver.findElement(By.cssSelector(".SaveBtn.mx-2")).click();
        Thread.sleep(3000);
    }

    @Test
    public void searchDevice(){
        String deviceid="WS154";
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(deviceid, Keys.ENTER);
    }
    @Test
    public void loanerToDecommissionedDevice() throws InterruptedException {
        String deviceid="WS157";
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        driver.findElement(By.xpath("//a[normalize-space()='Loaner Devices']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[name='"+deviceid+"']")).click();
        //waiting for dropdown
        Thread.sleep(3000);
        Select select = new Select(driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > main:nth-child(3) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > select:nth-child(1)")));
        select.selectByVisibleText("Decommission");
        //click on continue
        driver.findElement(By.cssSelector(".SaveBtn.mx-2")).click();
        Thread.sleep(3000);
        String alertmsg=driver.findElement(By.cssSelector(".alert")).getText();
        System.out.println(alertmsg);
        Assert.assertEquals(alertmsg,"Device Decommission Successfully.");
    }
    @Test
    public void loanerToActiveDevice() throws InterruptedException {
        String deviceid="TEST007";
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        driver.findElement(By.xpath("//a[normalize-space()='Loaner Devices']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[name='"+deviceid+"']")).click();
        //waiting for dropdown
        Thread.sleep(3000);
        Select select = new Select(driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > main:nth-child(3) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > select:nth-child(1)")));
        select.selectByVisibleText("Active");
        Thread.sleep(3000);

        String alertmsg=driver.findElement(By.cssSelector(".alert")).getText();
        System.out.println(alertmsg);
        Assert.assertEquals(alertmsg,"Device Activate Successfully.");
    }
    @Test
    public void decommissionToLoaner() throws InterruptedException {
        String deviceid="D10";
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        driver.findElement(By.xpath("//a[normalize-space()='Decommissioned Devices']")).click();
        Thread.sleep(3000);
        //click on device
        driver.findElement(By.cssSelector("input[name='"+deviceid+"']")).click();
        //waiting for dropdown
        Thread.sleep(3000);
        Select select = new Select(driver.findElement(By.xpath("//div[@class='pt-1 ']/child::select")));
        select.selectByVisibleText("Loaner");
        Thread.sleep(3000);

    }
    @Test
    public void decommissionToActive() throws InterruptedException {
        String deviceid="WS153";
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        driver.findElement(By.xpath("//a[normalize-space()='Decommissioned Devices']")).click();
        Thread.sleep(3000);
        //click on device
        driver.findElement(By.cssSelector("input[name='"+deviceid+"']")).click();
        //waiting for dropdown
        Thread.sleep(3000);
        Select select = new Select(driver.findElement(By.xpath("//div[@class='pt-1 ']/child::select")));
        select.selectByVisibleText("Active");
        Thread.sleep(3000);

    }
    @Test
    public void checkSerialNumberExists() throws InterruptedException {
        String deviceserialno="D13";
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices().clickAddDevice();
        manageDevicePage.enterSerialNumber(deviceserialno);
        //click on save device
        manageDevicePage.clickOnSaveDevice();
        //check device already msg appear successfully
        Thread.sleep(3000);
        String alertmsg=driver.findElement(By.cssSelector(".alert")).getText();
        Assert.assertEquals(alertmsg,"Serial Number already exists");

    }
    @Test
    public void sortBy() throws InterruptedException {
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        //wait for devices to load
        Thread.sleep(3000);
        //click on serial
        driver.findElement(By.cssSelector("th[title$='Sort by']:nth-child(2)")).click();
        Thread.sleep(3000);
        //click on asset tag
        driver.findElement(By.cssSelector("th[title$='Sort by']:nth-child(3)")).click();
        Thread.sleep(3000);
        //click on user
        driver.findElement(By.cssSelector("th[title$='Sort by']:nth-child(4)")).click();
        Thread.sleep(3000);
        //click on building
        driver.findElement(By.cssSelector("th[title$='Sort by']:nth-child(5)")).click();
        Thread.sleep(3000);
        //click on purchase date
        driver.findElement(By.cssSelector("th[title$='Sort by']:nth-child(6)")).click();
        Thread.sleep(3000);


    }
    @Test
    public void createTicket() throws InterruptedException {
        String deviceIVid="555346";
        String notes="ticket notes added";

        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        //wait for devices to load
        Thread.sleep(3000);
        //click on create ticket
        driver.findElement(By.cssSelector("img[inventoryid$='"+deviceIVid+"']:nth-child(2)")).click();
        Thread.sleep(3000);
        //select issues
        driver.findElement(By.cssSelector("input[issueid$='1']")).click();
        driver.findElement(By.cssSelector("input[issueid$='2']")).click();
        driver.findElement(By.cssSelector("input[issueid$='4']")).click();
        //enter notes
        WebElement noteElm=driver.findElement(By.cssSelector("textarea[placeholder='Notes']"));
        noteElm.clear();
        noteElm.sendKeys(notes);
        //click on create ticket
        driver.findElement(By.cssSelector(".SaveBtn")).click();
        Thread.sleep(3000);


    }
    @Test
    public void pagination() throws InterruptedException {
        ManageDevicePage manageDevicePage= new ManageDevicePage(driver);
        manageDevicePage.clickOnDeviceUser().clickOnManageDevices();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[aria-label='Go to next page']")).click();

    }

}
