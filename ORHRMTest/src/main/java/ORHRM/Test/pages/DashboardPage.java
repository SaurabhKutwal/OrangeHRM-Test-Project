package ORHRM.Test.pages;

import ORHRM.Test.SuiteBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage extends SuiteBase {

    //WebDriver driver;

    @FindBy(xpath = "//p[@class = 'oxd-userdropdown-name']")
    WebElement profile;

    @FindBy(xpath = "//ul[@class = 'oxd-dropdown-menu']//a[text() = 'Logout']")
    WebElement logout;
    public DashboardPage(WebDriver driver){
        //this.driver = driver;
        PageFactory.initElements(driver,this);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public void goTo(String node){
        String nodeEle = "//span[text() = '" + node + "']/parent::a";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(nodeEle))));
        driver.findElement(By.xpath(nodeEle)).click();
    }

    public void logout(){
        profile.click();
        wait.until(ExpectedConditions.visibilityOf(logout));
        logout.click();
    }
}
