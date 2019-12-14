package heroku_app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    // Declaring a Global static variable of the WebDriver object
    protected static WebDriver driver;

    // Initializing the elements of PageFactory through a constructor
    public DriverFactory() {
        PageFactory.initElements(driver, this);
    }

    // Open the browser
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // driver.get("http://the-internet.herokuapp.com/"); // implemented in heroku_app.Hooks Class
    }

    // Get the URL of the website
    public void url(String url) {
        driver.get(url);
    }

    // Maximize the browser
    public void maxiBrowser() {
        driver.manage().window().maximize();
    }

    // Delete the cookies
    public void deleteCookies() {
        driver.manage().deleteAllCookies();
    }

    // Apply the implicit wait
    public void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // Close the browser
    public void closeBrowser() {
        driver.quit();
    }
}
