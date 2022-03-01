package ru.stqa.pft.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;
import ru.stqa.pft.addressbook.testData.ContactData;
import ru.stqa.pft.addressbook.testData.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Класс для тестирования создания новой записи в БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 24.02.2022
 */

public class DataCreationTest extends TestBase {

    @Test
    public void testDataCreation() {

        // Тестовые данные
        String firstName = "Boris";
        String lastName = "Ivanov";
        String address = "Moscow";
        String email = "email@mail.ts";
        String mobileFone = "+79991231212";

        ContactData contactData = new ContactData(firstName, lastName, address, email, mobileFone);

        app.getNavigationHelper().goToHomePage();

        // Создаём лист записей в БД
        List<ContactData> before = app.getContactHelper().getDataList();

        app.getNavigationHelper().goToAddNewPage();
        app.getContactHelper().fillAddNewNoteForm(contactData);
        app.getContactHelper().createNewData();
        app.getNavigationHelper().goToHomePage();

        List<ContactData> after = app.getContactHelper().getDataList();

        // Проверка количества записей БД до и после редактирования
        Assert.assertEquals(after.size(), (before.size() + 1));

        int maxId = after
                .stream()
                .max(Comparator.comparingInt(o -> o.getInputId()))
                .get()
                .getInputId();

        before.add(new ContactData(maxId, firstName, lastName));

        // Отсортируем список групп
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getInputId(), c2.getInputId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }

    @Test
    public void testDataCreationWithGroup() {

        // Тестовые данные
        String firstName = "Boris";
        String lastName = "Ivanov";
        String group = "TestGroup";

        ContactData contactData = new ContactData(firstName, lastName, group);

        app.getNavigationHelper().goToAddNewPage();
        app.getContactHelper().fillContactForm(contactData, true);
        app.getContactHelper().createNewData();
    }

}
