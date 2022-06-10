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

    public final domainapp.modules.simple.dom.caracteristica.QCaracteristica caracteristica;
    public final domainapp.modules.simple.dom.inmueble.QInmueble inmueble;
    public final NumericExpression<Integer> cantidad;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QInmuebleCaracteristica(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        if (depth > 0)
        {
            this.caracteristica = new domainapp.modules.simple.dom.caracteristica.QCaracteristica(this, "caracteristica", depth-1);
        }
        else
        {
            this.caracteristica = null;
        }
        if (depth > 0)
        {
            this.inmueble = new domainapp.modules.simple.dom.inmueble.QInmueble(this, "inmueble", depth-1);
        }
        else
        {
            this.inmueble = null;
        }
        this.cantidad = new NumericExpressionImpl<Integer>(this, "cantidad");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QInmuebleCaracteristica(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.caracteristica = new domainapp.modules.simple.dom.caracteristica.QCaracteristica(this, "caracteristica", 5);
        this.inmueble = new domainapp.modules.simple.dom.inmueble.QInmueble(this, "inmueble", 5);
        this.cantidad = new NumericExpressionImpl<Integer>(this, "cantidad");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
