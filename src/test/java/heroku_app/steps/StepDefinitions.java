package heroku_app.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import heroku_app.page_objects.HomePage;
import org.hamcrest.Matchers;
import org.junit.Assert;

public class StepDefinitions {

    private HomePage homePage = new HomePage();

    @Given("^user is on homepage$")
    public void user_is_on_homepage() {
        // Write code here that turns the phrase above into concrete actions
        String homePageUrl = homePage.getHomePageUrl();
        Assert.assertThat(homePageUrl, Matchers.endsWith("the-internet.herokuapp.com/"));
    }

    @When("^user clicks on form authentication link$")
    public void user_clicks_on_form_authentication_link() {
        // Write code here that turns the phrase above into concrete actions
        homePage.formAuthentication();
    }

    @When("^user enters correct username and wrong password$")
    public void user_enters_correct_username_and_wrong_password() {
        // Write code here that turns the phrase above into concrete actions
        homePage.logInOne("tomsmith", "wrongSuperSecretPassword!");
//        Assert.assertThat();
    }

    @Given("^user enters wrong username and correct password$")
    public void user_enters_wrong_username_and_correct_password() {
        // Write code here that turns the phrase above into concrete actions
        homePage.logInTwo("wrongtomsmith", "SuperSecretPassword!");
//        Assert.assertThat();
    }

    @Then("^user fails to login$")
    public void user_fails_to_login() {
        // Write code here that turns the phrase above into concrete actions
//        Assert.assertThat();
    }

    @Given("^user enters correct username and correct password$")
    public void user_enters_correct_username_and_correct_password() {
        // Write code here that turns the phrase above into concrete actions
        homePage.logInThree("tomsmith", "SuperSecretPassword!");
//        Assert.assertThat();
    }

    @Then("^user logs in successfully$")
    public void user_logs_in_successfully() {
        // Write code here that turns the phrase above into concrete actions
//        Assert.assertThat();
    }

    @Then("^user can log out successfully$")
    public void user_logs_out_successfully() {
        // Write code here that turns the phrase above into concrete actions
//        Assert.assertThat();
    }

    @When("^user clicks on infinite scroll link$")
    public void userClicksOnInfiniteScrollLink() {
        // Write code here that turns the phrase above into concrete actions
        homePage.infiniteScroll();
    }

    @And("^user scrolls to the bottom of the page twice$")
    public void user_scrolls_to_the_bottom_of_the_page_twice() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        homePage.scrollDown();
        homePage.scrollDown();
    }

    @And("^user scrolls back to the top of the page$")
    public void user_scrolls_back_to_the_top_of_the_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        homePage.scrollUp();
    }

    @Then("^user can assert \"([^\"]*)\" text successfully$")
    public void user_asserts_text_successfully(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        homePage.textAssertion();
    }

    @When("^user clicks on key presses link$")
    public void userClicksOnKeyPressesLink() {
        // Write code here that turns the phrase above into concrete actions
        homePage.keyPressesLink();
    }

    @And("^user clicks on four keys$")
    public void user_clicks_on_four_keys() throws InterruptedException {
    }

    @Then("^user asserts the text displayed after every key is pressed$")
    public void user_asserts_the_text_displayed_after_every_key_is_pressed() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        String actualKey1 = homePage.keyPress1();
        Thread.sleep(3000);
        Assert.assertThat(actualKey1, Matchers.endsWith("ESCAPE"));
        String actualKey2 = homePage.keyPress2();
        Thread.sleep(3000);
        Assert.assertThat(actualKey2, Matchers.endsWith("TAB"));
        String actualKey3 = homePage.keyPress3();
        Thread.sleep(3000);
        Assert.assertThat(actualKey3, Matchers.endsWith("SHIFT"));
        String actualKey4 = homePage.keyPress4();
        Thread.sleep(3000);
        Assert.assertThat(actualKey4, Matchers.endsWith("CONTROL"));
        System.out.println("expected = actual");
    }
}
