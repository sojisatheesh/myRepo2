package com.justproperty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class HomePage {

    WebDriver driver;

    WebElement txtSearchLocation;
    WebElement btnSearch;
    WebElement dropdwn;
    WebElement budget;
    WebElement maxprice;
    WebElement minprice;
    WebElement Annual;
    WebElement area;
    WebElement minarea;
    WebElement maxarea;
    WebElement adsearch;

    public HomePage(WebDriver passeddriver)
     {
        this.driver = passeddriver;
}

    public void enterLocation(String Location){
        txtSearchLocation =driver.findElement(By.cssSelector("input[class='ui-widget-content ui-autocomplete-input']"));
        txtSearchLocation.sendKeys(Location);


    }

    public void rentalClick()
    {
        driver.findElement(By.cssSelector("div[class='wrap'] a[data-val='rent']")).click();

    }

    public void imgClick()
    {
        driver.findElement(By.cssSelector("div[class*='home-locations-masonry'] a[href*='properties-for-rent-in-dubai-marina']")).click();

    }


    public boolean selectLoationFromSuggestions(){

        List<WebElement> testlist = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
        for (WebElement locationlist:testlist) {
            locationlist.click();
        }
        return true;
}
    public void bedroom()
    {
        dropdwn =driver.findElement(By.cssSelector(("select[class='id_bedrooms']")));
        Select dropdown=new Select(dropdwn);
        //dropdown.selectByValue("2");
        dropdown.selectByVisibleText("2 Beds");



    }

    public void budget()
    {
   // buget= driver.findElement(By.className("price_label"));
        budget=driver.findElement(By.cssSelector
                ("div[class='range-elem search-field m-half m-half-last joined-elem range-elem-budget']")
        );
        budget.click();
        Annual=driver.findElement(By.cssSelector("label[class='selected']"));
        Annual.click();

        minprice=driver.findElement(By.cssSelector("input[class='id_price_min']"));
                minprice.sendKeys("20000");
        maxprice=driver.findElement(By.cssSelector("input[class='id_price_max']"));
        maxprice.sendKeys("50000");



    }  public void area()
    {
   // buget= driver.findElement(By.className("price_label"));
        adsearch=driver.findElement(By.cssSelector("div[class='advanced-search-btn']"));
        adsearch.click();
        area=driver.findElement(By.cssSelector
                ("span[data-placeholder='Area']"));
        area.click();
        //Annuale=driver.findElement(By.cssSelector("label[class='selected']"));
        //Annuale.click();

        minarea=driver.findElement(By.cssSelector("input[class='id_built_up_area_min']"));
        //minarea.click();
                minarea.sendKeys("1000");
    maxarea=driver.findElement(By.cssSelector("input[class='id_built_up_area_max']"));

        maxarea.sendKeys("3000");



    }

    public void clickSearchButton(){
        btnSearch=driver.findElement(By.cssSelector("button[class='button button-primary search-button btn-ser-search-default gtm-search-submit']"));
        btnSearch.click();
        //Assert.assertTrue(true);
    }

}
