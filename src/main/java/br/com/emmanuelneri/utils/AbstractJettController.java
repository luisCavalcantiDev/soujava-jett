package br.com.emmanuelneri.utils;

import javax.faces.application.FacesMessage;
import java.util.Map;

public abstract class AbstractJettController {

    protected abstract String getExcelTemplateNome();

    protected abstract String getExcelNome();

    protected abstract Map<String, Object> getMapValores();

    public void gerarExcel() {
        try {

            System.out.println(getTemplatePath() + getExcelTemplateNome());

            JettUtil.gerarExcel(getTemplatePath() + getExcelTemplateNome(), getExcelNome(), getMapValores());
            JsfUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Excel gerado com sucesso!");
        } catch (Exception e) {
            JsfUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Problemas ao gerar excel.");
            e.printStackTrace();
        }
    }

    public String getTemplatePath() {
        return "resources/sheets/";
    }

}
