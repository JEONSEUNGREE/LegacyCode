package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class SuggestServiceImpl implements SuggestService {

    private ProductRepository productRepository;

    private SuggestAreaRepository suggestAreaRepository;

    private SenarioMsRepository senarioMsRepository;

    private SuggestDetailRepository suggestDetailRepository;

    private Filter1Repository filter1Repository;

    private Filter2Repository filter2Repository;

    private Filter3Repository filter3Repository;

    public SuggestServiceImpl(ProductRepository productRepository, SuggestAreaRepository suggestAreaRepository,
                              SenarioMsRepository senarioMsRepository, SuggestDetailRepository suggestDetailRepository,
                              Filter1Repository filter1Repository, Filter2Repository filter2Repository,
                              Filter3Repository filter3Repository)
    {
        this.productRepository = productRepository;
        this.suggestAreaRepository = suggestAreaRepository;
        this.senarioMsRepository = senarioMsRepository;
        this.suggestDetailRepository = suggestDetailRepository;
        this.filter1Repository = filter1Repository;
        this.filter2Repository = filter2Repository;
        this.filter3Repository = filter3Repository;
    }

    @Override
    public List<Product> getSuggestProduct(Long areaCode) {
        List<Filter1> filter1 = new ArrayList<>();
        List<Filter2> filter2 = new ArrayList<>();
        List<Filter3> filter3 = new ArrayList<>();

        // 개인화 상품 조회
        SuggestArea suggest = suggestAreaRepository.findAreaCode(areaCode);

        // 개인화 상품 상세 조회 타입 A,B,C
        if (suggest != null) {
            List<SuggestDetail> suggestDetails = suggest.getSuggestDetails();
            // A,B 사용시
            if (!suggestDetails.isEmpty() && suggest.isAbYn()) {
                suggestDetails.removeIf(item -> "D".equals(item.getTypeCode()));
            }
            // A,B 미사용시
            if (!suggestDetails.isEmpty() && !suggest.isAbYn()) {
                suggestDetails.removeIf(item -> "A".equals(item.getTypeCode()) || "B".equals(item.getTypeCode()));
            }
            // 시나리오 상세 조회
            for (SuggestDetail item : suggestDetails) {
                // 필터 등록
                if (filter1.size() > 1) {
                    filter1.addAll(item.getFilter1());
                } else {
                    filter1 = item.getFilter1();
                }
                if (filter2.size() > 1) {
                    filter2.addAll(item.getFilter2());
                } else {
                    filter2 = item.getFilter2();
                }
                if (filter3.size() > 1) {
                    filter3.addAll(item.getFilter3());
                } else {
                    filter3 = item.getFilter3();
                }
            }

        }

        return null;
    }
}
