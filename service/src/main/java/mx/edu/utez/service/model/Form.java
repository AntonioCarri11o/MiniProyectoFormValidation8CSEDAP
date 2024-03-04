package mx.edu.utez.service.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_form;
    private String text_form;

    private String card_number_form;
    private String rfc_form;
    private String curp_form;
    private String email_form;
    private String password_form;
    private Long number_form;
    private Date date_form;

    private String genre_form;

    @OneToMany
    private List<File> files = new ArrayList<>();

    public Form(String text) {
        this.text_form = text;
    }

    public Form(String text_form, String card_number_form, String rfc_form, String curp_form, String email_form, String password_form, Long number_form, Date date_form, List<File> files, String genre) {
        this.text_form = text_form;
        this.card_number_form = card_number_form;
        this.rfc_form = rfc_form;
        this.curp_form = curp_form;
        this.email_form = email_form;
        this.password_form = password_form;
        this.number_form = number_form;
        this.date_form = date_form;
        this.files = files;
        this.genre_form = genre;
    }

    public Form() {

    }
}
