package domainapp.modules.simple.dom.tipo_unidad;

import domainapp.modules.simple.dom.tipocaracteristica.TipoCaracteristica;
import domainapp.modules.simple.dom.tipocaracteristica.TipoCaracteristicaRepositorio;
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
public class TipoUnidadList {

    private final TipoUnidad tipoUnidad;

    @ActionLayout( named = "Lista de Tipos de Unidad")
    public List<TipoUnidad> coll() {return tipoUnidadRepositorio.listAll(); }

    @Inject
    TipoUnidadRepositorio tipoUnidadRepositorio;
    JdoSupportService jdoSupportService;

}
