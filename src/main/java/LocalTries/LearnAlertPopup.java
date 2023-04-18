package LocalTries;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LearnAlertPopup {
    ChromeDriver driver;
    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void popupTest() throws InterruptedException {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        String alertMsg = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
       Assert.assertEquals(alertMsg, "Please enter a valid user name");
        System.out.println("alertMsg" + alertMsg);
    }
}
