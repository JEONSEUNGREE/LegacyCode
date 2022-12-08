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
public class SuggestDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suggestDetailId;

    @OneToMany(mappedBy = "suggestDetailId")
    private List<SenarioMs> senarioMs = new ArrayList<>();

    @OneToMany(mappedBy = "suggestDetailId")
    List<Filter1> filter1 = new ArrayList<>();

    @OneToMany(mappedBy = "suggestDetailId")
    List<Filter2> filter2 = new ArrayList<>();

    @OneToMany(mappedBy = "suggestDetailId")
    List<Filter3> filter3 = new ArrayList<>();


    private String suggestId;

    private String typeCode;


}
