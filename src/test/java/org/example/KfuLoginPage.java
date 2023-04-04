package org.example;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KfuLoginPage {

    private WebDriver driver;
    @FindBy(xpath = ("/html/body/header/div[1]/div[1]/div[2]/a"))
    private WebElement lkButton;
    @FindBy(xpath = ("/html/body/div[14]/div/div[2]/form/input[1]"))
    private WebElement loginField;
    @FindBy(xpath = ("/html/body/div[14]/div/div[2]/form/input[2]"))
    private WebElement passwordField;
    @FindBy(xpath = ("/html/body/div[14]/div/div[2]/form/input[3]"))
    private WebElement enterButton;

    public KfuLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLkButton(){
        lkButton.click();
    }

    public void setLoginField(){
        loginField.sendKeys("GAGalimov");
    }

    public void setPasswordField(){
        passwordField.sendKeys("bu1ad8gg");
    }

    public void clickEnterButton(){
        enterButton.click();
    }

    public void lkButtonIsDisplayed() {
        Assertions.assertTrue(lkButton.isDisplayed());
    }
}
