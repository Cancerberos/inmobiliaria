package domainapp.modules.simple.dom.estado_aviso;

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
public class EstadoAvisoList {

    private final EstadoAviso estadoAviso;

   // @ActionLayout( named = "Lista de Estados")
   // public List<EstadoAviso> coll() {return estadoAvisoRepositorio.listarEstadoAviso(); }

    @Inject
   EstadoAvisoRepositorio estadoAvisoRepositorio;
    JdoSupportService jdoSupportService;

}
