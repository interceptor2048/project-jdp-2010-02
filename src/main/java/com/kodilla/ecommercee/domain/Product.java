package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PRODUCTS")
public class Product {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Group groupId;
    private Order order;
    private Cart cart;
    private int amount;
    private BigDecimal sum;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull

    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    @Column(name = "PRODUCT_NAME")
    @NotNull
    public String getName() {
        return name;
    }

    @Column(name = "DESCRIPTION")
    @NotNull
    public String getDescription() {
        return description;
    }

    @Column(name = "PRICE")
    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    public Group getGroupId() {
        return groupId;
    }

    @ManyToOne
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {
        return cart;
    }

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    public Order getOrder() {
        return order;
    }

    @Column(name = "AMOUNT")
    public int getAmount() {
        return amount;
    }

    @Column(name = "TOTAL_VALUE_OF_PRODUCT")
    public BigDecimal getSum() {
        return sum;
    }

    public Product(String name, String description, BigDecimal price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.sum = getSum();
    }

}