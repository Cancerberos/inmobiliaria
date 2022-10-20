package domainapp.modules.simple.dom.usuario;


import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;
import java.util.List;
import java.util.Optional;

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
    @ActionLayout(named = "Listar ")
    public List<Usuario> listarUsuarioPorNombre() {
        return repositoryService.allMatches(Query.named(Usuario.class,Usuario.NAMED_QUERY__FIND_BY_NAME_LIKE_USUARIO));
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(named = "Listar Usuarios  ")
    public Optional<Usuario> getByUsernamePassword1(final String username, final String password) {
        return repositoryService.uniqueMatch(
                        Query.named(Usuario.class, Usuario.NAMED_QUERY__FIND_BY_USER_NAME_PASSWORD)
                                .withParameter("username",username )

                );

    }



        @Programmatic
        public Usuario buscarPorUserNameExacto ( final String userName){
            return repositoryService.uniqueMatch(
                            Query.named(Usuario.class, Usuario.NAMED_QUERY__FIND_BY_NAME_LIKE_USER_NAME)
                                    .withParameter("userName", userName))
                    .orElse(null);
        }

    @ActionLayout(named = "Validar Usuario")
    public Usuario getByUsernamePassword(final String username, final String password) {
        return repositoryService.firstMatch(
                        Query.named(Usuario.class, Usuario.NAMED_QUERY__FIND_BY_USER_NAME_PASSWORD)
                                .withParameter("username", username)
                                .withParameter("password", password))
                .orElse(null);
    }

        @Programmatic
        public void ping ( final String username){
            JDOQLTypedQuery<Usuario> q = jdoSupportService.newTypesafeQuery(Usuario.class);
            final QUsuario candidate = QUsuario.candidate();
            q.orderBy(candidate.username.asc());
            q.executeList();

        }
    @Inject
    RepositoryService repositoryService;
        JdoSupportService jdoSupportService;

    }