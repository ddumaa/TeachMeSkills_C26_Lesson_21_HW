package by.tms.lesson21.calculator.console;

import by.tms.lesson21.calculator.model.CalculationData;
import by.tms.lesson21.calculator.service.OperationService;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class ConsoleApplication {
    private final ConsoleManagerError consoleManagerError = new ConsoleManagerError();
    private final CalculationData calculationData = new CalculationData();
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
                        consoleManagerError.writeMessageClearScanner();
                    }
                }
            } catch (InputMismatchException e) {
                consoleManagerError.writeMessageClearScanner();
            }
        }
        count = 1;
        OperationService operationService = new OperationService();
        operationService.calculator(calculationData);
    }
}
