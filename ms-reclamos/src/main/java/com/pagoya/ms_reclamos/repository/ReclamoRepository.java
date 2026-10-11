package com.pagoya.ms_reclamos.repository;

import com.pagoya.ms_reclamos.entity.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo, Long> {
}