package pe.impulsa.SUNATParser.service;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pe.impulsa.SUNATParser.impulsadb.models.IEntities;
import pe.impulsa.SUNATParser.impulsadb.repo.IEntitiesRepo;
import pe.impulsa.SUNATParser.parserdb.models.PEntities;
import pe.impulsa.SUNATParser.parserdb.repo.PEntitiesRepo;

import java.util.List;


public class DataMethods {
    @PersistenceContext
    IEntitiesRepo Ientitiesrepo;
    @PersistenceContext
    PEntitiesRepo Pentitiesrepo;

    public void resetAllEntities(){
        Pentitiesrepo.deleteAll();
        List<IEntities> Entidades = Ientitiesrepo.findAllByActivoAndObservacionesIsNot(true, "Problema Autenticacion");
        for (IEntities e : Entidades) {
            PEntities NuevaEntidad = new PEntities(e.getEntityId(), e.getNombreRazon(), e.getTipoDocumento(), e.getNumeroDocumento(), e.getUsuarioSol(), e.getClaveSol());
            Pentitiesrepo.save(NuevaEntidad);
        }
    }


}
