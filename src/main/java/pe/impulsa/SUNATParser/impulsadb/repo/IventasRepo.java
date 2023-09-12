package pe.impulsa.SUNATParser.impulsadb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.impulsa.SUNATParser.impulsadb.models.Ientities;
import pe.impulsa.SUNATParser.impulsadb.models.Iventas;

public interface IventasRepo extends JpaRepository<Iventas,Long> {
}
