package com.jalasoft.pivotal.pages;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signin extends AbstractPage {

    @FindBy(css = "#credentials_username")
    private WebElement userNameTextField;

    @FindBy(css = "#credentials_password")
    private WebElement passwordTextField;

    @FindBy(css = ".app_signin_action_button")
    private WebElement loginButton;

    public Signin() {
        driver.get("https://www.pivotaltracker.com/signin?source=navbar");
    }

    public Header loginAs(String userName, String password) {
        action.setValue(userNameTextField, userName);
        action.click(loginButton);
        action.setValue(passwordTextField, password);
        action.click(loginButton);
        return new Header(driver);
    }
}
