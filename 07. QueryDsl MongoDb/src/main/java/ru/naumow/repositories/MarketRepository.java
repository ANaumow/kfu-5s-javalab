package ru.naumow.repositories;

import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import ru.naumow.domain.Market;
import ru.naumow.domain.QMarket;

public interface MarketRepository extends MongoRepository<Market, String>, QuerydslPredicateExecutor<Market>, QuerydslBinderCustomizer<QMarket> {
    @Override
    default void customize(QuerydslBindings bindings, QMarket qMarket) {
        bindings.bind(qMarket.name)
                .first(StringExpression::containsIgnoreCase);
    }
}
