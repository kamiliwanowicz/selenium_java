package runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.*;

//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/java/feature/", glue = "steps",
//        tags="@Gymshark",
//        plugin={"pretty"})
//public class TestRunner {
//
//}

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("runner")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/java/feature/")
@ConfigurationParameter(key = PARALLEL_EXECUTION_ENABLED_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@AllTests")
@ConfigurationParameter(key = PLUGIN_PUBLISH_ENABLED_PROPERTY_NAME, value = "true")

public class TestRunner {
}
