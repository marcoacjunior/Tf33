package testes;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import domain.Acessorio;
import domain.Carro;
import domain.Marca;
import dao.AcessorioDAO;
import dao.CarroDAO;
import dao.IAcessorioDAO;
import dao.ICarroDAO;
import dao.IMarcaDAO;
import dao.MarcaDAO;

public class CarroTest {

	private ICarroDAO carroDAO;
	
	private IMarcaDAO marcaDAO;
	
	private IAcessorioDAO acessorioDAO;
	
	public CarroTest() {
		carroDAO = new CarroDAO();
		marcaDAO = new MarcaDAO();
		acessorioDAO = new AcessorioDAO();
	}
	
	@Test
	public void cadastrar() {
		Marca marca = criarMarca("M1");
		Acessorio acessorio = criarAcessorio("A1");
		Carro carro = new Carro();
		carro.setCodigo("C1");
		carro.setNome("Nomedocarro 1");
		carro.setModelo("Modelo 1");
		carro.setMarca(marca);
		carro.setAcessorio(acessorio);
		acessorio.setCarro(carro);
		carroDAO.cadastrar(carro);
		
		assertNotNull(carro);
		assertNotNull(carro.getId());
		
	}
	
	private Acessorio criarAcessorio(String codigo) {
		Acessorio acessorio = new Acessorio();
		acessorio.setCodigo("A1");
		acessorio.setNome("Pneu");
		acessorio.setDescricao("Modelos 2021, 2020 e 2019");
		return acessorioDAO.cadastrar(acessorio);
	}
	
	private Marca criarMarca(String codigo) {
		Marca marca = new Marca();
		marca.setCodigo("M1");
		marca.setNome("Marca 1");
		marca.setFabricante("Fabricante 1");
		return marcaDAO.cadastrar(marca);
		
	}

}
