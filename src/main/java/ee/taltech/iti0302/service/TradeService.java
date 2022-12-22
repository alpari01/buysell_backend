package ee.taltech.iti0302.service;

import ee.taltech.iti0302.dto.TradeDto;
import ee.taltech.iti0302.exception.ApplicationException;
import ee.taltech.iti0302.mapper.TradeMapper;
import ee.taltech.iti0302.model.Product;
import ee.taltech.iti0302.repository.product.ProductRepository;
import ee.taltech.iti0302.repository.trade.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static ee.taltech.iti0302.service.ProductService.EXCEPTION_PRODUCT_NOT_FOUND_MESSAGE;

@RequiredArgsConstructor
@Service
public class TradeService {

    private final TradeRepository tradeRepository;
    private final ProductRepository productRepository;
    private final TradeMapper tradeMapper;

    public List<TradeDto> getTrades() {
        return tradeMapper.toDtoList(tradeRepository.findAll());
    }

    public void addTrade(TradeDto tradeDto, Integer productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        Product product = productOptional.orElseThrow(() -> new ApplicationException(EXCEPTION_PRODUCT_NOT_FOUND_MESSAGE));
        tradeRepository.save(tradeMapper.dtoToEntity(tradeDto));
        product.setTradeId(tradeRepository.findTopByOrderByIdDesc().getId());
        productRepository.save(product);
    }
}
