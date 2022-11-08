package com.cydeo.mentor.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client")
@Data
public class Client extends BaseEntity {

    private String clientName;
    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;


}
