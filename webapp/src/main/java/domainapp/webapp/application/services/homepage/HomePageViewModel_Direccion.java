package domainapp.webapp.application.services.homepage;
import domainapp.modules.simple.dom.direccion.Direccion;
import domainapp.modules.simple.dom.direccion.DireccionAdd;
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
public class HomePageViewModel_Direccion {

    final HomePageViewModel homePageViewModel;

    public Object act( Localidad localidad , String calle
            , int numero,String edificacion,String piso,String departamento,String latitud,String longitud,boolean showVisit) {
        Direccion direccion = wrapperFactory.wrapMixin(DireccionAdd.class,localidad).act(
                localidad,calle,numero,edificacion,piso,departamento,latitud,longitud);
        return  showVisit ? direccion :homePageViewModel;
    }
    public List<Localidad> autoComplete0Act(final String name) {
        return (List<Localidad>) localidadRepositorioy.findByName(name);
    }


    @Inject
    ProvinciaRepositorio provinciaRepositorio;
    @Inject
    LocalidadRepositorio localidadRepositorioy;
    @Inject WrapperFactory wrapperFactory;
    @Inject FactoryService factoryService;
}
