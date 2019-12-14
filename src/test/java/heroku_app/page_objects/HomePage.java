package heroku_app.page_objects;

import heroku_app.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverFactory {
    // homepage url
    public String getHomePageUrl() {
        return driver.getCurrentUrl();
    }

    // user clicks on "form authentication link"
    @FindBy(linkText = "Form Authentication")
    private WebElement formAuthenticationLink;

    public void formAuthentication() {
        formAuthenticationLink.click();
    }

    // log-in method
    public void logInOne(String userName, String password) {
        // correct userName and wrong password
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector(".radius")).click();
        String errorMessage = driver.findElement(By.cssSelector("#flash")).getText();
        System.out.println(errorMessage);
        closeBrowser();
    }

    public void logInTwo(String userName, String password) {
        // wrong userName and correct password
        userName = "wrongtomsmith";
        password = "SuperSecretPassword!";
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector(".radius")).click();
        String errorMessage = driver.findElement(By.cssSelector("#flash")).getText();
        System.out.println(errorMessage);
        closeBrowser();
    }

    public void logInThree(String userName, String password) {
        // correct userName and correct password
        userName = "tomsmith";
        password = "SuperSecretPassword!";
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector(".radius")).click();
        String successMessage = driver.findElement(By.cssSelector("#flash")).getText();
        System.out.println(successMessage);
        Assert.assertTrue("You logged into a secure area!", successMessage.contains(successMessage));
        driver.findElement(By.className("button")).click();
        String logOutMessage = driver.findElement(By.className("flash")).getText();
        System.out.println(logOutMessage);
        Assert.assertTrue("You logged out of the secure area!", logOutMessage.contains(logOutMessage));
        closeBrowser();
    }

    // user clicks on "infinite scroll" link
    @FindBy(linkText = "Infinite Scroll")
    private WebElement infiniteScrollLink;

    public void infiniteScroll() {
        infiniteScrollLink.click();
    }

    public void scrollDown() throws InterruptedException {
        Thread.sleep(5000);
        // Javascript method scrollTo() scrolls till the end of the page
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollUp() throws InterruptedException {
        // Javascript method scrollTo() scrolls to the top of the page
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    public void textAssertion() {
        String bodyText = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/h3[1]")).getText();
        System.out.println(bodyText);
        Assert.assertTrue("Infinite Scroll", bodyText.contains(bodyText));
    }

    // user clicks on "Key Presses" link
    @FindBy(linkText = "Key Presses")
    private WebElement keyPressesLink;

    public void keyPressesLink() {
        keyPressesLink.click();
    }

    // user clicks on "textField"
    @FindBy(id = "target")
    private WebElement textField;

    public String keyPress1() {
        textField.sendKeys(Keys.ESCAPE);
        return driver.findElement(By.id("result")).getText();
    }

    public String keyPress2() {
        textField.sendKeys(Keys.TAB);
        return driver.findElement(By.id("result")).getText();
    }

    public String keyPress3() {
        textField.sendKeys(Keys.SHIFT);
        return driver.findElement(By.id("result")).getText();
    }

    public String keyPress4() {
        textField.sendKeys(Keys.CONTROL);
        return driver.findElement(By.id("result")).getText();
    }
}
