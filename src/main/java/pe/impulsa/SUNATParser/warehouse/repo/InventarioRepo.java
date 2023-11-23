package pe.impulsa.SUNATParser.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.impulsa.SUNATParser.warehouse.models.Inventario;

public interface InventarioRepo extends JpaRepository<Inventario,Long> {
}
