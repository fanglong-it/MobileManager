package fa.training.mobilemanager.service;/*
 *
 *
 * Project ProductManager
 * Copyright (C) $year by Fanglong-it. All Rights Reserved.
 * For more information : Fang.longpc@gmail.com
 * Example project exist at : https://github.com/fanglong-it/
 * 10/22/21, 1:44 PM
 *
 *
 */

import fa.training.mobilemanager.entity.CartItem;

import java.util.Collection;

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

public interface ShoppingCartService {

    void add(CartItem item);

    void remove(int ProductId);

    Collection<CartItem> getCartItems();

    void clear();

    void update(int productId, int quantity);

    double getAmount();

    int getCount();

}
