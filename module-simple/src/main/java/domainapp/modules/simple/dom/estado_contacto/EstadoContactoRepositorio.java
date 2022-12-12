package domainapp.modules.simple.dom.estado_contacto;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import java.util.List;

@DomainService(
        nature = NatureOfService.REST,
        logicalTypeName = "simple.EstadoContactoRepositorio"
)
public class EstadoContactoRepositorio {


    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Listado de Estados Contacto")
    public List<EstadoContacto> ListarEstadoContactoOrdenaPorDescripcion() {
        return repositoryService.allMatches(
                Query.named(EstadoContacto.class, EstadoContacto.NAMED_QUERY__FIND_BY_NAME_LIKE_CONTACTO)
                          );
    }
    //@Action(semantics = SemanticsOf.SAFE)
  //  @ActionLayout(named = "Listar Todos los Estados")
    //public List<EstadoContacto> listarEstadoCotacto() {
     //   return repositoryService.allInstances(EstadoContacto.class);
 //   }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;


}