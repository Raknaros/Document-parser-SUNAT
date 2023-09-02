package pe.impulsa.SUNATParser.service;
import org.springframework.stereotype.Service;
import pe.impulsa.SUNATParser.impulsadb.models.IEntities;
import pe.impulsa.SUNATParser.impulsadb.repo.IEntitiesRepo;
import pe.impulsa.SUNATParser.parserdb.models.PEntities;
import pe.impulsa.SUNATParser.parserdb.repo.PEntitiesRepo;

import java.util.List;

@Service
public class DataMethods {
    private final PEntitiesRepo Pentitiesrepo;
    private final IEntitiesRepo Ientitiesrepo;

    public DataMethods(PEntitiesRepo pEntitiesRepository, IEntitiesRepo iEntitiesRepository) {
        this.Pentitiesrepo = pEntitiesRepository;
        this.Ientitiesrepo = iEntitiesRepository;
    }

    public void resetAllEntities(){

        Pentitiesrepo.deleteAll();
        List<IEntities> Entidades = Ientitiesrepo.findAllByActivoAndObservacionesIsNot(true, "Problema Autenticacion");
        for (IEntities e : Entidades) {
            PEntities NuevaEntidad = new PEntities(e.getEntityId(), e.getNombreRazon(), e.getTipoDocumento(), e.getNumeroDocumento(), e.getUsuarioSol(), e.getClaveSol());
            Pentitiesrepo.save(NuevaEntidad);
        }
    }


}
