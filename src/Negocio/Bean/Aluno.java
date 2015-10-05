package Negocio.Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Negocio.Bean.Dia;

public class Aluno extends Pessoa implements Serializable {
	private int matricula;
	private Professor professor;
	private List<Treino> padraoDeTreino;
	private ArrayList<Dia> dias;
	private int faltas;

	public Aluno(String Nome, String Login, String Senha, int idade, String CPF, int Matricula, Professor professor, List<Treino> padraoDeTreino) {
		super(Nome, Login, Senha, CPF, idade);
		this.matricula = Matricula;
		this.professor = professor;
		this.padraoDeTreino = padraoDeTreino;
		this.dias = new ArrayList<Dia>();
		this.faltas = 0;
	}

	public int getMatricula() {
		return this.matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public List<Treino> getPadraoDeTreino() {
		return padraoDeTreino;
	}
	public void setPadraoDeTreino(List<Treino> padraoDeTreino) {
		this.padraoDeTreino = padraoDeTreino;
	}
	public List<Dia> getDias()
	{
	    return this.dias;
	}
	public void setDia(Dia dia)
	{
		this.dias.add(dia);
	}
	public  Dia getUltimoDia()
	{
		Dia dia = null;
		for(int i = dias.size(); i>0 ;i--)
		{
			if(!(dias.get(i).getTreino().equals(null)) && dias.get(i).getPresenca() == true)
			{
				 dia = dias.get(i);
			}
		}
		return dia;
	}

	@Override
	public boolean equals(Object o) {
		if ((o instanceof Aluno)
				&& ((Aluno) o).getNome().equals(this.getNome())
				&& ((Aluno) o).getLogin().equals(this.getLogin())
				&& ((Aluno) o).getMatricula() == this.matricula) {
			return true;
		}
		return false;
	}
	

}
