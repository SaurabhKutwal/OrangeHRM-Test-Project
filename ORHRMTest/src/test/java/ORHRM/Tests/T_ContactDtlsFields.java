package ORHRM.Tests;

import ORHRM.Test.SuiteBase;
import ORHRM.Test.pages.DashboardPage;
import ORHRM.Test.pages.LoginPage;
import ORHRM.Test.pages.MyInfoPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class T_ContactDtlsFields extends SuiteBase {
    LoginPage loginPage;
    DashboardPage dbPage;
    MyInfoPage myInfoPage;

    @BeforeTest
    public void start() throws InterruptedException, IOException {

        launchBrowser();
        loginPage = new LoginPage(driver);
        loginPage.login(param.getProperty("username"),param.getProperty("password"));

        dbPage = new DashboardPage(driver);
        Thread.sleep(3000);
        dbPage.goTo("My Info");

        myInfoPage = new MyInfoPage(driver);
        Thread.sleep(3000);
        myInfoPage.navigateTo("Contact Details");
    }

    @Test(dataProvider = "data")
    public void T_ContactDtlsFields(String field){
        switch(field){
            case "Street 1":
                Assert.assertTrue(myInfoPage.checkField(field));
                break;

            case "Street 2":
                Assert.assertTrue(myInfoPage.checkField(field));
                break;

            case "City" :
                Assert.assertTrue(myInfoPage.checkField(field));
                break;

            case "State":
                Assert.assertTrue(myInfoPage.checkField(field));
                break;

            case "Zip":
                Assert.assertTrue(myInfoPage.checkField(field));
                break;

            case "Country":
                Assert.assertTrue(myInfoPage.checkDropdown(field));
                break;

            case "Home":
                Assert.assertTrue(myInfoPage.checkField(field));
                break;

            case "Mobile":
                Assert.assertTrue(myInfoPage.checkField(field));
                break;

            case "Work Email":
                Assert.assertTrue(myInfoPage.checkField(field));
                break;

            case "Other Email":
                Assert.assertTrue(myInfoPage.checkField(field));
                break;

//            case "Blood Type":
//                Assert.assertTrue(myInfoPage.checkDropdown(field));
//                break;

        }
    }

    @AfterTest
    public void close(){
        dbPage.logout();
    }

    @DataProvider
    public Object[][] data(){
        return new Object[][]{
                {"Street 1"},
                {"Street 2"},
                {"City"},
                {"State"},
                {"Zip"},
                {"Country"},
                {"Home"},
                {"Mobile"},
                {"Work Email"},
                {"Other Email"}
        };
    }
}
