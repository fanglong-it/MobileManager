package fa.training.mobilemanager.controller;

import fa.training.mobilemanager.entity.Product;
import fa.training.mobilemanager.entity.ProductCategory;
import fa.training.mobilemanager.service.ProductCategoryService;
import fa.training.mobilemanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

/*
 *
 *
 * Project ProductManager
 * Copyright (C) $year by Fanglong-it. All Rights Reserved.
 * For more information : Fang.longpc@gmail.com
 * Example project exist at : https://github.com/fanglong-it/
 * 10/23/21, 7:29 PM
 *
 *
 */

@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    ServletContext application;

    @RequestMapping("/")
    public String home(Model model) {
        List<Product> listPro = service.listAll();
        model.addAttribute("LIST_PRODUCT", listPro);
        return "home";
    }

    @RequestMapping("/homePage")
    public String homePage(Model model) {
        List<Product> listPro = service.listAll();
        model.addAttribute("LIST_PRODUCT", listPro);
        return "home";
    }

    @RequestMapping("/view_details/{id}")
    public ModelAndView viewDetails(@PathVariable(name = "id") int id, Model model) {
        ModelAndView modelAndView = new ModelAndView("productDetail");
        Product product = service.getByProductId(id);

        ProductCategory cate = productCategoryService.getCategory(product.getCategoryid());

        model.addAttribute("CATE_NAME", cate.getCategoryname());
        modelAndView.addObject("PRODUCT_DETAIL", product);
        return modelAndView;
    }

    @GetMapping("/insert_page")
    public String insertProductPage(Model model) {
        Product product = new Product();
        List<ProductCategory> listCate = productCategoryService.listCategory();
        model.addAttribute("LIST_CATE", listCate);
        model.addAttribute("PRODUCT", product);
        return "addProduct";
    }


    @PostMapping("/save")
    public String insertProduct(@ModelAttribute("PRODUCT") Product product, @RequestParam("photoUrl") MultipartFile photo,
                                ModelMap model) {


        Path path = Paths.get("uploads/");

        try {
            InputStream inputStream = photo.getInputStream();
            Files.copy(inputStream, path.resolve(photo.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            product.setImage(photo.getOriginalFilename().toLowerCase());

        } catch (Exception e) {

        }

        service.saveProduct(product);
        return "redirect:/homePage";
    }


}
