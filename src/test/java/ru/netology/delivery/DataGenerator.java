package ru.netology.delivery;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
}

    public static String generateDate(int addDays) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var cities = new String[]{"Москва", "Калуга", "Омск", "Брянск", "Самара",
            "Санкт-Петербург", "Орёл", "Кемерово", "Курск","Белгород"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber().replace("(", "").replace(")", "")
                .replace("-", "");
    }
    public static class Registration {
        private Registration(){
        }

        public static UserInfo generateUser(String locale){
            return new UserInfo (generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo{
        String city;
        String name;
        String phone;
    }
}