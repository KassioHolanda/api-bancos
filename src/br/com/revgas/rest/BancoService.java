package br.com.revgas.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.revgas.dao.BancoDAO;
import br.com.revgas.model.Banco;

@Path("/bancos")
public class BancoService {

	private BancoDAO bancoDAO;

	@PostConstruct
	private void init() {
		bancoDAO = new BancoDAO();
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Banco> recuperarBancos() {
		try {
			return bancoDAO.recuperarBancos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionarBanco(Banco banco) {
		String msg = "";

		System.out.println(banco.getNomeInstituicao());

		try {
			bancoDAO.adicionarBanco(banco);
			msg = "Banco inserido!";
		} catch (Exception e) {
			msg = "Erro ao adicionar!";
			e.printStackTrace();
		}

		return msg;
	}
	
	@GET
	@Path("/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Banco buscarPorId(@PathParam("id") long id) {		
		try {
			return bancoDAO.recuperarPorId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String atualizarBanco(Banco banco, @PathParam("id") long idBanco) {
		String msg = "";
		
		try {
			bancoDAO.atualizarBanco(banco, idBanco);

			msg = "Banco atualizado!";
		} catch (Exception e) {
			msg = "Erro ao atualizar!";
			e.printStackTrace();
		}

		return msg;
	}
	
	@GET
	@Path("/codigo/{codigo}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Banco buscarPorCodigo(@PathParam("codigo") int codigo) {		
		try {
			return bancoDAO.recuperarPorCodigoCompensacao(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String removerBanco(@PathParam("id") long idBanco) {
		String msg = "";

		try {
			bancoDAO.removerBanco(idBanco);

			msg = "Banco removido!";
		} catch (Exception e) {
			msg = "Erro ao remover banco!";
			e.printStackTrace();
		}

		return msg;
	}
	

}
