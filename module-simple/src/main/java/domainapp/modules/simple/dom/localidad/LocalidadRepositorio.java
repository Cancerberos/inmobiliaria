package domainapp.modules.simple.dom.localidad;

import domainapp.modules.simple.dom.provincia.Provincia;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import java.util.List;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@DomainService(nature = NatureOfService.REST,logicalTypeName = "simple.LocalidadRepositorio")
public class LocalidadRepositorio {

    @ActionLayout(named = "Listar Localidades")
    public List<Localidad> listAll() {
        return repositoryService.allInstances(Localidad.class);
    }


    public List<Localidad> findByProvincia_Localidad(
             final Provincia provincia
    ) {
        return repositoryService.allMatches(
                Query.named(Localidad.class, Localidad.NAMED_QUERY__FIND_BY_NAME_EXACT)
                        .withParameter("provincia", provincia)

        );
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;



}