package pe.impulsa.SUNATParser.impulsadb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.impulsa.SUNATParser.impulsadb.models.Ientities;

import java.util.List;

public interface IentitiesRepo extends JpaRepository<Ientities,Integer> {
    List<Ientities> findAllByActivoAndObservacionesIsNot(Boolean activo, String observaciones);
}
