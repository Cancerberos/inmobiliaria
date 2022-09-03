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
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.PromptStyle;
import org.apache.isis.applib.services.factory.FactoryService;
import org.apache.isis.applib.services.wrapper.WrapperFactory;
import javax.inject.Inject;
import java.util.List;

@Action
@RequiredArgsConstructor
public class HomePageViewModel_Direccion {

    final HomePageViewModel homePageViewModel;
    @ActionLayout( promptStyle = PromptStyle.DIALOG_MODAL,named = "Alta de Direccion")
    public Object act( String calle,
            int numero,String edificacion,String piso,String departamento,String latitud,String longitud,Localidad localidad ) {
        Direccion direccion = wrapperFactory.wrapMixin(DireccionAdd.class,localidad).act(calle,numero,edificacion,piso,departamento,latitud,longitud);
        return   direccion ;
    }

    public List<Localidad> autoComplete7Act(final String name) {
        return (List<Localidad>) localidadRepositorioy.listAll();
    }
    @Inject
    ProvinciaRepositorio provinciaRepositorio;
    @Inject
    LocalidadRepositorio localidadRepositorioy;
    @Inject WrapperFactory wrapperFactory;
    @Inject FactoryService factoryService;
}
