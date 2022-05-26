package com.example.crud_fiscal.domain.controller;

import com.example.crud_fiscal.domain.service.FiscalPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/fiscal"+"/position")
public class FiscalPositionController {
    private final FiscalPositionService fiscalPositionService;

    @Autowired
    public FiscalPositionController(FiscalPositionService fiscalPositionService) {
        this.fiscalPositionService = fiscalPositionService;
    }
}
