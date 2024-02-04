package base;

import elements.Element;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Browser;

public class BaseTest {
    protected Browser browser;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
//        options.addArguments("start-fullscreen");
        RemoteWebDriver driver = new ChromeDriver(options);
        browser = new Browser(driver);
    }

    @AfterEach
    public void tearDown(){
        System.out.println("Done ✅");
        browser.quit();
    }
}