package fa.training.mobilemanager.repository;

import fa.training.mobilemanager.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

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

public interface ProductCategoryRespository extends JpaRepository<ProductCategory, String> {
}
