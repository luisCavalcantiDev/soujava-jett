package br.com.emmanuelneri;

import br.com.emmanuelneri.utils.AbstractJettController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.HashMap;
import java.util.Map;

@RequestScoped
@ManagedBean
public class StyleController extends AbstractJettController {


    @Override
    protected String getExcelTemplateNome() {
        return "template-style.xlsx";
    }

    @Override
    protected String getExcelNome() {
        return "style.xlsx";
    }

    @Override
    protected Map<String, Object> getMapValores() {
        return new HashMap<>();
    }
}
