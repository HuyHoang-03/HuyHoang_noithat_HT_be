package com.javafood.server.repository;

import com.javafood.server.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Integer> {
    // Tìm tất cả OrderDetailEntity theo orderId của OrderEntity
    List<OrderDetailEntity> findByOrderOrderId(Integer orderId);

    List<OrderDetailEntity> findByOrder_OrderId(Integer orderId);
    @Query("SELECT od.product, SUM(od.quantity) FROM order_details od JOIN od.order o WHERE o.orderDate >= :startDate AND o.orderDate <= :endDate GROUP BY od.product ORDER BY SUM(od.quantity) DESC")
    List<Object[]> findBestSellingProducts(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Modifying
    @Transactional
    @Query("DELETE FROM order_details od WHERE od.product.productId = :productId")
    void deleteByProductId(@Param("productId") Long productId);
}
