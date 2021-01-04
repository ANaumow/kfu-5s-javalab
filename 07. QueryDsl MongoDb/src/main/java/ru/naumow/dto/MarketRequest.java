package ru.naumow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.naumow.domain.Address;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarketRequest {
    private String name;
    private Address address;
    private List<String> products;
}
