package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {
	
	public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static String getDateToString(LocalDate data) {
		return data.format(DATE_FORMAT);
	}
	
	public static String getDataTransacaoDebito() {
		return getDateToString(LocalDate.now());
	}
	
	public static String getDataTransacaoCredito() {
		return getDateToString(LocalDate.now().plusDays(30));
	}
	
	public static BigDecimal calcularDeconto(BigDecimal valor, BigDecimal percentual) {
		return valor.subtract(valor.multiply(percentual));
	}

}
