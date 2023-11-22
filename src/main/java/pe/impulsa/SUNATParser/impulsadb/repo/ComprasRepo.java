package pe.impulsa.SUNATParser.impulsadb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.impulsa.SUNATParser.impulsadb.models.Compras;

public interface ComprasRepo extends JpaRepository<Compras,Long> {
}
