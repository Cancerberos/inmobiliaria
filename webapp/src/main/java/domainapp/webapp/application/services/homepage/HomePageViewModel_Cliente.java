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
import java.util.List;

@Action
@RequiredArgsConstructor
public class HomePageViewModel_Cliente {

    final HomePageViewModel homePageViewModel;

    public Object act( String nombre , String apellido,Direccion direccion,
                      String telefono,String email, boolean showVisit) {
        Cliente cliente = wrapperFactory.wrapMixin(ClienteAdd.class,direccion).act(nombre,apellido,
                direccion,telefono,email
               );
        return  showVisit ? cliente :homePageViewModel;
    }
    public List<Direccion> autoComplete2Act(final String name) {
        return (List<Direccion>) direccionRepositorio.findByName(name);
    }


    //*//
   // public LocalDateTime default2Act(PetOwner petOwner, Pet pet) {
  ///      if(pet == null) return null;
  //      return factoryService.mixin(Pet_bookVisit.class, pet).default0Act();
  //  }
   // public String validate2Act(PetOwner petOwner, Pet pet, LocalDateTime visitAt){
    //     return factoryService.mixin(Pet_bookVisit.class, pet).validate0Act(visitAt);
  //  }
    ///
    @Inject
    ProvinciaRepositorio provinciaRepositorio;
    @Inject
    LocalidadRepositorio localidadRepositorioy;
    DireccionRepositorio direccionRepositorio;
    @Inject WrapperFactory wrapperFactory;
    @Inject FactoryService factoryService;
}
