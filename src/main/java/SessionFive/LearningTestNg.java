package SessionFive;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LearningTestNg {
    WebDriver driver;
    String url;
    String browser;

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


    //Check with Shihabul on Saturday//
    @BeforeClass
    public void readConfig(){
        //FileReader //BufferReader //InputStream //Scanner
        try{
            InputStream input = new FileInputStream("src/main/resources/config/config.properties");
            Properties prop = new Properties();
            prop.load(input);
           // new Properties().load(input);
            this.browser = prop.getProperty("browser");
            this.url = prop.getProperty("url");
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @BeforeMethod
    public void init(){

        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver","src/drivers/EdgeDriver/msedgedriver.exe");
            driver = new EdgeDriver();
        }
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ExtentReports extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("path/to/report.html");
        extent.attachReporter(htmlReporter);

    }


    @Test(priority = 1)
    public void loginTest(){
        driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
        driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
        driver.findElement(SIGNIN_FIELD).click();
        String getTextField = driver.findElement(DASHBOARD_HEADER_FIELD).getText();
        Assert.assertEquals(getTextField, "Dashboard" ,"Dashboard page not found!");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
