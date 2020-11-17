package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "USERS")
public class User {

    private Long id;

    private String username;
    private int status;
    private int userKey;
    private String postcode;
    private String town;
    private String street;
    private int houseNumber;
    private int apartmentNumber;
    private Cart cart;
    private List<Order> orders = new ArrayList<>();
    private List<Invoice> invoice = new ArrayList<>();

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    public Long getId(){
        return id;
    }


    @Column(name = "USERNAME")
    public String getUsername() { return username; }

    @Column(name = "STATUS")
    public int getStatus() { return status; }

    @Column(name = "USER_KEY")
    public int getUserKey() { return userKey; }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CART", referencedColumnName = "ID")
    public Cart getCart(){ return cart; }

    @OneToMany(targetEntity = Order.class, mappedBy = "user", fetch = FetchType.LAZY)
    public List<Order> getOrders() { return orders; }

    @OneToMany(targetEntity = Invoice.class, mappedBy = "user", fetch = FetchType.LAZY)
    @Column(name = "INVOICES")
    public List<Invoice> getInvoice() { return invoice; }

    @Column(name = "POSTCODE")
    public String getPostcode() { return postcode; }

    @Column(name = "TOWN")
    public String getTown() { return town; }

    @Column(name = "STREET")
    public String getStreet() { return street; }

    @Column(name = "HOUSE_NUMBER")
    public int getHouseNumber() { return houseNumber; }

    @Column(name = "APARTMENT_NUMBER")
    public int getApartmentNumber() { return apartmentNumber; }

    public User(String username) {
        this.username = username;
    }

}

