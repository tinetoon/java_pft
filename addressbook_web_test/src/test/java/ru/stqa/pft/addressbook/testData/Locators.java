package ru.stqa.pft.addressbook.testData;

import lombok.Getter;
import org.openqa.selenium.By;

/**
 * Базовый класс локаторов на страницах БД
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 25.02.2022
 */

@Getter
public class Locators {

//    private final By LC_1 = By.name("");
//    private final By LC_2 = By.xpath("");

    private final By MENU_PAGE_HOME = By.xpath("//a[.='home']");
    private final By MENU_PAGE_ADD_NEW = By.xpath("//a[.='add new']");
    private final By MENU_PAGE_GROUPS = By.xpath("//div[@id=\"nav\"]//a[.='groups']");

    private final By BUTTON_AUTHORIZATION_ENTER = By.xpath("//input[@type=\"submit\"]");

    private final By BUTTON_DATA_NEW_ENTER = By.xpath("//div[@id=\"content\"]//*[@type=\"submit\"][1]");
    private final By BUTTON_DATA_DELETE_ENTER = By.xpath("//input[@value=\"Delete\"]");
    private final By BUTTON_DATA_EDIT = By.xpath("//td[.='Ivanov']//..//img[@title=\"Edit\"]");

    // Селекторы для списков кнопок просмотра информации о записи, редактирования и создания VCard
    private final By BUTTON_DATA_DETAILS_LIST = By.cssSelector("img[title='Details']");
    private final By BUTTON_DATA_EDIT_LIST = By.cssSelector("img[title='Edit']");
    private final By BUTTON_DATA_VCARD_LIST = By.cssSelector("img[title='vCard']");

    private final By BUTTON_DATA_EDIT_ENTER = By.xpath("//input[@value=\"Update\"][1]");

    private final By CHECK_BOX_DATA = By.xpath("//input[@title=\"Select (Boris Ivanov)\"]");
    private final By CHECK_BOX_COUNT_DATA = By.name("selected[]");

    private final By BUTTON_GROUP_NEW = By.name("new");
    private final By BUTTON_GROUP_NEW_ENTER = By.name("submit");
    private final By BUTTON_GROUP_EDIT = By.name("edit");
    private final By BUTTON_GROUP_EDIT_ENTER = By.name("update");
    private final By BUTTON_GROUP_DELETE_ENTER = By.xpath("//*[@name=\"delete\"][1]");

    private final By CHECK_BOX_GROUP = By.xpath("//input[@title=\"Select (TestGroup)\"]");
    private final By CHECK_BOX_COUNT_GROUP = By.name("selected[]");
    private final By CHECK_BOX_IN_SPAN = By.tagName("input");

    private final By SPAN_GROUP = By.cssSelector("span.group");
//    private final By SPAN_DATA = By.xpath("//td[@class='center']//input");
    private final By SPAN_DATA = By.cssSelector("tr[name='entry']");

    private final By BUTTON_PAGE_RETURN_GROUP = By.xpath("//a[.='group page']");

    private final By FILL_DATA_FIRST_NAME = By.name("firstname");
    private final By FILL_DATA_LAST_NAME = By.name("lastname");
    private final By FILL_DATA_EMAIL = By.name("email");
    private final By FILL_DATA_ADDRESS = By.name("address");
    private final By FILL_DATA_PHONE = By.name("mobile");

    private final By FILL_GROUP_NAME = By.name("group_name");
    private final By FILL_GROUP_HEADER = By.name("group_header");
    private final By FILL_GROUP_FOOTER = By.name("group_footer");
}
