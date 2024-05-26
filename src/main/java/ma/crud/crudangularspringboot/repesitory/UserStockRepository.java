package ma.crud.crudangularspringboot.repesitory;

import jakarta.transaction.Transactional;
import ma.crud.crudangularspringboot.model.UserStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserStockRepository extends JpaRepository<UserStock,Long> {
    @Query("SELECT u FROM UserStock u WHERE u.productId = :productId AND u.userId = :userId")
    List<UserStock> findByProductIdAndUserId(@Param("productId") Long productId, @Param("userId") Long userId);
    @Modifying
    @Transactional
    @Query("DELETE FROM UserStock us WHERE us.productId = :productId")
    void deleteByProductId(@Param("productId") Long productId);

}
