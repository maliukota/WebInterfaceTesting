package ru.netology.web;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class WebTest {
    @Test
    void shouldFullForm() {
        open("http://localhost:9999");
        $("[name='name']").setValue("Мамин-Сибиряк Иван Петрович");
        $("[name='phone']").setValue("+70000000000");
        $("[data-test-id='agreement']").click();
        $(byClassName("button")).click();
        $("[data-test-id='order-success']").shouldHave(exactText("Ваша заявка успешно отправлена!" +
                " Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldFullFormIncorrectly() {
        open("http://localhost:9999");
        $("[name='name']").setValue("SSS");
        $("[name='phone']").setValue("123");
        $("[data-test-id='agreement']").click();
        $(byClassName("button")).click();
        $(byClassName("input__sub")).shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только" +
                " русские буквы, пробелы и дефисы."));
    }
}
