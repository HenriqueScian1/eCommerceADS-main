package interfaces;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 * @param <T>
 */
public abstract class AbstractConversor<T> implements Serializable {

    private String alias;

    public final List<T> convert(ResultSet rs) throws Exception {
        List<T> lista = new ArrayList<>();

        while (rs.next()) {
            lista.add(getObject(rs));
        }

        return lista;
    }

    public final T getObject(ResultSet rs, Integer linha) throws Exception {
        if (rs.absolute(linha)) {
            return getObject(rs);
        }
        return null;
    }

    protected abstract T getObject(ResultSet rs) throws Exception;

    final Boolean contain(String coluna, ResultSet rs) {
        try {
            Integer findColumn = rs.findColumn(coluna);
            return !findColumn.equals(0);
        } catch (SQLException ex) {
            return false;
        }
    }

    protected final String getAlias() {
        if (alias == null) {
            alias = "";
        }
        return alias;
    }

    public final void setAlias(String alias) {
        this.alias = alias;
    }
}
