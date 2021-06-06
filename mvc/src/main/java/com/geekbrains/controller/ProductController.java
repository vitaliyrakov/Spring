package com.geekbrains.controller;

import com.geekbrains.model.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.geekbrains.model.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping()
    public String showProducts(Model model) {
        model.addAttribute("products", productRepository.getList());
        return "list";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productRepository.getById(id));
        return "show";
    }

    @GetMapping("/new")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new";
    }

    @PostMapping("/new")
    public String create(Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }

}