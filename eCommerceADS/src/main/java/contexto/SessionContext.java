package contexto;

import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author Victor
 */
public class SessionContext {

    private static SessionContext instance;

    public static SessionContext getInstance() {
        if (instance == null) {
            instance = new SessionContext();
        }

        return instance;
    }

    public SessionContext() {
    }

    public ExternalContext getExternalContext() {
        if (FacesContext.getCurrentInstance() == null) {
            return null;
            //throw new RuntimeException("O FacesContext não pode ser chamado fora de uma requisição HTTP");
        } else {
            return FacesContext.getCurrentInstance().getExternalContext();
        }
    }

    public Usuario getUsuarioLogado() {
        return (Usuario) getAttribute("usuarioLogado");
    }

    public void setUsuarioLogado(Usuario usuario) {
        setAttribute("usuarioLogado", usuario);
    }

    public Object getAttribute(String nome) {
        try {
            return getExternalContext().getSessionMap().get(nome);
        } catch (Exception e) {
            return null;
        }
    }

    public void setAttribute(String nome, Object valor) {
        getExternalContext().getSessionMap().put(nome, valor);
    }

    public void removerAttribute(String nome) {
        getExternalContext().getSessionMap().remove(nome);
    }

    public void encerrarSessao() throws IOException {
        getExternalContext().invalidateSession();
        getExternalContext().redirect("/telas/login.xhtml");
    }

    public void atualizarSessao(Boolean reloadLogin) throws Exception {
        // https://stackoverflow.com/a/11258762
        Cookie[] cookies = ((HttpServletRequest) getExternalContext().getRequest()).getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    cookie.setValue("");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    HttpServletResponse resp = (HttpServletResponse) getExternalContext().getResponse();
                    resp.addCookie(cookie);
                    break;
                }
            }
        }
        if (reloadLogin) {
            getExternalContext().redirect("/telas/login.xhtml");
        }
    }
}
