package domainapp.modules.simple.dom.tipo_operacion;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QTipoOperacion extends PersistableExpressionImpl<TipoOperacion> implements PersistableExpression<TipoOperacion>
{
    public static final QTipoOperacion jdoCandidate = candidate("this");

    public static QTipoOperacion candidate(String name)
    {
        return new QTipoOperacion(null, name, 5);
    }

    public static QTipoOperacion candidate()
    {
        return jdoCandidate;
    }

    public static QTipoOperacion parameter(String name)
    {
        return new QTipoOperacion(TipoOperacion.class, name, ExpressionType.PARAMETER);
    }

    public static QTipoOperacion variable(String name)
    {
        return new QTipoOperacion(TipoOperacion.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression descripcion;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<domainapp.modules.simple.dom.tipo_operacion.TipoOperacionRepositorio> tipoOperacionRepositorio;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;

    public QTipoOperacion(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.tipoOperacionRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.tipo_operacion.TipoOperacionRepositorio>(this, "tipoOperacionRepositorio");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
    }

    public QTipoOperacion(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.tipoOperacionRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.tipo_operacion.TipoOperacionRepositorio>(this, "tipoOperacionRepositorio");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
    }
}
