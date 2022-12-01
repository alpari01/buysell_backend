package ee.taltech.iti0302.service;

import ee.taltech.iti0302.dto.TradeDto;
import ee.taltech.iti0302.mapper.TradeMapper;
import ee.taltech.iti0302.model.Trade;
import ee.taltech.iti0302.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TradeService {

    private final TradeRepository tradeRepository;
    private final TradeMapper tradeMapper;

    public List<TradeDto> getTrades() {
        System.out.println("trade mapper");
        return tradeMapper.toDtoList(tradeRepository.findAll());
    }

    public void addTrade(TradeDto tradeDto) {
        tradeRepository.save(tradeMapper.dtoToEntity(tradeDto));
    }
}
