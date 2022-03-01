package ru.stqa.pft.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;
import ru.stqa.pft.addressbook.testData.ContactData;
import ru.stqa.pft.addressbook.testData.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Класс для тестирования удаления записи в БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 25.02.2022
 */

public class DataDeletionTest extends TestBase {

    @Test
    public void testDataDeletion() {

        // Тестовые данные
        String firstName = "Boris";
        String lastName = "Ivanov";
        String address = "Moscow";
        String email = "email@mail.ts";
        String mobileFone = "+79991231212";

        ContactData contactData = new ContactData(firstName, lastName, address, email, mobileFone);

        app.getNavigationHelper().goToHomePage();

        if (! app.getContactHelper().isDataPresent()) {
            app.getNavigationHelper().goToAddNewPage();
            app.getContactHelper().createDataMethod(contactData);
        }

        app.getNavigationHelper().goToHomePage();

        // Создаём лист записей в БД
        List<ContactData> before = app.getContactHelper().getDataList();

        app.getContactHelper().selectData(before.size() - 2);
        app.getContactHelper().deleteSelectedData();
        app.getContactHelper().confirmDeletion();
        app.getNavigationHelper().goToHomePage();

        List<ContactData> after = app.getContactHelper().getDataList();

        // Проверка количества записей БД до и после удаления
        Assert.assertEquals(after.size(), (before.size() - 1));

        // Удаляем из списка before удалённую запись
        before.remove(before.size() - 2);

        // Отсортируем записи БД
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getInputId(), c2.getInputId());
        before.sort(byId);
        after.sort(byId);

        // Сравниваем списки групп
        Assert.assertEquals(before, after);
    }
}
