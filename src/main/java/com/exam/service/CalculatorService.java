package com.exam.service;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;

@Component
public class CalculatorService {
    public Double getRootSquare(Double[] inputData) {
        if (inputData == null) {
            return  null;
        }
        double rootSquare = Math.sqrt(Arrays.stream(inputData).sorted(Comparator.reverseOrder()).limit(3).map(x->x*x).reduce(0.0,Double::sum));
        return Math.round(rootSquare * 100.0) / 100.0;
    }
}
