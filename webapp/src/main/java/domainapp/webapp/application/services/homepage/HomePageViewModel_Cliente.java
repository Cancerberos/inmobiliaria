package domainapp.webapp.application.services.homepage;

import domainapp.modules.simple.dom.direccion.Direccion;
import domainapp.modules.simple.dom.direccion.DireccionRepositorio;
import domainapp.modules.simple.dom.localidad.Localidad;
import domainapp.modules.simple.dom.localidad.LocalidadRepositorio;
import domainapp.modules.simple.dom.provincia.Provincia;
import domainapp.modules.simple.dom.provincia.ProvinciaRepositorio;
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

    public Object act(Localidad localidad ,String calle,
             int numero,String edificacion,String piso,String departamento,String latitud,String longitud,boolean showVisit) {
        Direccion direccion = wrapperFactory.wrapMixin(DireccionRepositorio.class,localidad).createDireccion(
                localidad,calle,numero,edificacion,piso,departamento,latitud,longitud);
        return  showVisit ? direccion :homePageViewModel;
    }
    public List<Provincia> autoComplete0Act(final String name) {
        return (List<Provincia>) provinciaRepositorio.findByName(name);
    }
    public List<Localidad> autoComplete1Act(final String name) {
        return (List<Localidad>) localidadRepositorioy.findByNameExact(name);
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
    @Inject WrapperFactory wrapperFactory;
    @Inject FactoryService factoryService;
}
