package domainapp.modules.simple.dom.provincia;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QProvincia extends PersistableExpressionImpl<Provincia> implements PersistableExpression<Provincia>
{
    public static final QProvincia jdoCandidate = candidate("this");

    public static QProvincia candidate(String name)
    {
        return new QProvincia(null, name, 5);
    }

    public static QProvincia candidate()
    {
        return jdoCandidate;
    }

    public static QProvincia parameter(String name)
    {
        return new QProvincia(Provincia.class, name, ExpressionType.PARAMETER);
    }

    public static QProvincia variable(String name)
    {
        return new QProvincia(Provincia.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression descripcion;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;
    public final ObjectExpression<domainapp.modules.simple.dom.localidad.LocalidadRepositorio> localidadRepositorio;
    public final ObjectExpression<domainapp.modules.simple.dom.provincia.ProvinciaRepositorio> provinciaRepositorio;

    public QProvincia(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.localidadRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.localidad.LocalidadRepositorio>(this, "localidadRepositorio");
        this.provinciaRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.provincia.ProvinciaRepositorio>(this, "provinciaRepositorio");
    }

    public QProvincia(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.localidadRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.localidad.LocalidadRepositorio>(this, "localidadRepositorio");
        this.provinciaRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.provincia.ProvinciaRepositorio>(this, "provinciaRepositorio");
    }
}
