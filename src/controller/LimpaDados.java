package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LimpaDados {

	public static String limpaAll(String string) {
		String stringtemp = string.replaceAll("\\D", "");
		stringtemp.trim();
		return stringtemp;
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
	
	public static String converterDataConsulta(String dataconsulta) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		java.util.Date data_desejada = null;
		try {
			data_desejada = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dataconsulta);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dataformatada = formato.format(data_desejada);
		
		return dataformatada;
	}
	
	public static String converterDataConsultaBusca(String dataconsulta) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		java.util.Date data_desejada = null;
		try {
			data_desejada = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dataconsulta);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dataformatada = formato.format(data_desejada);
		
		return dataformatada;
	}
}
