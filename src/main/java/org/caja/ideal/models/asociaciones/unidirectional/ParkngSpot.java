package org.caja.ideal.models.asociaciones.unidirectional;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "uni_parkngSpot_one_to_one")
@Table(name = "uni_parkngSpot_one_to_one")
public class ParkngSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
