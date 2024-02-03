package pages;

import base.BaseTest;
import data.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductListPageTests extends BaseTest
{
    LoginPage loginPage;
    ProductListPage productListPage;
    CartPage cartPage;
    final ArrayList<String> EXPECTED_CART_ITEMS = new ArrayList<String>(
            Arrays.asList(
                    "Sauce Labs Backpack",
                    "Sauce Labs Bolt T-Shirt",
                    "Sauce Labs Onesie",
                    "Sauce Labs Bike Light"
            )
    );

    ArrayList<String> ACTUAL_CART_ITEMS = new ArrayList<String>();

    @Test
    public void verifyAddProductToCart()
    {
        productListPage = LoginPage.visit(browser).loginSuccessfully(User.valid());

        Assertions.assertDoesNotThrow(() -> {
            EXPECTED_CART_ITEMS.forEach((item) -> {
                productListPage.addProduct(item, 1);
            });
        });

        Assertions.assertDoesNotThrow(() -> {
            cartPage = productListPage.goToCartPage();
        });

        ACTUAL_CART_ITEMS = cartPage.getCartItems();

        Assertions.assertEquals(EXPECTED_CART_ITEMS, ACTUAL_CART_ITEMS);

        cartPage.goToCheckoutCustomerInfoPage().goToCheckoutOverviewPage();
    }
}
