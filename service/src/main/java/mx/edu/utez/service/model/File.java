package mx.edu.utez.service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity

public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_file;
    String name_file;
    String url_file;
    String contentType_file;
    @ManyToOne
    @JoinColumn(name = "id")
    private Form fk_form;

    public File(String name, String url, String contentType) {
        this.name_file = name;
        this.url_file = url;
        this.contentType_file = contentType;
    }
    public File() {

    }



}
