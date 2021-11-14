package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table (name = "Action")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Action implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long inOut;
    private String date;
    private long amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cashRegisterId")
    private CashRegister cashRegister;

    public Action(long id, long inOut, String date, long amount) {
        this.id = id;
        this.inOut = inOut;
        this.date = date;
        this.amount = amount;
        this.cashRegister = cashRegister;
    }
}
