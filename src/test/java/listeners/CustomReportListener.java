package listeners;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;
import org.testng.reporters.TestHTMLReporter;

import base.BaseTest;

import java.io.File;
import java.io.IOException;

public class CustomReportListener extends TestHTMLReporter {

    private WebDriver driver;
    private String path = System.getProperty("user.dir") + "/Failed Tests/";

    @Override
    public void onTestFailure(ITestResult tr) {
        try {
            driver = BaseTest.driver;
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(path + tr.getName() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    

    @Override
    public void onStart(ITestContext context) {
        super.onStart(context);
        File file = new File(path);
        if (file.exists()) {
            try {
                FileUtils.deleteDirectory(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

