package com.musu.service;

/**
 * Created by Ortayol on 2.01.2017.
 */
import com.musu.model.Slider;
import com.musu.repository.SliderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SliderServiceImpl implements SliderService {

    @Autowired
    private SliderRepository sliderRepository;
    @Override
    public  Slider findSliderById(int id){return sliderRepository.findSliderById(id);}
    @Override
    public void save(Slider slider) {
        sliderRepository.save(slider);
    }
    @Override
    public   List<Slider> findAll(){ return sliderRepository.findAll();}
    @Override
    public List<Slider> findActiveSlider() {
      return   sliderRepository.findActiveSliders();
    }

    @Override
    public void deleteSlider(int id){sliderRepository.deleteSlider(id);}
}
