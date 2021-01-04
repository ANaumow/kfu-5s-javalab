package ru.naumow.repositories;

import ru.naumow.dto.MarketDto;
import ru.naumow.dto.MarketRequest;

import java.util.List;

public interface MarketByRequestRepository {
    List<MarketDto> findByRequest(MarketRequest marketRequest);
}
