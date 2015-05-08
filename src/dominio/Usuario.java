package dominio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer cod_usuario;

	private String nome;
	private String email;
	private String senha;
	private boolean ativo;

	@ElementCollection(targetClass = String.class)
	@JoinTable(name = "usuario_permissao", uniqueConstraints = { @UniqueConstraint(columnNames = {
			"usuario", "permissao" }) }, joinColumns = @JoinColumn(name = "usuario"))
	@Column(name = "permissao", length = 50)
	private Set<String> permissoes = new HashSet<String>();

	public Integer getCod_usuario() {
		return cod_usuario;
	}

	public void setCod_usuario(Integer cod_usuario) {
		this.cod_usuario = cod_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Set<String> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Set<String> permissoes) {
		this.permissoes = permissoes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}