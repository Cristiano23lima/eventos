package com.f5.evento.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class AlternativeService {
	
	public Date convertData(Date data) throws ParseException {
		SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		String dataConvertida = formatador.format(data);//Converte o formato da data para string com a nova formatação
		Date dataFormatada = formatador.parse(dataConvertida);//depois converte o string para date e retorna a data formatada
				
		return dataFormatada;
	}
	
}
