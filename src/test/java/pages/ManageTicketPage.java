package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ManageTicketPage extends BasePage {
    private final By openTickets=By.xpath("//a[normalize-space()='Open Tickets']");
    private final By closedTickets=By.xpath("//a[normalize-space()='Closed Tickets']");
    private final By repairedTickets=By.xpath("//a[normalize-space()='Repaired Tickets']");
    private final By allTickets=By.xpath("//a[normalize-space()='All Tickets']");
    private final By repairs=By.xpath("//div[normalize-space()='Repairs']");
    private final By manageTicets=By.xpath("//div[normalize-space()='Manage Tickets']");
    private final By createTicket=By.xpath("//label[normalize-space()='Create Ticket']");
    private final By searchfld=By.cssSelector("input[type$='text']");
    private final By creaticketbtn=By.xpath("//button[normalize-space()='Create Ticket']");
    private final By ticketnotefld=By.cssSelector("textarea[placeholder='Notes']");
    private final By ticketStatusDropdown=By.cssSelector("div[class='col-md-3'] div select");

    public ManageTicketPage(WebDriver driver) {
        super(driver);
    }
    public ManageTicketPage clickOnOpenTickets() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(openTickets)).click();
        Thread.sleep(3000);
        return this;
    }
    public ManageTicketPage clickOnClosedTickets() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(closedTickets)).click();
        Thread.sleep(3000);
        return this;
    }
    public ManageTicketPage clickOnRepairedTickets() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(repairedTickets)).click();
        Thread.sleep(3000);
        return this;
    }
    public ManageTicketPage clickOnAllTickets() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(allTickets)).click();
        Thread.sleep(3000);
        return this;
    }
    public ManageTicketPage clickOnRepairs() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(repairs)).click();
        Thread.sleep(5000);
        return this;
    }
    public ManageTicketPage clickOnManageTickets(){
        wait.until(ExpectedConditions.elementToBeClickable(manageTicets)).click();
        return this;
    }
    public ManageTicketPage clickOnCreateTicket() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(createTicket)).click();
        Thread.sleep(3000);
        return this;
    }
    public ManageTicketPage eneterDataOnSearchfld(String data) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(searchfld)).sendKeys(data);
        Thread.sleep(3000);
        return this;
    }
    public ManageTicketPage clickCreateTicket(){
        wait.until(ExpectedConditions.elementToBeClickable(creaticketbtn)).click();
        return this;
    }
    public ManageTicketPage enterNotefld(String data){
        wait.until(ExpectedConditions.elementToBeClickable(ticketnotefld)).sendKeys(data);
        return this;
    }
    public ManageTicketPage enter(String data){
        wait.until(ExpectedConditions.elementToBeClickable(ticketnotefld)).sendKeys(data);
        return this;
    }
    public ManageTicketPage enterTicketStatus(String status){
        Select select =new Select(driver.findElement(ticketStatusDropdown));
        select.selectByVisibleText(status);
        return this;

    }

}
