package com.highperformance.repository;

import com.highperformance.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Consulta otimizada com projeção
    @Query("SELECT p.id, p.name, p.price FROM Product p WHERE p.quantity > 0")
    List<Object[]> findAvailableProductsSummary();

    // Consulta assíncrona
    @Async
    CompletableFuture<Product> findByName(String name);

    // Atualização em lote
    @Modifying
    @Query("UPDATE Product p SET p.price = p.price * (1 + :percentage/100) WHERE p.quantity > 0")
    int updatePrices(@Param("percentage") BigDecimal percentage);
}
