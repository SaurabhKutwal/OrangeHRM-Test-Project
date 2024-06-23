package ORHRM.Test.pages;

import ORHRM.Test.SuiteBase;
import ORHRM.Test.pages.UtilityPages.PageFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Hashtable;

public class MyInfoPage extends SuiteBase {

    @FindBy(xpath = "//div[@class = 'orangehrm-edit-employee-content']")
    WebElement employeeContent;

    @FindBy(xpath = "//input[@name = 'firstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name = 'middleName']")
    WebElement middleName;

    @FindBy(xpath = "//input[@name = 'lastName']")
    WebElement lastName;

    @FindBy(xpath = "//*[text() = 'Assigned Emergency Contacts']/following-sibling::button/i")
    WebElement asssignedEmerCnt;

    public MyInfoPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        driver.manage().window().maximize();
    }

    public void navigateTo(String subnode){
        wait.until(ExpectedConditions.visibilityOf(employeeContent));
        PageFunctions.clickOnLink(subnode);
    }

    public boolean checkFirstName(){
        wait.until(ExpectedConditions.visibilityOf(firstName));
        return firstName.isEnabled();
    }

    public boolean checkMiddleName(){
        wait.until(ExpectedConditions.visibilityOf(middleName));
        return middleName.isEnabled();
    }

    public boolean checkLastName(){
        wait.until(ExpectedConditions.visibilityOf(lastName));
        return lastName.isEnabled();
    }

    public boolean checkField(String field){
        wait.until(ExpectedConditions.visibilityOf(employeeContent));
        WebElement ele = driver.findElement(By.xpath("//label[contains(text(),'" + field + "')]/parent::div/following-sibling::div//input"));
        return ele.isEnabled();
    }

    public boolean checkDropdown(String field){
        wait.until(ExpectedConditions.visibilityOf(employeeContent));
        WebElement ele = driver.findElement(By.xpath("//label[contains(text(),'" + field + "')]/parent::div/following-sibling::div//child::div[contains(text(),'Select')]"));
        return ele.isEnabled();
    }

    public String addEmergencyContact(Hashtable<String, String> emrgContactData){
        wait.until(ExpectedConditions.visibilityOf(asssignedEmerCnt));
        asssignedEmerCnt.click();

        for(String field : emrgContactData.keySet()){
            driver.findElement(By.xpath("//label[contains(text(),'" + field + "')]" +
                    "/parent::div/following-sibling::div//input")).sendKeys(emrgContactData.get(field));
        }

        PageFunctions.clickBtn("Save");

        try{
            WebElement toaster = driver.findElement(By.xpath("(//div[@id = 'oxd-toaster_1']//p)[2]"));
            wait.until(ExpectedConditions.visibilityOf(toaster));
            // System.out.println("Msg : " + msg);
            return toaster.getText();
        }
        catch(Exception e){
            //System.out.println("Not Found : " + e.getCause());
            return "No Toaster";
        }
    }
}

