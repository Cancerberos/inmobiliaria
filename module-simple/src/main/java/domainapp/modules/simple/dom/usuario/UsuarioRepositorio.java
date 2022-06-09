package domainapp.modules.simple.dom.usuario;

import domainapp.modules.simple.dom.usuario.QUsuario;
//import domainapp.modules.simple.dom.so.QUsuario;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jdo.applib.services.JdoSupportService;

import javax.inject.Inject;
import javax.jdo.JDOQLTypedQuery;

@DomainService(
        nature = NatureOfService.VIEW,
        logicalTypeName = "simple.Usuarios"
)
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )
public class UsuarioRepositorio {

    final RepositoryService repositoryService;
    final JdoSupportService jdoSupportService;


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public Usuario createUsuario(
            final String username,
            final String apellido,
            final String nombre,
            final String telefono,
            final String mail,
            final String password,
            final boolean esAdmin) {
        return repositoryService.persist(new Usuario(username, apellido, nombre, telefono, mail, password, esAdmin));
    }

/*
    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public List<SimpleObject> findByName(
            @Name final String name
    ) {
        return repositoryService.allMatches(
                Query.named(SimpleObject.class, SimpleObject.NAMED_QUERY__FIND_BY_NAME_LIKE)
                        .withParameter("name", name));
    }


    @Programmatic
    public SimpleObject findByNameExact(final String name) {
        return repositoryService.firstMatch(
                        Query.named(SimpleObject.class, SimpleObject.NAMED_QUERY__FIND_BY_NAME_EXACT)
                                .withParameter("name", name))
                .orElse(null);
    }



    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    public List<SimpleObject> listAll() {
        return repositoryService.allInstances(SimpleObject.class);
    }
*/

    @Programmatic
    public void ping() {
        JDOQLTypedQuery<Usuario> q = jdoSupportService.newTypesafeQuery(Usuario.class);
        final QUsuario candidate = QUsuario.candidate();
        q.range(0,2);
        q.orderBy(candidate.username.asc());
        q.executeList();
    }


}