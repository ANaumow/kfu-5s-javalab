package ru.naumow.repositories;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;
import ru.naumow.domain.Address;
import ru.naumow.dto.MarketDto;
import ru.naumow.dto.MarketRequest;
import ru.naumow.domain.Market;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import static ru.naumow.domain.QMarket.market;

@Repository
public class MarketByRequestRepositoryImpl implements MarketByRequestRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MarketDto> findByRequest(MarketRequest marketRequest) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (marketRequest.getName() != null) {
            predicate.or(market.name.containsIgnoreCase(marketRequest.getName()));
        }

        Address address = marketRequest.getAddress();
        if (address != null) {
            String house = address.getHouse();
            String street = address.getStreet();
            String index = address.getIndex();

            if (house != null) {
                predicate.or(market.address().house.containsIgnoreCase(marketRequest.getAddress().getHouse()));
            }

            if (street != null) {
                predicate.or(market.address().street.containsIgnoreCase(marketRequest.getAddress().getStreet()));
            }

            if (index != null) {
                predicate.or(market.address().index.containsIgnoreCase(marketRequest.getAddress().getIndex()));
            }
        }

        return new JPAQuery<Market>(entityManager)
                .select(market.name, market.address())
                .from(market)
                .where(predicate)
                .fetch()
                .stream()
                .map(row -> MarketDto.builder()
                        .name(row.get(market.name))
                        .products(row.get(market.products))
                        .address(row.get(market.address()))
                        .build())
                .collect(Collectors.toList());

    }
}
