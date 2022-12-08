package com.example.demo.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SuggestArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suggestAreaId;

    @OneToMany(mappedBy = "suggestId")
    private List<SuggestDetail> suggestDetails = new ArrayList<>();

    private String suggestNm;
}
