package testes;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import domain.Marca;
import dao.IMarcaDAO;
import dao.MarcaDAO;

public class MarcaTest {
	
	private IMarcaDAO marcaDAO;
	
	public MarcaTest() {
		marcaDAO = new MarcaDAO();
	}
	
	@Test
	public void cadastrar() {
		Marca marca = new Marca();
		marca.setCodigo("M1");
		marca.setNome("Marca 1");
		marca.setFabricante("Fabricante 1");
		marcaDAO.cadastrar(marca);
		
		assertNotNull(marca);
		assertNotNull(marca.getId());
		
	}

}
