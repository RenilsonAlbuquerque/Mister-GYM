package Dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Excecoes.RepositorioException;
import Excecoes.TreinoJaExisteException;
import Excecoes.TreinoNaoExisteException;
import Excecoes.TreinosNaoCadastradosException;
import Negocio.Bean.Treino;

public class RepositorioTreinoArray {
	private List<Treino> treinos;

	public RepositorioTreinoArray() throws ClassNotFoundException, TreinoJaExisteException, RepositorioException, IOException
	{
		this.treinos = new ArrayList<Treino>();
		if(new File("treinos.dat").canRead() == true)
		{
			this.lerArquivo();
		}
		else
		{
			this.salvarArquivo();
		}
	}
	private void lerArquivo() throws ClassNotFoundException, TreinoJaExisteException, RepositorioException
	{
		if(new File("treinos.dat").canRead() == true)
		{
			FileInputStream inc;
			try 
			{
				inc = new FileInputStream("treinos.dat");
				ObjectInputStream ois = new ObjectInputStream(inc);
				
				ArrayList <Treino> treino = (ArrayList <Treino>) ois.readObject();
				for(int i = 0; i< treino.size(); i++)
				{
					this.treinos.add(treino.get(i));
				}
				System.out.println("Treinos Carregados");
			} 
			catch (IOException | ClassNotFoundException e) 
			{
				System.out.println(e.getMessage());
			} 
	     }
     }
	private void salvarArquivo() throws IOException  
	{
		try
		{
			FileOutputStream FOS = new FileOutputStream("treinos.dat");
			ObjectOutputStream OUS = new ObjectOutputStream(FOS);
			
			OUS.writeObject(treinos);
			OUS.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
	private int procurarIndice(Treino treino)
	{
		int indice = -1;

		for (int i = 0; i < this.treinos.size(); i++) 
		{
			if (this.treinos.get(i).equals(treino)) 
			{
				indice = i;
			}
		}
		return indice;
	}
	public void cadastrarTreino(Treino treino) throws IOException, TreinoJaExisteException
	{
		int indice = this.procurarIndice(treino);
        if (indice == -1)
	     throw new TreinoJaExisteException("O Treino já está cadastrado");
        else
        {
          this.treinos.add(treino);
          this.salvarArquivo();
        }
	}
	public void excluirTreino(Treino treino) throws TreinoNaoExisteException, IOException
	{
		if(treino.equals(null))
		{
			throw new TreinoNaoExisteException("O treino não existe");
		}
		else
		{
		  this.treinos.remove(treino);
		  this.salvarArquivo();
		}
	}
	public void alterarTreino(Treino treino) throws RepositorioException,TreinoNaoExisteException, IOException 
	{
           int indice = this.procurarIndice(treino);
           if (indice == -1)
	     throw new TreinoNaoExisteException("O treino não existe");
           else
           {
             this.treinos.set(indice, treino);
             this.salvarArquivo();
           }
     }
	public Treino existe(Treino treino)
	{
		Treino resultado = null;
		for (int i = 0; i < this.treinos.size(); i++) 
		{
			if (this.treinos.get(i).equals(treino)) 
			{
				resultado = this.treinos.get(i);
			}
		}
		return resultado;
	}
	public List<Treino> listarTreinos() throws TreinosNaoCadastradosException
	{
		if(this.treinos.isEmpty())
		{
			throw new TreinosNaoCadastradosException("Não existem Treinos Cadastrados");
		}	
		else
		{
			return this.treinos;	
		}
	}

}
