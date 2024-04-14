package com.demo.restapi.reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.restapi.entity.Product;


public interface ProductReposiotry extends JpaRepository<Product, Integer> {

}



