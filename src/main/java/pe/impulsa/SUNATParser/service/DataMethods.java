package pe.impulsa.SUNATParser.service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;
import pe.impulsa.SUNATParser.pojo.LogCUI;
import pe.impulsa.SUNATParser.warehouse.models.Entities;
import pe.impulsa.SUNATParser.warehouse.repo.EntitiesRepo;

import java.util.List;

@Service
public class DataMethods {
    private final EntitiesRepo entitiesRepo;
    private final EntityManager entityManager;
    public DataMethods(EntitiesRepo entitiesRepo, EntityManager entityManager) {
        this.entitiesRepo = entitiesRepo;
        this.entityManager = entityManager;
    }

    public List<Long> fetchEntities(){
        return entitiesRepo.findAllByActivo(true).stream()
                .map(Entities::getRuc)
                .toList();
    }
    public List verifyxml(){
        Query q=entityManager.createNamedQuery("LogCUI");
        return q.getResultList();
    }
}
