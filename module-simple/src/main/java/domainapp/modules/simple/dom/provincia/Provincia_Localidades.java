package domainapp.modules.simple.dom.provincia;

import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.localidad.LocalidadRepositorio;
import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.Collection;
import org.apache.isis.applib.annotation.CollectionLayout;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;


import javax.inject.Inject;
import java.util.List;

@Collection
@CollectionLayout(defaultView = "table")
@RequiredArgsConstructor
public class Provincia_Localidades {

    private final Provincia provincia;


    public List<Localidad> coll() {return localidadRepositorio.findByProvincia_Localidad(provincia); }

    @Inject
    LocalidadRepositorio localidadRepositorio;
    JdoSupportService jdoSupportService;

}
