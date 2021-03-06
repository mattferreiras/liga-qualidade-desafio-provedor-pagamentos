package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.servico;

import java.math.BigDecimal;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.util.Utils;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

public class Credito implements Transacao {
	
	public static final Credito INSTANCE = new Credito();

	@Override
	public String[] executar(DadosTransacao transacao, DadosRecebimentoAdiantado adiantamento) {
			
			
			return new String[] {"aguardando_liberacao_fundos",
					transacao.valor.toString(),
					Utils.calcularDeconto(transacao.valor, new BigDecimal("0.05")).toString(), 
					Utils.getDataTransacaoCredito()};
		}

}
