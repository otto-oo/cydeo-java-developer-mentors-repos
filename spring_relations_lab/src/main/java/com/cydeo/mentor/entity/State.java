package com.cydeo.mentor.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "state")
@Data
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stateCode;
    private String stateName;
}
