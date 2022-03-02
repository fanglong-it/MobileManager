package fa.training.mobilemanager.controller;/*
 *
 *
 * Project ProductManager
 * Copyright (C) $year by Fanglong-it. All Rights Reserved.
 * For more information : Fang.longpc@gmail.com
 * Example project exist at : https://github.com/fanglong-it/
 * 10/22/21, 1:58 PM
 *
 *
 */

import fa.training.mobilemanager.entity.CartItem;
import fa.training.mobilemanager.entity.Product;
import fa.training.mobilemanager.service.ProductService;
import fa.training.mobilemanager.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

@Controller
@RequestMapping("shoppingCart")
public class ShoppingCartController {

    @Autowired
    ProductService productService;

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("cart")
    public String list(Model model) {
        Collection<CartItem> cartItems = shoppingCartService.getCartItems();
        model.addAttribute("CART_ITEMS", cartItems);
        model.addAttribute("TOTAL", shoppingCartService.getAmount());
        model.addAttribute("NO_OF_ITEMS", shoppingCartService.getCount());

        return "shoppingCarts/cart";
    }

    @GetMapping("add/{id}")
    public String add(@PathVariable(name = "id") Integer productId) {
        Product product = productService.getByProductId(productId);
        if (product != null) {
            CartItem item = new CartItem(product.getProductid(), product.getProductname(),
                    product.getProductprice(), 1, product.getCategoryid(), product.getImage());
            item.setQuantity(1);
            shoppingCartService.add(item);
        }
        return "redirect:/shoppingCart/cart";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable(name = "id") Integer productid) {
        shoppingCartService.remove(productid);
        return "redirect:/shoppingCart/cart";
    }

    @PostMapping("update")
    public String update(@RequestParam("productId") Integer productId,
                         @RequestParam("quantity") Integer quantity) {

        shoppingCartService.update(productId, quantity);

        return "redirect:/shoppingCart/cart";
    }

    @GetMapping("clear")
    public String clear() {
        shoppingCartService.clear();
        return "redirect:/shoppingCart/cart";

    }

}
