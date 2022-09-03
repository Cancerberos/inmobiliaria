package domainapp.modules.simple.dom.localidad;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QLocalidad extends PersistableExpressionImpl<Localidad> implements PersistableExpression<Localidad>
{
    public static final QLocalidad jdoCandidate = candidate("this");

    public static QLocalidad candidate(String name)
    {
        return new QLocalidad(null, name, 5);
    }

    public static QLocalidad candidate()
    {
        return jdoCandidate;
    }

    public static QLocalidad parameter(String name)
    {
        return new QLocalidad(Localidad.class, name, ExpressionType.PARAMETER);
    }

    public static QLocalidad variable(String name)
    {
        return new QLocalidad(Localidad.class, name, ExpressionType.VARIABLE);
    }

    public final domainapp.modules.simple.dom.provincia.QProvincia provincia;
    public final StringExpression descripcion;
    public final StringExpression codigoPostal;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;
    public final ObjectExpression<domainapp.modules.simple.dom.localidad.LocalidadRepositorio> localidadRepositorio;
    public final ObjectExpression<domainapp.modules.simple.dom.provincia.ProvinciaRepositorio> provinciaRepositorio;
    public final ObjectExpression<org.apache.isis.applib.services.wrapper.WrapperFactory> wrapperFactory;

    public QLocalidad(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        if (depth > 0)
        {
            this.provincia = new domainapp.modules.simple.dom.provincia.QProvincia(this, "provincia", depth-1);
        }
        else
        {
            this.provincia = null;
        }
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.codigoPostal = new StringExpressionImpl(this, "codigoPostal");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.localidadRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.localidad.LocalidadRepositorio>(this, "localidadRepositorio");
        this.provinciaRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.provincia.ProvinciaRepositorio>(this, "provinciaRepositorio");
        this.wrapperFactory = new ObjectExpressionImpl<org.apache.isis.applib.services.wrapper.WrapperFactory>(this, "wrapperFactory");
    }

    public QLocalidad(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.provincia = new domainapp.modules.simple.dom.provincia.QProvincia(this, "provincia", 5);
        this.descripcion = new StringExpressionImpl(this, "descripcion");
        this.codigoPostal = new StringExpressionImpl(this, "codigoPostal");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
        this.localidadRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.localidad.LocalidadRepositorio>(this, "localidadRepositorio");
        this.provinciaRepositorio = new ObjectExpressionImpl<domainapp.modules.simple.dom.provincia.ProvinciaRepositorio>(this, "provinciaRepositorio");
        this.wrapperFactory = new ObjectExpressionImpl<org.apache.isis.applib.services.wrapper.WrapperFactory>(this, "wrapperFactory");
    }
}
