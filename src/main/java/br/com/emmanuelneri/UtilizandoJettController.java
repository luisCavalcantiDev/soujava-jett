package br.com.emmanuelneri;

import net.sf.jett.transform.ExcelTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.omnifaces.util.Faces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequestScoped
@ManagedBean
public class UtilizandoJettController {

    public Map<String, Object> popularValores() {
        Map<String, Object> mapValores = new HashMap<>();
        mapValores.put("valor1", 10);
        mapValores.put("valor2", "Valor 2");

        return mapValores;
    }

    public void gerarExcel() throws IOException, InvalidFormatException {
        final File templateFile =
                new File(Faces.getRealPath("resources/sheets/template-jett.xlsx"));

        final Map<String, Object> mapValores = popularValores();

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        Workbook workbook = WorkbookFactory.create(templateFile); //POI

        final ExcelTransformer transformer = new ExcelTransformer(); // JETT
        transformer.transform(workbook, mapValores);

        workbook.write(bout);

        Faces.sendFile(bout.toByteArray(), "utilizando-jett.xlsx", false);
    }

}


