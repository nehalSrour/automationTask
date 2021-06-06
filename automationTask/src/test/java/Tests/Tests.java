package Tests;

import BaseClass.Base;

import FileReader.ExcelReader;
import FileReader.PropertiesFileReader;
import Modules.AllureTestExecutionListener;
import Page.*;
import UIActions.UiAction;


import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureTestExecutionListener.class)
public class Tests extends Base {

    homePage home;
    firstSearchResultPage first;
    secondSearchResultPage second;

    /**
     * To read data from excel file
     *
     * @return
     */
    @DataProvider(name = "Search")
    public Object[][] getDataFromDataprovider() {
//        return ExcelReader.XslxReader("src\\test\\resources\\inputTestData.xlsx");
        return new Object[][]{{"Test automation", "automation", "Software Testing Leader - Free Continuous Testing Ebook", "Test Automation - Tutorialspoint"},
                {"Manual Testing", "Manual", "Manual Testing - javatpoint", "QA Manual Testing Full Course for Beginners Part-1 - YouTube"}
        };
    }


    /**
     * validateFirstSearchResult
     *
     * @param search
     * @param searchKey
     * @param firstPageSearchResult
     */
    @Description("write search key and validate the result is as expected")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Google search")
    @Test(priority = 1, dataProvider = "Search")
    public void validateFirstSearchResult(String search, String searchKey, String firstPageSearchResult, String second) {
        home = new homePage();
        first = new firstSearchResultPage();

        home.goToGoogleHomePage().enterSearchWord(search);

        Assert.assertEquals(first.firstSearchResultText(searchKey), firstPageSearchResult);
    }

    /**
     * @param search
     * @param searchKey
     * @param firstPageSearchResult
     * @param secondPageSearchResult
     */
    @Description("validate the Next button redirection is working correctly")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Google search")
    @Test(priority = 2, dataProvider = "Search")
    public void validateNextButtonRedirection(String search, String searchKey, String firstPageSearchResult, String secondPageSearchResult) {
        home = new homePage();
        first = new firstSearchResultPage();
        second = new secondSearchResultPage();

        home.goToGoogleHomePage().enterSearchWord(search);
        first.clickNextButton();


        //to Assert the redirection is done successfully
        Assert.assertEquals(second.secondSearchResultText(searchKey), secondPageSearchResult);
    }


    /**
     * validate the Previous button redirection is working correctly
     *
     * @param search
     * @param searchKey
     * @param firstPageSearchResult
     * @param secondPageSearchResult
     */
    @Description("validate the Previous button redirection is working correctly")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Google search")
    @Test(priority = 3, dataProvider = "Search")
    public void validatePreviousButtonRedirection(String search, String searchKey, String firstPageSearchResult, String secondPageSearchResult) {
        home = new homePage();
        first = new firstSearchResultPage();
        second = new secondSearchResultPage();

        home.goToGoogleHomePage().enterSearchWord(search);
        first.clickNextButton();
        second.clickPrevButton();


        //to Assert the redirection is done successfully
        Assert.assertEquals(first.firstSearchResultText(searchKey), firstPageSearchResult);
    }
}