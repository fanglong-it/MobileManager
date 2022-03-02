package fa.training.mobilemanager.service;

import fa.training.mobilemanager.entity.Product;
import fa.training.mobilemanager.repository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class ProductService {
    @Autowired
    private ProductRespository repo;

    public List<Product> listAll() {
        return repo.findAll();
    }


    public Product getByProductId(int id) {
        return repo.getById(id);
    }


    public void saveProduct(Product product) {
        repo.save(product);
    }

}
