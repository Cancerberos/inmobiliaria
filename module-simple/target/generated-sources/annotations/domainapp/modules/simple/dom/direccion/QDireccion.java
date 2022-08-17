package domainapp.modules.simple.dom.direccion;

import javax.annotation.processing.Generated;
import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

@Generated(value="org.datanucleus.jdo.query.JDOQueryProcessor")
public class QDireccion extends PersistableExpressionImpl<Direccion> implements PersistableExpression<Direccion>
{
    public static final QDireccion jdoCandidate = candidate("this");

    public static QDireccion candidate(String name)
    {
        return new QDireccion(null, name, 5);
    }

    public static QDireccion candidate()
    {
        return jdoCandidate;
    }

    public static QDireccion parameter(String name)
    {
        return new QDireccion(Direccion.class, name, ExpressionType.PARAMETER);
    }

    public static QDireccion variable(String name)
    {
        return new QDireccion(Direccion.class, name, ExpressionType.VARIABLE);
    }

    public final domainapp.modules.simple.dom.localidad.QLocalidad localidad;
    public final StringExpression calle;
    public final NumericExpression<Integer> numero;
    public final StringExpression edificacion;
    public final StringExpression piso;
    public final StringExpression departamento;
    public final StringExpression latitud;
    public final StringExpression longitud;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QDireccion(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        if (depth > 0)
        {
            this.localidad = new domainapp.modules.simple.dom.localidad.QLocalidad(this, "localidad", depth-1);
        }
        else
        {
            this.localidad = null;
        }
        this.calle = new StringExpressionImpl(this, "calle");
        this.numero = new NumericExpressionImpl<Integer>(this, "numero");
        this.edificacion = new StringExpressionImpl(this, "edificacion");
        this.piso = new StringExpressionImpl(this, "piso");
        this.departamento = new StringExpressionImpl(this, "departamento");
        this.latitud = new StringExpressionImpl(this, "latitud");
        this.longitud = new StringExpressionImpl(this, "longitud");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QDireccion(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.localidad = new domainapp.modules.simple.dom.localidad.QLocalidad(this, "localidad", 5);
        this.calle = new StringExpressionImpl(this, "calle");
        this.numero = new NumericExpressionImpl<Integer>(this, "numero");
        this.edificacion = new StringExpressionImpl(this, "edificacion");
        this.piso = new StringExpressionImpl(this, "piso");
        this.departamento = new StringExpressionImpl(this, "departamento");
        this.latitud = new StringExpressionImpl(this, "latitud");
        this.longitud = new StringExpressionImpl(this, "longitud");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
