package Session7_POM_Project.Page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    //webElements
    @FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")WebElement DASHBOARD_PAGE;
    @FindBy(how = How.XPATH, using ="//*[@id=\"side-menu\"]/li[3]/a/span[1]" ) WebElement CUSTOMER_MENU_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a") WebElement ADD_CUSTOMER_MENU_ELEMENT;

    //Interactable Methods
    public void validateDashboard(){
        Assert.assertTrue("Dashboard Page not available!", DASHBOARD_PAGE.isDisplayed());
        //Assert.assertEquals("Dashboard", DASHBOARD_PAGE.getText(), "Dashboard Page not available!");
    }

    public void clickCustomerMenuElement(){
        CUSTOMER_MENU_ELEMENT.click();
    }

    public void clickAddCustomerMenuElement(){
        ADD_CUSTOMER_MENU_ELEMENT.click();
    }

}
