package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TextBoxTests extends TestBase {

    @Test
    void fillFormTest() {
        String userName = "Alex Egorov";

        step("Open form", () -> {
            open("/text-box");
            $("h1.text-center").shouldHave(text("Text Box"));
        });

        step("Fill form", () -> {
            $("#userName").setValue(userName);
            $("#userEmail").setValue("andy@email.ru");
            $("#currentAddress").setValue("Some street 1");
            $("#permanentAddress").setValue("Another street 1");
//            $("#submit").scrollIntoView(true).click();
            $("#submit").click();
        });

        step("Verify results", () -> {
            $("#output").shouldBe(visible);
            $("#output").$("#name").shouldHave(text(userName));
            $("#output #email").shouldHave(text("andy@email.ru"));
            $("#output #currentAddress").shouldHave(text("Some street 1"));
            $("#output #permanentAddress").shouldHave(text("Another street 1"));
        });
    }
}
