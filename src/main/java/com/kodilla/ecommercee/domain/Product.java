package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Setter
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product {

    private Long id;
    private List<Cart> carts = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private BigDecimal price = new BigDecimal(0);
    private String name;
    private String description;

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }
    @ManyToMany( mappedBy = "products")
    public List<Cart> getCarts() {
        return carts;
    }
    @ManyToMany( mappedBy = "products")
    public List<Order> getOrders() {
        return orders;
    }
    @Column(name="PRICE")
    public BigDecimal getPrice() {
        return price;
    }
    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    @Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }
}
