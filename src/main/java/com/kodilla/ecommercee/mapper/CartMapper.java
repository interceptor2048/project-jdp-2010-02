package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {
    private ProductMapper productMapper;
    private OrderMapper orderMapper;

    @Autowired
    public CartMapper(OrderMapper orderMapper, ProductMapper productMapper) {
        this.orderMapper = orderMapper;
        this.productMapper = productMapper;
    }

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(cartDto.getId(),
                cartDto.getSum(),
                productMapper.mapToProductList(cartDto.getProducts()),
                orderMapper.mapToOrderList(cartDto.getOrders()),
                cartDto.getUser());
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(cart.getId(),
                cart.getSum(),
                productMapper.mapToProductDtoList(cart.getProducts()),
                orderMapper.mapToOrderDtoList(cart.getOrders()),
                cart.getUser());
    }

    public List<Cart> mapToCartList(final List<CartDto> carts) {
        return carts.stream()
                .map(c -> new Cart(c.getId(),
                        c.getSum(),
                        productMapper.mapToProductList(c.getProducts()),
                        orderMapper.mapToOrderList(c.getOrders()),
                        c.getUser()))
                .collect(Collectors.toList());
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> carts) {
        return carts.stream()
                .map(c -> new CartDto(c.getId(),
                        c.getSum(),
                        productMapper.mapToProductDtoList(c.getProducts()),
                        orderMapper.mapToOrderDtoList(c.getOrders()),
                        c.getUser()))
                .collect(Collectors.toList());
    }
}