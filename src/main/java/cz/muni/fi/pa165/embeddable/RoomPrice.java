package cz.muni.fi.pa165.embeddable;

import cz.muni.fi.pa165.entity.Room;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * @see Room
 * @author Ivo Hradek
 */
@Embeddable
public class RoomPrice {
    @Id
    @GeneratedValue
    private Long id;

    @Transient
    private Currency currency;

    @Column(nullable = false)
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
