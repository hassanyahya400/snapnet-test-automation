package pages.checkout;

import elements.Element;
import org.openqa.selenium.By;
import pages.BasePage;
import utils.Browser;

public class CompletionPage extends BasePage
{
    public final Element successMessage = browser.getElement(By.className("complete-header"));
    public final Element dispatchMessage = browser.getElement(By.className("complete-text"));
    public final Element homeButton = browser.getElement(By.id("back-to-products"));


    public CompletionPage(Browser browser) {
        super(browser);
    }

    public boolean successMessageIsDisplayed()
    {
        return successMessage.isDisplayed();
    }

    public boolean dispatchMessageIsDisplayed()
    {
        return dispatchMessage.isDisplayed();
    }

    public String getSuccessMessage()
    {
        return successMessage.getText();
    }
}
