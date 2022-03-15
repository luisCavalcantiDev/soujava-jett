package br.com.emmanuelneri;

import br.com.emmanuelneri.utils.AbstractJettController;
import br.com.emmanuelneri.utils.JettUtil;
import br.com.emmanuelneri.utils.JsfUtil;
import br.com.emmanuelneri.vo.PessoaVO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import br.com.emmanuelneri.utils.ListagemMultiplasAbas;
import javax.faces.application.FacesMessage;

@RequestScoped
@ManagedBean
public class ListagemVerticalMultiplasAbasController extends AbstractJettController implements ListagemMultiplasAbas {

    public ListagemVerticalMultiplasAbasController() {
    }

    @Override
    public String getExcelTemplateNome() {
        return "template-listagem-vertical-multiplas-abas.xlsx";
    }

    @Override
    public String getExcelNome() {
        return "listagem-vertical-multiplas-abas.xlsx";
    }

    @Override
    protected Map<String, Object> getMapValores() {
        return null;
    }

    @Override
    public List<Map<String, Object>> getListComMapValoresParaMultiplasAbas() {
        System.out.println("getListComMapValoresParaMultiplasAbas");
        List<Map<String, Object>> beanList = new ArrayList<>();
        
        for (int i = 0; i < 150; i++) {
            beanList.add(getValores("email" + i));
        }                

        return beanList;
    }

    @Override
    public List<String> getTemplateSheetNames() {
        System.out.println("getTemplateSheetNames");
        
        List<String> templateSheetNames = new ArrayList<>();
        
        for (int i = 0; i < 150; i++) {
            templateSheetNames.add("pessoasDuplicar");
        }        

        return templateSheetNames;
    }

    @Override
    public List<String> getNewSheetNamesList() {
        System.out.println("getNewSheetNamesList");
        
        List<String> newSheetNamesList = new ArrayList<>();
        
        for (int i = 0; i < 200; i++) {
            newSheetNamesList.add("E-mail" + i);
        }      

        return newSheetNamesList;
    }

    private Map<String, Object> getValores(String emailPrefix) {        
        List<PessoaVO> pessoas = new ArrayList<>();
        final Map<String, Object> mapValores = new HashMap<>();
        for (int i = 0; i <= 1000; i++) {
            pessoas.add(new PessoaVO("Pessoa" + i, String.format("email%d@" + emailPrefix + ".com", i), i % 2 == 0 ? "java" : ".net"));
        }
        mapValores.put("pessoas", pessoas);
        return mapValores;
    }

    public void gerarExcelComMultiplasAbas() {
        try {
            System.out.println(getTemplatePath() + getExcelTemplateNome());

            JettUtil.gerarExcelComMultiplasAbas(getTemplatePath() + getExcelTemplateNome(), getExcelNome(), getTemplateSheetNames(), getNewSheetNamesList(), getListComMapValoresParaMultiplasAbas());
            JsfUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Excel gerado com sucesso!");
        } catch (Exception e) {
            JsfUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Problemas ao gerar excel.");
            e.printStackTrace();
        }
    }
}
