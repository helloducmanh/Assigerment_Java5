package com.demo.repo;

import com.demo.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachhangRepo extends JpaRepository<KhachHang,Long> {
}
