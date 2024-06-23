package ORHRM.Test.pages;

import ORHRM.Test.SuiteBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends SuiteBase {

    //WebDriver driver;

    @FindBy(xpath = "//input[@name = 'username']")
    WebElement username;

    @FindBy(xpath = "//input[@name = 'password']")
    WebElement password;

    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement errorMsg;


    public LoginPage(WebDriver drive){
       // this.driver = drive;
        PageFactory.initElements(driver,this);
        driver.manage().window().maximize();
    }

    public void login(String userName, String passWord){
        username.sendKeys(userName);
        password.sendKeys(passWord);
        loginBtn.click();
    }

    public String getMsg(){
        try{
            return errorMsg.getText();
        }
        catch (Exception e){
            return "No Msg";
        }
    }

    public void logout(){

    }
}
