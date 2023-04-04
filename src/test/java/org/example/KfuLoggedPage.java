package org.example;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KfuLoggedPage {
    private WebDriver driver;
    @FindBy(xpath = ("/html/body/div[2]/header/a[1]"))
    private WebElement lgButton;

    public KfuLoggedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickExitButton(){
        lgButton.click();
    }

    public void lgButtonIsDisplayed() {
        Assertions.assertTrue(lgButton.isDisplayed());
    }
}
