package ru.mai;

public class Calculator {

    /**
     * метод для сложения двух чисел
     * @param a первое сумируемое число
     * @param b второе сумируемое число
     * @return сумма
     */
    public double summarize(double a, double b) {
        a = a + b;
        return a;
    }

    /**
     * метод для вычитания двух чисел
     * @param reduction уменьшаемое число
     * @param subtracted вычитаемое число
     * @return разность
     */
    public double deduct(double reduction, double subtracted) {
        reduction = reduction - subtracted;
        return reduction;
    }

    /**
     * метод для деления двух чисел
     * @param divisible делимое
     * @param divisor делитель
     * @return частное
     */
    public double divide(double divisible, double divisor) {
        if (divisor == 0) {
            divisible = 0;
            System.out.println("ERROR");
        } else {
            divisible = divisible / divisor;
        }
        return divisible;
    }

    /**
     * метод для нахождения остатка от деления
     * @param divisible делимое
     * @param divisor делитель
     * @return остаток от деления
     */
    public double mod(double divisible, double divisor) {
        if (divisor == 0) {
            divisible = 0;
            System.out.println("ERROR");
        } else {
            divisible = divisible % divisor;
        }
        return divisible;
    }

    /**
     * метод для умножения двух чисел
     * @param a первый множитель
     * @param b второй множитель
     * @return произведение
     */
    public double multiply(double a, double b) {
        a = a * b;
        return a;
    }

    /**
     * метод для нахождения обратного числа
     * @param a число, которое необходимо обратить
     * @return число, обратное a
     */
    public double reverseNumber(double a) {
        if (a != 0) {
            a = 1 / a;
        }
        return a;
    }
}
