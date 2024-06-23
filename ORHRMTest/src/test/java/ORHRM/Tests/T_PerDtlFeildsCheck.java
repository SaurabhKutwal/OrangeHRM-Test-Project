package ORHRM.Tests;

import ORHRM.Test.SuiteBase;
import ORHRM.Test.pages.DashboardPage;
import ORHRM.Test.pages.LoginPage;
import ORHRM.Test.pages.MyInfoPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.format.SignStyle;

public class T_PerDtlFeildsCheck extends SuiteBase {

    LoginPage loginPage;
    DashboardPage dbPage;
    MyInfoPage myInfoPage;

    @BeforeTest
    public void start() throws InterruptedException, IOException {

       // init();
        launchBrowser();
        loginPage = new LoginPage(driver);
        loginPage.login(param.getProperty("username"),param.getProperty("password"));

        dbPage = new DashboardPage(driver);
        Thread.sleep(3000);
        dbPage.goTo("My Info");

        myInfoPage = new MyInfoPage(driver);
        Thread.sleep(3000);
        myInfoPage.navigateTo("Personal Details");
    }

    @Test(dataProvider = "data")
    public void T_perDtlFieldsCheck(String field){
        switch(field){
            case "firstname":
                Assert.assertTrue(myInfoPage.checkFirstName());
                break;

            case "middlename":
                Assert.assertTrue(myInfoPage.checkMiddleName());
                break;

            case "lastname" :
                Assert.assertTrue(myInfoPage.checkLastName());
                break;

            case "Employee Id":
                Assert.assertTrue(myInfoPage.checkField(field));
                break;

            case "Other Id":
                Assert.assertTrue(myInfoPage.checkField(field));
                break;

            case "License Number":
                Assert.assertTrue(myInfoPage.checkField(field));
                break;

            case "License Expiry Date":
                Assert.assertTrue(myInfoPage.checkField(field));
                break;

            case "Date of Birth":
                Assert.assertTrue(myInfoPage.checkField(field));
                break;

            case "Nationlity":
                Assert.assertTrue(myInfoPage.checkDropdown(field));
                break;

            case "Marital Status":
                Assert.assertTrue(myInfoPage.checkDropdown(field));
                break;

            case "Blood Type":
                Assert.assertTrue(myInfoPage.checkDropdown(field));
                break;

        }
    }

    @AfterTest
    public void close(){
        dbPage.logout();
    }

    @DataProvider
    public Object[][] data(){
        return new Object[][]{
                {"firstname"},
                {"middlename"},
                {"lastname"},
                {"Employee Id"},
                {"Other Id"},
                {"License Number"},
                {"License Expiry Date"},
                {"Date of Birth"},
                {"Nationality"},
                {"Marital Status"},
                {"Blood Type"}
        };
    }
}
