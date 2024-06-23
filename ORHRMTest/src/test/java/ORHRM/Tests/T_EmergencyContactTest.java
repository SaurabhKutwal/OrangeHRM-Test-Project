package ORHRM.Tests;

import ORHRM.Test.SuiteBase;
import ORHRM.Test.pages.DashboardPage;
import ORHRM.Test.pages.LoginPage;
import ORHRM.Test.pages.MyInfoPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Hashtable;

public class T_EmergencyContactTest extends SuiteBase {

    LoginPage loginPage;
    DashboardPage dbPage;
    MyInfoPage myInfoPage;

    @BeforeTest
    public void start(){
        launchBrowser();
        loginPage = new LoginPage(driver);
        loginPage.login(param.getProperty("username"),param.getProperty("password"));
    }

    @Test(dataProvider = "EmergencyContacts")
    public void T_EmergencyContactTest(Hashtable<String, String> emergencyCntData) throws InterruptedException {

        dbPage = new DashboardPage(driver);
        Thread.sleep(3000);
        dbPage.goTo("My Info");

        myInfoPage = new MyInfoPage(driver);
        Thread.sleep(3000);
        myInfoPage.navigateTo("Emergency Contacts");

        Assert.assertEquals(myInfoPage.addEmergencyContact(emergencyCntData),"Successfully Saved");
    }

    @AfterTest
    public void close(){
        dbPage.logout();
    }

    @DataProvider(name = "EmergencyContacts")
    public Object[][] emergencyContactData(){
        return new Object[][]{
                {new Hashtable<String,String>(){{
                    put("Name","Bob");
                    put("Relationship","Relative");
                    put("Home Telephone","1234567");
                    put("Mobile","1234567890");
                    put("Work Telephone","0987654321");
                }}}
        };
    }
}
