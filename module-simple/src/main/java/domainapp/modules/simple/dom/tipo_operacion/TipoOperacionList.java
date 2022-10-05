package domainapp.modules.simple.dom.tipo_operacion;

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
public class TipoOperacionList {

    private final TipoOperacion tipoOperacion;

    @ActionLayout( named = "Lista de Operaciones")
    public List<TipoOperacion> coll() {return tipoOperacionRepositorio.listarTodasTipoOperacion(); }

    @Inject
    TipoOperacionRepositorio tipoOperacionRepositorio;
    JdoSupportService jdoSupportService;

}
