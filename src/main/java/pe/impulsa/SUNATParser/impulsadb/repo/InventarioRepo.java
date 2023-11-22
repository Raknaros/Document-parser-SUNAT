package pe.impulsa.SUNATParser.impulsadb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.impulsa.SUNATParser.impulsadb.models.Inventario;

public interface InventarioRepo extends JpaRepository<Inventario,Long> {
}
