package com.fastcampus.javaallinone.project2.demo.repository;

import com.fastcampus.javaallinone.project2.demo.domain.Person;
import com.fastcampus.javaallinone.project2.demo.dto.Birthday;
import org.hibernate.hql.internal.ast.tree.IntoClause;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud(){

        Person person = new Person();
        person.setName("martin");
        person.setAge(10);
        person.setBloodType("A");
        //person.isBlock();

        personRepository.save(person);

        System.out.println(personRepository.findAll());

        List<Person> people = personRepository.findAll();

        assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getName()).isEqualTo("martin");
        assertThat(people.get(0).getAge()).isEqualTo(10);
        assertThat(people.get(0).getBloodType()).isEqualTo("A");

    }

    @Test
    void hashCodeAndEquals(){
        Person person1 = new Person("martin",10, "A");
        Person person2 = new Person("martin",10, "A");

        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());

        Map<Person, Integer> map = new HashMap<>();
        map.put(person1, person1.getAge());

        System.out.println(map);
        System.out.println(map.get(person2)); //해시코드가 다르기에 null -> hashcode() 메서드처럼 작성하면 10 가져옴 또는 어노테이션
    }

    @Test
    void findByBloodType(){
        givenPerson("martin", 10, "A");
        givenPerson("david", 9, "B");
        givenPerson("dennis", 8, "O");
        givenPerson("sophia", 7, "AB");
        givenPerson("benny", 6, "A");

        List<Person> result = personRepository.findByBloodType("A");

        result.forEach(System.out::println);
    }

    private void givenPerson(String name, int age, String bloodType){
        givenPerson(name, age, bloodType,null);
    }

    private void givenPerson(String name, int age, String bloodType, LocalDate birthday){

        Person person = new Person(name,age, bloodType);
        person.setBirthday(new Birthday(birthday));

        personRepository.save(person);
    }

    @Test
    void findByBirthdayBetween(){
        givenPerson("martin", 10, "A",LocalDate.of(1991,8,15));
        givenPerson("david", 9, "B",LocalDate.of(1992,7,10));
        givenPerson("dennis", 8, "O",LocalDate.of(1993,1,5));
        givenPerson("sophia", 7, "AB",LocalDate.of(1994,6,30));
        givenPerson("benny", 6, "A",LocalDate.of(1995,8,30));

        List<Person> result = personRepository.findByMonthOfBirthday(8);
        result.forEach(System.out::println);
    }





}