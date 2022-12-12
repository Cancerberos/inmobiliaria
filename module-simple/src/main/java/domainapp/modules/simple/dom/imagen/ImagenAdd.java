package domainapp.modules.simple.dom.imagen;

import domainapp.modules.simple.dom.inmueble.Inmueble;
import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.value.Blob;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

@Action(
        semantics = SemanticsOf.IDEMPOTENT,
        commandPublishing = Publishing.ENABLED,
        executionPublishing = Publishing.ENABLED
)
@ActionLayout(associateWith = "imagen", sequence = "12",named = "Agregar Imagenes",promptStyle = PromptStyle.DIALOG_MODAL)
@RequiredArgsConstructor
public class ImagenAdd {

    private final Inmueble inmueble;

       public Inmueble AddImagenes(Blob url, String descripcion)
       {
            repositoryService.persist(new Imagen(url,descripcion, inmueble));
          //   System.out.println(" RUTA IMAGEN ===> "+url.toString());
            return  inmueble;
       }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;



}