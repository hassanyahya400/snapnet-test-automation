package pages.checkout;

import com.github.javafaker.Faker;
import data.User;
import elements.Element;
import org.openqa.selenium.By;
import pages.BasePage;
import utils.Browser;

public class CustomerInfoPage extends BasePage
{
    private final Faker faker = new Faker();
    public final Element firstNameInput = browser.getElement(By.id("first-name"));
    public final Element lastNameInput = browser.getElement(By.id("last-name"));
    public final Element postalCodeInput = browser.getElement(By.id("postal-code"));
    public final Element cancelButton = browser.getElement(By.id("cancel"));
    public final Element continueButton = browser.getElement(By.id("continue"));

    public CustomerInfoPage(Browser browser)
    {
        super(browser);
    }

    public static CustomerInfoPage visit(Browser browser)
    {
        CustomerInfoPage customerInfoPage = new CustomerInfoPage(browser);
        browser.get(URL + "/checkout-step-one.html");

        return customerInfoPage;
    }

    public OverviewPage goToCheckoutOverviewPage()
    {
        try
        {
            enterCheckoutInformation(new User());
        }
        catch (Exception e)
        {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        return new OverviewPage(browser);
    }

    private void enterCheckoutInformation(User user)
    {
        try
        {
            firstNameInput.sendKeys(user.firstName);
            lastNameInput.sendKeys(user.lastName);
            postalCodeInput.sendKeys(user.postalCode);
            continueButton.click();
        }
        catch (Exception e)
        {
            System.out.println("Exception thrown: " + e.getMessage());
        }
    }
}