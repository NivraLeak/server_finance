package com.example.crud_fiscal.domain.controller;

import com.example.crud_fiscal.domain.entities.FiscalPosition;
import com.example.crud_fiscal.domain.service.FiscalPositionService;
import com.example.crud_fiscal.exception.ErrorException;
import com.example.crud_fiscal.persistence.dto.entities.FiscalPositionDto;
import com.example.crud_fiscal.persistence.dto.entities.SaveFiscalPositionDto;
import com.example.crud_fiscal.response.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/fiscal"+"/position")
@CrossOrigin(origins = "http://localhost:3000/")
public class FiscalPositionController {
    private final FiscalPositionService fiscalPositionService;

    @Autowired
    public FiscalPositionController(FiscalPositionService fiscalPositionService) {
        this.fiscalPositionService = fiscalPositionService;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/create")
    @ApiOperation(value = "Save entity")
    public Response<FiscalPositionDto> createFiscalPosition(@RequestBody @Validated SaveFiscalPositionDto fiscalPositionDto) throws ErrorException{
        return new Response<>("Success",String.valueOf(HttpStatus.OK),"ok",this.fiscalPositionService.saveFiscalPosition(fiscalPositionDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update/{fiscalPositionId}")
    @ApiOperation(value = "Update entity")
    public Response<FiscalPositionDto> updateFiscalPosition(@RequestBody @Validated SaveFiscalPositionDto saveFiscalPositionDto, Integer fiscalPositionId) throws ErrorException{
        return new Response<>("Success",String.valueOf(HttpStatus.OK),"ok",this.fiscalPositionService.updateFiscalPositionById(fiscalPositionId,saveFiscalPositionDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAll")
    @ApiOperation(value = "Get all entities")
    public Response<List<FiscalPositionDto>> getListAllFiscalPosition()throws  ErrorException{
        return new Response<>("Success",String.valueOf(HttpStatus.OK),"ok",this.fiscalPositionService.getAllFiscalPosition());
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{fiscalPositionId}")
    @ApiOperation(value = "Delete entity by id")
    public Response<String> deleteFiscalPositionById(@PathVariable Integer fiscalPositionId) throws ErrorException{
        return new Response<>("Success",String.valueOf(HttpStatus.OK),"ok",this.fiscalPositionService.deleteFiscalPositionById(fiscalPositionId));
    }
}
