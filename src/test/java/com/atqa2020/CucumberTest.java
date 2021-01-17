package com.atqa2020;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/atqa2020/features",
        glue = "com.atqa2020",
        plugin = {"pretty", "html:target/cucumber-report"},
        tags = "@SmokeTest"
)
public class CucumberTest {
}
