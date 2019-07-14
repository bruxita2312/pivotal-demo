package com.jalasoft.pivotal.pages;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectForm extends AbstractPage {


	public static final String OPTION_ACCOUNT_XPATH = "//div[@class='tc-account-selector__option-account-name' and text()='%s']";

	public static final String OPTION_NEW_ACCOUNT_CSS = "span.tc-account-selector__create-account-text";

	public static final String PRIVACY_CSS = "input[data-aid='%s']";

	@FindBy(css = "input[name=\"project_name\"]")
	private WebElement projectNameTextField;

	@FindBy(css = ".tc-account-selector__header")
	private WebElement accountSelect;

	@FindBy(xpath = "//div[@data-aid=\"new-account-name\"]/descendant::input")
	private WebElement newAccountName;

	@FindBy(css = "[data-aid=\"FormModal__submit\"]")
	private WebElement createButton;

	@FindBy(css = "button[class='tc_projects_dropdown_link tc_context_name']")
	private WebElement pivotalButton;

	/**
	 * Method to create a new project sending required fields on a Map
	 * with following keys: project_name, account, privacy
	 * @param data
	 */
	public void createProject(Map<String, String> data) {
		Map<String, ISteps> strategyMap = new HashMap<>();
		strategyMap.put("project_name", () -> action.setValue(projectNameTextField, data.get("project_name")));
		strategyMap.put("account", () -> selectAccount(data.get("account")));
		strategyMap.put("privacy", () -> action.click(By.cssSelector(String.format(PRIVACY_CSS, data.get("privacy")))));

		Set<String> keys = data.keySet();
		for (String key: keys) {
			strategyMap.get(key).execute();
		}
		action.click(createButton);
	}

	public void createProject_with_new_account (Map<String, String> data){
		Map<String, ISteps> strategyMap = new HashMap<>();
		strategyMap.put("project_name", () -> action.setValue(projectNameTextField, data.get("project_name")));
		strategyMap.put("account", () -> addNewAccount(data.get("account")));
		strategyMap.put("privacy", () -> action.click(By.cssSelector(String.format(PRIVACY_CSS, data.get("privacy")))));

		Set<String> keys = data.keySet();
		for (String key: keys) {
			strategyMap.get(key).execute();
		}
		action.click(createButton);
	}

	private void selectAccount(String expectedAccount) {
		action.click(accountSelect);
		String optionAccountLocator = String.format(OPTION_ACCOUNT_XPATH, expectedAccount);
		action.click(By.xpath(optionAccountLocator));
	}

	private void addNewAccount (String newAccount){
		action.click(accountSelect);
		action.click(By.cssSelector(OPTION_NEW_ACCOUNT_CSS));
		action.setValue(newAccountName, newAccount);
	}

}
