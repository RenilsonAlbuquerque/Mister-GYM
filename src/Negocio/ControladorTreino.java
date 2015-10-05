package Negocio;

import java.io.IOException;
import java.util.List;

import Dados.RepositorioTreinoArray;
import Excecoes.RepositorioException;
import Excecoes.TreinoJaExisteException;
import Excecoes.TreinoNaoExisteException;
import Excecoes.TreinosNaoCadastradosException;
import Negocio.Bean.Treino;

public class ControladorTreino {
	
	private RepositorioTreinoArray repositorio;
	
	public ControladorTreino() throws ClassNotFoundException,RepositorioException, TreinoJaExisteException, IOException 
	{
		this.repositorio = new RepositorioTreinoArray();
	}
	public void cadastrarTreino(Treino treino) throws IOException, TreinoJaExisteException
	{
		this.repositorio.cadastrarTreino(treino);
	}
	public void removerTreino(Treino treino) throws TreinoNaoExisteException, IOException
	{
		this.repositorio.excluirTreino(treino);
	}
	public void alterarTreino(Treino treino) throws RepositorioException, TreinoNaoExisteException, IOException
	{
		this.repositorio.alterarTreino(treino);
	}
	public List<Treino> listarTreinos() throws TreinosNaoCadastradosException
	{
		return this.repositorio.listarTreinos();
	}

}
