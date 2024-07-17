package pages;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegistrationPageTests extends BaseTest
{
    RegistrationPage registrationPage;

    @Test
    public void verifyImportantElementsDisplayed()
    {
        registrationPage = RegistrationPage.visit(browser);
        Assertions.assertTrue(registrationPage.logoDisplayed());
    }

    @Test
    public void verifySignUpIsUnsuccessful()
    {
        registrationPage = RegistrationPage.visit(browser);

        Assertions.assertDoesNotThrow(() -> {
            registrationPage.registerSuccessfully("Mubo Money", "Mubby Tech", "example@com", "08143628474",
                    "P",
                    "");
        });
    }

    @Test
    public void verifyLogInSuccessful()
    {
        registrationPage = RegistrationPage.visit(browser);

        Assertions.assertDoesNotThrow(() -> {
            registrationPage.registerSuccessfully("Mubo Money", "Mubby Tech", "example@email.com", "08143628474",
                    "P@ssword1",
                    "captcha");
        });

    }
}
