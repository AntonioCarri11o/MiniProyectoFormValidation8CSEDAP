package mx.edu.utez.service.repository;

import mx.edu.utez.service.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {
}
