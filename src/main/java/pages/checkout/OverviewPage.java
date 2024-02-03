package pages.checkout;

import elements.Element;
import elements.ElementList;
import org.openqa.selenium.By;
import pages.BasePage;
import utils.Browser;

import java.util.ArrayList;

public class OverviewPage extends BasePage
{
    private final ElementList checkoutItems = browser.getElements(By.cssSelector(".inventory_item_name"));
    public final Element cancelButton = browser.getElement(By.id("cancel"));
    public final Element finishButton = browser.getElement(By.id("finish"));

    public OverviewPage(Browser browser)
    {
        super(browser);
    }

    public static OverviewPage visit(Browser browser)
    {
        OverviewPage customerInfoPage = new OverviewPage(browser);
        browser.get(URL + "/checkout-step-two.html");

        return customerInfoPage;
    }

    public ArrayList<String> getCheckoutItems() {
        ArrayList<String> items = new ArrayList<String>();

        checkoutItems.getElements().forEach((element -> {
            items.add(element.getText());
        }));

        return items;
    }

    public CompletionPage finish()
    {
        finishButton.click();
        return new CompletionPage(browser);
    }
}