package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
    WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure-selenide", new AllureSelenide());
//        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
//        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    @Test
    void fillFormTest() {
        String userName = "Alex Egorov";

        open("/text-box");
        $("h1.text-center").shouldHave(text("Text Box"));

        $("#userName").setValue(userName);
        $("#userEmail").setValue("andy@email.ru");
        $("#currentAddress").setValue("Some street 1");
        $("#permanentAddress").setValue("Another street 1");
        $("#submit").scrollIntoView(true).click();

        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave(text(userName));
        $("#output #email").shouldHave(text("andy@email.ru"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }


    @AfterEach
    void teardown() {
        driver.quit();
    }

    @AfterAll
    static void afterAll() {
//        closeWebDriver();
    }
}
