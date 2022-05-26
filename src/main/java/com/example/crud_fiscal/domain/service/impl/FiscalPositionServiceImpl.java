package com.example.crud_fiscal.domain.service.impl;

import com.example.crud_fiscal.domain.entities.FiscalPosition;
import com.example.crud_fiscal.domain.repository.FiscalPositionRepository;
import com.example.crud_fiscal.domain.service.FiscalPositionService;
import com.example.crud_fiscal.exception.ErrorException;
import com.example.crud_fiscal.persistence.dto.entities.FiscalPositionDto;
import com.example.crud_fiscal.persistence.dto.entities.SaveFiscalPositionDto;
import com.example.crud_fiscal.persistence.mapper.SuperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiscalPositionServiceImpl implements FiscalPositionService {
    private FiscalPositionRepository fiscalPositionRepository;
    private final SuperMapper<FiscalPosition,FiscalPositionDto> fiscalPositionMapper;
    @Autowired
    public FiscalPositionServiceImpl(FiscalPositionRepository fiscalPositionRepository, SuperMapper<FiscalPosition, FiscalPositionDto> fiscalPositionMapper){
        this.fiscalPositionRepository = fiscalPositionRepository;
        this.fiscalPositionMapper = fiscalPositionMapper;
    }

    @Override
    public FiscalPositionDto saveFiscalPosition(SaveFiscalPositionDto saveFiscalPositionDto) throws ErrorException {
        return null;
    }

    @Override
    public FiscalPositionDto updateFiscalPositionById(Integer idFiscalPosition, SaveFiscalPositionDto saveFiscalPositionDto) throws ErrorException {
        return null;
    }

    @Override
    public List<FiscalPositionDto> getAllFiscalPosition() throws ErrorException {
        return null;
    }

    @Override
    public FiscalPositionDto getFiscalPositionById(Integer idFiscalPosition) throws ErrorException {
        return null;
    }

    @Override
    public String deleteFiscalPositionById(Integer idFiscalPosition) throws ErrorException {
        return null;
    }
}
