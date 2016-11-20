package com.musu.account.model;

import javax.persistence.*;

/**
 * Created by User on 19.11.2016.
 */
@Entity
@Table(name = "optiongroups", schema = "mydatabase", catalog = "")
public class OptiongroupsEntity {
    private int optionGroupId;
    private String optionGroupName;

    @Id
    @Column(name = "OptionGroupID")
    public int getOptionGroupId() {
        return optionGroupId;
    }

    public void setOptionGroupId(int optionGroupId) {
        this.optionGroupId = optionGroupId;
    }

    @Basic
    @Column(name = "OptionGroupName")
    public String getOptionGroupName() {
        return optionGroupName;
    }

    public void setOptionGroupName(String optionGroupName) {
        this.optionGroupName = optionGroupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OptiongroupsEntity that = (OptiongroupsEntity) o;

        if (optionGroupId != that.optionGroupId) return false;
        if (optionGroupName != null ? !optionGroupName.equals(that.optionGroupName) : that.optionGroupName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = optionGroupId;
        result = 31 * result + (optionGroupName != null ? optionGroupName.hashCode() : 0);
        return result;
    }
}
