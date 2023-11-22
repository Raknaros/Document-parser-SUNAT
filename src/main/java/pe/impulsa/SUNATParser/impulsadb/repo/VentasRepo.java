package pe.impulsa.SUNATParser.impulsadb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.impulsa.SUNATParser.impulsadb.models.Ventas;

public interface VentasRepo extends JpaRepository<Ventas,Long> {
}
