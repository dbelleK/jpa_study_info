package com.fastcampus.javaallinone.project2.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@NoArgsConstructor
@Data
public class Birthday {

    private int yearOfBirthday;

   // @Min(1)
   // @Max(12)
    private int monthOfBirthday;

    //@Min(1)
    //@Max(31)
    private int dayOfBirthday;

    public Birthday(LocalDate birthday){
        this.yearOfBirthday=birthday.getYear();
        this.monthOfBirthday=birthday.getMonthValue();
        this.dayOfBirthday=birthday.getDayOfMonth();
    }
}