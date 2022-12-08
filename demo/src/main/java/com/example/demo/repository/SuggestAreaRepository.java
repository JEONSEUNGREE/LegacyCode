package com.example.demo.repository;

import com.example.demo.entity.SuggestArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SuggestAreaRepository extends JpaRepository<SuggestArea, Long> {

    @Query("SELECT S.suggestAreaId, S.suggestNm FROM SuggestArea S WHERE S.suggestAreaId = :areaCode")
    SuggestArea findAreaCode(Long areaCode);
}
