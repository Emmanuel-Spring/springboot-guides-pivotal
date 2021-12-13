package com.talentyco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String viewHomePage(Model modelo) {
        String keyword = "IPhone";
        List<Product> listProducts = productService.listAll(keyword);
        modelo.addAttribute("listProducts", listProducts);

        return "index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public  String showNewProductForm(Model modelo) {
        Product product = new Product();
        modelo.addAttribute("product", product);

        return "new_product";
    }

}
