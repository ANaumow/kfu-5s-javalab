package ru.naumow.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "market")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Market implements Serializable {
    @Id
    private String _id;
    private String name;
    private List<String> products;
    private Address address;
}
