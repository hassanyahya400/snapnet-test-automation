package pages;

import elements.Element;
import org.openqa.selenium.By;
import utils.Browser;

public class RegistrationPage extends BasePage
{
//    public static final String URL = URL ;
    private final Element fullNameInput = browser.getElement(By.id("fullName"));
    private final Element organizationInput = browser.getElement(By.id("organization"));
    private final Element industryField = browser.getElement(By.id("industry"));
    private final Element businessEmailInput = browser.getElement(By.id("email"));
    private final Element phoneNumberInput = browser.getElement(By.id("phone_number"));
    private final Element passwordInput = browser.getElement(By.id("password"));
    private final Element confirmPasswordInput = browser.getElement(By.id("cPassword"));
    private final Element captchaInput = browser.getElement(By.id("recaptcha"));
    private final Element signUpButton = browser.getElement(By.id("login-button"));
    private final Element appLogo = browser.getElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/img"));


    public static RegistrationPage visit(Browser browser)
    {
        RegistrationPage registrationPage = new RegistrationPage(browser);
        browser.get(URL + "/register");
        return registrationPage;
    }
    public RegistrationPage(Browser browser)
    {
        super(browser);
    };

    public boolean logoDisplayed()
    {
        return appLogo.isDisplayed();
    };

    public void registerSuccessfully(String fullName, String orgName, String email, String phone, String password,
                                     String captcha)
    {
        register(fullName, orgName, email, phone, password, captcha);
        String url = browser.getCurrentUrl();
    }

    private void register(String fullName, String orgName, String email, String phone, String password,
                          String captcha)
    {
        fullNameInput.sendKeys(fullName);
        organizationInput.sendKeys(orgName);
        industryField.click();
        businessEmailInput.sendKeys(email);
        phoneNumberInput.sendKeys(phone);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
        captchaInput.sendKeys(captcha);
        signUpButton.click();

        System.out.println(fullName + " logging in");
    };

}
