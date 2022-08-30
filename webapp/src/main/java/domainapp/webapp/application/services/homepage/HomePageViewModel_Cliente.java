package domainapp.webapp.application.services.homepage;

import domainapp.modules.simple.dom.cliente.Cliente;
import domainapp.modules.simple.dom.cliente.ClienteAdd;
import domainapp.modules.simple.dom.direccion.Direccion;
import domainapp.modules.simple.dom.direccion.DireccionRepositorio;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.localidad.LocalidadRepositorio;
import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.dom.provincia.ProvinciaRepositorio;
import domainapp.modules.simple.types.EmailAddress;
import lombok.RequiredArgsConstructor;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.services.factory.FactoryService;
import org.apache.isis.applib.services.wrapper.WrapperFactory;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@Action
@RequiredArgsConstructor
public class HomePageViewModel_Cliente {

    final HomePageViewModel homePageViewModel;

    public Object act( Direccion direccion,String nombre , String apellido,String telefono,String email) {
        Cliente cliente = wrapperFactory.wrapMixin(ClienteAdd.class,direccion).act(nombre,apellido,telefono,email);
        return  cliente ;
    }

    public List<Direccion> autoComplete0Act( final String name) {
        return (List<Direccion>) direccionRepositorio.findByCalle(name);
    }


    DireccionRepositorio direccionRepositorio;
    @Inject WrapperFactory wrapperFactory;
    @Inject FactoryService factoryService;
}
