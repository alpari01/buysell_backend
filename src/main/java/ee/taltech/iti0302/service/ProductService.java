package ee.taltech.iti0302.service;

import ee.taltech.iti0302.dto.ProductDto;
import ee.taltech.iti0302.mapper.ProductMapper;
import ee.taltech.iti0302.models.Product;
import ee.taltech.iti0302.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDto> getProducts() {
        return productMapper.toDtoList(productRepository.findAll());
    }

    public void addProduct(ProductDto productDto) {
        try {
            Product product = new Product();
            product.setUserId(productDto.getUserId());
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            productRepository.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
