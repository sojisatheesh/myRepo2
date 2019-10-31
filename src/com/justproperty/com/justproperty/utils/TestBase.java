package com.justproperty.com.justproperty.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TestBase {

    public WebDriver driver;
    @BeforeTest
    public void setupWebDriver(){

        System.setProperty
                ("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\New\\lib\\chromedriver1.exe");
        driver=new ChromeDriver();
        driver.get("https://www.justproperty.com/en/");


        // Map<String, String> mobileEmulation = new HashMap<>();
        //mobileEmulation.put("deviceName", "Nexus 5");

        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        //driver.manage().window().setSize(new Dimension(375,812));

        //driver = new ChromeDriver(chromeOptions);
    }
}
