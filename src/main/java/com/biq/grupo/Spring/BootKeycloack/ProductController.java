package com.biq.grupo.Spring.BootKeycloack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller

class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index()
    {
        return "index";
    }

   @GetMapping("/products")
    public String getProducts(Model model){
        model.addAttribute("products", productService.getProducts());
        return "product";
    }

    // @PreAuthorize("hasAnyAuthority('manager','admin')")
    @GetMapping("/ventes")
    public String vente()
    {
        return "ventes";
    }

  //  @PreAuthorize("hasAnyAuthority('admin')")
    @GetMapping("/admin")
    public String admin()
    {
        return "admin";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "/";
    }
}