package com.cydeo.bootstrap;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

public class MentorData {
    public static List<Mentor> getAll(){
        return Arrays.asList(new Mentor("Mike","Smith",45, Gender.MALE),
                new Mentor("Tom","Hanks",65, Gender.MALE),
                new Mentor("Ammy","Bryan",25, Gender.FEMALE));
    }
}
