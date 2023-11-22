package pe.impulsa.SUNATParser.impulsadb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.impulsa.SUNATParser.impulsadb.models.Entities;

import java.util.List;

public interface EntitiesRepo extends JpaRepository<Entities,Integer> {
    List<Entities> findAllByActivoAndObservacionesIsNot(Boolean activo, String observaciones);
    List<Entities> findAllByActivo(Boolean activo);
}
