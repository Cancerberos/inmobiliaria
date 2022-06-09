package domainapp.modules.simple.dom.estado_aviso;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QEstado_Aviso extends PersistableExpressionImpl<Estado_Aviso> implements PersistableExpression<Estado_Aviso>
{
    public static final QEstado_Aviso jdoCandidate = candidate("this");

    public static QEstado_Aviso candidate(String name)
    {
        return new QEstado_Aviso(null, name, 5);
    }

    public static QEstado_Aviso candidate()
    {
        return jdoCandidate;
    }

    public static QEstado_Aviso parameter(String name)
    {
        return new QEstado_Aviso(Estado_Aviso.class, name, ExpressionType.PARAMETER);
    }

    public static QEstado_Aviso variable(String name)
    {
        return new QEstado_Aviso(Estado_Aviso.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression descripcion;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QEstado_Aviso(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QEstado_Aviso(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
