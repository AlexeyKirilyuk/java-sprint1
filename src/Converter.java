
public class Converter { //В этом классе осуществляется преобразование шагов в километры и калории.

    double stepLength = 0.75;    //Для подсчёта дистанции можно считать, что один шаг равен 75 см.(0.75 метра)
    int stepEnergy = 50;         //Для подсчёта количества сожжённых килокалорий можно считать, что 1 шаг = 50 калорий, 1 килокалория = 1 000 калорий.



    public double ConverterDistance(int sumStepInMount) {
        double distanceInMount =sumStepInMount * stepLength/1000;
    return distanceInMount;
    }


    public double ConverterСollories(int sumStepInMount) {
        double colloriesInMount =sumStepInMount * stepEnergy/1000;
        return colloriesInMount;
    }
}
