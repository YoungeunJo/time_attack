package com.example._0610;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {
    private final PersonRepository personRepository;

    private final PersonService personService;

    @GetMapping("/api/persons/{id}")
    public Person getCourses(@PathVariable Long id, @RequestBody PersonRequestDto requestedDto) {
        return personRepository.findById(id);
    }

    @PostMapping("/api/persons")
    public Person createCourse(@RequestBody PersonRequestDto requestedDto) {
        Person person = new Person(requestedDto);
        return personRepository.save(person);
    }

    @PutMapping("/api/persons/{id}")
    public Long updateCourse(@PathVariable Long id, @RequestBody PersonRequestDto requestedDto) {
        return personService.update(id, requestedDto);
    }

    @DeleteMapping("/api/persons/{id}")
    public Long deleteCourse(@PathVariable Long id, @RequestBody PersonRequestDto requestedDto) {
        personRepository.deleteById(id);
        return id;
    }
}
