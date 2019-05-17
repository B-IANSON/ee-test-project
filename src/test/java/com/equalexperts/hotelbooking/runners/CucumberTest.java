package com.equalexperts.hotelbooking.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "junit:target/cucumber.xml"},
        features = "src/test/resources/com/equalexperts.hotelbooking/features",
        glue = {"com.equalexperts.hotelbooking.stepdefs", "com.equalexperts.hotelbooking.world"},
        junit ={ "--step-notifications"},
        monochrome = true)
public class CucumberTest {
}