package com.musu.service;

/**
 * Created by Ortayol on 2.01.2017.
 */
import com.musu.model.Slider;

import java.util.List;


public interface SliderService {
    void save (Slider slider);
    List<Slider> findActiveSlider();


}
