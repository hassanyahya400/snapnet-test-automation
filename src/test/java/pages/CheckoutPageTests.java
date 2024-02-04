package pages;

import base.BaseTest;
import data.Product;
import data.User;
import org.junit.jupiter.api.*;
import pages.checkout.CompletionPage;
import pages.checkout.OverviewPage;

import java.util.ArrayList;
import java.util.Arrays;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CheckoutPageTests extends GenericTests
{
    OverviewPage checkoutOverviewPage;
    CompletionPage checkoutCompletionPage;
    final String SUCCESS_MESSAGE = "Thank you for your order!";
    final String DISPATCH_MESSAGE = "Your order has been dispatched, and will arrive just as fast as the pony " +
            "can get there!";
    final Product PRODUCT = new Product();
    ArrayList<String> ACTUAL_CHECKOUT_ITEMS = new ArrayList<String>();

    @Test
    @Order(1)
    public void verifyThatCheckoutItemsAreCorrect()
    {
       loginSuccessfully();
       addItemsToCart();

       checkoutOverviewPage = CartPage.visit(browser)
               .goToCheckoutCustomerInfoPage()
               .goToCheckoutOverviewPage();

        ACTUAL_CHECKOUT_ITEMS = checkoutOverviewPage.getCheckoutItems();

        Assertions.assertEquals(PRODUCT.TEST_CART_ITEMS, ACTUAL_CHECKOUT_ITEMS);

    }

    @Test
    @Order(2)
    public void verifySuccessMessageIsDisplayed()
    {
        loginSuccessfully();
        addItemsToCart();

        checkoutCompletionPage = CartPage.visit(browser)
                .goToCheckoutCustomerInfoPage()
                .goToCheckoutOverviewPage()
                .finish();

        Assertions.assertTrue(checkoutCompletionPage.successMessageIsDisplayed());
        Assertions.assertTrue(checkoutCompletionPage.dispatchMessageIsDisplayed());
        Assertions.assertEquals(checkoutCompletionPage.getSuccessMessage(), SUCCESS_MESSAGE);
    }
}