package ee.taltech.iti0302.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TradeDto {

    private Integer id;
    private Integer buyerId;
    private Integer sellerId;
    private Integer productId;
    private LocalDate date;
}
