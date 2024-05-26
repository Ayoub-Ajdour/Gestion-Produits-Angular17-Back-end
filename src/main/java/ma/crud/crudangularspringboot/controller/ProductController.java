package ma.crud.crudangularspringboot.controller;

import ma.crud.crudangularspringboot.exception.ProductNotFoundException;
import ma.crud.crudangularspringboot.model.Product;

import ma.crud.crudangularspringboot.model.test;
import ma.crud.crudangularspringboot.repesitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/products")
    public List<Product> getAllEmployers(){
        return productRepository.findAll();
    }

    @PostMapping("/products/add")
    public Product createProduct(@RequestBody Product product1) {
        System.out.println(product1.toString());
        product1.setId(null);
        productRepository.save(product1);
        return product1;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getEmployerById(@PathVariable Long id){
        Product product=productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product not exit with ID = "+id));
        return ResponseEntity.ok(product);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        // Retrieve the existing product from the database
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID = " + id));

        // Update the existing product with the new data
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setUrlImage(updatedProduct.getUrlImage());
        existingProduct.setPartType(updatedProduct.getPartType());
        existingProduct.setQuantity(updatedProduct.getQuantity());
        existingProduct.setQeerebyasali(updatedProduct.isQeerebyasali());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setUrlImagetanya(updatedProduct.getUrlImagetanya());
        existingProduct.setPromo(updatedProduct.isPromo());

        // Save the updated product to the database
        Product savedProduct = productRepository.save(existingProduct);

        // Return the updated product in the response
        return ResponseEntity.ok(savedProduct);
    }



    @DeleteMapping("/products/{id}")
    public ResponseEntity <Map<String,Boolean>> deleteEmployer(@PathVariable Long id){
        System.out.println("Deleted declared 👌👌👌👌");
        Product product1=productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product not exit with ID = "+id));
        productRepository.delete(product1);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



}
