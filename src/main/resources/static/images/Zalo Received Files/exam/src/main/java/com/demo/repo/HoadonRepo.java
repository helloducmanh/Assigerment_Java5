package com.demo.repo;

import com.demo.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HoadonRepo extends JpaRepository<HoaDon,Long> {
    @Query("select p from HoaDon p where p.ngaylap>=?1 and  p.ngaylap<=?2")
    List<HoaDon> searchByNgaylap(Date start,Date end);
}
