package ru.netology.web.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.FormPage;

import java.time.Duration;

import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SendFormPage {

    @BeforeAll
    static void setUpAll() { SelenideLogger.addListener("allure", new AllureSelenide()); }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldSendFormPlanning() {
        holdBrowserOpen = true;
        open("http://localhost:9999/");
        var formPage = new FormPage();
        var formInfo = DataHelper.FormInfo.getFormInfo();
        formPage.sendValidForm(formInfo);
    }
}
