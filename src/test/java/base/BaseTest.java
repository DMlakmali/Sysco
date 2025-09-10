package base;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	
	 public static WebDriver driver;
	    Logger logger = LogManager.getLogger(BaseTest.class);

	    @BeforeTest
	    public void setUp() {
	        ConfigReader configReader = new ConfigReader();
	        String browser = configReader.getBrowser();
	        String url = configReader.getUrl();
	        if (browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	        } else if (browser.equalsIgnoreCase("edge")) {
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	        }else{
	            logger.error("Browser is not valid");
	        }
	        driver.get(url);
	    }
}
