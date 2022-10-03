package com.exam.controller;

import com.exam.entity.RequestData;
import com.exam.entity.ResponseData;
import com.exam.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("api/v1/calculator/rootsquare")
    public ResponseEntity<ResponseData> getSquareRoot(@RequestBody RequestData requestData) {
        try {
            Double rootSquareValue = calculatorService.getRootSquare(requestData.getData());
            ResponseData responseData = new ResponseData(rootSquareValue);
            log.info("Root square : " + rootSquareValue);
            return new ResponseEntity<ResponseData>(responseData,HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error occurring while getting square root " + ex.getMessage(), ex);
            return new ResponseEntity<ResponseData>(HttpStatus.BAD_REQUEST);
        }

    }
}
