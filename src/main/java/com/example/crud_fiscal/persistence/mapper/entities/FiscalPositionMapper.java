package com.example.crud_fiscal.persistence.mapper.entities;

import com.example.crud_fiscal.domain.entities.FiscalPosition;
import com.example.crud_fiscal.persistence.dto.entities.FiscalPositionDto;
import com.example.crud_fiscal.persistence.mapper.SuperMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FiscalPositionMapper implements SuperMapper<FiscalPosition, FiscalPositionDto> {
    private final ModelMapper modelMapper;

    @Autowired
    public FiscalPositionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public FiscalPositionDto toDto(FiscalPosition fiscalPosition) {
        return this.modelMapper.map(fiscalPosition, FiscalPositionDto.class);
    }

    @Override
    public FiscalPosition toEntity(FiscalPositionDto fiscalPositionDto) {
        return this.modelMapper.map(fiscalPositionDto, FiscalPosition.class);
    }

    @Override
    public List<FiscalPositionDto> toDtoList(List<FiscalPosition> list) {
        return list.stream().map(fiscalPosition -> this.modelMapper.map(fiscalPosition,FiscalPositionDto.class)).collect(Collectors.toList());
    }
}
