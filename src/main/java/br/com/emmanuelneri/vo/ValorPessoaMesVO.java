package br.com.emmanuelneri.vo;

import java.math.BigDecimal;
import java.util.Map;

public final class ValorPessoaMesVO {

	private PessoaVO pessoaVO;
	private Map<Mes, BigDecimal> valorMes;

	public ValorPessoaMesVO(PessoaVO pessoa,  Map<Mes, BigDecimal> valorMes) {
		this.pessoaVO = pessoa;
		this.valorMes = valorMes;
	}

	public PessoaVO getPessoaVO() {
		return pessoaVO;
	}

	public Map<Mes, BigDecimal> getValorMes() {
		return valorMes;
	}
}
