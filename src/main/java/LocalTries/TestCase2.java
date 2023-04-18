package LocalTries;

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

public class TestCase2 {


        WebDriver driver;

        // storing element on By type
        By USERNAME_FIELD = By.xpath("//input[@id='username']");
        By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
        By SIGNIN_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
        By DASHBOARD_HEADER_FIELD = By.xpath("//h2[contains(text(), 'Dashboard')]");

        @Before
        public void init() {

            System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.get("https://techfios.com/billing/?ng=admin/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        @Test
        public void loginTestNew() {

            // element list
            // storing element on WebElement type
            WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
            WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            WebElement SIGNIN_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));


            /*
             * USERNAME_ELEMENT.clear(); USERNAME_ELEMENT.sendKeys("demo@techfios.com");
             * //driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
             * PASSWORD_ELEMENT.sendKeys("abc123"); SIGNIN_ELEMENT.click();
             */

            driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
            driver.findElement(PASSWORD_FIELD).sendKeys("abc12332423");
            driver.findElement(SIGNIN_FIELD).click();

            boolean pageTitleDisplayStatus;
            try {

                WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(), 'Dashboard')]"));
                pageTitleDisplayStatus = true;
            }catch(Exception e) {
                pageTitleDisplayStatus = false;
                e.printStackTrace();
            }

            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER_FIELD));
//		wait.until(ExpectedConditions.visibilityOf(element))




//		Assert.assertTrue("Dashboard page not found!!!", DASHBOARD_HEADER_ELEMENT.isDisplayed());
            Assert.assertTrue("Dashboard page not found!!!", pageTitleDisplayStatus);
//		Assert.assertTrue("Dashboard page not found!!!", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
        }

        // @After
        public void tearDown() {
            driver.close();
            driver.quit();
        }


}
