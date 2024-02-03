package pages;

import base.BaseTest;
import data.User;
import org.junit.jupiter.api.*;
import pages.checkout.CompletionPage;
import pages.checkout.OverviewPage;

import java.util.ArrayList;
import java.util.Arrays;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CheckoutPageTests extends BaseTest
{
    LoginPage loginPage;
    ProductListPage productListPage;
    CartPage cartPage;
    OverviewPage checkoutOverviewPage;
    CompletionPage checkoutCompletionPage;
    final String SUCCESS_MESSAGE = "Thank you for your order!";
    final String DISPATCH_MESSAGE = "Your order has been dispatched, and will arrive just as fast as the pony " +
            "can get there!";

    final ArrayList<String> EXPECTED_CHECKOUT_ITEMS = new ArrayList<String>(
            Arrays.asList(
                    "Sauce Labs Backpack",
                    "Sauce Labs Bolt T-Shirt",
                    "Sauce Labs Onesie",
                    "Sauce Labs Bike Light"
            )
    );

    ArrayList<String> ACTUAL_CHECKOUT_ITEMS = new ArrayList<String>();

    @Test
    @Order(1)
    public void verifyImportantElementsDisplayed()
    {
        loginPage = LoginPage.visit(browser);
        Assertions.assertTrue(loginPage.logoDisplayed());
    }

    @Test
    @Order(2)
    public void verifyLogInUnsuccessful()
    {
        loginPage = LoginPage.visit(browser);
        Assertions.assertDoesNotThrow(() -> {
            loginPage.loginSuccessfully(User.invalid());
        });
    }

    @Test
    @Order(3)
    public void verifyLogInSuccessful()
    {
        loginPage = LoginPage.visit(browser);
        Assertions.assertDoesNotThrow(() -> {
            productListPage = loginPage.loginSuccessfully(User.valid());
        });

    }

    @Test
    @Order(4)
    public void verifyAddProductToCart()
    {
        loginPage = LoginPage.visit(browser);

        Assertions.assertDoesNotThrow(() -> {
            productListPage = loginPage.loginSuccessfully(User.valid());
        });

        Assertions.assertDoesNotThrow(() -> {
            EXPECTED_CHECKOUT_ITEMS.forEach((item) -> {
                productListPage.addProduct(item, 1);
            });
        });

        Assertions.assertDoesNotThrow(() -> {
            cartPage = productListPage.goToCartPage();
        });

        ACTUAL_CHECKOUT_ITEMS = cartPage.getCartItems();

        Assertions.assertEquals(EXPECTED_CHECKOUT_ITEMS, ACTUAL_CHECKOUT_ITEMS);

        Assertions.assertDoesNotThrow(() -> {
            checkoutOverviewPage = cartPage.goToCheckoutCustomerInfoPage().goToCheckoutOverviewPage();
        });

    }

    @Test
    @Order(5)
    public void verifyThatCheckoutItemsAreCorrect()
    {
        productListPage = LoginPage.visit(browser).loginSuccessfully(User.valid());

        EXPECTED_CHECKOUT_ITEMS.forEach((item) -> {
            productListPage.addProduct(item, 1);
        });

        cartPage = productListPage.goToCartPage();
        checkoutOverviewPage = cartPage.goToCheckoutCustomerInfoPage().goToCheckoutOverviewPage();

        ACTUAL_CHECKOUT_ITEMS = checkoutOverviewPage.getCheckoutItems();
        Assertions.assertEquals(EXPECTED_CHECKOUT_ITEMS, ACTUAL_CHECKOUT_ITEMS);

        Assertions.assertDoesNotThrow(() -> {
            checkoutCompletionPage = checkoutOverviewPage.finish();
        });

    }

    @Test
    @Order(6)
    public void verifySuccessMessageIsDisplayed()
    {
        productListPage = LoginPage.visit(browser).loginSuccessfully(User.valid());

        EXPECTED_CHECKOUT_ITEMS.forEach((item) -> {
            productListPage.addProduct(item, 1);
        });

        cartPage = productListPage.goToCartPage();
        checkoutCompletionPage = cartPage.goToCheckoutCustomerInfoPage().goToCheckoutOverviewPage().finish();

        Assertions.assertTrue(checkoutCompletionPage.successMessageIsDisplayed());
        Assertions.assertTrue(checkoutCompletionPage.dispatchMessageIsDisplayed());
        Assertions.assertEquals(checkoutCompletionPage.getSuccessMessage(), SUCCESS_MESSAGE);
    }
}