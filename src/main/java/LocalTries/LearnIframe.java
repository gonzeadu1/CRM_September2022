package LocalTries;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LearnIframe {
    ChromeDriver driver;
    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://docs.oracle.com/javase/8/docs/api/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void testIFrame(){
        driver.switchTo().frame("packageListFrame");
        driver.findElement(By.linkText("java.awt")).click();

        driver.switchTo().parentFrame();
        driver.switchTo().frame("packageFrame");
        driver.findElement(By.linkText("Adjustable")).click();

        driver.switchTo().parentFrame();
        driver.switchTo().frame("classFrame");
        driver.findElement(By.linkText("Adjustable")).click();
    }
}
