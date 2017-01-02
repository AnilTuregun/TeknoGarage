package com.musu.model;


import javax.persistence.*;

/**
 * Created by Ortayol on 2.01.2017.
 */
@Entity
@Table(name = "Slider", schema = "mydatabase")
public class Slider {

    private int SliderId;
    private String SliderImage;
    private String Link;
    private int Active;
    private String SliderName;



    @Id
    @Column(name = "SliderId")
    public int getSliderId() {
        return SliderId;
    }

    public void setSliderId(int sliderId) {
        SliderId = sliderId;
    }

    @Basic
    @Column(name = "SliderName")
    public String getSliderName() {
        return SliderName;
    }

    public void setSliderName(String sliderName) {
        SliderName = sliderName;
    }
@Basic
@Column(name = "SliderImage")
    public String getSliderImage() {
        return SliderImage;
    }

    public void setSliderImage(String sliderImage) {
        SliderImage = sliderImage;
    }
    @Basic
    @Column(name = "Link")
    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
    @Basic
    @Column(name = "Active")
    public int getActive() {
        return Active;
    }

    public void setActive(int active) {
        Active = active;
    }
}
