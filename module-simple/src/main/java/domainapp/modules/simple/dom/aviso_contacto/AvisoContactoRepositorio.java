package domainapp.modules.simple.dom.aviso_contacto;


import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.cliente.QCliente;
import domainapp.modules.simple.dom.estado_contacto.EstadoContacto;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.tipo_unidad.TipoUnidad;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.jdo.JDOQLTypedQuery;
import java.util.List;

@DomainService(
        nature = NatureOfService.REST,
        logicalTypeName = "simple.AvisoContactoRepositorio"
)


public class AvisoContactoRepositorio {



    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Listar Avisos")
    public List<AvisoContacto> listarAvisoContacto() { return repositoryService.allInstances(AvisoContacto.class); }



    @ActionLayout(named = "Listar Avisos Contacto")
    public List<AvisoContacto> findByName() {
        return repositoryService.allMatches(
                Query.named(AvisoContacto.class, AvisoContacto.NAMED_QUERY__FIND_BY_NAME_LIKE_AVISO_CONTACTO_CLIENTE)
        );
    }

    @Programmatic
    public void ping() {
        JDOQLTypedQuery<AvisoContacto> q = jdoSupportService.newTypesafeQuery(AvisoContacto.class);
        final QAvisoContacto candidate = QAvisoContacto.candidate();
        q.range(0,2);
        q.orderBy(candidate.mensaje.asc());
        q.executeList();
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;

}