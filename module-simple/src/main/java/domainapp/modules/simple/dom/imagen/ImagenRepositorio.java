package domainapp.modules.simple.dom.imagen;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;

@DomainService(
        nature = NatureOfService.VIEW,
        logicalTypeName = "simple.ImagenRepositorio"
)
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )
public class ImagenRepositorio {

    final RepositoryService repositoryService;
    final JdoSupportService jdoSupportService;


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public Imagen createImagen(
            final String url,
            final String descripcion,
            final Inmueble inmueble) {
        return repositoryService.persist(new Imagen(url, descripcion, inmueble));
    }

    @Programmatic
    public void ping() {
        JDOQLTypedQuery<Imagen> q = jdoSupportService.newTypesafeQuery(Imagen.class);
        final QImagen candidate = QImagen.candidate();
        q.range(0,2);
        q.orderBy(candidate.descripcion.asc());
        q.executeList();
    }


}