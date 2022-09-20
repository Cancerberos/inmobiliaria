package domainapp.modules.simple.dom.inmueble_caracteristica;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QInmuebleCaracteristica extends PersistableExpressionImpl<InmuebleCaracteristica> implements PersistableExpression<InmuebleCaracteristica>
{
    public static final QInmuebleCaracteristica jdoCandidate = candidate("this");

    public static QInmuebleCaracteristica candidate(String name)
    {
        return new QInmuebleCaracteristica(null, name, 5);
    }

    public static QInmuebleCaracteristica candidate()
    {
        return jdoCandidate;
    }

    public static QInmuebleCaracteristica parameter(String name)
    {
        return new QInmuebleCaracteristica(InmuebleCaracteristica.class, name, ExpressionType.PARAMETER);
    }

    public static QInmuebleCaracteristica variable(String name)
    {
        return new QInmuebleCaracteristica(InmuebleCaracteristica.class, name, ExpressionType.VARIABLE);
    }

    public final NumericExpression<Integer> cant;
    public final domainapp.modules.simple.dom.tipocaracteristica.QTipoCaracteristica tipoCaracteristica;
    public final domainapp.modules.simple.dom.inmueble.QInmueble inmueble;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<domainapp.modules.simple.dom.tipocaracteristica.TipoCaracteristicaRepositorio> tipoCaracteristicaRepositorio;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;

    public QInmuebleCaracteristica(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.cant = new NumericExpressionImpl<Integer>(this, "cant");
        if (depth > 0)
        {
            this.tipoCaracteristica = new domainapp.modules.simple.dom.tipocaracteristica.QTipoCaracteristica(this, "tipoCaracteristica", depth-1);
        }
        else
        {
            this.tipoCaracteristica = null;
        }
        if (depth > 0)
        {
            this.inmueble = new domainapp.modules.simple.dom.inmueble.QInmueble(this, "inmueble", depth-1);
        }
        else
        {
            this.inmueble = null;
        }
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.tipoCaracteristicaRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.tipocaracteristica.TipoCaracteristicaRepositorio>(this, "tipoCaracteristicaRepositorio");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
    }

    public QInmuebleCaracteristica(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.cant = new NumericExpressionImpl<Integer>(this, "cant");
        this.tipoCaracteristica = new domainapp.modules.simple.dom.tipocaracteristica.QTipoCaracteristica(this, "tipoCaracteristica", 5);
        this.inmueble = new domainapp.modules.simple.dom.inmueble.QInmueble(this, "inmueble", 5);
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.tipoCaracteristicaRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.tipocaracteristica.TipoCaracteristicaRepositorio>(this, "tipoCaracteristicaRepositorio");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
    }
}
