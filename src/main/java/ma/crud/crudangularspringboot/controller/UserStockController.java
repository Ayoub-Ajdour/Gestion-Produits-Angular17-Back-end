package ma.crud.crudangularspringboot.controller;

import ma.crud.crudangularspringboot.exception.ProductNotFoundException;
import ma.crud.crudangularspringboot.model.Product;
import ma.crud.crudangularspringboot.model.UserStock;
import ma.crud.crudangularspringboot.repesitory.UserStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class UserStockController {
    @Autowired
    private UserStockRepository userStockRepository;

    @GetMapping("/carts")
    public List<UserStock> getAllCarts() {
        return userStockRepository.findAll();
    }

    @DeleteMapping("/deletebyproduct/{productId}")
    public ResponseEntity<Void> deleteCartByProductId(@PathVariable Long productId) {
        userStockRepository.deleteByProductId(productId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/carts/add")
    public UserStock addUserStock(@RequestBody UserStock userStock) {
        System.out.println("hiiii 💚💚💚" + userStock.toString());
        userStock.setId(null);
        userStockRepository.save(userStock);
        return userStock;
    }

    @GetMapping("/carts/findbyproduct/{productId}/{userId}")
    public ResponseEntity<UserStock> checkProductExistence(@PathVariable Long productId, @PathVariable Long userId) {
        List<UserStock> userStockList = userStockRepository.findByProductIdAndUserId(productId, userId);
        if (!userStockList.isEmpty()) {
            UserStock userStock = userStockList.get(0); // Assuming only one entry for a given product and user
            userStock.setQuantity(userStock.getQuantity() + 1); // Increment quantity by 1
            UserStock savedUserStock = userStockRepository.save(userStock); // Save the updated UserStock
            return ResponseEntity.ok(savedUserStock);
        } else {
            // UserStock not found, create a new one with quantity = 1
            UserStock newUserStock = new UserStock(userId, productId, 1); // Set initial quantity to 1
            UserStock savedUserStock = userStockRepository.save(newUserStock); // Save the new UserStock
            return ResponseEntity.ok(savedUserStock);
        }
    }

    @PutMapping("/userstock/update/{id}")
    public ResponseEntity<UserStock> updateUserStockQuantity(@PathVariable Long id, @RequestBody UserStock updatedUserStock) {
        UserStock existingUserStock = userStockRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("UserStock not found with ID = " + id));

        existingUserStock.setQuantity(updatedUserStock.getQuantity());
        UserStock savedUserStock = userStockRepository.save(existingUserStock);
        int q = savedUserStock.getQuantity();
        savedUserStock.setQuantity(--q);
        return ResponseEntity.ok(savedUserStock);
    }

    @DeleteMapping("/carts/{id}")
    public ResponseEntity<Boolean> deleteCart(@PathVariable Long id) {
        boolean isRemoved = deleteCartById(id);
        if (!isRemoved) {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    private boolean deleteCartById(Long id) {
        Optional<UserStock> cart = userStockRepository.findById(id);
        if (cart.isPresent()) {
            userStockRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
