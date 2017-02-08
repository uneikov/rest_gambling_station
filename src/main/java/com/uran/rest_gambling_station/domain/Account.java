package com.uran.rest_gambling_station.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@ToString(exclude={"id", "user"})
@Table(name = "accounts")
public class Account implements Serializable{
    private static final long serialVersionUID = -6091983356638366235L;
    @Id
    @GeneratedValue
    private @Setter @Getter Long id;
    
    @Column
    private @Setter @Getter String cardNumber;
    
    @Column(nullable = false)
    private Double balance;
    
    @OneToOne(optional = false)
    private @Setter User user;
    
    public Account() {
    }
    
    public Account(String cardNumber, Double balance, User user) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.user = user;
    }
    
    public Account(Long id, String cardNumber, Double balance, User user) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.user = user;
    }
    
    public Double getBalance() {
        return balance;
    }
    
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    public User getUser() {
        return user;
    }
}
