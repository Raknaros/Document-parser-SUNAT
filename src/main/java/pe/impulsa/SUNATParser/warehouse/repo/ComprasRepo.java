package pe.impulsa.SUNATParser.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.impulsa.SUNATParser.warehouse.models.Compras;

public interface ComprasRepo extends JpaRepository<Compras,Long> {
}
