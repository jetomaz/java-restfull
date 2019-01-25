package br.com.tomazinformatica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.tomazinformatica.config.DbConfig;
import br.com.tomazinformatica.entidade.Nota;

public class NotaDAO{

    // Listando todas as Notas Cadastradas
	public List<Nota> listarNotas() throws Exception{
        List<Nota> lista = new ArrayList<>();

        Connection conexao = DbConfig.getConnection();

        String sql = "Select * from tb_nota";

        PreparedStatement statement = conexao.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Nota nota = new Nota();
            nota.setId(rs.getInt("ID"));
            nota.setTitulo(rs.getString("TITULO"));
            nota.setDescricao(rs.getString("DESCRICAO"));

            lista.add(nota);
            
        }
        return lista;
    }
    
    // buscando a nota por ID
    public Nota buscarNotaporID(int idNota) throws Exception {
    	Nota nota = null;
    	
    	Connection conexao = DbConfig.getConnection();
    	
    	String sql = "Select * from tb_nota where id = ?";
    	
    	PreparedStatement statement = conexao.prepareStatement(sql);
    	statement.setInt(1, idNota);
    	ResultSet rs = statement.executeQuery();
    	
    	if(rs.next()) {
    		nota = new Nota();
    		nota.setId(rs.getInt("ID"));
            nota.setTitulo(rs.getString("TITULO"));
            nota.setDescricao(rs.getString("DESCRICAO"));    		
    	}
    	return nota;
    }
    
    // inserindo uma nova nota
    public void addNota(Nota nota) throws Exception {
    	Connection conexao = DbConfig.getConnection();
    	
    	String sql = "insert into tb_nota(titulo, descricao) values (?,?)";
    	
    	PreparedStatement statement = conexao.prepareStatement(sql);
    	statement.setString(1, nota.getTitulo());
    	statement.setString(2, nota.getDescricao());
    	statement.execute();
    }
    
    //editando uma nota
    public void editarNota(Nota nota, int idNota) throws Exception {
    	Connection conexao = DbConfig.getConnection();
    	
    	String sql = "update tb_nota set titulo=?, descricao=? where id=?";
    	
    	PreparedStatement statement = conexao.prepareStatement(sql);
    	statement.setString(1, nota.getTitulo());
    	statement.setString(2, nota.getDescricao());
    	statement.setInt(3, idNota);
    	statement.execute();
    }
    
    //removendo uma nota
    public void removerNota(int idNota) throws Exception {
    	Connection conexao = DbConfig.getConnection();
    	
    	String sql = "delete from tb_nota where id=?";
    	
    	PreparedStatement statement = conexao.prepareStatement(sql);
    	statement.setInt(1, idNota);
    	statement.execute();
    }

}