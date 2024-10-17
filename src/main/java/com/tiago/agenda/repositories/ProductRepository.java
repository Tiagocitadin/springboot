package com.tiago.agenda.repositories;

import com.tiago.agenda.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
    Optional<ProductModel> findById(int id);
    Optional<ProductModel> findAllBy(int id);
}
