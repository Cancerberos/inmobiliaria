package domainapp.modules.simple.dom.aviso;

import domainapp.modules.simple.dom.imagen.Imagen;
import domainapp.modules.simple.dom.imagen.ImagenRepositorio;
import domainapp.modules.simple.dom.inmueble.Inmueble;
import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.Collection;
import org.apache.isis.applib.annotation.CollectionLayout;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import java.util.List;

@Collection
@CollectionLayout(defaultView = "table")
@RequiredArgsConstructor
public class Aviso_Imagen {

    private final Aviso aviso;

    @ActionLayout( named = "Lista de Imagenes")
    public List<Imagen> coll() {return imagenRepositorio.BuscarPorImagen(aviso.getInmueble()); }

    @Inject
   ImagenRepositorio imagenRepositorio;
    JdoSupportService jdoSupportService;

}
