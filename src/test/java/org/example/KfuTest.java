package org.example;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class KfuTest {
    private static WebDriver driver;
//    private static WebDriverWait wait;
    private static KfuLoginPage kfuLoginPage;



    @BeforeAll
    public static void start() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zxlx\\Desktop\\TPO\\chromedriver.exe");
        driver = new ChromeDriver(options);
        kfuLoginPage = new KfuLoginPage(driver);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://kpfu.ru/");
    }

    @AfterAll
    public static void stop() {
        if(driver != null) {
            driver.quit();
        }
    }
    @Test
    public void aLoginTest(){
        kfuLoginPage.clickLkButton();
//        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//        wait.until(ExpectedConditions.visibilityOf((WebElement) By.xpath("/html/body/div[14]/div/div[2]/form/input[3]")));
        kfuLoginPage.setLoginField();
        kfuLoginPage.setPasswordField();
        kfuLoginPage.clickEnterButton();
//        Assertions.assertNotEquals("Казанский (Приволжский) федеральный университет - официальный сайт", driver.getTitle());
//        wait.until(ExpectedConditions.visibilityOf((WebElement) By.xpath("/html/body/div[2]/header/a[1]")));
        KfuLoggedPage kfuLoggedPage = new KfuLoggedPage(driver);
        kfuLoggedPage.lgButtonIsDisplayed();
    }

    @Test
    public void bExitTest(){
        KfuLoggedPage kfuLoggedPage = new KfuLoggedPage(driver);
//        wait.until(ExpectedConditions.visibilityOf((WebElement) By.xpath("/html/body/div[2]/header/a[1]")));
        kfuLoggedPage.clickExitButton();
        kfuLoginPage.lkButtonIsDisplayed();
    }

}
