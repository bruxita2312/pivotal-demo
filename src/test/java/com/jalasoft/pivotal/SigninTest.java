package com.jalasoft.pivotal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.jalasoft.pivotal.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SigninTest {

    @Test
    public void testSignin() {
        // When
        String expectedUserName = "rpfh1";
        String password = "123456Aa*";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "");

        // Then
        ProfileDropdown profileDropdown = header.clickProfileDropdown();
        String actualResult = profileDropdown.getAvatarName();
        //Assert.assertEquals( expectedUserName, actualResult);
    }

    @Test
    public void testCreateProject() {

        // Given
        String expectedUserName = "rpfh1";
        String password= "123456Aa*";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, password);

        // When
        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        Map<String, String> data = new HashMap<>();
        data.put("project_name", "My Project Test");
        data.put("account", "Account1");
        data.put("privacy", "public");

        projectForm.createProject(data);



        // Then
//        String actualProjectName = driver.findElement(By.cssSelector(".raw_context_name")).getText();
//        Assert.assertEquals(expectedProject, actualProjectName);
//
//        String actualPrivacy = driver.findElement(By.cssSelector(".public_project_label")).getText();
//        Assert.assertEquals("(Public)", actualPrivacy);
//
//        driver.findElement(By.cssSelector("a[href*=\"/settings\"] > span")).click();
//
//        actualProjectName = driver.findElement(By.cssSelector("#project_name")).getAttribute("value");
//        Assert.assertEquals(expectedProject, actualProjectName);
//
//        String actualAccount = driver.findElement(By.cssSelector("a[href*='/accounts']")).getText();
//        Assert.assertTrue(actualAccount.contains(expectedAccount));
//
//        Assert.assertTrue(driver.findElement(By.cssSelector("#project_public")).isSelected());
    }

    @Test
    public void testCreateProject_with_new_account() {

        // Given
        String expectedUserName = "rpfh1";
        String password = "123456Aa*";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, password);

        // When
        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        Map<String, String> data = new HashMap<>();
        data.put("project_name", "My Project Test");
        data.put("account", "Account1");
        data.put("privacy", "public");

        projectForm.createProject_with_new_account(data);
    }

/*
        @Test
    public void addStory(){
        // Given
        String expectedUserName = "rpfh1";
        String password= "123456Aa*";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, password);
        //StoryForm
    }*/
}
