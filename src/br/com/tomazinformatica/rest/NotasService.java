package br.com.tomazinformatica.rest;

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

import br.com.tomazinformatica.dao.NotaDAO;
import br.com.tomazinformatica.entidade.Nota;

// servico que vai mandar e receber dados pro cliente PostMan
// e interagir com o DAO
@Path("/notas")
public class NotasService {
	private NotaDAO notaDAO;
	
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	@PostConstruct
	private void init() {
		notaDAO = new NotaDAO();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Nota> listarNotas(){
		List<Nota> lista=null;
		try {
			lista = notaDAO.listarNotas();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String addNota(Nota nota){
		String msg="";
		try {
			notaDAO.addNota(nota);
			msg = "Nota Adicionada com Sucesso!";
		}catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao Add a Nota!";
		}
		return msg;
	}
	
	@GET
	@Path("/get/{id}")	
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Nota buscarPorID(@PathParam("id") int idNota){
		Nota nota=null;
		try {
			nota = notaDAO.buscarNotaporID(idNota);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return nota;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String editarNota(Nota nota, @PathParam("id") int idNota){
		String msg="";
		//nota.setId(idNota); // Setando o ID que veio na URL para identificar a nota a ser editada
		try {
			notaDAO.editarNota(nota, idNota);
			msg = "Nota editada com Sucesso!";
		}catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao editar a Nota!";
		}
		return msg;
	}
	
	@DELETE
	@Path("/delete/{id}")	
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletarPorID(@PathParam("id") int idNota){
		String msg="";
		try {
			notaDAO.removerNota(idNota);
			msg = "Nota deletada com Sucesso!";
		}catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao deletar Nota!";
		}
		return msg;
	}
	
	
}
