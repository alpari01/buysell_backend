package ee.taltech.iti0302.repository;

import ee.taltech.iti0302.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ProductResponse {
    private List<ProductDto> productList;
    private Long count;
}
