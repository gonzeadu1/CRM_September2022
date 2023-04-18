import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FrontEndTestSelenium {
    WebDriver driver;
    @Before
    public void init(){
        System.out.println("Before Class");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Gideon\\Downloads\\seleniumProjects\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("http://www.techfios.com/billing/?ng=admin/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void userAcct(){
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("demo@techfios.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abc123");
        driver.findElement(By.name("login")).click();
        //driver.findElement(By.className("//button[@class = 'btn btn-success block full-width']")).click();
        driver.findElement(By.linkText("Bank & Cash")).click();
        driver.findElement(By.cssSelector("a[href = 'https://techfios.com/billing/?ng=accounts/add/']")).click();
        driver.findElement(By.xpath("//input[@ type = 'text' and @id = 'account']")).sendKeys("Savings Account of Umuchinemerem community");
        driver.findElement(By.xpath("//input[@ type = 'text' and @id = 'description']")).sendKeys("Umuchinemerem Savings Account--Jehovah bu ike anyi ooh");
        driver.findElement(By.xpath("//input[@ type = 'text' and @id = 'balance']")).sendKeys("250000000");
        driver.findElement(By.xpath("//input[@ type = 'text' and @id = 'account_number']")).sendKeys("999363699");
        driver.findElement(By.xpath("//input[@ type = 'text' and @id = 'contact_person']")).sendKeys("Chris Hayes");
        driver.findElement(By.xpath("//input[@ type = 'text' and @id = 'contact_phone']")).sendKeys("9999999999");
        driver.findElement(By.xpath("//input[@ type = 'text' and @id = 'ib_url']")).sendKeys("https://www.chase.com/");


        //how do i automate the delete button after the account has been deleted?

    }
    @After
   public void tearDown(){
        System.out.println("After Class");
        driver.quit();
    }
}
