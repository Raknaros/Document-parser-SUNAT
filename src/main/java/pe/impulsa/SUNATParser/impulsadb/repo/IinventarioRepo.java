package pe.impulsa.SUNATParser.impulsadb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.impulsa.SUNATParser.impulsadb.models.Ientities;

public interface IinventarioRepo extends JpaRepository<Ientities,Long> {
}
