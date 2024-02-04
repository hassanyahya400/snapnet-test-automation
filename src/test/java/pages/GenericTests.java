package pages;

import base.BaseTest;
import data.Product;
import data.User;
import org.junit.jupiter.api.Test;
import pages.checkout.OverviewPage;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericTests extends BaseTest
{
    private LoginPage loginPage;
    private ProductListPage productListPage;
    private CartPage cartPage;
    private OverviewPage checkoutOverviewPage;
    private final Product PRODUCT = new Product();

    public void loginSuccessfully()
    {
        loginPage = LoginPage.visit(browser);
        loginPage.loginSuccessfully(User.valid());
    }

    public void addItemsToCart()
    {
        loginSuccessfully();
        productListPage = ProductListPage.visit(browser);

        PRODUCT.TEST_CART_ITEMS.forEach((item) -> {
            productListPage.addProduct(item, 1);
        });
    }

}
