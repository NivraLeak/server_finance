package com.example.crud_fiscal.domain.service;

import com.example.crud_fiscal.persistence.dto.entities.FiscalPositionDto;
import com.example.crud_fiscal.persistence.dto.entities.SaveFiscalPositionDto;
import com.example.crud_fiscal.persistence.dto.error.ErrorException;

import java.util.List;

public interface FiscalPositionService {
    FiscalPositionDto saveFiscalPosition(SaveFiscalPositionDto saveFiscalPositionDto)throws ErrorException;
    FiscalPositionDto updateFiscalPositionById(Integer idFiscalPosition, SaveFiscalPositionDto saveFiscalPositionDto) throws ErrorException;
    List<FiscalPositionDto> getAllFiscalPosition() throws ErrorException;

    FiscalPositionDto getFiscalPositionById(Integer idFiscalPosition) throws ErrorException;

    String deleteFiscalPositionById(Integer idFiscalPosition) throws ErrorException;
}
