package session7_POM_Project;

import Session7_POM_Project.Page.AddCustomerPage;
import Session7_POM_Project.Page.DashboardPage;
import Session7_POM_Project.Page.LoginPage;
import Session7_POM_Project.Util.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AddCustomerTest {
    WebDriver driver;
    String userName = "demo@techfios.com";
    String password = "abc123";

    @Test
    public void userShouldBeAbleToAddCustomer(){
     driver = BrowserFactory.init();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.insertUserName(userName);
        loginPage.insertPassword(password);
        loginPage.clickOnSigninButton();

        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        dashboardPage.validateDashboard();
        dashboardPage.clickAddCustomerMenuElement();
        dashboardPage.clickAddCustomerMenuElement();

        AddCustomerPage addCustomerPage= PageFactory.initElements(driver, AddCustomerPage.class);
        addCustomerPage.validateAddContactPage();
    }
}
