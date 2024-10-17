package com.tiago.agenda.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "TBPRODUTO")
public class ProductModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String NMproduto;
   private BigDecimal vlProduto;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNMproduto() {
        return NMproduto;
    }

    public void setNMproduto(String NMproduto) {
        this.NMproduto = NMproduto;
    }

    public BigDecimal getVlProduto() {
        return vlProduto;
    }

    public void setVlProduto(BigDecimal vlProduto) {
        this.vlProduto = vlProduto;
    }
}




