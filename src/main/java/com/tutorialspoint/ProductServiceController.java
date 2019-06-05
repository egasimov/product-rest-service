package com.tutorialspoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Collection;
import java.util.HashMap;

@RestController
public class ProductServiceController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/product",method = RequestMethod.GET)
    ResponseEntity<Object> getAllProduct(){
        System.out.println("GET request accepted ");
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.BAD_GATEWAY);
    }

    @PostMapping(value = "/product")
    ResponseEntity<String> addProduct(@RequestBody Product product){
        System.out.println("POST REQUEST ACCEPTED");
        productService.addProduct(product);
        return new ResponseEntity<>("Product has been added succesfully",HttpStatus.CREATED);
    }

    @PutMapping(value = "/product/{id}")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product,@PathVariable("id") String id){
        System.out.println("PUT REQUEST ACCEPTED");
        productService.updateProduct(id , product);
        return new ResponseEntity<>("Updated",HttpStatus.OK);
    }
    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<String> deleteTopic(@PathVariable("id") String id){
        System.out.println("Delete Request accepted");
        productService.deleteTopic(id);
        return  new ResponseEntity<>("Product has been removed",HttpStatus.OK);
    }
}
