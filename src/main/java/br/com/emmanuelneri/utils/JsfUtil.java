package br.com.emmanuelneri.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public final class JsfUtil {

	private JsfUtil() {}

	public static void adicionarMensagem(FacesMessage.Severity severity, String msg) {
		FacesMessage facesMsg = new FacesMessage(severity, "", msg);
		FacesContext.getCurrentInstance().addMessage("", facesMsg);
	}
}
