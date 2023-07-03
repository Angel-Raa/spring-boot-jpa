package org.caja.ideal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clubs", schema = "public")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_club", unique = true)
    private String nameClub;
    @Column
    private String city;
    @Column
    private String country;
    /**
     * Relacion de uno a uno con la entidad Coach
     */
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Coach.class)
    @JoinColumn(name = "coach_id")
    private Coach coach;
    /**
     * Relacion de uno a muchos con la entidad Player
     */
    @OneToMany(targetEntity = Player.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "club")
    private List<Player> players; // <Player
    /**
     * Relacion de muchos a uno con la entidad Assciation
     */
    @ManyToOne(targetEntity = Assciation.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Assciation assciation;
    /**
     * Relacion de muchos a muchos con la entidad Competition
     */
    @ManyToMany(targetEntity = Competition.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name =  "clubs_competitions", // nombre de table
    joinColumns = @JoinColumn(name = "club_id"), // nombre de columna de la tabla de claves foraneas table club
            inverseJoinColumns = @JoinColumn(name = "competition_id")) // nombre de columna de la tabla de claves foraneas table competition
    private List<Competition> competitions;


}
