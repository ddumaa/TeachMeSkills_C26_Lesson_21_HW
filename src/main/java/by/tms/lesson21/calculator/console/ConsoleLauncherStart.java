package by.tms.lesson21.calculator.console;

public class ConsoleLauncherStart {
    ConsoleApplication consoleApplication = new ConsoleApplication();
    ConsoleReader consoleReader = new ConsoleReader();
    ConsoleWriter consoleWriter = new ConsoleWriter();
    public void launcherStart(){
    String work = "Y";
        consoleWriter.write("Калькулятор включён");
        while (true) {
            if (work.equals("N")) {
                break;
            } else if (work.equals("Y")) {
                consoleApplication.run();
                consoleWriter.write("Хотите продолжить? Да - 'Y', Нет - 'N'");
                work = consoleReader.readOperationType().toUpperCase();
            } else {
                consoleWriter.write("Некоректный ввод, повторите");
            }
        }
    }
}
