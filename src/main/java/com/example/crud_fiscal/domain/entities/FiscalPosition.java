package com.example.crud_fiscal.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_fiscalposition")
public class FiscalPosition {
    @Id
    @Column(name = "id", nullable = false, length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "year_balance", nullable = false)
    private Integer yearBalance;

    @Column(name = "state", nullable = false)
    private State state;

    @Column(name = "item", nullable = false)
    private String item;

    @Column(name = "amount", nullable = false)
    private Integer Amount;

    @Column(name = "gdp", nullable = false)
    private Float gdp;
}
