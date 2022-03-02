package fa.training.mobilemanager.service;

import fa.training.mobilemanager.entity.ProductCategory;
import fa.training.mobilemanager.repository.ProductCategoryRespository;
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
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRespository repo;

    public List<ProductCategory> listCategory() {
        List<ProductCategory> listCate = repo.findAll();
        return listCate;
    }

    public ProductCategory getCategory(String categoryid) {
        ProductCategory category = repo.getById(categoryid);
        return category;
    }


}
