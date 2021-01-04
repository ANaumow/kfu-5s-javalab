package ru.naumow.controllers;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.naumow.dto.MarketDto;
import ru.naumow.domain.Market;
import ru.naumow.repositories.MarketRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class MarketSearchController {

    @Autowired
    private MarketRepository marketRepository;

    @GetMapping("/markets/search")
    public ResponseEntity<List<MarketDto>> searchByPredicate(
            @QuerydslPredicate(root = Market.class, bindings = MarketRepository.class) Predicate predicate
    ) {
        Iterable<Market> found = marketRepository.findAll(predicate);
        List<MarketDto> body = StreamSupport.stream(found.spliterator(), true)
                .map(market -> MarketDto.builder()
                        .name(market.getName())
                        .products(market.getProducts())
                        .address(market.getAddress())
                        .build())
                .collect(Collectors.toList());
        return ResponseEntity.ok(body);
    }

}
