package com.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciclo3.reto3.repository.PapeleriaRepository;
import com.ciclo3.reto3.model.Papeleria;

@Service
public class PapeleriaService {
	
	@Autowired private PapeleriaRepository papeleriaRepository;
	
	public List<Papeleria> getAll(){
		return papeleriaRepository.getAll();
	}
	
	public Optional<Papeleria> getPapeleria(int id){
		return papeleriaRepository.getPapeleria(id);
	}
	
	public Papeleria save(Papeleria p) {
		if(p.getId()==null) {
			return papeleriaRepository.save(p);
		}else {
			Optional<Papeleria> papeleriaAuxiliar = papeleriaRepository.getPapeleria(p.getId());
			if(papeleriaAuxiliar.isEmpty()) {
				return papeleriaRepository.save(p);
			}else {
				return p;
			}
		}
	}
}
