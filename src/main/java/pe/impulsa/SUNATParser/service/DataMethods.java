package pe.impulsa.SUNATParser.service;
import org.springframework.stereotype.Service;
import pe.impulsa.SUNATParser.impulsadb.models.Entities;
import pe.impulsa.SUNATParser.impulsadb.repo.EntitiesRepo;
import pe.impulsa.SUNATParser.parserdb.models.Pentities;
import pe.impulsa.SUNATParser.parserdb.models.Plog;
import pe.impulsa.SUNATParser.parserdb.repo.PentitiesRepo;
import pe.impulsa.SUNATParser.parserdb.repo.PlogRepo;

import java.util.List;

@Service
public class DataMethods {
    private final PentitiesRepo Pentitiesrepo;
    private final EntitiesRepo ientitiesrepo;
    private final PlogRepo plogRepo;
    public DataMethods(PentitiesRepo pentitiesRepository, EntitiesRepo entitiesRepository, PlogRepo plogRepo) {
        this.Pentitiesrepo = pentitiesRepository;
        this.ientitiesrepo = entitiesRepository;
        this.plogRepo = plogRepo;
    }

    public void resetAllEntities(){

        Pentitiesrepo.deleteAll();
        List<Entities> Entidades = ientitiesrepo.findAllByActivo(true);
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
