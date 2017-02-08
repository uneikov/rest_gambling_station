package com.uran.rest_gambling_station.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString(exclude={"id", "stakes"})
@Table(name = "races", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "start") })
public class Race implements Serializable{
    private static final long serialVersionUID = 7814524545785467671L;
    
    @Id
    @GeneratedValue
    private @Setter @Getter Long id;
    
    @NaturalId
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private @Setter @Getter LocalDateTime start;
    
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private @Setter @Getter LocalDateTime finish;
    
    // Horses list (serialized)
    @Column(nullable = false)
    private @Setter @Getter String horses;
    
    // Winning horse (serialized)
    @Column(nullable = false)
    private @Setter @Getter String winning;
    
    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value="stake-race")
    private @Setter @Getter List<Stake> stakes;
    
    public Race() {
    }
    
    public Race(Long id, LocalDateTime startRace, LocalDateTime endRace) {
        this.id = id;
        this.start = startRace;
        this.finish = endRace;
    }
    
    public Race(Long id, LocalDateTime startRace, LocalDateTime endRace, String horses, String winning) {
        this.id = id;
        this.start = startRace;
        this.finish = endRace;
        this.horses = horses;
        this.winning = winning;
    }
    
}
