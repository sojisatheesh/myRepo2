package com.justproperty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class SignInPage {
    WebDriver driver;

    public SignInPage(WebDriver passeddriver) {
        this.driver = passeddriver;
    }

    public boolean signin() {
        WebElement siginlink = driver.findElement(By.linkText("Sign In"));
        siginlink.click();
        WebElement email = driver.findElement(By.id("id_user_email"));
        email.sendKeys("sojirn@gmail.com");
        WebElement password = driver.findElement(By.id("id_password"));
        password.sendKeys("Ucs@1234");
        WebElement SignInButton = driver.findElement(By.name("submit"));
        SignInButton.click();

        //WebElement test=driver.findElement(By.className( "fs-13 all-caps"));
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='semi-bold all-title']")));
        if(driver.findElement(By.cssSelector("span[class='semi-bold all-title']")).isDisplayed())
        {
            return true;
        } else
            {
            return false;
        }
    }
}