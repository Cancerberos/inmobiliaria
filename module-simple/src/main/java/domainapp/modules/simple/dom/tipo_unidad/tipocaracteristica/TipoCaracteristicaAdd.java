package domainapp.modules.simple.dom.tipo_unidad.tipocaracteristica;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.repository.RepositoryService;

import javax.inject.Inject;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@DomainService(
        nature = NatureOfService.REST,
        logicalTypeName = "simple.TipoCaracteristicaAdd")

public class TipoCaracteristicaAdd { public TipoCaracteristica  tipoCaracteristica;

    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_MODAL,named = "Agregar Caracteristicas" )
    public TipoCaracteristica AddCaracteristica(final String descripcion) {
        repositoryService.persist(new TipoCaracteristica( descripcion));
        return tipoCaracteristica;
    }

    @Inject RepositoryService repositoryService;
}
