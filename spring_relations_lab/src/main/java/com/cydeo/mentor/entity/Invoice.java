package com.cydeo.mentor.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "invoice")
@Data
public class Invoice extends BaseEntity{

    private String invoiceNumber;
    private String invoiceType;

    private LocalDate invoiceDate;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


}
