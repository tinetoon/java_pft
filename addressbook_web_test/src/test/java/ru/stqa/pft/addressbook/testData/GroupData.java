package ru.stqa.pft.addressbook.testData;

import lombok.Data;

@Data
public class GroupData {

    private int id;
    private final String nameGroup;
    private final String headerGroup;
    private final String footerGroup;

    public GroupData(String nameGroup) {
        this.id = 0;
        this.nameGroup = nameGroup;
        this.headerGroup = null;
        this.footerGroup = null;
    }

    public GroupData(int id, String nameGroup) {
        this.id = id;
        this.nameGroup = nameGroup;
        this.headerGroup = null;
        this.footerGroup = null;
    }

    public GroupData(String nameGroup, String headerGroup, String footerGroup) {
        this.id = 0;
        this.nameGroup = nameGroup;
        this.headerGroup = headerGroup;
        this.footerGroup = footerGroup;
    }

    public GroupData(int id, String nameGroup, String headerGroup, String footerGroup) {
        this.id = id;
        this.nameGroup = nameGroup;
        this.headerGroup = headerGroup;
        this.footerGroup = footerGroup;
    }

    /*public String getNameGroup() {
        return nameGroup;
    }

    public String getHeaderGroup() {
        return headerGroup;
    }

    public String getFooterGroup() {
        return footerGroup;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "nameGroup='" + nameGroup + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(nameGroup, groupData.nameGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameGroup);
    }*/
}
