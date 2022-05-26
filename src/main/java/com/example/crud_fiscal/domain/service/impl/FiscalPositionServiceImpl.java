package com.example.crud_fiscal.domain.service.impl;

import com.example.crud_fiscal.domain.entities.Category;
import com.example.crud_fiscal.domain.entities.FiscalPosition;
import com.example.crud_fiscal.domain.repository.CategoryRepository;
import com.example.crud_fiscal.domain.repository.FiscalPositionRepository;
import com.example.crud_fiscal.domain.service.FiscalPositionService;
import com.example.crud_fiscal.exception.ErrorException;
import com.example.crud_fiscal.exception.InternalServerErrorException;
import com.example.crud_fiscal.exception.NotFoundException;
import com.example.crud_fiscal.persistence.dto.entities.FiscalPositionDto;
import com.example.crud_fiscal.persistence.dto.entities.SaveFiscalPositionDto;
import com.example.crud_fiscal.persistence.mapper.SuperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiscalPositionServiceImpl implements FiscalPositionService {
    private FiscalPositionRepository fiscalPositionRepository;
    private CategoryRepository categoryRepository;
    private final SuperMapper<FiscalPosition,FiscalPositionDto> fiscalPositionMapper;
    @Autowired
    public FiscalPositionServiceImpl(FiscalPositionRepository fiscalPositionRepository,CategoryRepository categoryRepository, SuperMapper<FiscalPosition, FiscalPositionDto> fiscalPositionMapper){
        this.fiscalPositionRepository = fiscalPositionRepository;
        this.categoryRepository = categoryRepository;
        this.fiscalPositionMapper = fiscalPositionMapper;
    }

    @Override
    public FiscalPositionDto saveFiscalPosition(SaveFiscalPositionDto saveFiscalPositionDto) throws ErrorException {
        Category category = this.categoryRepository.findById(saveFiscalPositionDto.getCategoryId())
                                                    .orElseThrow(()-> new NotFoundException("SNOT-404-1","ID_CATEGORY_NOT_FOUND"));

        FiscalPosition fiscalPosition = new FiscalPosition();
        fiscalPosition.setAmount(saveFiscalPositionDto.getAmount());
        fiscalPosition.setCategory(category);
        fiscalPosition.setGdp(saveFiscalPositionDto.getGdp());
        fiscalPosition.setItem(saveFiscalPositionDto.getItem());
        fiscalPosition.setState(saveFiscalPositionDto.getState());
        fiscalPosition.setYearBalance(saveFiscalPositionDto.getYearBalance());
        try {
            this.fiscalPositionRepository.save(fiscalPosition);
        }catch (final Exception e){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","SAVE_ENTITY");
        }
        return this.fiscalPositionMapper.toDto(fiscalPosition);
    }

    @Override
    public FiscalPositionDto updateFiscalPositionById(Integer idFiscalPosition, SaveFiscalPositionDto saveFiscalPositionDto) throws ErrorException {
        Category category = this.categoryRepository.findById(saveFiscalPositionDto.getCategoryId())
                .orElseThrow(()-> new NotFoundException("SNOT-404-1","ID_CATEGORY_NOT_FOUND"));

        FiscalPosition fiscalPosition = this.fiscalPositionRepository.findById(idFiscalPosition).orElseThrow(()-> new NotFoundException("SNOT-404-1","ID_FISCAL_POSITION_NOT_FOUND"));
        fiscalPosition.setAmount(saveFiscalPositionDto.getAmount());
        fiscalPosition.setCategory(category);
        fiscalPosition.setGdp(saveFiscalPositionDto.getGdp());
        fiscalPosition.setItem(saveFiscalPositionDto.getItem());
        fiscalPosition.setState(saveFiscalPositionDto.getState());
        fiscalPosition.setYearBalance(saveFiscalPositionDto.getYearBalance());
        try {
            this.fiscalPositionRepository.save(fiscalPosition);
        }catch (final Exception e){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","SAVE_ENTITY");
        }
        return this.fiscalPositionMapper.toDto(fiscalPosition);
    }

    @Override
    public List<FiscalPositionDto> getAllFiscalPosition() throws ErrorException {
        List<FiscalPosition> listFiscalPosition = this.fiscalPositionRepository.findAll();
        return this.fiscalPositionMapper.toDtoList(listFiscalPosition);
    }

    @Override
    public FiscalPositionDto getFiscalPositionById(Integer idFiscalPosition) throws ErrorException {
        FiscalPosition fiscalPosition = this.fiscalPositionRepository.findById(idFiscalPosition).orElseThrow(()-> new NotFoundException("SNOT-404-1","ID_FISCAL_POSITION_NOT_FOUND"));

        return this.fiscalPositionMapper.toDto(fiscalPosition);
    }

    @Override
    public String deleteFiscalPositionById(Integer idFiscalPosition) throws ErrorException {
        try {
            this.fiscalPositionRepository.deleteById(idFiscalPosition);
        }catch (final Exception e){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","DELETE");
        }

        return "ENTITY_DELETED";
    }

}
