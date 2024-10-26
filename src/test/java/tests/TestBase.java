package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    WebDriver driver;

    @BeforeAll
    static void beforeAll() {
//        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
//        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
        Configuration.browserSize = "1920x1080";
        // for selenoid
//        Configuration.remote = "http://user1:1234@selenoid.autotest.cloud/wd/hub";
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        SelenideLogger.addListener("allure-selenide", new AllureSelenide());
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @AfterEach
    void addAttachments() {
//        Attach.screenshotAs("Last screenshot");
//        Attach.pageSource();
//        Attach.browserConsoleLogs();

        // Attach.video();
    }

//    @AfterAll
//    static void afterAll() {
//        closeWebDriver();
//    }
}
