package controller;

import dao.UsuarioDao;
import database.Paginacao;
import interfaces.Filtro;
import java.io.Serializable;
import java.sql.Connection;
import model.Usuario;

/**
 *
 * @author Victor
 */
public class UsuarioController implements Serializable{

    private final UsuarioDao dao;

    public UsuarioController(Filtro filtro, Paginacao paginacao) {
        dao = new UsuarioDao();
        dao.setFiltro(filtro);
        dao.setPaginacao(paginacao);
    }

    public Usuario getObject(Connection c, Filtro filtro) throws Exception {
        Boolean fecharConexao = dao.criarConexao(c);
        try {
            dao.setFiltro(filtro);
            return dao.getObject();
        } finally {
            if (fecharConexao) {
                dao.fecharConexao();
            }
        }
    }
}
