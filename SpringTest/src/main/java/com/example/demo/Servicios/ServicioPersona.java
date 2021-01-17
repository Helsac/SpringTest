package com.example.demo.Servicios;

import java.util.List;
import com.example.demo.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.repositorio.Personarepositorio;


@Service
public class ServicioPersona {
	@Autowired
	private Personarepositorio personaRepositorio;

	public Persona obtenerPersona(long codigo) throws Exception {
		Persona p;
		p = personaRepositorio.findById(codigo).get();
		if(p == null) throw new Exception("No se encontró a la persona");
		return p;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Persona registrarPersona(Persona p) throws Exception {
		if(p == null)throw new Exception("No se pudo registrar");
		else return personaRepositorio.save(p);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Persona actualizarPersona(Persona p) throws Exception{
		personaRepositorio.findById(p.getCodigo()).orElseThrow(() -> new Exception("No se encontró esa persona"));
		return personaRepositorio.save(p);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void borrarPersona(long id) throws Exception {
		personaRepositorio.findById(id).orElseThrow(() -> new Exception("No se encontró esa persona"));
		personaRepositorio.deleteById(id);
	}
	
	
	
	
	}


