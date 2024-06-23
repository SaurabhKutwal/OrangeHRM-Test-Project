package ORHRM.Test.pages.UtilityPages;

import ORHRM.Test.SuiteBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageFunctions extends SuiteBase {

    public static void node(String nodeName){
        String nodeEle = "//span[text() = '" + nodeName + "']/parent::a";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(nodeEle))));
        driver.findElement(By.xpath(nodeEle)).click();
    }

    public static void clickOnLink(String link){
        String ele = "//a[text() = '" + link + "']";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ele))));
        driver.findElement(By.xpath(ele)).click();
    }

    public static void clickBtn(String btn){
        WebElement btnele = driver.findElement(By.xpath("//button[text()[normalize-space() = '" + btn + "']]"));
        wait.until(ExpectedConditions.visibilityOf(btnele));
        btnele.click();
    }
}
