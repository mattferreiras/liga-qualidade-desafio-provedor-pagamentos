package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.servico;

public enum TransacaoPagamento  {
	DEBITO {
		@Override
		public Transacao instance() {
			return Debito.INSTANCE;
		}
	},
	CREDITO {
		@Override
		public Transacao instance() {
			return Credito.INSTANCE;
		}
	};
	
	public abstract Transacao instance();
}
