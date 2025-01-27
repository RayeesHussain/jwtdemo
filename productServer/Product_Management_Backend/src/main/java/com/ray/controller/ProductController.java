package com.ray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ray.model.Product;
import com.ray.service.ProductService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class ProductController {
	@Autowired
	private ProductService service;
	@PostMapping("/saveProduct")
	public ResponseEntity<?> saveProduct(@RequestBody Product product){
		return new ResponseEntity<>(service.saveProduct(product),HttpStatus.CREATED);
		
		
	}
	@GetMapping("/")
	public ResponseEntity<?> getAllProduct(){
		return new ResponseEntity<>(service.getAllProduct(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Integer id){
		return new ResponseEntity<>(service.getProductById(id),HttpStatus.OK);
	}
	@GetMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
		
		return new ResponseEntity<>(service.deleteProduct(id),HttpStatus.OK);
		
	}
	@PostMapping("/editProduct/{id}")
	public ResponseEntity<?> editProduct(@RequestBody Product product,@PathVariable Integer id){
		return new ResponseEntity<>(service.editProduct(product,id),HttpStatus.CREATED);
	}

}
