package pages;

import elements.Element;
import elements.ElementList;
import org.openqa.selenium.By;
import pages.checkout.CustomerInfoPage;
import utils.Browser;

import java.util.ArrayList;

public class CartPage extends BasePage
{
    private final ElementList cartItems = browser.getElements(By.cssSelector(".inventory_item_name"));
    public final Element checkout = browser.getElement(By.id("checkout"));

    public CartPage(Browser browser)
    {
        super(browser);
    }

    public static CartPage visit(Browser browser)
    {
        CartPage cartPage = new CartPage(browser);
        browser.get(URL + "/cart.html");
        return cartPage;
    }

    public ArrayList<String> getCartItems() {
        ArrayList<String> items = new ArrayList<String>();

        cartItems.getElements().forEach((element -> {
            items.add(element.getText());
        }));

        return items;
    }

    public CustomerInfoPage goToCheckoutCustomerInfoPage()
    {
        try
        {
            checkout.click();
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }

        return new CustomerInfoPage(browser);
    }
}