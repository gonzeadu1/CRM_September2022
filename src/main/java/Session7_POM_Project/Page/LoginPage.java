package Session7_POM_Project.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    WebDriver driver;
     public LoginPage(WebDriver driver){
         this.driver = driver;
     }
    //elements
   @FindBy(how = How.XPATH, using = "//*[@id=\"username\"]") WebElement USER_NAME_ELEMENT;
    @FindBy(how = How.XPATH, using = "//*[@id=\"password\"]") WebElement PASSWORD_ELEMENT;
    @FindBy(how = How.XPATH, using =  "/html/body/div/div/div/form/div[3]/button") WebElement SIGNIN_BUTTON_ELEMENT;


    //Interactable methods
    public void insertUserName(String userName){
        USER_NAME_ELEMENT.sendKeys(userName);
    }
    public void insertPassword(String password){
        PASSWORD_ELEMENT.sendKeys(password);
    }
    public void clickOnSigninButton(){
        SIGNIN_BUTTON_ELEMENT.click();
    }


    public void performLogin(String userName, String password){
        USER_NAME_ELEMENT.sendKeys(userName);
        PASSWORD_ELEMENT.sendKeys(password);
        SIGNIN_BUTTON_ELEMENT.click();
    }


}
