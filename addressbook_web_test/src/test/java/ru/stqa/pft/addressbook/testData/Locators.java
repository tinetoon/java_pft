package ru.stqa.pft.addressbook.testData;

import org.openqa.selenium.By;

/**
 * Базовый класс локаторов на страницах БД
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания - 25.02.2022
 */

public class Locators {


    private final By LC_1 = By.name("");
    private final By LC_2 = By.xpath("");

    private final By MENU_GROUP_PAGE = By.xpath("//div[@id=\"nav\"]//a[.='groups']");

    private final By BUTTON_GROUP_NEW = By.name("new");
    private final By BUTTON_GROUP_NEW_ENTER = By.name("submit");
    private final By BUTTON_GROUP_EDIT = By.name("edit");
    private final By BUTTON_GROUP_EDIT_ENTER = By.name("update");

    private final By BUTTON_PAGE_RETURN_GROUP = By.xpath("//a[.='group page']");

    private final By FILL_GROUP_NAME = By.name("group_name");
    private final By FILL_GROUP_HEADER = By.name("group_header");
    private final By FILL_GROUP_FOOTER = By.name("group_footer");

    public By getMENU_GROUP_PAGE() {
        return MENU_GROUP_PAGE;
    }

    public By getBUTTON_GROUP_NEW() {
        return BUTTON_GROUP_NEW;
    }
    public By getBUTTON_GROUP_NEW_ENTER() {
        return BUTTON_GROUP_NEW_ENTER;
    }
    public By getBUTTON_GROUP_EDIT() {
        return BUTTON_GROUP_EDIT;
    }
    public By getBUTTON_GROUP_EDIT_ENTER() {
        return BUTTON_GROUP_EDIT_ENTER;
    }
    public By getBUTTON_PAGE_RETURN_GROUP() {
        return BUTTON_PAGE_RETURN_GROUP;
    }

    public By getFILL_GROUP_NAME() {
        return FILL_GROUP_NAME;
    }
    public By getFILL_GROUP_HEADER() {
        return FILL_GROUP_HEADER;
    }
    public By getFILL_GROUP_FOOTER() {
        return FILL_GROUP_FOOTER;
    }
}
