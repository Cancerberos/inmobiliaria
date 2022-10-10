package domainapp.modules.simple.dom.estado_contacto;

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
public class EstadoContactoList {

    private final EstadoContacto estadoContacto;

    @ActionLayout( named = "Lista de Estados Contacto")
    public List<EstadoContacto> coll() {return estadoContactoRepositorio.ListarEstadoContactoOrdenaPorDescripcion(); }

    @Inject
    EstadoContactoRepositorio estadoContactoRepositorio;
    JdoSupportService jdoSupportService;

}
