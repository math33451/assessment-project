package br.com.ekan.assessment.infra.controller;

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

import br.com.ekan.assessment.infra.dto.BeneficiarioDTO;
import br.com.ekan.assessment.infra.service.BeneficiarioService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("beneficiario")
public class BeneficiarioController {

	@Autowired
	private BeneficiarioService beneficiarioService;

	@GetMapping()
	public List<BeneficiarioDTO> listarTodosBeneficiarios(){
		return beneficiarioService.findAll();
	}
	
	@GetMapping("/{id}")
	public BeneficiarioDTO buscarDocumentosPorId(@PathVariable Long id) throws Exception{
		return beneficiarioService.findById(id);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> salvarBeneficiario(@RequestBody BeneficiarioDTO beneficiario) throws Exception{
		beneficiarioService.save(beneficiario);
		return ResponseEntity.ok("Novo membro salvo com sucesso.");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarBeneficiario(@PathVariable Long id, @RequestBody BeneficiarioDTO beneficiario) throws Exception{
		beneficiarioService.editarBeneficiario(id, beneficiario);
		return ResponseEntity.ok("Alterações salvas com sucesso.");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> excluirBeneficiario(@PathVariable Long id){
		beneficiarioService.excluiBeneficiario(id);
		return ResponseEntity.ok().build();
	}
}
