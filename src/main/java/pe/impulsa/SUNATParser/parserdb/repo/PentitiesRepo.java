package pe.impulsa.SUNATParser.parserdb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.impulsa.SUNATParser.parserdb.models.Pentities;

public interface PentitiesRepo extends JpaRepository<Pentities,Long> {
}
