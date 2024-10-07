package database;

import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class Conexao implements Serializable {

    private static final String ipServidorWebPRODUCAO = "localhost";


    ////------------------------------------------------------------------------
    //// TO-DO
    static {
        try {
            System.out.println("Conexão banco eCommerceADS-Driver");
            Class.forName("com.mysql.jddbc.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean isDebug() {
        return ManagementFactory.getRuntimeMXBean().getInputArguments().stream().anyMatch(arg -> arg.contains("jdwp="));
    }

    public static Connection conectar() {
        ConnectionEcommerce c;
        try {
            c = new ConnectionEcommerce(DriverManager.getConnection("jdbc:mysql://" + ipServidorWebPRODUCAO + "/ecommerceadsbd?useSSL=false", "root", ""));
            return c;

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet retornaRSMySQL(String sql, Connection c) throws Exception {
        if (c == null) {
            throw new Exception("Conexão fechada em retornaRS");
        }

        sql = sql.replace("%\"", "");
        sql = sql.replace("\"%", "");

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(sql);

        return rs;
    }

    public void executarSql(String sql, Connection c) throws Exception {
        List<String> list = new ArrayList<>();
        list.add(sql);
        executarSql(list, c);
    }

    public void executarSql(List<String> listaSql, Connection c) throws Exception {
        Boolean fecharConexao = false;

        if (c == null) {
            fecharConexao = true;
            c = Conexao.conectar();
        }

        boolean testCommit = c.getAutoCommit();
        Integer count = 0;

        if (testCommit == true) {
            c.setAutoCommit(false);
        }

        PreparedStatement ps = null;
        try {
            for (String s : listaSql) {
                ps = c.prepareStatement(s);
                ps.executeUpdate();
                count++;
            }
            c.commit();
        } catch (SQLException ex) {
            c.rollback();
            System.out.println("Exception no executar lista de sql\n" + listaSql.get(count));
            System.out.println(ex);
        } finally {
            if (testCommit) {
                c.setAutoCommit(true);
            }

            if (fecharConexao == true) {
                c.close();
            }
        }
    }
}
