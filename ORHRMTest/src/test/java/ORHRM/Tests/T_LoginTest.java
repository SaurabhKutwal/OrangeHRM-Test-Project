package ORHRM.Tests;

import ORHRM.Test.SuiteBase;
import ORHRM.Test.pages.DashboardPage;
import ORHRM.Test.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class T_LoginTest extends SuiteBase {

    LoginPage loginPage;

    @BeforeTest
    public void start() throws IOException {
        System.out.println("!!!!!");
        //init();
        loginPage = new LoginPage(driver);
        launchBrowser();
    }

    @Test(dataProvider = "data")
    public void T_LoginTest(String userName, String passWord,String expected) {

        loginPage.login(userName,passWord);
        String msg = loginPage.getMsg();

        Assert.assertEquals(msg,expected);
    }

    @AfterTest
    public void close(){
        DashboardPage dbPage = new DashboardPage(driver);
        dbPage.logout();
    }

    @Test
    public void T_Sample(){
        System.out.println("Sample only");
    }

    @DataProvider
    public Object[][] data(){
        return new Object[][]{
                {"abcd","abcd","Invalid credentials"},
                {"ace19","abcd","Invalid credentials"},
                {"abcd","ACE19@ORhrm","Invalid credentials"},
                {"ace19","ACE19@ORhrm","No Msg"}
        };
    }
}
