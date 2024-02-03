package pages;

import elements.Element;
import elements.ElementList;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import utils.Browser;

public class ProductListPage extends BasePage{

    private final Element appLogo = browser.getElement(By.className("app_logo"));
    private final Element shoppingCartIcon = browser.getElement(By.className("shopping_cart_link"));
    private final ElementList socialMediaLinks = browser.getElements(By.cssSelector(".social li"));
    Element addButton;

    public ProductListPage(Browser browser)
    {
        super(browser);
    }

    public static ProductListPage visit(Browser browser)
    {
        ProductListPage productListPage = new ProductListPage(browser);
        browser.get(URL + "/inventory.html");
        return productListPage;
    }

    public boolean appLogoDisplayed()
    {
        return appLogo.isDisplayed();
    }

    public boolean setShoppingCartDisplayed()
    {
        return shoppingCartIcon.isDisplayed();
    }

    public boolean socialMediaLinksDisplayed()
    {
        return !socialMediaLinks.isEmpty();
    }

    public void addProduct(String product, int count)
    {
        product = product.replace(" ", "-").toLowerCase();
        String buttonId = "add-to-cart-" + product;

        try
        {
            addButton = browser.getElement(By.id(buttonId));
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }

        for (int i = 1; i <= count; ++i)
        {
            addButton.click();
        }

    }

    public CartPage goToCartPage()
    {
        try
        {
            shoppingCartIcon.click();
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Can not navigate to cart");
        }

        return new CartPage(browser);
    };




}
