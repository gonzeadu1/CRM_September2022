package LocalTries;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ElementLocators {
    WebDriver driver;
    @Before
     public void init(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://objectspy.space/\n");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


     }

     @Test
     public void testElementLocators(){
        driver.findElement(By.name("firstname")).sendKeys("Selenium");
        driver.findElement(By.id("sex-1")).click();
        driver.findElement(By.id("photo")).sendKeys("C:/Users/Gideon/Pictures/hahah.jpg");
        driver.findElement(By.linkText("OS-API Product FrontEnd")).click();
        driver.navigate().back();//to go back to previous page
        driver.findElement(By.partialLinkText("Product Backend")).click();
        driver.navigate().back();
        driver.findElement(By.cssSelector("input#exp-3")).click();
        driver.findElement(By.cssSelector("input[id='tool-2'][value='Selenium Webdriver']")).click();
        //href link with cssLocator
        driver.findElement(By.cssSelector("a[href$='http://www.objectspy.space']")).click();
         //absolute xpath
        driver.findElement(By.xpath("html/body/div/div[2]/div[2]/form/div[10]/input"))
                .sendKeys("Lord I need your help!!");
         //relative xpath
         driver.findElement(By.xpath("//input[@name=\"firstname\"]"))
                 .sendKeys("Your help has come says the Lord almighty!");
         //using multiple attributes with xpath
         driver.findElement(By.xpath("//input[@ id=\"profession-1\" and @value = \"Automation Tester\"]"))
                 .sendKeys("I love to love you Lord!");
         //xpath for links
         driver.findElement(By.xpath("//a[text()= 'API Documentations']")).click();
         //xpath for links using contains() method
         driver.findElement(By.xpath("//a[contains(text(), 'API Documentation')]")).click();

     }
}