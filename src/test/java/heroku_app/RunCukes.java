package heroku_app;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        strict = true,
//        dryRun = false,
//        glue = {}
        tags = {"@login, @scolling, @keypresses"},
        plugin = "json:target/heroku_app.json"
)
public class RunCukes {
    // Runner Class by Haroon
}
