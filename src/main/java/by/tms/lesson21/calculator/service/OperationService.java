package by.tms.lesson21.calculator.service;

import by.tms.lesson21.calculator.console.ConsoleWriter;
import by.tms.lesson21.calculator.model.CalculationData;

public class OperationService {
    ConsoleWriter consoleWriter = new ConsoleWriter();
    public void calculator(CalculationData calculationData) {
        if (!calculationData.getNumbers().isEmpty()) {
            double result = calculationData.getNumbers().get(0);
            boolean divisionByZero = false;
            for (int i = 1; i < calculationData.getNumbers().size(); i++) {
                char op = calculationData.getOperations().get(i - 1);
                double nextNum = calculationData.getNumbers().get(i);
                switch (op) {
                    case '+':
                        result += nextNum;
                        break;
                    case '-':
                        result -= nextNum;
                        break;
                    case '*':
                        result *= nextNum;
                        break;
                    case '/':
                        if (nextNum != 0) {
                            result /= nextNum;
                        } else {
                            consoleWriter.write("Попытка деления на ноль");
                            divisionByZero = true;
                        }
                        break;
                    default:
                        consoleWriter.write("Неподдерживаемая операция");
                }
            } if (!divisionByZero) {
                consoleWriter.write("Результат: " + result);
            } else {
                consoleWriter.write("На ноль делить нельзя");
            }
        } else {
            consoleWriter.write("Список пуст");
        }
        calculationData.getNumbers().clear();
        calculationData.getOperations().clear();
    }
}
