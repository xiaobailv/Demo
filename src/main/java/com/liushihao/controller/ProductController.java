package com.liushihao.controller;

import com.liushihao.entity.Product;
import com.liushihao.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 11092
 * @date 2024-12-29 13:50
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getProductById")
    public String getProductById(int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "show";
    }
}
