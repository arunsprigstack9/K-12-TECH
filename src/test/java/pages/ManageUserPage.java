package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManageUserPage extends BasePage {
    private final By deviceUser=By.xpath("//aside[@class='sidebar-wrapper']//li[3]//a[1]");
    private final By manageUsers=By.xpath("//div[contains(text(),'Manage Users')]");
    private final By addUser=By.xpath("//label[normalize-space()='Add User']");
    private final By firstName=By.cssSelector("input[name='firstname']");
    private final By lastName=By.cssSelector("input[name='lastName']");
    private final By middleName=By.cssSelector("input[name='middleName']");
    private final By studentID=By.cssSelector("input[name='studentID']");
    private final By grade=By.cssSelector("input[name='grade']");
    private final By guardianEmail=By.cssSelector("input[name='guardianemail']");
    private final By guardianName=By.cssSelector("input[name='guardianName']");
    private final By parentPhoneNumber=By.cssSelector("input[name='parentphonenumber']");
    private final By saveuser=By.cssSelector(".SaveBtn");
    public ManageUserPage(WebDriver driver) {
        super(driver);
    }
    public ManageUserPage clickOnDeviceUser(){
        wait.until(ExpectedConditions.elementToBeClickable(deviceUser)).click();
        return this;
    }
    public ManageUserPage clickOnManageUsers(){
        wait.until(ExpectedConditions.elementToBeClickable(manageUsers)).click();
        return this;

    }
    public ManageUserPage clickOnAddUser(){
        wait.until(ExpectedConditions.elementToBeClickable(addUser)).click();
        return this;

    }
    public ManageUserPage enterFirstName(String firstname){
        WebElement e =wait.until(ExpectedConditions.elementToBeClickable(firstName));
        e.clear();
        e.sendKeys(firstname);
        return this;
    }
    public ManageUserPage enterMiddleName(String middlename){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(middleName));
        e.clear();
        e.sendKeys(middlename);
        return this;
    }
    public ManageUserPage enterLastName(String lastname){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(lastName));
        e.clear();
        e.sendKeys(lastname);
        return this;
    }
    public ManageUserPage enterStudentID(String studentid){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(studentID));
        e.clear();
        e.sendKeys(studentid);
        return this;
    }
    public ManageUserPage enterGrade(String gradename){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(grade));
        e.clear();
        e.sendKeys(gradename);
        return this;
    }
    public ManageUserPage enterGuardianEmail(String emailid){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(guardianEmail));
        e.clear();
        e.sendKeys(emailid);
        return this;
    }
    public ManageUserPage enterGuardianName(String name){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(guardianName));
        e.clear();
        e.sendKeys(name);
        return this;
    }
    public ManageUserPage enterPhoneNumber(String phonenum){
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(parentPhoneNumber));
        e.clear();
        e.sendKeys(phonenum);
        return this;
    }
    public ManageUserPage clickSaveUser(){
        wait.until(ExpectedConditions.elementToBeClickable(saveuser)).click();
        return this;
    }

}
