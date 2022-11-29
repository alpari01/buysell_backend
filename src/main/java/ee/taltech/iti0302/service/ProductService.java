package ee.taltech.iti0302.service;

import ee.taltech.iti0302.dto.ProductDto;
import ee.taltech.iti0302.exception.ApplicationException;
import ee.taltech.iti0302.mapper.ProductMapper;
import ee.taltech.iti0302.model.Product;
import ee.taltech.iti0302.model.User;
import ee.taltech.iti0302.repository.ProductCriteriaRepository;
import ee.taltech.iti0302.repository.ProductFilter;
import ee.taltech.iti0302.repository.ProductRepository;
import ee.taltech.iti0302.repository.ProductResponse;
import ee.taltech.iti0302.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ProductMapper productMapper;
    private final ProductCriteriaRepository productCriteriaRepository;

    public List<ProductDto> getProducts() {
        return productMapper.toDtoList(productRepository.findAll());
    }

    public void addProduct(ProductDto productDto) {
        Product product = productMapper.dtoToEntity(productDto);
        productRepository.save(product);
    }

    public ProductResponse search(ProductFilter filter) {
        List<Product> productList = productCriteriaRepository.search(filter);
        Long count = productCriteriaRepository.searchCount(filter);
        return new ProductResponse(productMapper.toDtoList(productList), count);
    }

    public void deleteProductById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = optionalProduct.orElseThrow(() -> new ApplicationException("Product not found"));
        productRepository.deleteById(product.getId());
    }

    public void updateProductById(ProductDto productDto, Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) throw new ApplicationException("Product not found");
        Product product = productMapper.dtoToEntity(productDto);
        productRepository.save(product);
    }

    public List<ProductDto> getProductsByUserId(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.orElseThrow(() -> new ApplicationException("User not found"));
        return productMapper.toDtoList(user.getProducts());
    }
}
