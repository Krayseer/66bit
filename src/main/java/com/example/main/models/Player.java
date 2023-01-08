package com.example.main.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Player {
    private String id;
    private String name;
    private String surname;
    private String sex;
    private String birthDay;
    private String team;
    private String country;

    @Override
    public String toString() {
        return id + ") Имя: " + name + ". Фамилия: " + surname + ". Пол: " + sex + ". Дата рождения: " + birthDay
                + ". Команда: " + team + ". Страна: " + country + ".";
    }
}
