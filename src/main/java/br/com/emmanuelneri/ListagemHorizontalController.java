package br.com.emmanuelneri;

import br.com.emmanuelneri.utils.AbstractJettController;
import br.com.emmanuelneri.vo.Mes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestScoped
@ManagedBean
public class ListagemHorizontalController extends AbstractJettController {

	private final List<Mes> meses;
	private final List<BigDecimal> valores;

	public ListagemHorizontalController() {
		meses = Arrays.asList(Mes.values());
		valores = new ArrayList<>();

		for(int i = 0; i < meses.size(); i++) {
			valores.add(BigDecimal.valueOf(i * 7));
		}
	}

	@Override
	protected String getExcelTemplateNome() {
		return "template-listagem-horizontal.xlsx";
	}

	@Override
	protected String getExcelNome() {
		return "listagem-horizontal.xlsx";
	}

	@Override
	protected Map<String, Object> getMapValores() {
		final Map<String, Object> mapValores = new HashMap<>();
		mapValores.put("meses", meses);
		mapValores.put("valores", valores);

		return mapValores;
	}
}