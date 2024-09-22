import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class drag_and_drop {
    @BeforeAll
    public static void beforeAll()
    {
        Configuration.baseUrl = "https://the-internet.herokuapp.com"; // открываем страницу Selenide в GitHub (абсолютный путь)
        Configuration.pageLoadStrategy = "eager"; // команда для того, чтобы селенид не ждал загрузки всех картинок и тяжелых элементов. Только html.
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void fillTests() {
        open("/drag_and_drop"); // открываем страницу Selenide в GitHub (относительный путь)
//        executeJavaScript("$('#fixedban').remove()"); //убрать окна и баннеры
//        executeJavaScript("$('footer').remove()"); //убрать окна и баннеры
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(200, 0).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}