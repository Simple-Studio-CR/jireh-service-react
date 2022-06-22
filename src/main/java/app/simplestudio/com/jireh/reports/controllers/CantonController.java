package app.simplestudio.com.jireh.reports.controllers;

import app.simplestudio.com.jireh.reports.documents.Canton;
import app.simplestudio.com.jireh.reports.service.inteface.CantonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/canton")
public class CantonController {
	
	@Autowired
	private CantonService cantonService;
	
	@GetMapping("/")
	public Mono<ResponseEntity<Flux<Canton>>> findAll(){
		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(cantonService.findAll()));
	}

	@GetMapping("/cantonid/{cantonId}")
	public Mono<ResponseEntity<Mono<Canton>>> findCantonByCantonId(@PathVariable Long cantonId){
		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(cantonService.findCantonByCantonId(cantonId)));
	}
	
	@GetMapping("/numberCanton/{numberCanton}")
	public Mono<ResponseEntity<Flux<Canton>>> findCantonByNumberCanton(@PathVariable Long numberCanton){
		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(cantonService.findCantonByNumberCanton(numberCanton)));
	}
	
	@GetMapping("/numberProvince/{numberProvince}")
	public Mono<ResponseEntity<Flux<Canton>>> findCantonByNumberProvince(@PathVariable Long numberProvince){
		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(cantonService.findCantonByNumberProvince(numberProvince)));
	}
	
	@GetMapping("/name/{canton}")
	public Mono<ResponseEntity<Mono<Canton>>> findByCanton(@PathVariable String canton){
		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(cantonService.findByCanton(canton)));
	}
	
	@PostMapping("/save")
	public Mono<ResponseEntity<Map<String, Object>>> newCanton(@Valid @RequestBody 
			Mono<Canton> monoCaton){
		Map<String, Object> response = new HashMap<String, Object>();
		return monoCaton.flatMap(canton -> {
			return cantonService.save(canton).map(c->{
				response.put("canton", c);
				response.put("Message", "Canton create successfuly");
				return ResponseEntity
						.created(URI.create("/api/address/".concat(c.getId()))).body(response);
			});
		});
	}

}
