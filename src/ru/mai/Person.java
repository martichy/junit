package ru.mai;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

    private String firstname;
    private String lastname;
    private String patronymic;
    private byte age;
    final byte AGEOFMAJORITY = 18;
    final String WORDREGEX = "^.*[А-ЯЁа-яё].$";
    final Pattern WORDPATTERN = Pattern.compile(WORDREGEX);

    /**
     * метод для задания имени
     * @param firstname имя, которое должно содержать только буквы кириллицы и начинаться с заглавной буквы
     */
    public void setFirstname(String firstname) {
        Matcher matcherF = WORDPATTERN.matcher(firstname);
        if (matcherF.find()) {
            if (firstname.substring(0,1).equals(firstname.substring(0,1).toUpperCase()) &&
                    firstname.substring(1).equals(firstname.substring(1).toLowerCase())) {
                this.firstname = firstname;
            } else {
                System.out.println("Ошибка! Первая буква имени должна быть заглавной, а все остальные строчными.");
            }
        } else {
            System.out.println("Ошибка! Имя должно содержать только буквы кириллицы!");
        }
    }

    /**
     * метод для получения имени
     * @return имя
     */

    public String getFirstname() {
        return firstname;
    }

    /**
     * метод для задания фамилии
     * @param lastname фамилия, которая должна содержать в себе только буквы кириллицы и начинаться с заглавной буквы
     *                 также предусмотрен вариант двойной фамилии, в таком случае разделителем является дефис
     */
    public void setLastname(String lastname) {
        String[] words = lastname.trim().split("-");
        boolean error = false;
        for (String word : words) {
            Matcher matcherL= WORDPATTERN.matcher(word);
            if (matcherL.find()) {
                if (!word.substring(0, 1).equals(word.substring(0, 1).toUpperCase()) ||
                        !word.substring(1).equals(word.substring(1).toLowerCase())) {
                            System.out.println("Ошибка! Первая буква фамилии должна быть заглавной, а все остальные строчными.");
                            error = true;
                        }
            } else {
                System.out.println("Ошибка! Фамилия должна содержать только буквы кириллицы! Составная фамилия должна быть разделена дефисом.");
                break;
            }
        }
        if (!error) {
            this.lastname = lastname;
        }
    }

    /**
     * метод для получения фамилии
     * @return фамилия
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * метод для задания отчества
     * @param patronymic отчество, которое должно состоять только из букв кириллицы и начинаться с заглавной буквы
     */
    public void setPatronymic(String patronymic) {
        Matcher matcherPatronymic = WORDPATTERN.matcher(patronymic);
        if (matcherPatronymic.find()) {
            if (patronymic.substring(0,1).equals(patronymic.substring(0,1).toUpperCase()) &&
                    patronymic.substring(1).equals(patronymic.substring(1).toLowerCase())) {
                this.patronymic = patronymic;
            } else {
                System.out.println("Ошибка! Первая буква отчества должна быть заглавной, а все остальные строчными.");
            }
        } else if (patronymic.equals("")) {
            this.patronymic = patronymic;
        } else {
            System.out.println("Ошибка! Отчестов должно содержать только буквы кириллицы, либо быть пустым полем!");
        }
    }

    /**
     * @return метод для получения отчества
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * метод для задания возраста
     * @param age возраст, который не может быть отрицательным и более 127
     */
    public void setAge(byte age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Ошибка! Возраст не может быть отрицательным и больше 127 лет.");
        }
    }

    /**
     * метод для получения возраста
     * @return возраст
     */
    public byte getAge() {
        return age;
    }

    /**
     * метод для проверки, является ли человек совершеннолетним
     * @return true, если объект класса является совершеннолетним (возраст >=18), false в остальных случаях
     */
    public boolean isMajor() {
        return age >= AGEOFMAJORITY;
    }
}
