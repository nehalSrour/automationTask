package Page;

import UIActions.UiAction;
import org.openqa.selenium.By;

public class secondSearchResultPage {

    UiAction elementAction = new UiAction();
    By prevButton = By.id("pnprev");
    By secondSearchResult ;

    /**
     * in the second page find the first search result
     * @param name
     * @return
     */
    public String secondSearchResultText(String name){
        secondSearchResult = By.xpath(String.format("(//div[@class='g']//a/h3[contains(text(),'%s')])[1]",name));
        return elementAction.FindElement(secondSearchResult).getElementText();

    }

    /**
     * Click on previous button
     */
    public void clickPrevButton(){
        elementAction.scrollDownToTheBottomOfThePage();
        elementAction.FindElement(prevButton).ActOntheElement(UiAction.CLICK);
    }


}
