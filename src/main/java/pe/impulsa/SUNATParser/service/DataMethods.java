package pe.impulsa.SUNATParser.service;
import org.springframework.stereotype.Service;
import pe.impulsa.SUNATParser.warehouse.models.Entities;
import pe.impulsa.SUNATParser.warehouse.repo.EntitiesRepo;
import pe.impulsa.SUNATParser.parserdb.models.Pentities;
import pe.impulsa.SUNATParser.parserdb.models.Plog;
import pe.impulsa.SUNATParser.parserdb.repo.PlogRepo;

import java.util.List;

@Service
public class DataMethods {
    private final EntitiesRepo entitiesRepo;
    private final PlogRepo plogRepo;
    public DataMethods(EntitiesRepo entitiesRepo, PlogRepo plogRepo) {
        this.entitiesRepo = entitiesRepo;
        this.plogRepo = plogRepo;
    }

    public List<Long> fetchEntities(){
        return entitiesRepo.findAllByActivo(true).stream()
                .map(Entities::getRuc)
                .toList();
    }
    public boolean verifyxml(Integer periodo, String cui){
        List<String> Log = plogRepo.findAllByPeriodo(periodo).stream()
                .map(Plog::getCui)
                .toList();
        return !Log.contains(cui);
    }
}
