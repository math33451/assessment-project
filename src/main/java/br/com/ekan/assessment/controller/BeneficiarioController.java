package br.com.ekan.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ekan.assessment.dto.BeneficiarioDTO;
import br.com.ekan.assessment.service.BeneficiarioService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/beneficiario", produces="application/json", consumes="application/json")
public class BeneficiarioController {

	@Autowired
	private BeneficiarioService beneficiarioService;

	@GetMapping()
	public List<BeneficiarioDTO> listarTodosBeneficiarios(){
		return beneficiarioService.findAll();
	}
	
	@GetMapping(value="/lista-documentos/{id}")
	public BeneficiarioDTO buscarDocumentosPorId(@PathVariable Long id) throws Exception{
		return beneficiarioService.findDocumentosById(id);
	}
	
	@PostMapping(value="/salvar")
	public ResponseEntity<?> salvarBeneficiario(@RequestBody BeneficiarioDTO beneficiario) throws Exception{
		beneficiarioService.save(beneficiario);
		return ResponseEntity.ok("Novo membro salvo com sucesso.");
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<?> editarBeneficiario(@PathVariable Long id, @RequestBody BeneficiarioDTO beneficiario) throws Exception{
		beneficiarioService.editarBeneficiario(id, beneficiario);
		return ResponseEntity.ok("Alterações salvas com sucesso.");
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> excluirBeneficiario(@PathVariable Long id){
		beneficiarioService.excluiBeneficiario(id);
		return ResponseEntity.ok().build();
	}
}
