package by.tms.lesson21.calculator.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CalculationData {
    private final List <Double> numbers;
    private final List <Character> operations;
    public CalculationData(){
        numbers = new ArrayList<>();
        operations = new ArrayList<>();
    }
    public void addNumbers (double number){
        numbers.add(number);
    }
    public void addOperations (char operation){
        operations.add(operation);
    }
}
