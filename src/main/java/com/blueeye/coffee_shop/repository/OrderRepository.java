package com.blueeye.coffee_shop.repository;

import com.blueeye.coffee_shop.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query("SELECT o FROM OrderEntity o WHERE o.user.id = ?1")
    List<OrderEntity> findByUserId(Long id);
}
