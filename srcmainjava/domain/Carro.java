package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CARRO")
public class Carro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carro_seq")
	@SequenceGenerator(name="carro_seq", sequenceName="sq_carro", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column (name = "CODIGO", length = 10, nullable = false, unique = true)
	private String codigo;

	@Column (name = "NOME", length = 50, nullable = false)
	private String nome;
	
	@Column (name = "MODELO", length = 50)
	private String modelo;
	
	@ManyToOne
	@JoinColumn(name = "id_marca_fk", 
		foreignKey = @ForeignKey(name = "fk_acessorio_carro"), 
		referencedColumnName = "id", nullable = false
	)
	
	private Marca marca;
	
	@OneToOne
	@JoinColumn(name = "id_acessorio_fk", 
	foreignKey = @ForeignKey(name = "fk_marca_carro"), 
	referencedColumnName = "id", nullable = false
)	
	private Acessorio acessorio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Acessorio getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}
	
	

}
