package com.example._0610;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;


@Setter
@Getter
@RequiredArgsConstructor
public class PersonRequestDto {
    private String name;
    private int age;
    private char gender;
    private String email;

    public PersonRequestDto(String name, int age, char gender, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }
}

