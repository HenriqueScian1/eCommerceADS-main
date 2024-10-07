package controller;

import database.Conexao;
import interfaces.Filtro;
import java.io.Serializable;
import java.sql.Connection;
import model.Usuario;

/**
 *
 * @author Victor
 */
public class LoginController implements Serializable {

    public Usuario buscarUsuarioParaLogar(String login, String senha) throws Exception {
        Connection c = Conexao.conectar();
        UsuarioController userController = new UsuarioController(null, null);

        try {

            Filtro f = () -> {
                String sql;
                sql = " where (usuario.email = '" + login + "' "
                        + "or usuario.cpf = '" + login + "') and usuario.senha = '" + senha + "'";
                return sql;
            };
            return userController.getObject(c, f);
        } finally {
            c.close();
        }

    }
}
