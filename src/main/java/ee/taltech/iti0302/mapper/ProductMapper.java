package ee.taltech.iti0302.mapper;

import ee.taltech.iti0302.dto.ProductDto;
import ee.taltech.iti0302.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductDto entityToDto(Product product);
    Product dtoToEntity(ProductDto productDto);

    List<ProductDto> toDtoList(List<Product> products);
}
