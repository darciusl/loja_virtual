package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

	@Id
	@GeneratedValue
	private Integer codPedido;

	@Column(name = "data")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	private String estado;

	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens;

	public Pedido() {
		itens = new ArrayList<ItemPedido>();
	}

	public Pedido(Integer codPedido, String estado, Date data, List<ItemPedido> itens) {
		this.codPedido = codPedido;
		this.estado = estado;
		this.data = data;
		this.itens = itens;
	}

	public Integer getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codPedido == null) ? 0 : codPedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (codPedido == null) {
			if (other.codPedido != null)
				return false;
		} else if (!codPedido.equals(other.codPedido))
			return false;
		return true;
	}
}
