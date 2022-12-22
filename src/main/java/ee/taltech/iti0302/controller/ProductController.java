package ee.taltech.iti0302.controller;

import ee.taltech.iti0302.dto.ProductDto;
import ee.taltech.iti0302.repository.product.ProductFilter;
import ee.taltech.iti0302.repository.product.ProductResponse;
import ee.taltech.iti0302.repository.product.ProductTradeIdRequest;
import ee.taltech.iti0302.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/api/public/products")
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/api/public/product/{id}")
    public ProductDto getProductById(@PathVariable("id") Integer id) {
        return productService.getProductById(id);
    }

    @GetMapping("/api/public/products/{userId}")
    public List<ProductDto> getProductsByUserId(@PathVariable("userId") Integer id) {
        return productService.getProductsByUserId(id);
    }

    @PostMapping("/api/public/products")
    public void addProduct(@RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
    }

    @DeleteMapping("/api/public/products/{productId}")
    public void deleteProduct(@PathVariable("productId") Integer id) {
        productService.deleteProductById(id);
    }

    @PutMapping("/api/public/products/{productId}")
    public void updateProduct(@RequestBody ProductDto productDto, @PathVariable("productId") Integer id) {
        productService.updateProductById(productDto, id);
    }

    @GetMapping("/api/public/products2")
    public ProductResponse filterProducts(int page, String orderBy, String name) {
        ProductFilter filter = new ProductFilter(page, orderBy, name);
        return productService.filterProducts(filter);
    }

    @GetMapping("/api/public/products3")
    public List<ProductDto> paginateProducts(int page, String orderBy, Integer userId) {
        return productService.paginateProductsByUserId(page, orderBy, userId);
    }

    @GetMapping("/api/public/products4")
    public List<ProductDto> paginateProductsByTradeIdIsNotNull(int page, String orderBy) {
        return productService.paginateProductsByTradeIdIsNotNull(page, orderBy);
    }

    @PutMapping("/api/public/products2/{productId}")
    public void updateProductTradeId(@RequestBody ProductTradeIdRequest productTradeIdRequest, @PathVariable("productId") Integer id) {
        productService.updateProductTradeId(productTradeIdRequest, id);
    }
}
