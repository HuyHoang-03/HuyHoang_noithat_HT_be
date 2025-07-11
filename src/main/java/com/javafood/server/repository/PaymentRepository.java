package com.javafood.server.repository;

import com.javafood.server.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {
    @Query("SELECT DISTINCT p FROM payments p WHERE p.order.id = :orderId")
    PaymentEntity findByOrderId(@Param("orderId") Integer orderId);
}
