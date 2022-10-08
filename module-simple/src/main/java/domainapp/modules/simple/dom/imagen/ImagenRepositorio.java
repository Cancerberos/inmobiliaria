package domainapp.modules.simple.dom.imagen;

import domainapp.modules.simple.dom.inmueble.Inmueble;
import domainapp.modules.simple.dom.inmueble_caracteristica.InmuebleCaracteristica;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.events.domain.ActionDomainEvent;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import java.util.List;

@DomainService(nature = NatureOfService.VIEW,logicalTypeName = "simple.ImagenRepositorio")
public class ImagenRepositorio {

    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    public List<Imagen> BuscarPorImagen(
            final Inmueble inmueble
            ) {
        return repositoryService.allMatches(
                Query.named(Imagen.class, Imagen.NAMED_QUERY__FIND_BY_NAME_LIKE)
                        .withParameter("inmueble", inmueble)

        );
    }
    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    public Imagen BuscarImagen(
            final Inmueble inmueble
    ) {
        return (Imagen) repositoryService.allMatches(
                Query.named(Imagen.class, Imagen.NAMED_QUERY__FIND_BY_NAME_LIKE)
                        .withParameter("inmueble", inmueble)

        );
    }
    @ActionLayout(named = "Listar todas las Imagenes")
    public List<Imagen> listAll() {
        return repositoryService.allInstances(Imagen.class);
    }
    public static class CreateDomainEvent extends ActionDomainEvent<ImagenRepositorio> {}

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;



}