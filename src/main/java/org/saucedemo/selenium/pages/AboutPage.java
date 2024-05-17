package org.saucedemo.selenium.pages;


import org.openqa.selenium.WebDriver;

public class AboutPage {
    private WebDriver driver;
    public AboutPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getTitle(){
        return driver.getTitle();
    }
}