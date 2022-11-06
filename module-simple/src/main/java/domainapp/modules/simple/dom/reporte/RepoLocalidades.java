package domainapp.modules.simple.dom.reporte;

import domainapp.modules.simple.dom.provincia.Provincia;

@lombok.Getter @lombok.Setter
public class RepoLocalidades {

   private  Provincia provincia;
   private  String descripcion;
   private  String codigoPostal;

    public RepoLocalidades( Provincia provincia,String descripcion, String codigoPostal) {
        this.provincia=provincia;
        this.descripcion = descripcion;
        this.codigoPostal = codigoPostal;
    }
    public RepoLocalidades(){}

    public Provincia getProvincia () {
        return provincia;
    }

    public String getDescripcion() {return descripcion;}

    public String getCodigoPostal() {
        return codigoPostal;
    }



}
