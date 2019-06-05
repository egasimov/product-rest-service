package com.tutorialspoint;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
@Service //+includes @Component
public class ProductService {
     private HashMap<String , Product> products;
    {
        products=new HashMap<>();
        products.put("1",new Product("1","apple"));
        products.put("2",new Product("2","banana"));
        products.put("3",new Product("3","blackberry"));
    }

    Collection<Product> getAllProduct(){
        return products.values();
    }


    public void addProduct(Product product) {
        products.put(product.getId(),product);
    }

    public void updateProduct(String id, Product product) {
        products.remove(id);
        products.put(id,product);
    }

    public void deleteTopic(String id) {
        products.remove(id);
    }
}
