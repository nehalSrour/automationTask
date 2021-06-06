package Page;

import FileReader.PropertiesFileReader;
import UIActions.UiAction;
import org.openqa.selenium.By;

import static UIActions.UiAction.WAIT_UNTIL_VISIBILITY;
import static UIActions.UiAction.WAIT_implicitlyWait;

public class homePage {


    UiAction elementAction = new UiAction();

    By searchPar = By.xpath("//input[@title='Search']");

    /**
     * goToGoogleHomePage
     * @return
     */
    public homePage goToGoogleHomePage(){
        elementAction.goToUrl((PropertiesFileReader.propertiesFileReader(new String[]{"URL"},"configuration.properties"))[0]);

        return this;
    }

    /**
     * enterSearchWord
     * @param name
     */
    public void enterSearchWord(String name){
                elementAction.FindElement(searchPar).SendKeysToElement(name).ActOntheElement(UiAction.ENTER);
    }


}
