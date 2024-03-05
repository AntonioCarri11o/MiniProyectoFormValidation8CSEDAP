package mx.edu.utez.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_select")
@Entity
public class Select {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_select")
    private Long id;
    @Column(name = "option_select")
    private String option;

    public Select(Long id) {
        this.id = id;
    }
}
