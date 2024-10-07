package dao;

import interfaces.DAOMySQL;
import model.Usuario;

/**
 *
 * @author Victor
 */
public class UsuarioDao extends DAOMySQL<Usuario> {

    @Override
    public Usuario getObject() throws Exception {
        String sql = "select * from ecommerceadsbd.usuario";
        sql += filtro != null ? filtro.getWhere() : "";
        return conversor.getObject(classeConexao.retornaRSMySQL(sql, getConexao()), 1);
    }

}
