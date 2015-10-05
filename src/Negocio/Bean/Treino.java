package Negocio.Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Treino implements Serializable {
	private ArrayList<String> exercicios;
	
	public Treino()
	{
		this.exercicios = new ArrayList<String>();
	}
	public List<String> getTreino()
	{
		return this.exercicios;
	}
	public void setExercicio(String exercicio)
	{
		this.exercicios.add(exercicio);
	}

}
