package domainapp.modules.simple.dom.imagenes;

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

    public final StringExpression url;
    public final StringExpression descripcion;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QImagen(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.url = new StringExpressionImpl(this, "url");
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QImagen(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.url = new StringExpressionImpl(this, "url");
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
