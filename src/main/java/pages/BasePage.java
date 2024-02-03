package pages;

import utils.Browser;

public abstract class BasePage
{
    protected Browser browser;

    public static String URL = "https://www.saucedemo.com";

    public BasePage(Browser browser)
    {
        this.browser = browser;
    }
}
