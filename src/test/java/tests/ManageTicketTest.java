package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.ManageTicketPage;

import java.io.File;
import java.io.IOException;

public class ManageTicketTest extends BaseTest {

    @Test
    public void checkTabs() throws InterruptedException {
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        manageTicket.clickOnClosedTickets().clickOnRepairedTickets().clickOnAllTickets();
        manageTicket.clickOnAllTickets().clickOnRepairedTickets().clickOnClosedTickets().clickOnOpenTickets();

    }
    @Test
    public void createTicketWithDeviceSerialID() throws InterruptedException {
        String deviceid="DEC123";
        String notes="ticket notes added";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets().clickOnCreateTicket();
        Thread.sleep(3000);
        manageTicket.eneterDataOnSearchfld(deviceid);
        driver.findElement(By.xpath("//b[normalize-space()='"+deviceid+"']")).click();
        Thread.sleep(3000);
        //select issues
        driver.findElement(By.cssSelector("input[issueid$='1']")).click();
        driver.findElement(By.cssSelector("input[issueid$='2']")).click();
        driver.findElement(By.cssSelector("input[issueid$='4']")).click();

        manageTicket.enterNotefld(notes);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".SaveBtn")).click();
        Thread.sleep(3000);



    }
    @Test
    public void createTicketChangeReturnlocationAssignLoaner() throws InterruptedException {
        String deviceid="DEC123";
        String loanerdevice="KL10";
        String loanerid="555841";
        String notes="ticket notes added";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets().clickOnCreateTicket();
        Thread.sleep(3000);
        manageTicket.eneterDataOnSearchfld(deviceid);
        driver.findElement(By.xpath("//b[normalize-space()='"+deviceid+"']")).click();
        Thread.sleep(3000);
        //select issues
        driver.findElement(By.cssSelector("input[issueid$='1']")).click();
        driver.findElement(By.cssSelector("input[issueid$='2']")).click();
        driver.findElement(By.cssSelector("input[issueid$='4']")).click();

        manageTicket.enterNotefld(notes);
        Thread.sleep(3000);
        //change return loaction
        Select returnlocation=new Select(driver.findElement(By.xpath("(//select)[1]")));
        returnlocation.selectByVisibleText("C");
        //make this location as device primary building
        driver.findElement(By.cssSelector("button[class='SaveBtn']")).click();
        Thread.sleep(3000);
        //asign a loaner
        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(loanerdevice);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div[loanerid$='"+loanerid+"']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".SaveBtn")).click();
        Thread.sleep(3000);
    }
    @Test
    public void createTicketWithAttachImage() throws InterruptedException, IOException {
        String deviceid="D1";
        String notes="ticket notes added";
        String imgpath="C:/Users/kruna/autoit/k12filedownloadScript.exe";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets().clickOnCreateTicket();
        Thread.sleep(3000);
        manageTicket.eneterDataOnSearchfld(deviceid);
        driver.findElement(By.xpath("//b[normalize-space()='"+deviceid+"']")).click();
        Thread.sleep(3000);
        //select issues
        driver.findElement(By.cssSelector("input[issueid$='1']")).click();
        driver.findElement(By.cssSelector("input[issueid$='2']")).click();
        driver.findElement(By.cssSelector("input[issueid$='4']")).click();

        manageTicket.enterNotefld(notes);
        Thread.sleep(3000);
        //attach images
         driver.findElement(By.cssSelector(".col-md-4.col-sm-5.col-10.col-lg-4.col-xl-3")).click();
         Thread.sleep(3000);
//
         Runtime.getRuntime().exec(imgpath);
         Thread.sleep(7000);
//
        driver.findElement(By.cssSelector(".SaveBtn")).click();
        Thread.sleep(3000);
    }
    @Test
    public void addRepairParts() throws InterruptedException {
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        String ticketid="2284";
        String repairnotes="added new repair parts";
        String repairPartnotes="repair part notes";
        String partname="lenovo battery";
        String masterinvpart="Lenovo Tab 10e Motherboard";

        //click on add repair
        driver.findElement(By.cssSelector("img[ticketid$='"+ticketid+"']:nth-child(4)")).click();
        Thread.sleep(3000);
        //select repair type
        driver.findElement(By.cssSelector("div[class='row mt-2'] div:nth-child(1) input:nth-child(1)")).click();
        //repair notes
        WebElement repairnoteELm=driver.findElement(By.cssSelector("textarea[name='RepairedNm']"));
        repairnoteELm.clear();
        repairnoteELm.sendKeys(repairnotes);
        //search part in inventory
        driver.findElement(By.cssSelector("input[placeholder='Search the necessary repair part with the ticket']")).sendKeys("lenovo");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//b[normalize-space()='"+partname+"']")).click();
        Thread.sleep(3000);
        //add a part from master inventory
        driver.findElement(By.cssSelector("input[placeholder='Search the necessary repair part with the ticket']")).sendKeys("lenovo");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//b[normalize-space()='"+masterinvpart+"']")).click();
        Thread.sleep(3000);

//        click on savedetails
        driver.findElement(By.cssSelector(".SaveBtn.mt-2")).click();
        Thread.sleep(3000);
        //new modal appear
        driver.findElement(By.cssSelector("button[class='SaveBtn']")).click();

        Thread.sleep(5000);

    }

    @Test
    public void changeTicketStatus() throws InterruptedException {
        String deviceserialno="D1";
        String ticketstatus="In Progress";

        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
       driver.findElement(By.cssSelector("input[name='"+deviceserialno+"']")).click();
        Thread.sleep(3000);
       manageTicket.enterTicketStatus(ticketstatus);
       Thread.sleep(3000);
    }

    @Test
    public void showTicketDetailsCheckAllTabs() throws InterruptedException {
        String ticketid="JaNtKf";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//u[normalize-space()='"+ticketid+"']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Ticket History']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Parts History']")).click();

    }

    @Test
    public void editTicket() throws InterruptedException {
        String ticketid="2286";
        String issueid="7";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);

        //click on edit
        driver.findElement(By.cssSelector("img[ticketid$='"+ticketid+"']:nth-child(1)")).click();
        Thread.sleep(3000);
        //click on issue
        driver.findElement(By.cssSelector("input[issueid$='"+issueid+"']")).click();
        Thread.sleep(3000);
        //click on updateticket
        driver.findElement(By.cssSelector(".SaveBtn")).click();
        Thread.sleep(3000);
    }

    @Test
    public void searchTicket() throws InterruptedException {
        String ticketid="At6y";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(ticketid);
        Thread.sleep(3000);


    }
    @Test
    public void changeTicketStatusThroughModal() throws InterruptedException {
        String ticketid="2286";
        String statusid="3";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("span[ticketid$='"+ticketid+"']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[statusid$='"+statusid+"']")).click();
        //click on change status
        driver.findElement(By.cssSelector(".SaveBtn")).click();
        Thread.sleep(3000);


    }

    @Test
    public void showDevicedetails() throws InterruptedException {
        String deviceid="DEC123";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//u[normalize-space()='"+deviceid+"']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Ticket Details']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("img[title='Show Ticket History']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='User History']")).click();


    }
    @Test
    public void sortBY() throws InterruptedException {
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        //click on ticket
        driver.findElement(By.cssSelector("th[title='Sort by ticket num']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("th[title='Sort by created at']")).click();
        Thread.sleep(3000);
    }
    @Test
    public void pagination() throws InterruptedException {
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        String pageno="2";
        scrollElementIntoView(driver,driver.findElement(By.xpath("//a[normalize-space()='"+pageno+"']")));
        driver.findElement(By.xpath("//a[normalize-space()='"+pageno+"']")).click();
    }

    @Test
    public void showMoreTicketDetails() throws InterruptedException {
        String ticketId="2243";

        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("img[ticketid$='"+ticketId+"']:nth-child(2)")).click();
        Thread.sleep(3000);
    }
    @Test
    public void showTicketDetails() throws InterruptedException {
        String ticketid="daIBeF";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//u[normalize-space()='"+ticketid+"']")).click();
        Thread.sleep(3000);

    }


    public static void scrollElementIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'start', inline: 'nearest' });", element);
    }

}
