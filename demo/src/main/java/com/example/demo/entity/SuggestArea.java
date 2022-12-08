package com.example.demo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SuggestArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suggestAreaId;

    @OneToMany(mappedBy = "suggestId")
    private List<SuggestDetail> suggestDetails = new ArrayList<>();

    private String suggestNm;

    private boolean abYn;
}
