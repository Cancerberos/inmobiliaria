package domainapp.modules.simple.dom.estado_aviso;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QEstadoAviso extends PersistableExpressionImpl<EstadoAviso> implements PersistableExpression<EstadoAviso>
{
    public static final QEstadoAviso jdoCandidate = candidate("this");

    public static QEstadoAviso candidate(String name)
    {
        return new QEstadoAviso(null, name, 5);
    }

    public static QEstadoAviso candidate()
    {
        return jdoCandidate;
    }

    public static QEstadoAviso parameter(String name)
    {
        return new QEstadoAviso(EstadoAviso.class, name, ExpressionType.PARAMETER);
    }

    public static QEstadoAviso variable(String name)
    {
        return new QEstadoAviso(EstadoAviso.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression descripcion;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QEstadoAviso(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QEstadoAviso(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
