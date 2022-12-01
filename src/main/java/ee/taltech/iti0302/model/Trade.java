package ee.taltech.iti0302.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter
@Entity
@Table(name="trade")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "buyer_id")
    private Integer buyerId;

    @Column(name = "seller_id")
    private Integer sellerId;

    @Column(name = "product_id")
    private Integer productId;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "buyer_id", insertable=false, updatable=false)
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "seller_id", insertable=false, updatable=false)
    private User seller;

    @OneToOne
    @JoinColumn(name = "product_id", insertable=false, updatable=false)
    private Product product;
}
