package ru.RushAnalytics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestRegistration {

    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");


        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {

        driver.quit();
        driver = null;
    }
    @Test
    public void registrationTest1() {
        driver.get("https://www.rush-analytics.ru/");
        driver.findElement(By.className("btn-ra-menu-register")).click();

        driver.findElement(By.cssSelector("#edit-name")).sendKeys("kireenko86.osil@mail.ru");
        driver.findElement(By.cssSelector("#edit-field-phone-und-0-value")).sendKeys("+79270000000");
        driver.findElement(By.cssSelector("#edit-field-name-und-0-value")).sendKeys("Olga");
        driver.findElement(By.cssSelector("#edit-field-terms-und")).click();
        driver.findElement(By.cssSelector("#edit-submit")).click();
        String text = driver.findElement(By.cssSelector("#messages")).getText();
        assertEquals("Error message\n" +
                "Этот е-мейл адрес уже зарегистрирован.Забыли пароль?", text.trim());



        //Thread.sleep(5000);
    }



}




