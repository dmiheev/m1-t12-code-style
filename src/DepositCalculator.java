import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int powValue) {
        double scale = Math.pow(10, powValue);

        return Math.round(value * scale) / scale;
    }

    void calculateProfit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int userAction = scanner.nextInt();

        double profit = 0;
        if (userAction == 1) {
            profit = calculateSimplePercent(amount, 0.06, period);
        } else if (userAction == 2) {
            profit = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + profit);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateProfit();
    }
}
