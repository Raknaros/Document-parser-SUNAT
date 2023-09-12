package pe.impulsa.SUNATParser.impulsadb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.impulsa.SUNATParser.impulsadb.models.Ientities;
import pe.impulsa.SUNATParser.impulsadb.models.Isunatpagos;

public interface IsunatpagosRepo extends JpaRepository<Isunatpagos,Long> {
}
