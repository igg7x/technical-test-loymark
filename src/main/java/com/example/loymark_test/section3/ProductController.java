package com.example.loymark_test.section3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String listOfProducts(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "product-list";
    }

    @PostMapping("/products/add")
    public String addProduct(@RequestParam String name, @RequestParam Double price, @RequestParam String description,
            Model model) {
        productService.addProduct(new Product(name, price, description));
        model.addAttribute("products", productService.getProducts());
        return "redirect:/products";
    }

}
