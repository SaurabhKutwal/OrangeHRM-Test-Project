package Rough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RoughTest {


    @Test
    void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

}
