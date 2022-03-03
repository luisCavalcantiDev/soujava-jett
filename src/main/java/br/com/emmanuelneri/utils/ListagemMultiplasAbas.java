package br.com.emmanuelneri.utils;

import java.util.List;
import java.util.Map;

public interface ListagemMultiplasAbas {

    public String getExcelTemplateNome();

    public String getExcelNome();

    public List<String> getTemplateSheetNames();

    public List<String> getNewSheetNamesList();

    public List<Map<String, Object>> getListComMapValoresParaMultiplasAbas();
}
