package base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageBase {
    protected WebDriver driver;
    

    public PageBase(WebDriver webdriver) {
        this.driver = webdriver;
        
    }


    public String getText(String locator) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        return driver.findElement(By.xpath(locator)).getText();
    }

    public void click(String locator) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.findElement(By.xpath(locator)).click();
    }

    public void fillAndEnter(String locator, String text) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.findElement(By.xpath(locator)).sendKeys(text);
        driver.findElement(By.xpath(locator)).sendKeys(Keys.RETURN);

    }

    public boolean isDisplayed(String locator) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        return driver.findElement(By.xpath(locator)).isDisplayed();
    }

    public void sendKeys(String locator, String text) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }
    
    public void waitUntilLoadingIsCompleted() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    	 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'loader')]")));
    }
}
