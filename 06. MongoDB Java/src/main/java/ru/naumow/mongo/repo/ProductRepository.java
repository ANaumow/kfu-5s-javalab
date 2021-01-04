package ru.naumow.mongo.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.naumow.domain.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {
}
