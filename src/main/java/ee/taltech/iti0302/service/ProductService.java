package ee.taltech.iti0302.service;

import ee.taltech.iti0302.dto.ProductDto;
import ee.taltech.iti0302.exception.ApplicationException;
import ee.taltech.iti0302.mapper.ProductMapper;
import ee.taltech.iti0302.model.Image;
import ee.taltech.iti0302.model.Product;
import ee.taltech.iti0302.model.ProductCategory;
import ee.taltech.iti0302.model.User;
import ee.taltech.iti0302.repository.image.ImageRepository;
import ee.taltech.iti0302.repository.product.ProductCategoryRepository;
import ee.taltech.iti0302.repository.product.ProductCriteriaRepository;
import ee.taltech.iti0302.repository.product.ProductFilter;
import ee.taltech.iti0302.repository.product.ProductRepository;
import ee.taltech.iti0302.repository.product.ProductResponse;
import ee.taltech.iti0302.repository.product.ProductTradeIdRequest;
import ee.taltech.iti0302.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static ee.taltech.iti0302.repository.product.ProductCriteriaRepository.PAGE_SIZE;
import static ee.taltech.iti0302.service.UserService.EXCEPTION_USER_NOT_FOUND_MESSAGE;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductMapper productMapper;
    private final ProductCriteriaRepository productCriteriaRepository;
    public static final String EXCEPTION_PRODUCT_NOT_FOUND_MESSAGE = "Product not found";
    public static final String EXCEPTION_PRODUCT_CATEGORY_NOT_FOUND_MESSAGE = "Product category not found";

    public List<ProductDto> getProducts() {
        return productMapper.toDtoList(productRepository.findAll());
    }

    public ProductDto getProductById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = optionalProduct.orElseThrow(() -> new ApplicationException(EXCEPTION_PRODUCT_NOT_FOUND_MESSAGE));
        return productMapper.entityToDto(product);
    }

    public void addProduct(ProductDto productDto) {
        Product product = productMapper.dtoToEntity(productDto);
        Optional<ProductCategory> optionalProductCategory = productCategoryRepository.findProductCategoryByName(productDto.getCategoryName());
        ProductCategory productCategory = optionalProductCategory.orElseThrow(() -> new ApplicationException(EXCEPTION_PRODUCT_CATEGORY_NOT_FOUND_MESSAGE));
        product.setCategoryId(productCategory.getId());

        Image image = imageRepository.findTopByOrderByIdDesc();
        product.setImageId(image.getId());

        productRepository.save(product);
    }

    public List<ProductDto> getProductsByUserId(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.orElseThrow(() -> new ApplicationException(EXCEPTION_USER_NOT_FOUND_MESSAGE));
        return productMapper.toDtoList(user.getProducts());
    }

    public List<ProductDto> paginateProductsByUserId(int page, String orderBy, Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.orElseThrow(() -> new ApplicationException(EXCEPTION_USER_NOT_FOUND_MESSAGE));
        Sort sort = Sort.by(orderBy).ascending();
        Pageable pageRequest = PageRequest.of(page, PAGE_SIZE, sort);
        List<Product> products = productRepository.findAllByUserId(user.getId(), pageRequest);
        return productMapper.toDtoList(products);
    }

    public ProductResponse filterProducts(ProductFilter filter) {
        List<Product> productList = productCriteriaRepository.search(filter);
        Long count = productCriteriaRepository.searchCount(filter);
        return new ProductResponse(productMapper.toDtoList(productList), count);
    }

    public void deleteProductById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = optionalProduct.orElseThrow(() -> new ApplicationException(EXCEPTION_PRODUCT_NOT_FOUND_MESSAGE));
        productRepository.deleteById(product.getId());
    }

    public void updateProductById(ProductDto productDto, Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) throw new ApplicationException(EXCEPTION_PRODUCT_NOT_FOUND_MESSAGE);
        Product product = productMapper.dtoToEntity(productDto);
        Optional<ProductCategory> optionalProductCategory = productCategoryRepository.findProductCategoryByName(productDto.getCategoryName());
        ProductCategory productCategory = optionalProductCategory.orElseThrow(() -> new ApplicationException(EXCEPTION_PRODUCT_CATEGORY_NOT_FOUND_MESSAGE));
        product.setCategoryId(productCategory.getId());
        productRepository.save(product);
    }

    public void updateProductTradeId (ProductTradeIdRequest productTradeIdRequest, Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = optionalProduct.orElseThrow(() -> new ApplicationException(EXCEPTION_PRODUCT_NOT_FOUND_MESSAGE));
        product.setTradeId(productTradeIdRequest.getTradeId());
        System.out.println(product);
        productRepository.save(product);
    }

    public List<ProductDto> paginateProductsByTradeIdIsNotNull(int page, String orderBy) {
        Sort sort = Sort.by(orderBy).ascending();
        Pageable pageRequest = PageRequest.of(page, PAGE_SIZE, sort);
        List<Product> products = productRepository.findAllByTradeIdIsNull(pageRequest);
        return productMapper.toDtoList(products);
    }
}
