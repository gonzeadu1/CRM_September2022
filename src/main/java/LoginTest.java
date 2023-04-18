import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;

    @Before
    public void init() {
        System.out.println("Before class");
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("http://www.techfios.com/billing/?ng=admin/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        WebElement USERNAME = driver.findElement(By.id("username"));
        WebElement USERNAME_PASSWORD = driver.findElement(By.id("password"));
        WebElement USERNAME_CLICK = driver.findElement(By.name("login"));
        Boolean pageTitleToDisplay;

        try {
            USERNAME.sendKeys("demo@techfios.com");
            USERNAME_PASSWORD.sendKeys("abc123");
            USERNAME_CLICK.click();
            WebElement DASHBOARD_HEADER = driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]"));
            String dashboardHeaderText = driver.findElement((By) DASHBOARD_HEADER).getText();
           // Assert.assertTrue("dashboard not found", DASHBOARD_HEADER.isDisplayed());
            Assert.assertEquals("dashboard not found", "Dashboard- iBilling", driver.getTitle());
            Assert.assertEquals("dashboard not found", "Dashboard", dashboardHeaderText);
            System.out.println("driver: " + driver.getTitle());
        } catch(Exception e) {
                e.printStackTrace();
            }


    }
}
//import java.util.Random;
//
//public class Main {
//    public static void main(String[] args) {
//        String randomString = Random.randomAlphabetic(4).toLowerCase();
//        System.out.println("Random lowercase alphabetic string: " + randomString);
//    }
//}
//
