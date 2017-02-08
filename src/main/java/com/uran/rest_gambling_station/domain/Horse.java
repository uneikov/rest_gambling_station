package com.uran.rest_gambling_station.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.io.Serializable;

@Entity
@ToString(exclude="id")
@Table(name = "horses", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "name") })
public class Horse implements Serializable{
    private static final long serialVersionUID = 2714600491390664126L;
    
    @Id
    @GeneratedValue
    private @Setter @Getter Long id;
    
    @NotEmpty
    @NaturalId
    @Column(nullable = false)
    private @Setter String name;
    
    @NotEmpty
    @Column(nullable = false)
    private @Setter @Getter String ruName;
    
    @Digits(fraction = 0, integer = 2)
    @Column(nullable = false)
    private @Setter @Getter int age;
    
    @Digits(fraction = 0, integer = 4)
    @Column(nullable = false)
    private @Setter @Getter int wins;
    
    @Column(nullable = false)
    private @Setter @Getter boolean ready;
    
    public Horse() {
    }
    
    public Horse(String name, String ruName, int age, int wins) {
        this(null, name, ruName, age, wins);
    }
    
    public Horse(Long id, String name, String ruName, int age, int wins) {
        this.id = id;
        this.name = name;
        this.ruName = ruName;
        this.age = age;
        this.wins = wins;
        this.ready = false;
    }
    
    public Horse(Long id, String name, String ruName, int age, int wins, boolean ready) {
        this.id = id;
        this.name = name;
        this.ruName = ruName;
        this.age = age;
        this.wins = wins;
        this.ready = ready;
    }
    
    public String getName() {
        return name;
    }
}
