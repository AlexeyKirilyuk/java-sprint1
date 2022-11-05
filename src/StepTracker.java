import java.util.Scanner;

public class StepTracker {

    Scanner scanner = new Scanner(System.in);
    int stepsTarget = 10000;
    Converter converter = new Converter();
    int [][] stepMountDay = new int[12][30];
    public StepTracker() {
        /*MonthData[] monthToData;      не чего не понимаю - в смысле массив из классов( учили что может быть int, double, String)

    public StepTracker() {
            monthToData = new MonthData[12];
            for (int i = 0; i < monthToData.length; i++) {
                monthToData[i] = new MonthData();
            }
        }

        class MonthData {
            // Заполните класс самостоятельно
        }*/

    for (int i = 0; i < 12; i++) {  //месяцы
        for (int j = 0; j < 30; j++) {//дни

            System.out.print(" " +  stepMountDay[i][j] + " "); //вывод кол-ва шагов за день
        }
        System.out.println();//перенос строки ради визуального сохранения табличной формы
    }

    }

    void saveStepInDay() { //Сохранение количества шагов за день.
        System.out.println("За какой месяц вы хотите ввести количество шагов ?");
        System.out.println("(0-Январь,1-Февраль,2-Март,3-Апрель,4-Май,5-Июнь,6-Июль,7-Август,8-Сентябрь,9-Октябрь,10-Ноябрь,11-Декабрь)");
        //Пользователь должен указать номер месяца (начиная с 0)
        int Mount = scanner.nextInt();
        System.out.println("За какой день вы хотите ввести количество шагов ?");
        int day = scanner.nextInt()-1;
        System.out.println("Введите количество шагов ? ");
        System.out.println("(Количество шагов должно быть неотрицательным!)");

        int stepInDay = scanner.nextInt();

        stepMountDay[Mount][day] = stepInDay;

        for (int i = 0; i < 12; i++) {  //месяцы
            for (int j = 0; j < 30; j++) {//дни

                System.out.print(" " +  stepMountDay[i][j] + " "); //вывод кол-ва шагов за день
            }
            System.out.println();//перенос строки ради визуального сохранения табличной формы
        }


    }


    void statisticsMonth() { //Подсчёт и вывод статистики за указанный пользователем месяц.
        System.out.println("За какой месяц вы хотите напечатать статистику ?");
        System.out.println("(0-Январь,1-Февраль,2-Март,3-Апрель,4-Май,5-Июнь,6-Июль,7-Август,8-Сентябрь,9-Октябрь,10-Ноябрь,11-Декабрь)");
        //Пользователь должен указать номер месяца (начиная с 0)
        int Mount = scanner.nextInt();
        int sumStepInMount =0;
        int maxStepInMount =0;
        int bestSeriesStepInMount =0;
        int bestSeriesStep =0;

        System.out.println("Количество пройденных шагов в "+Mount);
        for (int day = 0; day < 30; day++) {//дни
            System.out.print(" " +day+" день: "+  stepMountDay[Mount][day] + ","); //вывод кол-ва шагов (в формате 1 день: 3000,)
            sumStepInMount = sumStepInMount + stepMountDay[Mount][day];
            if(maxStepInMount <stepMountDay[Mount][day]){maxStepInMount = stepMountDay[Mount][day];}

            if(stepMountDay[Mount][day]>stepsTarget) {
                bestSeriesStep = bestSeriesStep + 1;
                if (bestSeriesStep > bestSeriesStepInMount)
                {
                    bestSeriesStepInMount = bestSeriesStep;
                }
            } else {bestSeriesStep = 0;}

        }
        System.out.print("Общее количество шагов за месяц "+sumStepInMount);
        System.out.print("Максимальное пройденное количество шагов в месяце "+maxStepInMount);
        System.out.print("Среднее количество шагов "+sumStepInMount/30);
        System.out.print("Пройденная дистанция (в км) "+ converter.ConverterDistance(sumStepInMount));
        System.out.print("Количество сожжённых килокалорий (в ккал) "+ converter.ConverterСollories(sumStepInMount));
        System.out.print("Лучшая серия: "+ bestSeriesStepInMount +" дней.");


    }



    void changeStepsTarget() { //Изменение целевого количества шагов.
        System.out.println("Введите количество шагов ? ");
        System.out.println("(Количество шагов должно быть неотрицательным!)");

        int newStepsTarget = scanner.nextInt();
        stepsTarget = newStepsTarget;

    }

}