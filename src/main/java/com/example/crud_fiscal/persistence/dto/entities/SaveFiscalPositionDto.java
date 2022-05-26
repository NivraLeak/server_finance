package com.example.crud_fiscal.persistence.dto.entities;

import com.example.crud_fiscal.domain.entities.State;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveFiscalPositionDto {

    private Integer yearBalance;

    private State state;

    private String item;

    private Integer Amount;

    private Float gdp;

    private Integer categoryId;
}
