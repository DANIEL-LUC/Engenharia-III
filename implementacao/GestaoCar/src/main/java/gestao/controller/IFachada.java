package gestao.controller;

import java.sql.SQLException;

import gestao.dominio.EntidadeDominio;
import gestao.util.Resultado;


public interface IFachada {

	public Resultado salvar(EntidadeDominio entidade);
	public Resultado editar(EntidadeDominio entidade);
	public Resultado excluir(EntidadeDominio entidade) throws SQLException;
	public Resultado consultar(EntidadeDominio entidade);
	public Resultado visualizar(EntidadeDominio entidade);

}
