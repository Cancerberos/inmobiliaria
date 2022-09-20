package domainapp.modules.simple.dom.inmueble;

import domainapp.modules.simple.dom.inmueble_caracteristica.InmuebleCaracteristica;
import domainapp.modules.simple.dom.inmueble_caracteristica.InmuebleCaracteristicaRepositorio;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.localidad.LocalidadRepositorio;
import domainapp.modules.simple.dom.provincia.Provincia;
import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import java.util.List;
@Collection
@CollectionLayout(defaultView = "table")
@RequiredArgsConstructor
public class Caracteristica_Inmueble {

    private final Inmueble inmueble;

    @ActionLayout( named = "Lista de Caracteristicas")
    public List<InmuebleCaracteristica> coll() {return inmuebleCaracteristicaRepositorio.BuscarPorInmuebleCaracteristica(inmueble); }

    @Inject
   InmuebleCaracteristicaRepositorio inmuebleCaracteristicaRepositorio;
    JdoSupportService jdoSupportService;

}
