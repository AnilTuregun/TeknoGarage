package com.musu.model;

import javax.persistence.*;

/**
 * Created by User on 19.11.2016.
 */
@Entity
@Table(name = "productoptions", schema = "mydatabase", catalog = "")
public class ProductoptionsEntity {
    private int productOptionId;
    private Double optionPriceIncrement;
    private OptionsEntity optionsByOptionId;
    private OptiongroupsEntity optiongroupsByOptionGroupId;

    @Id
    @Column(name = "ProductOptionID")
    public int getProductOptionId() {
        return productOptionId;
    }

    public void setProductOptionId(int productOptionId) {
        this.productOptionId = productOptionId;
    }

    @Basic
    @Column(name = "OptionPriceIncrement")
    public Double getOptionPriceIncrement() {
        return optionPriceIncrement;
    }

    public void setOptionPriceIncrement(Double optionPriceIncrement) {
        this.optionPriceIncrement = optionPriceIncrement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductoptionsEntity that = (ProductoptionsEntity) o;

        if (productOptionId != that.productOptionId) return false;
        if (optionPriceIncrement != null ? !optionPriceIncrement.equals(that.optionPriceIncrement) : that.optionPriceIncrement != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productOptionId;
        result = 31 * result + (optionPriceIncrement != null ? optionPriceIncrement.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "OptionID", referencedColumnName = "OptionID", nullable = false)
    public OptionsEntity getOptionsByOptionId() {
        return optionsByOptionId;
    }

    public void setOptionsByOptionId(OptionsEntity optionsByOptionId) {
        this.optionsByOptionId = optionsByOptionId;
    }

    @ManyToOne
    @JoinColumn(name = "OptionGroupID", referencedColumnName = "OptionGroupID", nullable = false)
    public OptiongroupsEntity getOptiongroupsByOptionGroupId() {
        return optiongroupsByOptionGroupId;
    }

    public void setOptiongroupsByOptionGroupId(OptiongroupsEntity optiongroupsByOptionGroupId) {
        this.optiongroupsByOptionGroupId = optiongroupsByOptionGroupId;
    }
}
