package pages;

import data.User;
import elements.Element;
import elements.ElementList;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import utils.Browser;

public class LoginPage extends BasePage
{
//    public static final String URL = URL ;
    private final Element usernameInput = browser.getElement(By.id("user-name"));
    private final Element passwordInput = browser.getElement(By.id("password"));
    private final Element loginButton = browser.getElement(By.id("login-button"));
    private final Element appLogo = browser.getElement(By.className("login_logo"));
    private final ElementList errorToast = browser.getElements(By.cssSelector("span.toast__text"));


    public static LoginPage visit(Browser browser)
    {
        LoginPage loginPage = new LoginPage(browser);
        browser.get(URL);
        return loginPage;
    }
    public LoginPage(Browser browser)
    {
        super(browser);
    };

    public boolean logoDisplayed()
    {
        return appLogo.isDisplayed();
    };

    public void loginUnsuccessfully(User user)
    {
        login(user);

        try
        {
            errorToast.waitUntilPresent();

        }
        catch (TimeoutException ex)
        {
            String url = browser.getCurrentUrl();
            throw new PageValidationException("Expected login errors, but none were found; current URL: " + url);

        }
    }

    public ProductListPage loginSuccessfully(User user)
    {
        try
        {
            login(user);
        }
        catch (Exception e)
        {
            throw new IllegalStateException(e.getMessage());
        }

        return new ProductListPage(browser);
    };

    private void login(User user)
    {
        usernameInput.sendKeys(user.getUsername());
        passwordInput.sendKeys(user.getPassword());
        loginButton.click();

        System.out.println(user.getUsername() + " logging in");
    };

}
