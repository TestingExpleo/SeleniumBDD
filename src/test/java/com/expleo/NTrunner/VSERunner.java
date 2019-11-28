package com.expleo.NTrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:Feature info\\VSE.feature",glue= "com.expleo.NtDefinition")


public class VSERunner {

}
