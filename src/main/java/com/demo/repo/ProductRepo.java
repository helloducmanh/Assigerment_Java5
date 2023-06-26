package com.demo.repo;

import com.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
  @Query("Select p FROM Product p WHERE p.category.id=?1 AND p.name like ?2 and p.price between ?3 and ?4")
  Page<Product> searchByCategoryNamePrice(String cid, String keyword, int minPrice, int maxPrice, Pageable pageable);
    @Query("Select p FROM Product p WHERE p.name like ?1 and p.price between ?2 and ?3")
    Page<Product> searchByNamePrice(String keyword,int minPrice,int maxPrice,Pageable pageable);
}
