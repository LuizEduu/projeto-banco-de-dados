package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LimpaDados {

	public static String limpatelefone(String telefone) {
		String telefonetemp = telefone.replaceAll("\\D", "");
		telefonetemp.trim();
		return telefonetemp;
	}

	public static String limpadatanascimento(String datanacimento) {
		String datatemp = datanacimento.replaceAll("\\D", "");
		datatemp.trim();
		return datatemp;
	}

	public static String converterData(String data) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date data_desejada = null;
		try {
			data_desejada = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dataformatada = formato.format(data_desejada);

		return dataformatada;
	}

	public static String converterDataBusca(String data) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date data_desejada = null;
		try {
			data_desejada = new SimpleDateFormat("yyyy-MM-dd").parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dataformatada = formato.format(data_desejada);

		return dataformatada;
	}
}
