package modelos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Samid Alexis Giraldo
 */
@Entity
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")
    , @NamedQuery(name = "Solicitud.findById", query = "SELECT s FROM Solicitud s WHERE s.id = :id")
    , @NamedQuery(name = "Solicitud.findByFechaHora", query = "SELECT s FROM Solicitud s WHERE s.fechaHora = :fechaHora")
    , @NamedQuery(name = "Solicitud.findByMontoDeseado", query = "SELECT s FROM Solicitud s WHERE s.montoDeseado = :montoDeseado")
    , @NamedQuery(name = "Solicitud.findByIngresosMenuales", query = "SELECT s FROM Solicitud s WHERE s.ingresosMenuales = :ingresosMenuales")
    , @NamedQuery(name = "Solicitud.findByObservaciones", query = "SELECT s FROM Solicitud s WHERE s.observaciones = :observaciones")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_deseado")
    private double montoDeseado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ingresos_menuales")
    private double ingresosMenuales;
    @Size(max = 1024)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "asesor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Asesor asesorId;
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente clienteId;
    @JoinColumn(name = "solicitud_estado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SolicitudEstado solicitudEstadoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudId")
    private Collection<Referencia> referenciaCollection;

    public Solicitud() {
    }

    public Solicitud(Integer id) {
        this.id = id;
    }

    public Solicitud(Integer id, Date fechaHora, double montoDeseado, double ingresosMenuales) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.montoDeseado = montoDeseado;
        this.ingresosMenuales = ingresosMenuales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getMontoDeseado() {
        return montoDeseado;
    }

    public void setMontoDeseado(double montoDeseado) {
        this.montoDeseado = montoDeseado;
    }

    public double getIngresosMenuales() {
        return ingresosMenuales;
    }

    public void setIngresosMenuales(double ingresosMenuales) {
        this.ingresosMenuales = ingresosMenuales;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Asesor getAsesorId() {
        return asesorId;
    }

    public void setAsesorId(Asesor asesorId) {
        this.asesorId = asesorId;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public SolicitudEstado getSolicitudEstadoId() {
        return solicitudEstadoId;
    }

    public void setSolicitudEstadoId(SolicitudEstado solicitudEstadoId) {
        this.solicitudEstadoId = solicitudEstadoId;
    }

    @XmlTransient
    public Collection<Referencia> getReferenciaCollection() {
        return referenciaCollection;
    }

    public void setReferenciaCollection(Collection<Referencia> referenciaCollection) {
        this.referenciaCollection = referenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Solicitud[ id=" + id + " ]";
    }

}
