package Negocio;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import Dados.RepositorioAlunoArray;
import Excecoes.RepositorioException;
import Excecoes.UsuarioJaExisteException;
import Excecoes.UsuarioNaoExisteException;
import Excecoes.UsuariosNaoCadastradosException;
import Negocio.Bean.Aluno;
import Negocio.Bean.Dia;
import Negocio.Bean.Treino;


public class ControladorAluno {

	private RepositorioAlunoArray repositorio;
	
	public ControladorAluno() throws ClassNotFoundException,RepositorioException, UsuarioJaExisteException, IOException 
	{
		this.repositorio = new RepositorioAlunoArray();
	}
	public void cadastrarAluno(Aluno aluno) throws IOException, UsuarioJaExisteException
	{
		this.repositorio.cadastrarAluno(aluno);
	}
	public void removerAluno(Aluno aluno) throws UsuarioNaoExisteException, IOException
	{
		this.repositorio.excluirAluno(aluno);
	}
	public void alterarAluno(Aluno aluno) throws RepositorioException, UsuarioNaoExisteException, IOException
	{
		this.repositorio.alterarAluno(aluno);
	}
	public List<Aluno> listarAlunos() throws UsuariosNaoCadastradosException
	{
		return this.repositorio.listarAlunos();
	}
	public Aluno existe(Aluno aluno)
	{
		return this.repositorio.existe(aluno);
	}
	public void colocarPresenca(Aluno aluno,Treino treino)
	{
		Dia dia;
		Date d = new Date(System.currentTimeMillis());
		if(treino == null)
		{
			dia = new Dia(d,false,null);
			aluno.setDia(dia);
		}
		else
		{
         dia = new Dia(d,true,treino);
         aluno.setDia(dia); 
		}
	}
	public Treino treinodeHoje(Aluno aluno)
	{
		Treino treino = aluno.getPadraoDeTreino().get(1);
		 for(int i = 0; i < aluno.getPadraoDeTreino().size();i++)
		 {
			 if(aluno.getUltimoDia().getTreino().equals(aluno.getPadraoDeTreino().get(i)))
			 {
				 if(i++ > aluno.getPadraoDeTreino().size())
				 {
					treino = aluno.getPadraoDeTreino().get(1); 
				 }
				 else
				 {
				    treino = aluno.getPadraoDeTreino().get(i++);
				 }
			 }
		 }
		 return treino;
	}
	public void colocarFaltas(Aluno aluno){
	   
	}
	
}
