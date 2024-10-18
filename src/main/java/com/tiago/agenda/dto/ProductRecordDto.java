package com.tiago.agenda.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record ProductRecordDto(@NotBlank String nmProduto, @NotNull BigDecimal vlProduto) {
}
