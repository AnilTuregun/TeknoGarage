package com.musu.repository;

import com.musu.model.Slider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SliderRepository extends JpaRepository<Slider, Long>{

    @Query("select s from Slider s  where s.active=1")
    List<Slider> findActiveSliders();




}
