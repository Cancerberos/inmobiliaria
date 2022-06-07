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

    public final StringExpression descripcion;
    public final DateTimeExpression fechaExclusividad;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QInmueble(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.fechaExclusividad = new DateTimeExpressionImpl(this, "fechaExclusividad");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QInmueble(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.fechaExclusividad = new DateTimeExpressionImpl(this, "fechaExclusividad");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
