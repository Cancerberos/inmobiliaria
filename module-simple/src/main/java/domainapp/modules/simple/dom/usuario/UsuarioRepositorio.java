package domainapp.modules.simple.dom.usuario;


import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.jdo.JDOQLTypedQuery;
import java.util.List;

@DomainService(
        nature = NatureOfService.VIEW,
        logicalTypeName = "simple.UsuarioRepositorio"
)


public class UsuarioRepositorio {


    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Listar Usuarios Registrados")
    public List<Usuario> listarUsuario() {
        return repositoryService.allInstances(Usuario.class);
    }
    @ActionLayout(named = "Listar Usuarios ")
    public List<Usuario> listarUsuarioPorNombre() {
        return repositoryService.allMatches(Query.named(Usuario.class,Usuario.NAMED_QUERY__FIND_BY_NAME_LIKE_USUARIO));
    }

    @Programmatic
    public Usuario buscarPorUsuarioExacto(final String name) {
        return repositoryService.firstMatch(
                        Query.named(Usuario.class, Usuario.NAMED_QUERY__FIND_BY_NAME_LIKE_USUARIO)
                                .withParameter("nombre", name))
                .orElse(null);
    }
    @Programmatic
    public Usuario buscarPorUserNameExacto(final String userName) {
        return repositoryService.firstMatch(
                        Query.named(Usuario.class, Usuario.NAMED_QUERY__FIND_BY_NAME_LIKE_USER_NAME)
                                .withParameter("userName", userName))
                .orElse(null);
    }


    @Programmatic
    public void ping() {
        JDOQLTypedQuery<Usuario> q = jdoSupportService.newTypesafeQuery(Usuario.class);
        final QUsuario candidate = QUsuario.candidate();
        q.range(0,2);
        q.orderBy(candidate.nombre.asc());
        q.executeList();
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
    JdoSupportService jdoSupportService;

}