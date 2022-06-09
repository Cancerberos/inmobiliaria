package domainapp.modules.simple.dom.inmueble;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QInmueble extends PersistableExpressionImpl<Inmueble> implements PersistableExpression<Inmueble>
{
    public static final QInmueble jdoCandidate = candidate("this");

    public static QInmueble candidate(String name)
    {
        return new QInmueble(null, name, 5);
    }

    public static QInmueble candidate()
    {
        return jdoCandidate;
    }

    public static QInmueble parameter(String name)
    {
        return new QInmueble(Inmueble.class, name, ExpressionType.PARAMETER);
    }

    public static QInmueble variable(String name)
    {
        return new QInmueble(Inmueble.class, name, ExpressionType.VARIABLE);
    }

    public final domainapp.modules.simple.dom.cliente.QCliente cliente;
    public final StringExpression descripcion;
    public final DateTimeExpression fechaExclusividad;
    public final domainapp.modules.simple.dom.tipo_unidad.QTipoUnidad tipoUnidad;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QInmueble(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        if (depth > 0)
        {
            this.cliente = new domainapp.modules.simple.dom.cliente.QCliente(this, "cliente", depth-1);
        }
        else
        {
            this.cliente = null;
        }
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.fechaExclusividad = new DateTimeExpressionImpl(this, "fechaExclusividad");
        if (depth > 0)
        {
            this.tipoUnidad = new domainapp.modules.simple.dom.tipo_unidad.QTipoUnidad(this, "tipoUnidad", depth-1);
        }
        else
        {
            this.tipoUnidad = null;
        }
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QInmueble(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.cliente = new domainapp.modules.simple.dom.cliente.QCliente(this, "cliente", 5);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.fechaExclusividad = new DateTimeExpressionImpl(this, "fechaExclusividad");
        this.tipoUnidad = new domainapp.modules.simple.dom.tipo_unidad.QTipoUnidad(this, "tipoUnidad", 5);
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
