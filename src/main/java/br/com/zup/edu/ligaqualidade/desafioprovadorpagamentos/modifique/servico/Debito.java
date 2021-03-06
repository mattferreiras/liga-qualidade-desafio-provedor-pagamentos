package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.servico;

import java.math.BigDecimal;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.util.Utils;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

public class Debito implements Transacao {
	
	public static final Debito INSTANCE = new Debito();
	
	@Override
	public String[] executar(DadosTransacao transacao, DadosRecebimentoAdiantado adiantamento) {
		return new String[] {"pago",
				transacao.valor.toString(),
				Utils.calcularDesconto(transacao.valor, new BigDecimal("0.03")).toString(), 
				Utils.getDataTransacaoDebito()};	
	}

}
