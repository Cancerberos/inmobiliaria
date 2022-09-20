package domainapp.modules.simple.dom.inmueble;

import domainapp.modules.simple.dom.inmueble_caracteristica.InmuebleCaracteristica;
import domainapp.modules.simple.dom.inmueble_caracteristica.InmuebleCaracteristicaRepositorio;
import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.Collection;
import org.apache.isis.applib.annotation.CollectionLayout;
import org.apache.isis.applib.annotation.PromptStyle;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import java.util.List;

@Collection
@CollectionLayout(defaultView = "table")
@RequiredArgsConstructor
public class InmuebleList {

    private final Inmueble inmueble;

    @ActionLayout( named = "Lista de Inmueble")
    public List<Inmueble> coll() {return inmuebleRepositorio.listAll(); }

    @Inject
            InmuebleRepositorio inmuebleRepositorio;
     JdoSupportService jdoSupportService;

}
