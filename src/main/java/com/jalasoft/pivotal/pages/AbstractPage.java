package com.jalasoft.pivotal.pages;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected WebDriverAction action;

	public AbstractPage() {
		driver = DriverManager.getInstance().getDriver();
		wait = DriverManager.getInstance().getWait();
		action = new WebDriverAction(driver, wait);

		PageFactory.initElements(driver, this);
	}

}
