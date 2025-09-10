package base;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class PageBase {
    private WebDriver driver;
    

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
}
