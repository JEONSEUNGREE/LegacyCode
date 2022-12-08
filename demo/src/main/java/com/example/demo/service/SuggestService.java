package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface SuggestService {

    List<Product> getSuggestProduct(Long areaCode);
}
