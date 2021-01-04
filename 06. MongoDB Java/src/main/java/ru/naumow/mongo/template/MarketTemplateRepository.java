package ru.naumow.mongo.template;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.naumow.domain.Market;
import ru.naumow.mongo.MarketRepository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class MarketTemplateRepository implements MarketRepository {

    @Autowired
    private MongoTemplate template;

    @Override
    public void save(Market market) {
        template.insert(market);
    }

    @Override
    public List<Market> find(Integer rating, String status, Integer productCount) {
        return template.find(
                new Query(where("rating").gt(rating)
                        .orOperator(
                                where("status").is(status),
                                where("products").size(productCount))), Market.class, "market");
    }

    @Override
    public void delete(Market market) {
        template.remove(market);
    }

    @Override
    public void update(Market market) {
        template.findAndReplace(new Query(where("_id").is(new ObjectId(market.get_id()))), market);
    }
}
