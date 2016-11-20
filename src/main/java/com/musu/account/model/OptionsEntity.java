package com.musu.account.model;

import javax.persistence.*;

/**
 * Created by User on 19.11.2016.
 */
@Entity
@Table(name = "options", schema = "mydatabase", catalog = "")
public class OptionsEntity {
    private int optionId;
    private String optionName;
    private OptiongroupsEntity optiongroupsByOptionGroupId;

    @Id
    @Column(name = "OptionID")
    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    @Basic
    @Column(name = "OptionName")
    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OptionsEntity that = (OptionsEntity) o;

        if (optionId != that.optionId) return false;
        if (optionName != null ? !optionName.equals(that.optionName) : that.optionName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = optionId;
        result = 31 * result + (optionName != null ? optionName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "OptionGroupID", referencedColumnName = "OptionGroupID")
    public OptiongroupsEntity getOptiongroupsByOptionGroupId() {
        return optiongroupsByOptionGroupId;
    }

    public void setOptiongroupsByOptionGroupId(OptiongroupsEntity optiongroupsByOptionGroupId) {
        this.optiongroupsByOptionGroupId = optiongroupsByOptionGroupId;
    }
}
