package session7_POM_Project;

import Session7_POM_Project.Page.DashboardPage;
import Session7_POM_Project.Page.LoginPage;
import Session7_POM_Project.Util.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginTest {
   WebDriver driver;

    @Test
public void validUserShouldBeAbleToLogin(){
    String userName = "demo@techfios.com";
    String password = "abc123";



    driver =  BrowserFactory.init();
    //LoginPage loginPage = new LoginPage();
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
    loginPage.insertUserName(userName);
    loginPage.insertPassword(password);
    loginPage.clickOnSigninButton();

    //Dashboard Page
    dashboardPage.validateDashboard();

    BrowserFactory.tearDown();

}
}
