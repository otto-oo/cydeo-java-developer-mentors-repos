package com.cydeo.mentor.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "invoice_product")
@Data
public class Invoice_Product extends BaseEntity{

    private int quantity;
    private double profit;


    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}
