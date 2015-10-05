package Negocio.Bean;

import java.util.Date;

public class Dia {
	
	
	private Date data;
	private boolean presenca;
	private Treino treino;
	
	public Dia(Date data,boolean presenca,Treino treino)
	{
		this.data = data;
		this.presenca = presenca;
		this.treino = treino;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date d) {
		this.data = d;
	}

	public boolean getPresenca() {
		return presenca;
	}

	public void setPresenca(boolean presenca) {
		this.presenca = presenca;
	}

	public Treino getTreino() {
		return treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}
	
	

}
