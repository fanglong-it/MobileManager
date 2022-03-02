package fa.training.mobilemanager.service.impl;/*
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
import fa.training.mobilemanager.entity.Product;
import fa.training.mobilemanager.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private Map<Integer, CartItem> map = new HashMap<>();

    @Override
    public void add(CartItem item) {

        CartItem existItem = map.get(item.getProductid());
        if (existItem != null) {
            existItem.setQuantity(item.getQuantity() + existItem.getQuantity());

        } else {
            map.put(item.getProductid(), item);
        }
    }

    @Override
    public void remove(int ProductId) {
        map.remove(ProductId);
    }

    @Override
    public Collection<CartItem> getCartItems() {
        return map.values();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public void update(int productId, int quantity) {
        CartItem item = map.get(productId);
        item.setQuantity(quantity);
        if (item.getQuantity() <= 0) {
            map.remove(productId);
        }
    }

    @Override
    public double getAmount() {
        return map.values().stream().mapToDouble(item -> item.getQuantity() * item.getProductprice()).sum();
    }

    @Override
    public int getCount() {
        if (map.isEmpty()) {
            return 0;
        }
        return map.values().size();
    }


}
