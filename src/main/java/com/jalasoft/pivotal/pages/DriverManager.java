package com.jalasoft.pivotal.pages;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {
	private static DriverManager ourInstance = new DriverManager();

	public static DriverManager getInstance() {
		return ourInstance;
	}

	private WebDriver driver;

	private WebDriverWait wait;

	private DriverManager() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);

		driver.manage().window().maximize();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}
}
