package ru.stqa.pft.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;
import ru.stqa.pft.addressbook.testData.ContactData;
import ru.stqa.pft.addressbook.testData.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Класс для тестирования редактирования записи в БД addressbook
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 25.02.2022
 */

public class DataEditTest extends TestBase {

    @Test
    public void testDataEdit() {

        // Тестовые данные
        String firstName = "Boris Edit";
        String lastName = "Ivanov Edit";
        String address = "Moscow city";
        String email = "edit@mail.ts";
        String mobileFone = "+70001231212";

        ContactData contactData = new ContactData(firstName, lastName, address, email, mobileFone);

        app.getNavigationHelper().goToHomePage();

        if (! app.getContactHelper().isDataPresent()) {
            app.getNavigationHelper().goToAddNewPage();
            app.getContactHelper().createDataMethod(contactData);
        }

        app.getNavigationHelper().goToHomePage();

        // Создаём лист групп и ID
        List<ContactData> before = app.getContactHelper().getDataList();
        int id = before.get(before.size() - 2).getInputId(); // !!! Вынести в тестовые данные

        app.getContactHelper().initDatEdit(before.size() - 2);
        app.getContactHelper().fillContactForm(contactData, false);
        app.getContactHelper().submitDataEdit();
        app.getNavigationHelper().goToHomePage();

        List<ContactData> after = app.getContactHelper().getDataList();

        // Проверка количества записей БД до и после редактирования
        Assert.assertEquals(after.size(), before.size());

        // Удаляем из списка before отредактированную запись
        before.remove(before.size() - 2);

        // Добавляем запись с параметрами редактирования
        before.add(new ContactData(id, firstName, lastName));

        // Отсортируем записи БД
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getInputId(), c2.getInputId());
        before.sort(byId);
        after.sort(byId);

        // Сравниваем списки групп
        Assert.assertEquals(before, after);
    }
}
