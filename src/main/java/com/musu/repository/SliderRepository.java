package com.musu.repository;

import com.musu.model.Slider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SliderRepository extends JpaRepository<Slider, Long>{

    @Query("select s from Slider s  where s.active=1")
    List<Slider> findActiveSliders();

    @Query("select s from Slider s where s.sliderId=?1")
    Slider findSliderById(int id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Slider s WHERE s.sliderId = ?1")
    int deleteSlider(int id);

}
