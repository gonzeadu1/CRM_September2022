package LocalTries;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestCases {
    WebDriver driver;

    @Before
    public void init(){
        System.out.println("Before test");
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("http://www.techfios.com/billing/?ng=admin/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void LoginTest() {
        boolean pageTitleDisplayStatus = false;
        By DASHBOARD_HEADER_FIELD = By.xpath("//h2[contains(text(), 'Dashboard')]");


//        WebDriverWait wait = new WebDriverWait(driver, 15);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER_FIELD));

        WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement SIGNIN_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));

        USERNAME_ELEMENT.clear();
        USERNAME_ELEMENT.sendKeys("demo@techfios.com");
        PASSWORD_ELEMENT.sendKeys("abc123");

        try {
            // element list
            // storing element on WebElement type

           // By DASHBOARD_HEADER_FIELD = By.xpath("//h2[contains(text(), 'Dashboard')]");








            //WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(), 'Dashboard')]"));
            pageTitleDisplayStatus = true;

          //  SIGNIN_ELEMENT.click();
        }catch (Exception e){
            pageTitleDisplayStatus = false;
            e.printStackTrace();
        }
//        driver.findElement(DASHBOARD_HEADER_FIELD).click();
            //driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]")).click();

            // WebElement DASHBOARD_HEADER_FIELD = driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]"));
            // DASHBOARD_HEADER_FIELD.click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER_FIELD));
        Assert.assertTrue("Dashboard page not found!!!", pageTitleDisplayStatus);


    }
       @After
       public void tearDown(){
            System.out.println("tearDown");
            driver.close();
            driver.quit();
        }

        
    }

