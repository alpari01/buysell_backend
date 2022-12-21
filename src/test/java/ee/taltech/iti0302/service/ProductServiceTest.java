package ee.taltech.iti0302.service;

import ee.taltech.iti0302.dto.ProductDto;
import ee.taltech.iti0302.mapper.ProductMapper;
import ee.taltech.iti0302.mapper.ProductMapperImpl;
import ee.taltech.iti0302.model.Product;
import ee.taltech.iti0302.repository.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Spy
    private ProductMapper productMapper = new ProductMapperImpl();

    @InjectMocks
    private ProductService productService;

    @Test
    void getProducts() {
        Product product1 = Product.builder().id(1).name("Milk").description("...").build();
        Product product2 = Product.builder().id(2).name("Milk").description("...").build();
        Product product3 = Product.builder().id(3).name("Milk").description("...").build();
        Product product4 = Product.builder().id(4).name("Milk").description("...").build();
        List<Product> products = new ArrayList<>(List.of(product1, product2, product3, product4));
        given(productRepository.findAll()).willReturn(products);

        // when
        var result = productService.getProducts();

        // then
        then(productMapper).should().toDtoList(products);
        then(productRepository).should().findAll();
        ProductDto productDto1 = ProductDto.builder().id(1).name("Milk").description("...").build();
        ProductDto productDto2 = ProductDto.builder().id(2).name("Milk").description("...").build();
        ProductDto productDto3 = ProductDto.builder().id(3).name("Milk").description("...").build();
        ProductDto productDto4 = ProductDto.builder().id(4).name("Milk").description("...").build();
        List<ProductDto> productDtos = new ArrayList<>(List.of(productDto1, productDto2, productDto3, productDto4));
        assertEquals(productDtos, result);
    }
}