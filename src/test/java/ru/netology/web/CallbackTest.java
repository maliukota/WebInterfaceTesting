package ru.netology.web;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CallbackTest {
    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
        $("[name='name']").setValue("Иванов Иван");
        $("[name='phone']").setValue("+70000000000");
        $("[data-test-id='agreement']").click();
        $(byClassName("button")).click();
        $("[data-test-id='order-success']").shouldHave(exactText("Ваша заявка успешно отправлена!" +
                " Наш менеджер свяжется с вами в ближайшее время."));
    }
}
