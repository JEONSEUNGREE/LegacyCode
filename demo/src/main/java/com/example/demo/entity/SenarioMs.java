package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SenarioMs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suggestMsId;

    private String suggestNm;

    @OneToMany(mappedBy = "suggestMsId")
    List<SenarioDetail> senarioDetails = new ArrayList<>();

    private boolean abYn;

}
