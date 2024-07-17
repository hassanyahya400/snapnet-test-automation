package pages;

import base.BaseTest;

public class GenericTests extends BaseTest
{
    private RegistrationPage registrationPage;

    public void loginSuccessfully()
    {
        registrationPage = RegistrationPage.visit(browser);
    }

}
