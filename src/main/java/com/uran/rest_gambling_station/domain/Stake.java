package com.uran.rest_gambling_station.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@ToString(exclude={"id","horse","user","race"})
@Table(name = "stakes", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "datetime") })
public class Stake implements Serializable{
    private static final long serialVersionUID = 5060337295162113935L;
    
    @Id
    @GeneratedValue
    private @Setter @Getter Long id;
    
    @Column(nullable = false)
    private @Setter @Getter Double stakeValue;
    
    @NaturalId
    @Column(nullable = false, columnDefinition = "timestamp default now()")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private @Setter @Getter LocalDateTime dateTime = LocalDateTime.now();
    
    @Column(nullable = false)
    private @Setter @Getter boolean wins;
    
    @Column(nullable = false)
    private @Setter @Getter Double amount;
    
    @Column(nullable = false)
    private @Setter @Getter boolean editable;
    
    @NotNull
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private @Setter @Getter Horse horse;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference(value="stake-user")
    private @Setter @Getter User user;
    
    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference(value="stake-race")
    private @Setter @Getter Race race;
    
    public Stake() {
    }
    
    public Stake(Double stakeValue, boolean wins, Double amount) {
        this.stakeValue = stakeValue;
        this.wins = wins;
        this.amount = amount;
        this.editable = true;
    }
    
    public Stake(Long id, Double stakeValue, boolean wins, Double amount) {
        this.id = id;
        this.stakeValue = stakeValue;
        this.wins = wins;
        this.amount = amount;
        this.editable = true;
    }
    
    public Stake(Long id, User user, Horse horse, Double stakeValue, boolean wins, Double amount) {
        this.id = id;
        this.user = user;
        this.horse = horse;
        this.stakeValue = stakeValue;
        this.wins = wins;
        this.amount = amount;
        this.editable = true;
    }
    
    public Stake(Long id, User user, Horse horse, Double stakeValue, LocalDateTime dateTime, boolean wins, Double amount, boolean editable) {
        this.id = id;
        this.user = user;
        this.horse = horse;
        this.stakeValue = stakeValue;
        this.dateTime = dateTime;
        this.wins = wins;
        this.amount = amount;
        this.editable = editable;
    }
    
    public Stake(Long id, User user, Horse horse, Race race, Double stakeValue, LocalDateTime dateTime, boolean wins, Double amount, boolean editable) {
        this.id = id;
        this.user = user;
        this.horse = horse;
        this.race = race;
        this.stakeValue = stakeValue;
        this.dateTime = dateTime;
        this.wins = wins;
        this.amount = amount;
        this.editable = editable;
    }

}
