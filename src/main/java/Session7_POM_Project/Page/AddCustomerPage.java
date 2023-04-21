package Session7_POM_Project.Page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage extends BasePage {
    WebDriver driver;

    public AddCustomerPage(WebDriver driver){
        this.driver = driver;
    }
    //WebElement

    @FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5")WebElement ADD_CONTACT_PAGE;
    @FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")WebElement FULLNAME_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")WebElement COMPANY_DROPDOWN_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")WebElement EMAIL_ELEMENT;

    //Interactable Methods
   public void validateAddContactPage(){
       Assert.assertTrue("Add contact page not found!", ADD_CONTACT_PAGE.isDisplayed());
   }

   public void insertFullName(String fullName){
       FULLNAME_ELEMENT.sendKeys(fullName + generateRandomChar() + generateRandomNum(999));

   }

    public void selectCompany(String companyName){
        selectFromDropDown(COMPANY_DROPDOWN_ELEMENT, companyName);
    }

    public void insertEmailAddress(String email){
       EMAIL_ELEMENT.sendKeys(generateRandomChar() + generateRandomNum(999) + email);
   }





}
