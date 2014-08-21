package br.com.emmanuelneri;

import br.com.emmanuelneri.utils.AbstractJettController;
import br.com.emmanuelneri.vo.Mes;
import br.com.emmanuelneri.vo.PessoaVO;
import br.com.emmanuelneri.vo.ValorPessoaMesVO;

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
public class ListagemHorizontalEVerticalController extends AbstractJettController {

	private List<ValorPessoaMesVO> valoresPorPessoa;
	private final List<Mes> meses;

	public ListagemHorizontalEVerticalController() {
		valoresPorPessoa = new ArrayList<>();
		meses = Arrays.asList(Mes.values());

		for(int i = 0; i <= 10; i++) {
			final PessoaVO pessoaVO = new PessoaVO("Pessoa"+i,
					String.format("email%d@gmail.com", i));

			Map<Mes, BigDecimal> valores = new HashMap<>();

			for(Mes mes : meses) {
				valores.put(mes,
						BigDecimal.valueOf(i * mes.ordinal() * 7));
			}

			valoresPorPessoa.add(
					new ValorPessoaMesVO(pessoaVO, valores));
		}

	}

	@Override
	protected String getExcelTemplateNome() {
		return "template-listagem-horizontal-vertical.xlsx";
	}

	@Override
	protected String getExcelNome() {
		return "listagem-horizontal-vertical.xlsx";
	}

	@Override
	protected Map<String, Object> getMapValores() {
		final Map<String, Object> mapValores = new HashMap<>();
		mapValores.put("valoresPorPessoa", valoresPorPessoa);
		mapValores.put("meses", meses);

		return mapValores;
	}
}
