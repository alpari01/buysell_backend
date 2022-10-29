package ee.taltech.iti0302.product;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductDto toDto(Product product);

    List<ProductDto> toDtoList(List<Product> products);
}
