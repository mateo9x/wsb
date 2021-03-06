package com.mateo9x.shop.repository;

import java.util.List;

import com.mateo9x.shop.domain.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByItemCategoryId(Long id);

    @Query(value = "select * from db.items it inner join db.carts ct on it.id = ct.item_id where ct.user_id = :userId", nativeQuery = true)
    List<Item> findByUserId(@Param("userId") Long userId);

    @Query(value = "select * from db.items where seller_id = :sellerId", nativeQuery = true)
    List<Item> findBySellerId(@Param("sellerId") Long sellerId);

    @Query(value = "select * from db.items where brand like %:query% or model like %:query%", nativeQuery = true)
    List<Item> findByBrandLikeOrModelLike(@Param("query") String query);

}
