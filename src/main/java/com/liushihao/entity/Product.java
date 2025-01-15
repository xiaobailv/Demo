package com.liushihao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 11092
 * @date 2024-12-29 13:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    private int id;
    private String name;
    private double price;
}
