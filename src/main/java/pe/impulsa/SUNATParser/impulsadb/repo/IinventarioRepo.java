package pe.impulsa.SUNATParser.impulsadb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.impulsa.SUNATParser.impulsadb.models.Iinventario;

public interface IinventarioRepo extends JpaRepository<Iinventario,Long> {
}
