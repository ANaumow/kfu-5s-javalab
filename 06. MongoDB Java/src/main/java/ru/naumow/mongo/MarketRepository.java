package ru.naumow.mongo;

import ru.naumow.domain.Market;

import java.util.List;

public interface MarketRepository {

    void save(Market market);

    List<Market> find(Integer rating, String status, Integer productCount);

    void delete(Market market);

    void update(Market market);

}
