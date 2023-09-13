package pe.impulsa.SUNATParser.service;
import org.springframework.stereotype.Service;
import pe.impulsa.SUNATParser.impulsadb.models.Ientities;
import pe.impulsa.SUNATParser.impulsadb.repo.IentitiesRepo;
import pe.impulsa.SUNATParser.parserdb.models.Pentities;
import pe.impulsa.SUNATParser.parserdb.models.Plog;
import pe.impulsa.SUNATParser.parserdb.repo.PentitiesRepo;
import pe.impulsa.SUNATParser.parserdb.repo.PlogRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataMethods {
    private final PentitiesRepo Pentitiesrepo;
    private final IentitiesRepo Ientitiesrepo;
    private final PlogRepo plogRepo;
    public DataMethods(PentitiesRepo pentitiesRepository, IentitiesRepo ientitiesRepository, PlogRepo plogRepo) {
        this.Pentitiesrepo = pentitiesRepository;
        this.Ientitiesrepo = ientitiesRepository;
        this.plogRepo = plogRepo;
    }

    public void resetAllEntities(){

        Pentitiesrepo.deleteAll();
        List<Ientities> Entidades = Ientitiesrepo.findAllByActivo(true);
        for (Ientities e : Entidades) {
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
