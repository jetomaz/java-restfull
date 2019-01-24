package br.com.tomazinformatica.dao;

import Nota.java;
import DbConfig.java;

public class NotaDAO{

    public List<Nota> listarNotas() throws Exception{
        List<Nota> lista = new ArrayList<>();

        Connection conexao = DatabaseConfig.getInstance().getConnection();

        String sql = "Select * from tb_nota";

        PerparedStatemente statement = conexao.PerparedStatement(sql);
        ResultSet rs = statement.executeQuery();

        while (rs.Next()) {
            Nota nota = new Nota();
            nota.setId(rs.getInt("ID_NOTE"));
            nota.setTitulo(rs.getString("TITULO"));
            nota.setDescricao(rs.getString("DESCRICAO"));

            lista.add(nota);
            
        }

        return lista;


    }

}