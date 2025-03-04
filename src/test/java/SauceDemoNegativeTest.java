import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SauceDemoNegativeTest {

    @BeforeEach
    void setUp() {
        Configuration.baseUrl = "https://www.saucedemo.com";
        open("/");
        WebDriver driver = Selenide.webdriver().driver().getWebDriver();
        driver.manage().window().maximize();
    }

    @Test
    void loginTestWithInvalidCredentials() {
        $("#user-name").setValue("invalid_user");
        $("#password").setValue("invalid_password");
        $("#login-button").click();

        $("[data-test='error']").shouldBe(visible)
                .shouldHave(text("Epic sadface: Username and password do not match any user in this service"));
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}