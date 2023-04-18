package Session6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
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

    @BeforeMethod
    public void init(){
        System.out.println("Before Class");
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("http://www.techfios.com/billing/?ng=admin/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest(){
        driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
        driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
        driver.findElement(SIGNIN_FIELD).click();
        String getTextField = driver.findElement(DASHBOARD_HEADER_FIELD).getText();
        Assert.assertEquals(getTextField, "Dashboard" ,"Dashboard page not found!");
    }


    public void selectFromDropDown(By locator, String visibilityText){
        Select sel = new Select(driver.findElement(locator));
        sel.selectByVisibleText(visibilityText);
    }

}
