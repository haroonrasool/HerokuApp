package heroku_app;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.net.MalformedURLException;

public class Hooks {

    private DriverFactory df = new DriverFactory();

    @Before
    public void setUp() throws MalformedURLException {
        df.openBrowser();
        df.maxiBrowser();
        df.url("http://the-internet.herokuapp.com/");
        df.implicitlyWait();
        df.deleteCookies();
    }

    @After
    public void quitBrowser() {
        df.closeBrowser();
    }
}
