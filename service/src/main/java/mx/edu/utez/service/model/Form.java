package mx.edu.utez.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "form")
@Entity
@Getter
@Setter
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_form")
    private Long id;
    @Column(name = "text_form")
    private String text;
    @Column(name = "card_number_form")
    private String card_number;
    @Column(name = "rfc_form")
    private String rfc;
    @Column(name = "email_form")
    private String email;
    @Column(name = "number_form")
    private Long number;
    @Column(name = "date_form")
    private Date date;
}
