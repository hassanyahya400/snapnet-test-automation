package pages;

import utils.Browser;

public abstract class BasePage
{
    protected Browser browser;

    public static String URL = "https://hcmatrix-saas.netlify.app";

    public BasePage(Browser browser)
    {
        this.browser = browser;
    }
}
