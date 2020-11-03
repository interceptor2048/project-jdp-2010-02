package com.kodilla.ecommercee.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id", nullable = true)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<Cart> carts = new ArrayList<>();

}