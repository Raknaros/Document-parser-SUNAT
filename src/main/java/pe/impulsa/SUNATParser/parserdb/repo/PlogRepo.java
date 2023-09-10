package pe.impulsa.SUNATParser.parserdb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.impulsa.SUNATParser.parserdb.models.Plog;

import java.util.List;

public interface PlogRepo  extends JpaRepository<Plog,Long> {
    List<Plog> findAllByPeriodo(Integer periodo);
}
