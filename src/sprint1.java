import java.util.Scanner;

public class sprint1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StepTracker stepTracker = new StepTracker();


        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                stepTracker.saveStepInDay();

            } else if (command == 2) {
                stepTracker.statisticsMonth();

            } else if (command == 3) {
                stepTracker.changeStepsTarget();

            } else if (command == 4) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }




    public static void printMenu() {
        System.out.println(" ");
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }
}