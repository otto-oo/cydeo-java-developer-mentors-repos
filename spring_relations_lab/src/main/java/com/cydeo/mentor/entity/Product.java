package com.cydeo.mentor.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Data
public class Product extends BaseEntity {

    private String name;
    private double price;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
