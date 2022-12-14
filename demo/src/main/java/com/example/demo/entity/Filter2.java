package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Filter2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filterOneId;

    private String suggestDetailId;

    private String filterName;
}
