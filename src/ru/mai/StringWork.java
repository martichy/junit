package ru.mai;

public class StringWork {

    /**
     * метод для задания строки "заборчика" - чередования верхнего и нижнего регистра
     * @param string исходная строка
     * @return строка "заборчиком"
     */

    public String makePence(String string) {
        String finalString = "";
        try {
            for (int i = 0; i < string.length(); i++) {
                String symbol = string.substring(i, i + 1);
                if (i % 2 == 0) {
                    symbol = symbol.toUpperCase();
                } else {
                    symbol = symbol.toLowerCase();
                }
                finalString = finalString.concat(symbol);
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Ошибка! Введена строка нулевой длины.");
        }
        return finalString;
    }

    /**
     * метод для задания тексту формата: первая буква заглавная, остальные - строчные
     * @param string исходная строка
     * @return отформатированная строка
     */

    public String startWithCapital(String string) {
        String firstLetter = "";
        String other = "";
        String finalString = "";
        try {
            String[] words = string.trim().split(" ");
            for (int i = 0; i < words.length; i++) {
                firstLetter = words[i].substring(0, 1);
                firstLetter = firstLetter.toUpperCase();
                other = words[i].substring(1);
                other = other.toLowerCase();
                if (i != words.length - 1) {
                    finalString = finalString.concat(firstLetter).concat(other).concat(" ");
                } else {
                    finalString = finalString.concat(firstLetter).concat(other);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка! Введена строка нулевой длины.");
        }
        return finalString;
    }

    /**
     * метод для выделения букв заданного символа верхним регистром
     * @param string исходная строка
     * @param symbol символ, который нужно выделить
     * @return отформатированная строка
     */

    public String upperChar(String string, char symbol) {
        string = string.toLowerCase();
        string = string.replace(Character.toLowerCase(symbol), Character.toUpperCase(symbol));
        return string;
    }

    /**
     * метод для выделения букв заданного символа нижним регистром
     * @param string исходная строка
     * @param symbol символ, который нужно выделить
     * @return отформатированная строка
     */

    public String lowerChar(String string, char symbol) {
        string = string.toUpperCase();
        string = string.replace(Character.toUpperCase(symbol), Character.toLowerCase(symbol));
        return string;
    }
}