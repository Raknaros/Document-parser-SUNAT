package pe.impulsa.DriverSUNAT.impulsadb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.impulsa.DriverSUNAT.impulsadb.models.IEntities;

import java.util.List;

public interface IEntitiesRepo  extends JpaRepository<IEntities,Integer> {
    List<IEntities> findAllByActivoAndObservacionesIsNot(Boolean activo,String observaciones);
}
