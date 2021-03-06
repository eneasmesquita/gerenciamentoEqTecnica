/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Eneas
 */
@Entity
@Table(catalog = "corporativo", schema = "interior", name = "situacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Situacao.findAll", query = "SELECT s FROM Situacao s"),
    @NamedQuery(name = "Situacao.findById", query = "SELECT s FROM Situacao s WHERE s.id = :id"),
    @NamedQuery(name = "Situacao.findByDescricao", query = "SELECT s FROM Situacao s WHERE s.descricao = :descricao")})
public class Situacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descricao")
    private String descricao;
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "situacao")
    private Collection<HistoricoSituacao> historicoSituacaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "situacao")
    private Collection<SolicitacaoServico> solicitacaoServicoCollection;
    */

    public Situacao() {
    }

    public Situacao(Integer id) {
        this.id = id;
    }

    public Situacao(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /*
    @XmlTransient
    public Collection<HistoricoSituacao> getHistoricoSituacaoCollection() {
        return historicoSituacaoCollection;
    }

    public void setHistoricoSituacaoCollection(Collection<HistoricoSituacao> historicoSituacaoCollection) {
        this.historicoSituacaoCollection = historicoSituacaoCollection;
    }

    @XmlTransient
    public Collection<SolicitacaoServico> getSolicitacaoServicoCollection() {
        return solicitacaoServicoCollection;
    }

    public void setSolicitacaoServicoCollection(Collection<SolicitacaoServico> solicitacaoServicoCollection) {
        this.solicitacaoServicoCollection = solicitacaoServicoCollection;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Situacao)) {
            return false;
        }
        Situacao other = (Situacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Situacao[ id=" + id + " ]";
    }
    
}
