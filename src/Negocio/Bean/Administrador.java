package Negocio.Bean;

import java.io.Serializable;

public class Administrador extends Pessoa implements Serializable {


	public Administrador(String Nome, String Login, String Senha, int idade,
			String CPF) {
		super(Nome, Login, Senha, CPF, idade);
		

	}

	

	@Override
	public boolean equals(Object o) {
		if ((o instanceof Administrador)
				&& ((Administrador) o).getNome().equals(this.getNome())
				&& ((Administrador) o).getLogin().equals(this.getLogin())) {
			return true;
		}
		return false;
	}

}
