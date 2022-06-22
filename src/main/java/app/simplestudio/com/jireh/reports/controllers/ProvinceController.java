package app.simplestudio.com.jireh.reports.controllers;

import app.simplestudio.com.jireh.reports.documents.Province;
import app.simplestudio.com.jireh.reports.service.inteface.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/province")
public class ProvinceController {
	
	@Autowired
	private ProvinceService provinceService;
	
	@GetMapping("/")
	public Mono<ResponseEntity<Flux<Province>>> findAll(){
		return Mono.just(
				ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(provinceService.findAll())
				);
	}
	
	@GetMapping("/number/{numberProvince}")
	public Mono<ResponseEntity<Mono<Province>>> findByNumberProvince(@PathVariable Long numberProvince){
		return Mono.just(
				ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(provinceService.findByNumberProvince(numberProvince))
				);
	}
	
	@GetMapping("/name/{province}")
	public Mono<ResponseEntity<Mono<Province>>> findByProvince(@PathVariable String province){
		return Mono.just(
				ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(provinceService.findByProvince(province))
				);
	}
	
	@PostMapping
	public Mono<ResponseEntity<Map<String, Object>>> newProvince(@Valid @RequestBody Mono<Province> monoProvince){
		Map<String, Object> respuesta = new HashMap<String, Object>();
		return monoProvince.flatMap(province -> {			
			return provinceService.save(province).map(p-> {
				respuesta.put("province", p);
				respuesta.put("mensaje", "Provincia Creada con Exito creado con exito");
				return ResponseEntity
					.created(URI.create("/api/address/".concat(p.getId())))
					.contentType(MediaType.APPLICATION_JSON)
					.body(respuesta);
				});
			
		}).onErrorResume(t -> {
			return Mono.just(t).cast(WebExchangeBindException.class)
					.flatMap(e -> Mono.just(e.getFieldErrors()))
					.flatMapMany(Flux::fromIterable)
					.map(fieldError -> "El campo "+fieldError.getField() + " " + fieldError.getDefaultMessage())
					.collectList()
					.flatMap(list -> {
						respuesta.put("errors", list);
						respuesta.put("status", HttpStatus.BAD_REQUEST.value());
						return Mono.just(ResponseEntity.badRequest().body(respuesta));
					});
							
		}).onErrorResume(t -> {
			return Mono.just(t).cast(WebExchangeBindException.class)
					.flatMap(e -> Mono.just(e.getFieldErrors()))
					.flatMapMany(Flux::fromIterable)
					.map(fieldError -> "El campo "+fieldError.getField() + " " + fieldError.getDefaultMessage())
					.collectList()
					.flatMap(list -> {
						respuesta.put("errors", list);
						respuesta.put("status", HttpStatus.BAD_REQUEST.value());
						return Mono.just(ResponseEntity.badRequest().body(respuesta));
					});
							
		});
		

	}

}
