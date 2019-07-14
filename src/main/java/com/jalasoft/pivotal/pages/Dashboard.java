package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends AbstractPage {

	@FindBy(css = "#create-project-button")
	private WebElement createProjectButton;

	public ProjectForm clickCreateProjectButton() {
		action.click(createProjectButton);
		return new ProjectForm();
	}



}
