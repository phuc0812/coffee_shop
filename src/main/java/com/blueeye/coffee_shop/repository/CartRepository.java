package com.blueeye.coffee_shop.repository;

import com.blueeye.coffee_shop.entity.CartEntity;
import com.blueeye.coffee_shop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
    @Query("SELECT c FROM CartEntity c WHERE c.user.id = ?1")
    List<CartEntity> findAllByUserID(Long id);
    @Query("SELECT c FROM CartEntity c WHERE c.product.id = ?1 AND c.user.id = ?2")
    CartEntity findByProductIdAndUserId(Long productId, Long userId);
    @Modifying
    @Query("DELETE FROM CartEntity c WHERE c.product.id = ?1")
    void deleteByProductId(Long id);
}
