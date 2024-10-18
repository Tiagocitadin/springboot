package com.tiago.agenda.controllers;

import com.tiago.agenda.dto.ProductRecordDto;
import com.tiago.agenda.model.ProductModel;
import com.tiago.agenda.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")

public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid  ProductRecordDto productRecordDto) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @GetMapping
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    @GetMapping("/{id}")
        public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") int id) {
            Optional<ProductModel> product0 = productRepository.findById(id);
            if (product0.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não Encontrado");
            }
            return ResponseEntity.status(HttpStatus.OK).body(product0.get());
        }

        @PutMapping("/{id}")
        public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") int id,
                                                    @RequestBody @Valid ProductRecordDto productRecordDto) {
            Optional<ProductModel> product0 = productRepository.findById(id);
            if (product0.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não Encontrado");
            }
            var productModel = product0.get();
            BeanUtils.copyProperties(productRecordDto, productModel);
            return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
        }

        @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") int id) {
        Optional<ProductModel> product0 = productRepository.findById(id);
        if (product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não Encontrado");
        }
        productRepository.delete(product0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto removido com sucesso");
        }
}
