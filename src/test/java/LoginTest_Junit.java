import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest_Junit {
    WebDriver driver;
    @Before
    public void init(){
        System.out.println("Before Class");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Gideon\\Downloads\\seleniumProjects\\src\\driver\\chromedriver.exe");
       driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://www.techfios.com/billing/?ng=admin/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void LoginTest() {
        //driver.findElement(By.id("username")).sendKeys("demo@Techfios.com");
        //Element list
        WebElement USERNAME = driver.findElement(By.id("username"));
        WebElement USERNAME_PASSWORD = driver.findElement(By.id("password"));
        WebElement USERNAME_CLICK = driver.findElement(By.name("login"));
        boolean pageTitleToDisplay;
        try {
            //Login
            USERNAME.sendKeys("demo@techfios.com");
            USERNAME_PASSWORD.sendKeys("abc123");
            USERNAME_CLICK.click();
            WebElement DASHBOARD_HEADER = driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]"));
            pageTitleToDisplay = true;
           // DASHBOARD_HEADER.click();
            Assert.assertTrue("dashboard not found", DASHBOARD_HEADER.isDisplayed());
        }   catch(Exception e){
            pageTitleToDisplay = false;
            e.printStackTrace();
        }

       // WebDriverWait wait = new WebDriverWait(driver, 15);
       // wait.until(ExpectedConditions.visibilityOfElementLocated((By) DASHBOARD_HEADER));


        //USERNAME_CLICK.clear();

    }

    @After
    public void tearDown(){
//        driver.close();
//        driver.quit();
    }


}
