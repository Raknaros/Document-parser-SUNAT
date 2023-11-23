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

    public void fetchEntities(){
        List<Entities> Entidades = entitiesRepo.findAllByActivo(true);
        for (Entities e : Entidades) {
            Pentities NuevaEntidad = new Pentities(e.getRuc(), e.getNombreRazon(), e.getUsuarioSol(), e.getClaveSol());
            Pentitiesrepo.save(NuevaEntidad);
        }
    }
    public boolean verifyxml(Integer periodo, String cui){
        List<String> Log = plogRepo.findAllByPeriodo(periodo).stream()
                .map(Plog::getCui)
                .toList();
        return !Log.contains(cui);
    }
    public boolean verifysupplier(Long ruc){
        List<Long> Suppliers = Pentitiesrepo.findAll().stream()
                .map(Pentities::getRuc)
                .toList();
        return Suppliers.contains(ruc);
    }
    public boolean verifycustomer(Long ruc){
        List<Long> Customers = Pentitiesrepo.findAll().stream()
                .map(Pentities::getRuc)
                .toList();
        return Customers.contains(ruc);
    }
}
