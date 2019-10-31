package com.justproperty.tests;

import com.justproperty.com.justproperty.utils.TestBase;
import com.justproperty.pages.HomePage;
import com.justproperty.pages.ListingsPage;
import com.justproperty.pages.SignInPage;
import org.testng.annotations.Test;
import org.testng.Assert;

// POM --> Test Design Pattern
//TestNG --> Test Execution Framework


public class TestLocationSearch extends TestBase {
    @Test
    public void testSingleLocationSearch(){
        HomePage home = new HomePage(driver);
        home.enterLocation("AL NAHDA");
        home.bedroom();
        home.budget();
        home.area();
        home.clickSearchButton();

        ListingsPage searchresult  = new ListingsPage(driver);
        //searchresult.verifyListingsByLocation("Al Nahda");
        Assert.assertTrue(searchresult.amountvalidation(20000,50000));
        Assert.assertTrue(searchresult.SqFtValidation(1000,3000));
        Assert.assertTrue(searchresult.getbedroom(2));
        //Assert.assertTrue(searchresult.closelisting());

            Assert.assertTrue(searchresult.shortlist());
         //searchresult.getbedroom();


    }
   @Test
   public void signin()
   {
     SignInPage sign=new SignInPage(driver);
     Assert.assertTrue(sign.signin());

   }



    @Test
    public void testclick()
    {
        HomePage home = new HomePage(driver);
        home.rentalClick();
    }

    @Test
            public void click()









































    {
        HomePage home = new HomePage(driver);
        home.imgClick();

    }


    @Test
    public void testuderstandAssertations(){

        String expected = "soji";
        String actual = "soji";

        Assert.assertFalse(expected.equals(actual));

    }

    @Test
    public void testMultiplaLocationSearch(){

        HomePage home = new HomePage(driver);
        home.enterLocation("Al Nahda");
        home.selectLoationFromSuggestions();
        home.enterLocation("Al Wahda");
        home.selectLoationFromSuggestions();
        home.clickSearchButton();

        ListingsPage searchresult  = new ListingsPage(driver);
        searchresult.verifyListingsByLocation("Al Nahda");
        searchresult.verifyListingsByLocation("Al Wahda");

    }

    @Test
    public void testInvalidLocationSearch(){

        HomePage home = new HomePage(driver);
        home.enterLocation("fdsf");
        home.clickSearchButton();

        ListingsPage searchresult  = new ListingsPage(driver);
        searchresult.verifyListingsByLocation("fdsf");

    }

}
