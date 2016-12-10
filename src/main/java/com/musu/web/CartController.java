package com.musu.web;

        import com.musu.model.ProductcategoriesEntity;
        import com.musu.model.ProductsEntity;
        import com.musu.model.ShoppingCart;
        import com.musu.model.User;
        import com.musu.service.CartService;
        import com.musu.service.CategoryService;
        import com.musu.service.ProductService;
        import com.musu.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.context.SecurityContextHolder;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;

        import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/cart/{product}"})
    public String showhome(Model model, @PathVariable("product")String productname) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
          username = ((UserDetails)principal).getUsername();
        } else {
          username = principal.toString();
        }
        User user=userService.findByUsername(username);
        ProductsEntity product = productService.findByName(productname);
        List<ShoppingCart> shoppingCart1=cartService.findCartProductByProductId(username,product.getProductId());
        if(shoppingCart1.size()>0){
            int quantity=shoppingCart1.get(0).getQuantity();
     ShoppingCart sCart= shoppingCart1.get(0);
            quantity++;
            sCart.setQuantity(quantity);
     cartService.update(quantity,shoppingCart1.get(0).getId());
        }
        else{
            ShoppingCart shoppingCart=new ShoppingCart();
            shoppingCart.setProduct(product);
            shoppingCart.setUser(user);
            shoppingCart.setQuantity(1);
            cartService.save(shoppingCart);
        }

        List<ShoppingCart> shoppingCarts=cartService.findCartByUser(username);
        List<ProductcategoriesEntity> productCategoryEntitiyList = categoryService.findAll();
        model.addAttribute("category",productCategoryEntitiyList);
        model.addAttribute("shoppingCarts",shoppingCarts);
        return "cart";
    }
    @RequestMapping(value = {"/cart"})
    public String showCart(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        List<ShoppingCart> shoppingCarts=cartService.findCartByUser(username);
        List<ProductcategoriesEntity> productCategoryEntitiyList = categoryService.findAll();
        model.addAttribute("category",productCategoryEntitiyList);
        model.addAttribute("shoppingCarts",shoppingCarts);
        return "cart";
    }
}
