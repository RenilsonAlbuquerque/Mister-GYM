package Negocio;

import java.io.IOException;
import java.util.List;

import Excecoes.RepositorioException;
import Excecoes.TreinoJaExisteException;
import Excecoes.TreinoNaoExisteException;
import Excecoes.TreinosNaoCadastradosException;
import Excecoes.UsuarioJaExisteException;
import Excecoes.UsuarioNaoExisteException;
import Excecoes.UsuariosNaoCadastradosException;
import Negocio.Bean.Aluno;
import Negocio.Bean.Professor;
import Negocio.Bean.Treino;

public class Fachada {
	
	private static Fachada fachada = null;
	private ControladorAluno aluno;
	private ControladorProfessor professor;
	private ControladorTreino treino;

	private Fachada() throws ClassNotFoundException, RepositorioException, UsuarioJaExisteException, IOException, TreinoJaExisteException
	{
		this.aluno = new ControladorAluno();
		this.professor = new ControladorProfessor();
		this.treino = new ControladorTreino();
	}
	public static Fachada getInstance() throws ClassNotFoundException, RepositorioException, UsuarioJaExisteException, IOException, TreinoJaExisteException
	{
		if(Fachada.fachada == null)
		{
			Fachada.fachada = new Fachada();
		}
	    return Fachada.fachada;
	}
	public void cadastrarAluno(Aluno aluno) throws IOException, UsuarioJaExisteException
	{
		this.aluno.cadastrarAluno(aluno);
	}
	public void removerAluno(Aluno aluno) throws UsuarioNaoExisteException, IOException
	{
		this.aluno.removerAluno(aluno);
	}
	public void alterarAluno(Aluno aluno) throws RepositorioException, UsuarioNaoExisteException, IOException
	{
		this.aluno.alterarAluno(aluno);
	}
	public List<Aluno> listarAlunos() throws UsuariosNaoCadastradosException
	{
		return this.aluno.listarAlunos();
	}
	public Treino treinoDeHoje(Aluno aluno)
	{
		return this.aluno.treinodeHoje(aluno);
	}
	public void cadastrarProfessor(Professor professor) throws IOException, UsuarioJaExisteException
	{
		this.professor.cadastrarProfessor(professor);
	}
	public void removerProfessor(Professor professor) throws UsuarioNaoExisteException, IOException
	{
		this.professor.removerProfessor(professor);
	}
	public void alterarProfessor(Professor professor) throws RepositorioException, UsuarioNaoExisteException, IOException
	{
		this.professor.alterarProfessor(professor);
	}
	public List<Professor> listarPorfessores() throws UsuariosNaoCadastradosException
	{
		return this.professor.listarProfessores();
	}
	public void adcionarPadraoDeTreino(Aluno aluno,List<Treino> padraoDeTreino) throws RepositorioException, UsuarioNaoExisteException, IOException
	{
		this.professor.criarPadraoDeTreino(aluno, padraoDeTreino);
	}
	public void cadastrarTreino(Treino treino) throws IOException, TreinoJaExisteException
	{
		this.treino.cadastrarTreino(treino);
	}
	public void removerTreino(Treino treino) throws TreinoNaoExisteException, IOException
	{
		this.treino.removerTreino(treino);
	}
	public void alterarTreino(Treino treino) throws RepositorioException, TreinoNaoExisteException, IOException
	{
		this.treino.alterarTreino(treino);
	}
	public List<Treino> listarTreinos() throws TreinosNaoCadastradosException
	{
		return this.treino.listarTreinos();
	}
}
