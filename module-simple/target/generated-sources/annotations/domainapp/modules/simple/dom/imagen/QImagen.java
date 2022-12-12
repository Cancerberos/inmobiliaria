package domainapp.modules.simple.dom.imagen;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QImagen extends PersistableExpressionImpl<Imagen> implements PersistableExpression<Imagen>
{
    public static final QImagen jdoCandidate = candidate("this");

    public static QImagen candidate(String name)
    {
        return new QImagen(null, name, 5);
    }

    public static QImagen candidate()
    {
        return jdoCandidate;
    }

    public static QImagen parameter(String name)
    {
        return new QImagen(Imagen.class, name, ExpressionType.PARAMETER);
    }

    public static QImagen variable(String name)
    {
        return new QImagen(Imagen.class, name, ExpressionType.VARIABLE);
    }

    public final ObjectExpression<org.apache.isis.applib.value.Blob> url;
    public final StringExpression descripcion;
    public final domainapp.modules.simple.dom.inmueble.QInmueble inmueble;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<domainapp.modules.simple.dom.tipo_unidad.tipocaracteristica.TipoCaracteristicaRepositorio> tipoCaracteristicaRepositorio;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;

    public QImagen(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.url = new ObjectExpressionImpl<org.apache.isis.applib.value.Blob>(this, "url");
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        if (depth > 0)
        {
            this.inmueble = new domainapp.modules.simple.dom.inmueble.QInmueble(this, "inmueble", depth-1);
        }
        else
        {
            this.inmueble = null;
        }
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.tipoCaracteristicaRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.tipo_unidad.tipocaracteristica.TipoCaracteristicaRepositorio>(this, "tipoCaracteristicaRepositorio");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
    }

    public QImagen(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.url = new ObjectExpressionImpl<org.apache.isis.applib.value.Blob>(this, "url");
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.inmueble = new domainapp.modules.simple.dom.inmueble.QInmueble(this, "inmueble", 5);
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.tipoCaracteristicaRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.tipo_unidad.tipocaracteristica.TipoCaracteristicaRepositorio>(this, "tipoCaracteristicaRepositorio");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
    }
}
