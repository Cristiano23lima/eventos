package com.f5.evento.service;

/*import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;*/

//@Component
public class UploadService {
	
	/*@Value("${diretorio.raiz}")
	private String raiz;
	
	@Value("${diretorio.fotos}")
	private String diretorioFotos;
	
	public Path salvarFoto(MultipartFile foto) {
		 return this.salvar(this.diretorioFotos, foto);
	}
	
	public Path salvar(String diretorio, MultipartFile arquivo) {
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());
		
		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(diretorioPath);
			return arquivoPath;
		}catch(IOException e) {
			throw new RuntimeException("Houve um problema ao tentar salvar o arquivo "+e);
		}
		
	}*/

}
