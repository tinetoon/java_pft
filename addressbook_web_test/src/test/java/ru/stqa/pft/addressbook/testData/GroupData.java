package ru.stqa.pft.addressbook.testData;

public class GroupData {
    private final String nameGroup;
    private final String headerGroup;
    private final String footerGroup;

    public GroupData(String nameGroup, String headerGroup, String footerGroup) {
        this.nameGroup = nameGroup;
        this.headerGroup = headerGroup;
        this.footerGroup = footerGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public String getHeaderGroup() {
        return headerGroup;
    }

    public String getFooterGroup() {
        return footerGroup;
    }
}
