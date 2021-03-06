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
        String status = "aguardando_pagamento";

        if (null != adiantamento) {
            value = Utils.calcularDesconto(transacao.valor, adiantamento.taxa);
            status = "pago";
        }

        final BigDecimal finalValue = Utils.calcularDesconto(value, new BigDecimal("0.05"));

        return new String[]{
                status,
                transacao.valor.toString(),
                finalValue.toString(),
                Utils.getDataTransacaoCredito()
        };
    }

}
