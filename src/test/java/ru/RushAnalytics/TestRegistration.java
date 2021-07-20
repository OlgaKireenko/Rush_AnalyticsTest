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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestRegistration {

    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {

        driver.quit();
        driver = null;
    }
    @Test
    public void registrationTest() {
        driver.get("https://www.rush-analytics.ru/");
        //WebElement form = driver.findElement(By.cssSelector("[data-test-id=order-form]"));
        driver.findElement(By.className("username form-text")).sendKeys("kireenko86.osil@mail.ru");
        driver.findElement(By.className("text-full form-text required error")).sendKeys("+79270000000");
        driver.findElement(By.className("text-full form-text required")).sendKeys("Olga");
        driver.findElement(By.className("form-checkbox required")).click();
        driver.findElement(By.className("form-submit")).click();
        String text = driver.findElement(By.className("f-size-24 l-height-34 p-top-7 p-bottom-17")).getText();
        assertEquals("В течение 5 минут вы получите ссылку для входа на указанный Вами email.", text.trim());





    }
}




