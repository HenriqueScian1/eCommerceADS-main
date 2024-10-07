package database;

import conversor.Conversor;
import interfaces.AbstractConversor;

/**
 *
 * @author Victor
 */
public class FactoryConversor {

    public AbstractConversor fabricarConversor(Class<? extends Object> t) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String nomeDaClasse = "";
        if (t.isAnnotationPresent(Conversor.class)) {
            Conversor c = t.getAnnotation(Conversor.class);
            if (!c.nome().isEmpty()) {
                nomeDaClasse = c.nome();
            }
        } else {
            //TO-DO
            nomeDaClasse = "";
        }
        return (AbstractConversor) Class.forName(nomeDaClasse).newInstance();
    }

}
