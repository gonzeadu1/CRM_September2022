package Session7_POM_Project.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class BasePage {

    public char generateRandomChar(){
        Random rnd = new Random();
        char rndChar = (char) (rnd.nextInt(26) + 'a');
        return rndChar;
    }

    public int generateRandomNum(int boundNum){
        Random rnd = new Random();
        int rndChar = (rnd.nextInt(boundNum));
        return rndChar;
    }

    public void selectFromDropDown(WebElement element, String visibleText) {
        Select sel = new Select(element);
        sel.selectByVisibleText(visibleText);
    }
}
