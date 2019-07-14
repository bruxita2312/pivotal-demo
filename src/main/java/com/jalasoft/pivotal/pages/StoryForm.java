package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StoryForm extends AbstractPage {
    public static String ADD_BUTTON_CSS = ".current_backlog a[data-aid=\"AddButton\"]";
    public static String TITLE_CSS = "textarea[data-aid=\"name\"]";
    public static String TITLE_CSS2 = "textarea[name=\"story[name]\"]";
    public static String SAVE_BUTTON_CSS = "#story_close_c507";

    @FindBy(css = "#story_close_c507")
    private WebElement saveButton;

    public void addStory(Map<String, String> data) {
        action.click(By.cssSelector(ADD_BUTTON_CSS));
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("title", () -> action.setValue(By.cssSelector(TITLE_CSS2), data.get("story_title")));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }

        action.click(By.cssSelector(SAVE_BUTTON_CSS));
    }
}
