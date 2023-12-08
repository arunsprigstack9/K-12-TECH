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
        String deviceid="TEST007";
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
    public void createTicketWithAllDetails() throws InterruptedException, IOException {
        String deviceid="ARUNDEV123";
        String notes="ticket notes added";
        String buildingname="BLOCK-A";
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
        //select return location
        Select select=new Select(driver.findElement(By.cssSelector("select")));
        select.selectByVisibleText(buildingname);
        //wait for pop up window to select device as primary building
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[class='SaveBtn']")).click();

//        //attach images
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
    public void createTicketWithAllDetailsMultipleImgs() throws InterruptedException, IOException {
        String deviceid="C17";
        String notes="ticket notes added";
        String buildingname="BLOCK-A";
        String imgpath="C:/Users/kruna/autoit/k12filedownloadScript.exe";
        String secondimgpath="C:/Users/kruna/autoit/k12secondimg.exe";
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
        //select return location
        Select select=new Select(driver.findElement(By.cssSelector("select")));
        select.selectByVisibleText(buildingname);
        Thread.sleep(3000);
        //wait for pop up window to select device as primary building
        WebElement attachImgElm=driver.findElement(By.cssSelector(".col-md-4.col-sm-5.col-10.col-lg-4.col-xl-3"));
        scrollElementIntoView(driver,attachImgElm);
        Thread.sleep(3000);

        //attach images
        driver.findElement(By.cssSelector(".col-md-4.col-sm-5.col-10.col-lg-4.col-xl-3")).click();
        Thread.sleep(7000);
        //upload img
        Runtime.getRuntime().exec(imgpath);
        Thread.sleep(5000);
        //add a new img a
        driver.findElement(By.cssSelector(".col-md-4.col-sm-5.col-10.col-lg-4.col-xl-3")).click();
        Thread.sleep(5000);
        //upload img
        Runtime.getRuntime().exec(secondimgpath);
        Thread.sleep(7000);
        scrollElementIntoView(driver,driver.findElement(By.cssSelector(".SaveBtn")));
//        update ticket
        driver.findElement(By.cssSelector(".SaveBtn")).click();
        Thread.sleep(3000);

    }
    @Test
    public void editTicketStatus() throws InterruptedException {
        String deviceserialno="TEST007";
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
    public void showTicketDetails() throws InterruptedException {
        String ticketid="JQh4kH";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//u[normalize-space()='"+ticketid+"']")).click();
        Thread.sleep(3000);
    }
    @Test
    public void showTicketDetailsCheckAllTabs() throws InterruptedException {
        String ticketid="ZWH77F";
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
    public void showMoreTicketDetails() throws InterruptedException {
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        String ticketId="1869";
        driver.findElement(By.cssSelector("img[ticketid$='"+ticketId+"']:nth-child(2)")).click();
        Thread.sleep(3000);
    }
    @Test
    public void editTicket() throws InterruptedException {
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        String ticketid="1908";
        //click on edit
        driver.findElement(By.cssSelector("img[ticketid$='"+ticketid+"']:nth-child(1)")).click();
        Thread.sleep(3000);
        //click on issue
        driver.findElement(By.cssSelector("input[issueid$='7']")).click();
        Thread.sleep(3000);
        //click on updateticket
        driver.findElement(By.cssSelector(".SaveBtn")).click();
        Thread.sleep(3000);
    }
    @Test
    public void editTicketAttachImg() throws InterruptedException, IOException {
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        String ticketid="1927";
        String imgpath="C:/Users/kruna/autoit/k12filedownloadScript.exe";
        String secondimgpath="C:/Users/kruna/autoit/k12secondimg.exe";
        //click on edit
        driver.findElement(By.cssSelector("img[ticketid$='"+ticketid+"']:nth-child(1)")).click();
        Thread.sleep(3000);
        //click on issue
        driver.findElement(By.cssSelector("input[issueid$='7']")).click();
        Thread.sleep(3000);
        //wait for pop up window to select device as primary building
        WebElement attachImgElm=driver.findElement(By.cssSelector(".col-md-4.col-sm-5.col-10.col-lg-4.col-xl-3"));
        scrollElementIntoView(driver,attachImgElm);
        Thread.sleep(3000);

        //attach images
        driver.findElement(By.cssSelector(".col-md-4.col-sm-5.col-10.col-lg-4.col-xl-3")).click();
        Thread.sleep(7000);
        //upload img
        Runtime.getRuntime().exec(imgpath);
        Thread.sleep(5000);
        //add a new img a
        driver.findElement(By.cssSelector(".col-md-4.col-sm-5.col-10.col-lg-4.col-xl-3")).click();
        Thread.sleep(5000);
        //upload img
        Runtime.getRuntime().exec(secondimgpath);
        Thread.sleep(7000);
        //click on updateticket
        driver.findElement(By.cssSelector(".SaveBtn")).click();
        Thread.sleep(3000);

    }
    @Test
    public void addRepairs() throws InterruptedException {
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        String ticketid="1918";
        String ticketSerialno="XJvJDa";
        String repairnotes="added new repair parts";
        String repairPartnotes="repair part notes";
        String partname="Lenovo monitor";
        String partprice="90";
        String masterinvpart="Lenovo Tab 10e Battery";

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
        Thread.sleep(5000);
        //part cost
        WebElement partcostElm=driver.findElement(By.cssSelector("#PartsPrice_1734"));
        partcostElm.clear();
        partcostElm.sendKeys(partprice);
        //add notes
        WebElement noteElm=driver.findElement(By.cssSelector("#NotesId_1734"));
        noteElm.sendKeys(repairPartnotes);
        Thread.sleep(3000);
        //add a part from master inventory
        driver.findElement(By.cssSelector("input[placeholder='Search the necessary repair part with the ticket']")).sendKeys("lenovo");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//b[normalize-space()='"+masterinvpart+"']")).click();
        Thread.sleep(3000);
        WebElement masterpartELm=driver.findElement(By.cssSelector("#NotesId_2"));
        masterpartELm.clear();
        masterpartELm.sendKeys(repairnotes);
        Thread.sleep(5000);

        //mark as close ticket
//        driver.findElement(By.cssSelector("input[name='allSelect']")).click();
//        click on savedetails
        driver.findElement(By.cssSelector(".SaveBtn.mt-2")).click();
        Thread.sleep(3000);
        //new modal appear
        driver.findElement(By.cssSelector("button[class='SaveBtn']")).click();

//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//u[normalize-space()='"+ticketSerialno+"']")).click();
//        //wait for the modal
//        Thread.sleep(4000);
//        driver.findElement(By.xpath("//a[normalize-space()='Parts History']")).click();

    }
    @Test
    public void addRepairsAttachedParts() throws InterruptedException {
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        String ticketid="1870";
        String partprice="30";
        String repairnotes="added new repair parts";
        String partname="Lenovo monitor";
        String attachpartnotes="attach part note";
        String partnote="part noted added";
        //click on add repair
        driver.findElement(By.cssSelector("img[ticketid$='"+ticketid+"']:nth-child(4)")).click();
        Thread.sleep(3000);
        //repair notes

        WebElement repairnoteELm=driver.findElement(By.cssSelector("textarea[name='RepairedNm']"));
        repairnoteELm.clear();
        repairnoteELm.sendKeys(repairnotes);
        //search part in inventory
        driver.findElement(By.cssSelector("input[placeholder='Search the necessary repair part with the ticket']")).sendKeys("lenovo");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//b[normalize-space()='"+partname+"']")).click();
        Thread.sleep(3000);

        //attached part price
        //enter price
        WebElement partpriceElm =driver.findElement(By.cssSelector("input[placeholder$='Part Price']"));
        partpriceElm.clear();
        partpriceElm.sendKeys(partprice);
        //enter part notes
        WebElement partnoteElm=driver.findElement(By.cssSelector("#NotesId_1734"));
        partnoteElm.clear();
        partnoteElm.sendKeys(partnote);
        //enter attached part notes
        WebElement attachedpartnoteElm=driver.findElement(By.cssSelector("input[placeholder$='Notes']"));
        attachedpartnoteElm.clear();
        attachedpartnoteElm.sendKeys(attachpartnotes);
        //click on savedetails
        driver.findElement(By.cssSelector(".SaveBtn.mt-2")).click();
        //new modal appear
        driver.findElement(By.cssSelector("button[class='SaveBtn']")).click();
    }
    @Test
    public void searchTicket() throws InterruptedException {
        String ticketid="McfP3i";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(ticketid);
        Thread.sleep(3000);


    }
    @Test
    public void changeTicketStatusThroughModal() throws InterruptedException {
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        String ticketid="1861";
        String statusid="3";
        driver.findElement(By.cssSelector("td[ticketid$='"+ticketid+"']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[statusid$='"+statusid+"']")).click();
        //click on change status
        driver.findElement(By.cssSelector(".SaveBtn")).click();
        Thread.sleep(3000);


    }
    @Test
    public void changeTicketStatusThroughGrid() throws InterruptedException {
        String deviceId="WS150";

        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[name='"+deviceId+"']")).click();
        Thread.sleep(3000);
//        wait for dropdown
        Select select=new Select(driver.findElement(By.cssSelector("div[class='col-md-3'] div select")));
        select.selectByVisibleText("In Progress");
        Thread.sleep(3000);

    }
    @Test
    public void showDevicedetails() throws InterruptedException {
        String deviceid="WS156";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//u[normalize-space()='"+deviceid+"']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Ticket Details']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("img[title='Show Ticket History']")).click();

    }
    @Test
    public void sortBY() throws InterruptedException {
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        //click on ticket
        driver.findElement(By.cssSelector("th[title='Sort by Ticket #']")).click();
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
    public void changeTicketStatusDropDown() throws InterruptedException {
        String deviceSerialno="WS157";
        ManageTicketPage manageTicket=new ManageTicketPage(driver);
        manageTicket.clickOnRepairs().clickOnManageTickets();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[name='"+deviceSerialno+"']")).click();
        Thread.sleep(3000);
        Select select=new Select(driver.findElement(By.cssSelector("div[class='col-md-3'] div select")));
        select.selectByVisibleText("Closed");
        Thread.sleep(3000);
//        driver.findElement(By.cssSelector("#FreeDevice")).click();
        //loaner device
        driver.findElement(By.cssSelector("#ParmanentDevice")).click();
        driver.findElement(By.cssSelector(".SaveBtn")).click();


    }

    public static void scrollElementIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'start', inline: 'nearest' });", element);
    }

}
