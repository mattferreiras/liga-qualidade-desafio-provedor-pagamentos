package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.servico;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.mapper.DadosRecebimentoAdiantadoMapper;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.mapper.DadosTransacaoMapper;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

public class TransacaoPagamentoService {
	
	public static List<String[]> processar(List<String> infoTransacoes, List<String> infoAdiantamentos) {
		List<DadosTransacao> transacoes = DadosTransacaoMapper.toList(infoTransacoes);
		List<DadosRecebimentoAdiantado> adiantamentos = DadosRecebimentoAdiantadoMapper.toList(infoAdiantamentos);
		
		return transacoes.stream().map(transacao ->
			getTransacao(transacao).executar(transacao, getAdiantamento(transacao, adiantamentos))
		).collect(Collectors.toList());
	}
	
	public static DadosRecebimentoAdiantado getAdiantamento(DadosTransacao transacao, List<DadosRecebimentoAdiantado> adiantamentos) {
		
		
		return adiantamentos.isEmpty() ? null : adiantamentos.stream().filter(it -> it.idTransacao == transacao.id).findAny().get();
	}
	
	public static Transacao getTransacao(DadosTransacao transacao) {
		return TransacaoPagamento.valueOf(transacao.metodo.name()).instance();
	}
	

}
