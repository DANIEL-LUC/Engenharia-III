package gestao.dominio;

public abstract class EntidadeDominio {

	private int id;

	private long dtCadastro;
	
//	public EntidadeDominio(int id, long data) {
//		this.dtCadastro = data;
//		this.id = id;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(long dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
	

}
