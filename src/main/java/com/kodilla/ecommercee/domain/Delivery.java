package com.kodilla.ecommercee.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
@NoArgsConstructor
@Entity
@Table(name = "DELIVERYS")
public class Delivery {

    private Long id;
    private BigDecimal value = new BigDecimal(0);
    private Order order;

    public Delivery(BigDecimal value) {
        this.value = value;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "DELIVERY_ID", unique = true)
    public Long getId() {
        return id;
    }
    @Column(name = "DELIVERY_VALUE")
    public BigDecimal getValue() {
        return value;
    }
    @OneToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    public Order getOrder() {
        return order;
    }

}
