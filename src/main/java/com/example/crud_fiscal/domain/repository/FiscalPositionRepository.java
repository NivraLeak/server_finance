package com.example.crud_fiscal.domain.repository;

import com.example.crud_fiscal.domain.entities.FiscalPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiscalPositionRepository extends JpaRepository<FiscalPosition, Integer> {
}
