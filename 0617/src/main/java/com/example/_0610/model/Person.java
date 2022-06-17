package com.example._0610;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private char gender;

    @Column(nullable = false)
    private String email;

    public Person(String name, int age, char gender, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public Person(PersonRequestDto requestedDto){
        this.name = requestedDto.getName();
        this.age = requestedDto.getAge();
        this.gender = requestedDto.getGender();
        this.email = requestedDto.getEmail();
    }

    public void update(PersonRequestDto requestedDto) {
        this.name = requestedDto.getName();
        this.age = requestedDto.getAge();
        this.gender = requestedDto.getGender();
        this.email = requestedDto.getEmail();
    }
}