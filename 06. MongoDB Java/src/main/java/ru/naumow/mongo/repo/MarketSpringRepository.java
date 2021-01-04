package ru.naumow.mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.naumow.domain.Market;

import java.util.List;

public interface MarketSpringRepository extends MongoRepository<Market, String> {

    @RestResource(path = "specified", rel = "specified")
    @Query(value = "{ rating: { $gt: ?0 }, $or: [{status: ?1}, {products: { $size: ?2 }}] }")
    List<Market> find(@Param("rating") Integer rating, @Param("status") String status, @Param("count") int productCount);

}
