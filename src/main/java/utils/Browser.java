package utils;

import elements.Element;
import elements.ElementList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.Callable;

public class Browser {
    private final RemoteWebDriver driver;
    protected final WebDriverWait wait;

    public Browser(RemoteWebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public Element getElement(By locator) {
        return new Element(driver, locator);
    }

    public ElementList getElements(By locator) {
        return new ElementList(driver, locator);
    }

    public void quit() {
        driver.quit();
    }

    public void get(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public Object waitUntil(Callable<Object> block) {
        return wait.until(driver -> {
            try {
                return block.call();
            } catch (WebDriverException e) {
                throw e;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
