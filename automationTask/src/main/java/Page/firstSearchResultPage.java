package Page;

import UIActions.UiAction;
import org.openqa.selenium.By;

public class firstSearchResultPage {

    UiAction elementAction = new UiAction();

    By firstSearchResult ;
    By nextButton = By.id("pnnext");

    /**
     * in the first page find the first search result
     * @param name
     * @return
     */
    public String firstSearchResultText(String name){
        firstSearchResult = By.xpath(String.format("(//div[@class='g']//a/h3[contains(text(),'%s')])[1]",name));
        return elementAction.FindElement(firstSearchResult).getElementText();

    }

    /**
     * Click Next Button in the first page
     */
    public void clickNextButton(){
        elementAction.scrollDownToTheBottomOfThePage();
        elementAction.FindElement(nextButton).ActOntheElement(UiAction.CLICK);
    }


}
