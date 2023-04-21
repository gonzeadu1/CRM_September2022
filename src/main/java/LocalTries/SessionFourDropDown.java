package LocalTries;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SessionFourDropDown {
    WebDriver driver;

    // storing element on By type
    By USERNAME_FIELD = By.xpath("//input[@id='username']");
    By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
    By SIGNIN_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
    By DASHBOARD_HEADER_FIELD = By.xpath("//h2[contains(text(), 'Dashboard')]");
    By CUSTOMERS_MENU_FIELD = By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]");
    By ADD_CUSTOMERS_MENU_FIELD = By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a");
    By ADD_C0NTACT_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5");
    By FULLNAME_FIELD = By.xpath("//input[@id='account']");
    By COMPANY_DROPDOWN_FIELD = By.xpath("//select[@id='cid']");

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("http://www.techfios.com/billing/?ng=admin/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void LoginTest(){
        driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
        driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
        driver.findElement(SIGNIN_FIELD).click();


        Assert.assertTrue("Session7_POM_Project.Page not found!!!", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
        Assert.assertEquals("page not found", "Dashboard- iBilling", driver.getTitle());
        System.out.println("this is the title: " + driver.getTitle());
        WebElement Dashboard = driver.findElement(DASHBOARD_HEADER_FIELD);
        Assert.assertEquals("page not found", "Dashboard", Dashboard.getText());
    }

    @Test
    public void testDropDown(){
        LoginTest();

        driver.findElement(CUSTOMERS_MENU_FIELD).click();
        driver.findElement(ADD_CUSTOMERS_MENU_FIELD).click();
        WebElement AddContact = driver.findElement(ADD_C0NTACT_HEADER_FIELD);

        Assert.assertEquals("Add Contact page not found", "Add Contact", AddContact.getText());

        driver.findElement(FULLNAME_FIELD).sendKeys("Gideon Nzeadu");

        Select sel = new Select(driver.findElement(COMPANY_DROPDOWN_FIELD));
        sel.selectByVisibleText("Tesla");


    }
}
