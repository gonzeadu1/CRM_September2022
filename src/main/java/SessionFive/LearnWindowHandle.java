package SessionFive;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LearnWindowHandle {
    WebDriver driver;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://yahoo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void testsWindowHandle() throws InterruptedException {
        String title1 = driver.getTitle();
//        String handle1 = driver.getWindowHandle();
//        System.out.println("================" + title1);
//        System.out.println("================" + handle1);

     driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("Selenium");
     driver.findElement(By.xpath("//button[@type='submit']")).click();
     //Assert.assertEquals("Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos", title1);
     //link to selenium

     driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a/span")).click();
     Thread.sleep(2000);
     String titles3 = driver.getTitle();
     System.out.println("titles3 " + titles3);
     String handle3  = driver.getWindowHandle();
     System.out.println("handle3 "  + handle3);

       Set<String> handles = driver.getWindowHandles();
        System.out.println("handles " + handles);
        for(String str : handles){
            System.out.println("============= " + str);
            driver.switchTo().window(str);
        }

        String title4 = driver.getTitle();
        System.out.println("title4 " + title4);
        driver.switchTo().window(titles3);
    }
}
