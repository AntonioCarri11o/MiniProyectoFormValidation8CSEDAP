package mx.edu.utez.service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_file;
    String name_file;
    String url_file;
    String contentType_file;

    public File() {

    }



}
