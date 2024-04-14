package com.demo.restapi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.restapi.entity.Product;
import com.demo.restapi.reposiotry.ProductReposiotry;

@RestController
public class ProductController {
	@Autowired
	ProductReposiotry repo;
	
	@GetMapping("/product")
	public List<Product> getAllProducts(){
		List<Product>products = repo.findAll();
		return products;
	}
	
	 @GetMapping("/product/{id}")
	   public Product getProduct (@PathVariable int id) {
		   Product product =repo.findById(id).get();
		   
		   return product;
		   
	   }
	 
	 @PostMapping("/product/add")
	    @ResponseStatus(code = HttpStatus.CREATED)
	    public void createProduct(@RequestBody Product product) {
	    	repo.save(product);
	    	
	    }
	 
	 
	 @PutMapping("/product/update/{id}")
	    public Product updateCategory(@PathVariable int id) {
	        Product product = repo.findById(id).orElse(null);
	        if (product != null) {
	            product.setProduct_name("Lamp");
	            product.setPrice(650.0);
	            try {
	                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	                Date parsedDate = dateFormat.parse("2024-04-14");
	                product.setMfg_date(parsedDate);
	            } catch (ParseException e) {
	                e.printStackTrace();
	                
	            }
	            product.setProduct_type("show piss");
	            repo.save(product);
	        }
	        return product;
	         
	    }
	 
	 @DeleteMapping("/product/delete/{id}")
		public void removeCategory(@PathVariable int id) {
			Product product = repo.findById(id).get();
			repo.delete(product);
		}

	 

}
