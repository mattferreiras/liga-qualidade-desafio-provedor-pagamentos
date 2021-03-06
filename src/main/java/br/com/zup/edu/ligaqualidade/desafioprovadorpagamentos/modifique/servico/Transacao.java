package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.servico;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

public interface Transacao {
	
	public String[] executar(DadosTransacao transacao, DadosRecebimentoAdiantado adiantamento);
}
