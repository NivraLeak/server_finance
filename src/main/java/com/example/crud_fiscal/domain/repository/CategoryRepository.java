package com.example.crud_fiscal.domain.repository;

import com.example.crud_fiscal.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(@NonNull String name);

}
