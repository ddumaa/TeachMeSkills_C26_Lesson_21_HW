package by.tms.lesson21.calculator.console;

public class ConsoleWriter {
    public void write(String message) {
        System.out.println(message);
    }
    public void errorWrite(){
        write("Некоректный ввод, повторите попытку");
    }
}
