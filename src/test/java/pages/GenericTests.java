package pages;

import base.BaseTest;
import data.Product;
import data.User;
import pages.checkout.OverviewPage;

public class GenericTests extends BaseTest
{
    private RegistrationPage registrationPage;
    private final Product PRODUCT = new Product();

    public void loginSuccessfully()
    {
        registrationPage = RegistrationPage.visit(browser);
    }

}
