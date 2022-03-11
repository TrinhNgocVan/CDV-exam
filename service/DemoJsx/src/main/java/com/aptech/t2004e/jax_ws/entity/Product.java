package com.aptech.t2004e.jax_ws.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Product {
    private long id ;
    private String name ;
    private double price ;
    private int status ;
}
