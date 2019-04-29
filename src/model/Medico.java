package model;

public class Medico {

	private Long id;
	private String nome;
	private String cpf;
	private String sexo;
	private String especialidade;
	private String crm;
	private TelefoneMedico telefoneMedico;
	private EnderecoMedico enderecoMedico;

	public Medico() {
	}

	public Medico(String nome, String cpf, String sexo, String especialidade, String crm) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.especialidade = especialidade;
		this.crm = crm;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public TelefoneMedico getTelefoneMedico() {
		return telefoneMedico;
	}

	public void setTelefoneMedico(TelefoneMedico telefoneMedico) {
		this.telefoneMedico = telefoneMedico;
	}

	public EnderecoMedico getEnderecoMedico() {
		return enderecoMedico;
	}

	public void setEnderecoMedico(EnderecoMedico enderecoMedico) {
		this.enderecoMedico = enderecoMedico;
	}

}
