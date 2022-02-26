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

    private final By MENU_PAGE_HOME = By.xpath("//a[.='home']");
    private final By MENU_PAGE_ADD_NEW = By.xpath("//a[.='add new']");
    private final By MENU_PAGE_GROUPS = By.xpath("//div[@id=\"nav\"]//a[.='groups']");

    private final By BUTTON_AUTHORIZATION_ENTER = By.xpath("//input[@type=\"submit\"]");

    private final By BUTTON_DATA_NEW_ENTER = By.xpath("//div[@id=\"content\"]//*[@type=\"submit\"][1]");
    private final By BUTTON_DATA_DELETE_ENTER = By.xpath("//input[@value=\"Delete\"]");
    private final By BUTTON_DATA_EDIT = By.xpath("//td[.='Ivanov']//..//img[@title=\"Edit\"]");
    private final By BUTTON_DATA_EDIT_ENTER = By.xpath("//input[@value=\"Update\"][1]");

    private final By CHECK_BOX_DATA = By.xpath("//input[@title=\"Select (Boris Ivanov)\"]");

    private final By BUTTON_GROUP_NEW = By.name("new");
    private final By BUTTON_GROUP_NEW_ENTER = By.name("submit");
    private final By BUTTON_GROUP_EDIT = By.name("edit");
    private final By BUTTON_GROUP_EDIT_ENTER = By.name("update");
    private final By BUTTON_GROUP_DELETE_ENTER = By.xpath("//*[@name=\"delete\"][1]");

    private final By CHECK_BOX_GROUP = By.xpath("//input[@title=\"Select (TestGroup)\"]");

    private final By BUTTON_PAGE_RETURN_GROUP = By.xpath("//a[.='group page']");

    private final By FILL_GROUP_NAME = By.name("group_name");
    private final By FILL_GROUP_HEADER = By.name("group_header");
    private final By FILL_GROUP_FOOTER = By.name("group_footer");

    public By getMENU_PAGE_HOME() {
        return MENU_PAGE_HOME;
    }
    public By getMENU_PAGE_ADD_NEW() {
        return MENU_PAGE_ADD_NEW;
    }
    public By getMENU_PAGE_GROUPS() {
        return MENU_PAGE_GROUPS;
    }

    public By getBUTTON_AUTHORIZATION_ENTER() {
        return BUTTON_AUTHORIZATION_ENTER;
    }

    public By getBUTTON_DATA_NEW_ENTER() {
        return BUTTON_DATA_NEW_ENTER;
    }
    public By getBUTTON_DATA_DELETE_ENTER() {
        return BUTTON_DATA_DELETE_ENTER;
    }
    public By getBUTTON_DATA_EDIT() {
        return BUTTON_DATA_EDIT;
    }
    public By getBUTTON_DATA_EDIT_ENTER() {
        return BUTTON_DATA_EDIT_ENTER;
    }
    public By getBUTTON_GROUP_DELETE_ENTER() {
        return BUTTON_GROUP_DELETE_ENTER;
    }

    public By getCHECK_BOX_GROUP() {
        return CHECK_BOX_GROUP;
    }

    public By getCHECK_BOX_DATA() {
        return CHECK_BOX_DATA;
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
