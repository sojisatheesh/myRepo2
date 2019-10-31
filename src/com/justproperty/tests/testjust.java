package com.justproperty.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  testjust {
   static WebDriver driver ;
    public static void main(String args[]) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\New\\lib\\chromedriver.exe");
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.justproperty.com/en/");
        //driver.findElement(By.className("ui-autocomplete-input")).sendKeys("AL NAHDA");
        WebElement testr = driver.findElement(By.cssSelector("input[class='ui-widget-content ui-autocomplete-input\']"));
        String testy="Al Nahda";
       testr.sendKeys(testy);
       driver.findElement(By.cssSelector("button[class='button button-primary search-button btn-ser-search-default gtm-search-submit']")).click();


        testsearch(testy);
        testverify(testy);

    }

    public static void testsearch(String test) {
        List<WebElement> testlist = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
        int in = 0;
        for (in = 0; in < testlist.size()-1; in++)
        {
            try {
                if (testlist.get(in).getText().contains(test))

                {

                    testlist.get(in).click();
                    break;

                }

            }
         catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void testverify(String expectedLocation)
    {
        List<WebElement> locationlist= driver.findElements(By.cssSelector("div[class='item-location']"));
        for (WebElement location:locationlist) {
            System.out.println(location.getText());

            if(location.getText().contains(expectedLocation))
                System.out.println("Test Success");

            else
            {
                System.out.println("not correct");
            }

        }
    }
}
        //driver.findElement(By.className("button-primary")).click();
         //driver.findElement(By.cssSelector("button[class='button button-primary search-button btn-ser-search-default gtm-search-submit']")).click();
         //driver.findElements(By.cssSelector("li[class='ui-menu-item']"));


