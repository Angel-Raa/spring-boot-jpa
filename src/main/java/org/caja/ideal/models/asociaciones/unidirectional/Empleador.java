package org.caja.ideal.models.asociaciones.unidirectional;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "uni_empleado_one_to_one")
@Table(name = "uni_empleado_one_to_one")
public class Empleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "parking_spot_id")
    private ParkngSpot parkngSpot;

}
