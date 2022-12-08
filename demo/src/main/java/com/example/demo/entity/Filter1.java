package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Filter1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filterOneId;

    private String suggestDetailId;

    private String filterName;

}
