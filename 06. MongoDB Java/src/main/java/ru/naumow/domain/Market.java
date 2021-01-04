package ru.naumow.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "market")
public class Market {

    @Id
    private String _id;
    private Map<String, String> address;
    private String name;
    private String status;
    private Integer rating;
    @DBRef
    private List<Product> products;

}
