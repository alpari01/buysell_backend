package ee.taltech.iti0302.controller;

import ee.taltech.iti0302.dto.TradeDto;
import ee.taltech.iti0302.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TradeController {

    private final TradeService tradeService;

    @GetMapping("/api/trades")
    public List<TradeDto> getTrades() {
        return tradeService.getTrades();
    }

    @PostMapping("/api/trades")
    public void addTrade(@RequestBody TradeDto tradeDto) {
        tradeService.addTrade(tradeDto);
    }
}
