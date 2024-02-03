package pages;

import base.BaseTest;
import data.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginPageTests extends BaseTest
{
    LoginPage loginPage;
    ProductListPage productListPage;

    @Test
    public void verifyImportantElementsDisplayed()
    {
        loginPage = LoginPage.visit(browser);
        Assertions.assertTrue(loginPage.logoDisplayed());
    }

    @Test
    public void verifyLogInUnsuccessful()
    {
        loginPage = LoginPage.visit(browser);

        Assertions.assertDoesNotThrow(() -> {
            loginPage.loginSuccessfully(User.invalid());
        });
    }

    @Test
    public void verifyLogInSuccessful()
    {
        loginPage = LoginPage.visit(browser);

        Assertions.assertDoesNotThrow(() -> {
            loginPage.loginSuccessfully(User.valid());
        });

    }
}
