package domainapp.modules.simple.dom.tipocaracteristica;

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

public class TipoCaracteristicaList {

    private final TipoCaracteristica tipoCaracteristica;

    @ActionLayout( named = "Lista de Caracteristicas")
    public List<TipoCaracteristica> coll() {return tipoCaracteristicaRepositorio.listAll(); }

    @Inject
    TipoCaracteristicaRepositorio tipoCaracteristicaRepositorio;
    JdoSupportService jdoSupportService;

}
