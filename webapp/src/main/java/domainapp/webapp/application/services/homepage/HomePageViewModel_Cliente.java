package domainapp.webapp.application.services.homepage;

import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.cliente.ClienteAdd;
import domainapp.modules.simple.dom.direccion.Direccion;
import domainapp.modules.simple.dom.direccion.DireccionRepositorio;
import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.PromptStyle;
import org.apache.isis.applib.services.factory.FactoryService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.wrapper.WrapperFactory;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@Action
@RequiredArgsConstructor
public class HomePageViewModel_Cliente {

    final HomePageViewModel homePageViewModel;
   @ActionLayout( promptStyle = PromptStyle.DIALOG_MODAL,named = "Alta de Clientes")

    public Object act( Direccion direccion,String nombre , String apellido,String telefono,String email) {
       return wrapperFactory.wrapMixin(ClienteAdd.class,direccion).act(nombre,apellido,telefono,email);
    }
    public List<Direccion> autoComplete0Act(final String name) {
        return (List<Direccion>) direccionRepositorio.findByCalle(name);
    }

    @Inject
    DireccionRepositorio direccionRepositorio;
    WrapperFactory wrapperFactory;
    FactoryService factoryService;
    RepositoryService repositoryService;
}
