package pe.impulsa.SUNATParser.parserdb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.impulsa.SUNATParser.parserdb.models.PEntities;

import java.util.List;

public interface PEntitiesRepo extends JpaRepository<PEntities,Integer> {


}
