package by.tms.lesson21.calculator.console;

import by.tms.lesson21.calculator.model.CalculationData;
import by.tms.lesson21.calculator.service.OperationService;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class ConsoleApplication {
    CalculationData calculationData = new CalculationData();
    private final ConsoleReader consoleReader = new ConsoleReader();
    private final ConsoleWriter consoleWriter = new ConsoleWriter();
    int count = 1;
    public void run(){
        while (true) {
            try {
                if (count % 2 != 0) {
                    consoleWriter.write("Введите число");
                    double num = consoleReader.readNum();
                    calculationData.addNumbers(num);
                    count++;
                }
                if (count % 2 == 0) {
                    consoleWriter.write("Введите знак операции: '+,-,*,/' для вывода результата нажмите '='");
                    String str = consoleReader.readOperationType();
                    if (Pattern.matches(".*[\\+\\-\\*\\/\\=].*", str)) {
                        char op = str.charAt(0);
                        if (op == '=') {
                            break;
                        } else {
                            calculationData.addOperations(op);
                            count++;
                        }
                    } else {
                        consoleWriter.write("Некоректный ввод, повторите попытку");
                        consoleReader.clearScanner();
                    }
                }
            } catch (InputMismatchException e) {
                consoleWriter.write("Некоректный ввод, повторите попытку");
                consoleReader.clearScanner();
            }
        }
        count = 1;
        OperationService operationService = new OperationService();
        operationService.calculator(calculationData);
    }
}
