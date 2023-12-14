package pe.impulsa.SUNATParser.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.impulsa.SUNATParser.warehouse.models.Ventas;

public interface VentasRepo extends JpaRepository<Ventas,Long> {
    Ventas findByCui(String cui);
}
