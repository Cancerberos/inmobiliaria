package domainapp.modules.simple.dom.inmueble;

import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.direccion.Direccion;
import domainapp.modules.simple.dom.inmobiliaria.Inmobiliaria;
import domainapp.modules.simple.dom.inmobiliaria.QInmobiliaria;
import domainapp.modules.simple.dom.tipo_unidad.TipoUnidad;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;
import java.util.Date;

@DomainService(
        nature = NatureOfService.VIEW,
        logicalTypeName = "simple.InmuebleRepositorio"
)
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )
public class InmuebleRepositorio {

    final RepositoryService repositoryService;
    final JdoSupportService jdoSupportService;


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public Inmueble createInmueble(
            final Cliente cliente,
            final String descripcion,
            final Date fechaExclusividad,
            final TipoUnidad tipoUnidad,
            final Direccion direccion) {
        return repositoryService.persist(new Inmueble(cliente, descripcion, fechaExclusividad, tipoUnidad, direccion));
    }

    @Programmatic
    public void ping() {
        JDOQLTypedQuery<Inmueble> q = jdoSupportService.newTypesafeQuery(Inmueble.class);
        final QInmueble candidate = QInmueble.candidate();
        q.range(0,2);
        q.orderBy(candidate.descripcion.asc());
        q.executeList();
    }


}
