package Modules;

import UIActions.UiAction;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;



public class AllureTestExecutionListener implements ITestListener  {

            UiAction element = new UiAction();



        @Override
        public void onTestStart(ITestResult result) {
            // TODO Auto-generated method stub



        }
        @Override
        public void onTestSuccess(ITestResult result) {
            // TODO Auto-generated method stub

        }
        @Override
        public void onTestFailure(ITestResult result) {
            // TODO Auto-generated method stub
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) UiAction.getDriver()).getScreenshotAs(OutputType.BYTES)));


        }
        @Override
        public void onTestSkipped(ITestResult result) {
            // TODO Auto-generated method stub

        }
        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
            // TODO Auto-generated method stub

        }
        @Override
        public void onStart(ITestContext context) {
            // TODO Auto-generated method stub

        }
        @Override
        public void onFinish(ITestContext context) {
            // TODO Auto-generated method stub

        }

    }


