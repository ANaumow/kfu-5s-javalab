package ru.naumow.mongo.driver;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.stereotype.Repository;
import ru.naumow.domain.Market;
import ru.naumow.mongo.MarketRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;

@Repository
public class MarketDriverRepositoryImpl implements MarketRepository {

    private final MongoClient client;
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    @Autowired
    private MappingMongoConverter converter;

    public MarketDriverRepositoryImpl() {
        client = MongoClients.create();
        database = client.getDatabase("local");
        collection = database.getCollection("market");
    }

    @Override
    public void save(Market market) {
        Document document = new Document();
        converter.write(market, document);
        collection.insertOne(document);
    }

    @Override
    public List<Market> find(Integer rating, String status, Integer productCount) {
        Document searchQuery =
                new Document("rating", new Document("$gt", rating))
                .append("$or", Arrays.asList(
                        new Document("status", status),
                        new Document("products", new Document("$size", productCount))));

        FindIterable<Document> resultDocuments =
                collection.find(searchQuery)
                .projection(fields(include("address", "name", "products", "status", "rating")));

        List<Market> markets = new ArrayList<>();
        for (Document resultDocument : resultDocuments) {
            try {
                Market market = converter.read(Market.class, resultDocument);
                markets.add(market);
            } catch (Throwable e) {
                throw new IllegalArgumentException(e);
            }
        }
        return markets;
    }

    @Override
    public void delete(Market market) {
        Document document = new Document();
        converter.write(market, document);
        collection.findOneAndDelete(document);
    }

    @Override
    public void update(Market market) {
        Document selector = new Document("_id", new ObjectId(market.get_id()));
        Document changes = new Document();
        converter.write(market, changes);
        collection.updateOne(selector, changes);
    }
}
