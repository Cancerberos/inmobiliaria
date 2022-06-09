package domainapp.modules.simple.dom.aviso;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QAviso extends PersistableExpressionImpl<Aviso> implements PersistableExpression<Aviso>
{
    public static final QAviso jdoCandidate = candidate("this");

    public static QAviso candidate(String name)
    {
        return new QAviso(null, name, 5);
    }

    public static QAviso candidate()
    {
        return jdoCandidate;
    }

    public static QAviso parameter(String name)
    {
        return new QAviso(Aviso.class, name, ExpressionType.PARAMETER);
    }

    public static QAviso variable(String name)
    {
        return new QAviso(Aviso.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression descripcion;
    public final domainapp.modules.simple.dom.inmueble.QInmueble inmueble;
    public final NumericExpression<Double> valor;
    public final domainapp.modules.simple.dom.tipo_operacion.QTipoOperacion tipoOperacion;
    public final ObjectExpression<org.joda.time.DateTime> fecInicio;
    public final ObjectExpression<org.joda.time.DateTime> fecFin;
    public final domainapp.modules.simple.dom.estado_aviso.QEstadoAviso estadoAviso;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QAviso(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        if (depth > 0)
        {
            this.inmueble = new domainapp.modules.simple.dom.inmueble.QInmueble(this, "inmueble", depth-1);
        }
        else
        {
            this.inmueble = null;
        }
        this.valor = new NumericExpressionImpl<Double>(this, "valor");
        if (depth > 0)
        {
            this.tipoOperacion = new domainapp.modules.simple.dom.tipo_operacion.QTipoOperacion(this, "tipoOperacion", depth-1);
        }
        else
        {
            this.tipoOperacion = null;
        }
        this.fecInicio = new ObjectExpressionImpl<org.joda.time.DateTime>(this, "fecInicio");
        this.fecFin = new ObjectExpressionImpl<org.joda.time.DateTime>(this, "fecFin");
        if (depth > 0)
        {
            this.estadoAviso = new domainapp.modules.simple.dom.estado_aviso.QEstadoAviso(this, "estadoAviso", depth-1);
        }
        else
        {
            this.estadoAviso = null;
        }
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QAviso(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.inmueble = new domainapp.modules.simple.dom.inmueble.QInmueble(this, "inmueble", 5);
        this.valor = new NumericExpressionImpl<Double>(this, "valor");
        this.tipoOperacion = new domainapp.modules.simple.dom.tipo_operacion.QTipoOperacion(this, "tipoOperacion", 5);
        this.fecInicio = new ObjectExpressionImpl<org.joda.time.DateTime>(this, "fecInicio");
        this.fecFin = new ObjectExpressionImpl<org.joda.time.DateTime>(this, "fecFin");
        this.estadoAviso = new domainapp.modules.simple.dom.estado_aviso.QEstadoAviso(this, "estadoAviso", 5);
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
