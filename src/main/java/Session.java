import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Session {
    ChromeDriver driver;
    @Before
 public void  init(){
        System.out.println("Be" +
                "fore Class");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Gideon\\Downloads\\seleniumProjects\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://objectspy.space/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
 public void textLocator(){
        driver.findElement(By.name("firstname")).sendKeys("Gideon");
        //driver.findElement(By.name("password")).sendKeys("#1ifeomA");
        //cheeking on radio button

        driver.findElement(By.id("sex-0")).click();
        //upload file
        //sendkeys will work as along as there is an input
        //robot class if other than input tag
        driver.findElement(By.id("photo")).sendKeys("C:\\Users\\Gideon\\Pictures\\DOR.jpg");
        //Link Text
        driver.findElement(By.linkText("OS-API Product FrontEnd")).click();
        //to go back to previous page
        driver.navigate().back();
        //partial Link Text
       // driver.findElement(By.partialLinkText("Product")).click();

        //css locator using hastag#
      //driver.findElement(By.cssSelector("input#exp-4")).click();

        //css locator using .Value
//        driver.findElement(By.id("exp-1")).click();
//        driver.findElement(By.id("tool-2")).click();
        driver.findElement(By.cssSelector("input#exp-3")).click();

       // driver.findElement(By.cssSelector("input[value= 'Selenium WebDriver']")).click();
        // driver.findElement(By.id("tool-2")).click();
        //driver.findElement(By.cssSelector("input[value= 'Selenium WebDriver'][id= 'tool-2']")).click();
       // driver.findElement(By.xpath())

        //using css_HrefLinks
        driver.findElement(By.cssSelector("a[href='http://www.objectspy.space']")).click();

        //using XPaths
        //absolute
        driver.findElement(By.xpath("html/body/div/div[2]/div[2]/form/div[10]/input")).sendKeys("Nzeadu");

        //relative
        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Miracle");
        //relative
        //multiple attributes
        driver.findElement(By.xpath("//input[@id='profession-1' and @value = 'Automation Tester']")).click();
        //relative and using text() method
       // driver.findElement(By.xpath("//a[text()='API Documentations']")).click();


        //relative and using contains() method
        driver.findElement(By.xpath("//a[contains(text(), 'API Doc')]")).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();

    }

    @After
    public void tearDown(){
        System.out.println("After class");
        driver.quit();
    }

}
