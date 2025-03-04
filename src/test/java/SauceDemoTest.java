import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SauceDemoTest {

    @BeforeEach
    void setUp() {
        Configuration.baseUrl = "https://www.saucedemo.com";
        open("/");
        WebDriver driver = Selenide.webdriver().driver().getWebDriver();
        driver.manage().window().maximize();
    }

    @Test
    void loginTest() {
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();

        $(".inventory_list").shouldBe(visible);
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
