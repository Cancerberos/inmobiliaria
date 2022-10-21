package domainapp.modules.simple.dom.usuario;


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
public class UsuarioList {

    private final Usuario usuario;

    /* @ActionLayout( named = "Lista de Usuarios Registrados")
    public List<Usuario> coll() {return usuarioRepositorio.listarUsuario(); }*/

    @Inject
    UsuarioRepositorio usuarioRepositorio;
    JdoSupportService jdoSupportService;

}
