package com.justproperty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.naming.directory.SearchResult;
import java.util.List;

public class ListingsPage {

    WebDriver driver;
    WebElement count;
    WebElement close;

    public ListingsPage(WebDriver passeddriver) {
        this.driver = passeddriver;
    }


    public void verifyListingsByLocation(String expectlocation) {
        List<WebElement> locationlist = driver.findElements(By.cssSelector("div[class='item-location']"));
        for (WebElement location : locationlist) {
            System.out.println(location.getText());

            if (location.getText().contains(expectlocation))
                System.out.println("Test Success");

            else {
                System.out.println("not correct");
            }

        }
    }

    public boolean getbedroom(int selectedBed) {
        int bed;
        boolean resultsProper = false;
        // List<WebElement> searchResults = driver.findElements(By.cssSelector("div.item-result ul.item-amenities"));
        List<WebElement> searchResults = driver.findElements(By.xpath("//span[@class='icon-bed']/parent::li"));


        for (WebElement result : searchResults) {
            bed = Integer.parseInt(result.getText());
            if (selectedBed == bed) {
                resultsProper = true;
            } else {
                return false;
            }
        }
        return resultsProper;
    }

    // for(WebElement result : searchResults){
    //   bed = Integer.parseInt(result.findElements(By.tagName("li")).get(0).getText());
    // if(selectedBed == bed){
    //   resultsProper = true;
    //}else{
    //  return false;
    //}
    //}
    //  return resultsProper;
//}

    public boolean amountvalidation(int expecte1, int expectted2) {
        List<WebElement> amountdisplayed = driver.findElements(By.cssSelector("span[class='original']"));
        int test1 = expecte1;
        int test2 = expectted2;
        String amount;
        String[] amtac;
        int amtc;
        boolean result = false;
        for (WebElement amt : amountdisplayed) {
            amount = amt.getText();
            amtac = amount.split(" ");
            amtc = Integer.parseInt(amtac[1].replaceAll(",", ""));
            if ((amtc >= test1) && (amtc <= test2)) {
                result = true;
            } else {
                return false;
            }
        }
        return result;
    }

    public boolean SqFtValidation(int expecte1, int expectted2) {
        List<WebElement> sqftdisplayed = driver.findElements(By.xpath("//span[@class='icon-area_3']/parent::li"));
        int test1 = expecte1;
        int test2 = expectted2;
        String sqft;
        String[] sqrft;
        int actsqft;
        boolean result = false;
        for (WebElement sqt : sqftdisplayed) {
            sqft = sqt.getText();
            sqrft = sqft.split(" ");
            actsqft = Integer.parseInt(sqrft[0].replaceAll(",", ""));
            if ((actsqft >= test1) && (actsqft <= test2)) {
                result = true;
            } else {
                return false;
            }
        }
        return result;
    }

    public boolean closelisting() {
        boolean isClicked = false;
        //close=driver.findElement(By.cssSelector("a[title='Remove from Search Results'] span[class='icon-cancel']"));
        List<WebElement> test = driver.findElements(By.cssSelector("span[class='icon-cancel']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        for (WebElement te : test) {

            js.executeScript("window.scrollBy(0,100)");
            if (te.isDisplayed()) {
                te.click();
                isClicked = true;
            }

        }
        //close.click();
        if (driver.findElement(By.cssSelector("a[class='item-remove-exempt']")).isDisplayed()) {
            isClicked = true;
        } else {
            isClicked = false;
        }
        return isClicked;
    }

    public boolean shortlist() {
        WebElement icon = driver.findElement(By.className("icon-heart-empty"));
        icon.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement highlighted = driver.findElement(By.cssSelector("span[class='icon-heart-1']"));
        if (highlighted.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}







