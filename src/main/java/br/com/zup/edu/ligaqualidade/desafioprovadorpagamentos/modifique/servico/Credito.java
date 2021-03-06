package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.servico;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.util.Utils;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

import java.math.BigDecimal;

public class Credito implements Transacao {

    public static final Credito INSTANCE = new Credito();

    @Override
    public String[] executar(DadosTransacao transacao, DadosRecebimentoAdiantado adiantamento) {
        BigDecimal value = transacao.valor;

        if (null != adiantamento) {
            value = Utils.calcularDesconto(transacao.valor, adiantamento.taxa);
        }

        final BigDecimal finalValue = Utils.calcularDesconto(value, new BigDecimal("0.05"));

        return new String[]{
                "aguardando_pagamento",
                transacao.valor.toString(),
                finalValue.toString(),
                Utils.getDataTransacaoCredito()
        };
    }

}
