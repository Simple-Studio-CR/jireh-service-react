package app.simplestudio.com.jireh.reports.controllers;

import app.simplestudio.com.jireh.reports.documents.client.Clients;
import app.simplestudio.com.jireh.reports.documents.client.ClientsBranchOffice;
import app.simplestudio.com.jireh.reports.documents.client.ClientsBranchOfficeWarehouse;
import app.simplestudio.com.jireh.reports.service.inteface.client.ClientsBranchOfficeService;
import app.simplestudio.com.jireh.reports.service.inteface.client.ClientsBranchOfficeWarehouseService;
import app.simplestudio.com.jireh.reports.service.inteface.client.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @Autowired
    private ClientsBranchOfficeService branchOfficeService;

    @Autowired
    private ClientsBranchOfficeWarehouseService warehouseService;

    @GetMapping("/all")
    public Mono<ResponseEntity<Flux<Clients>>> findAllClients() {
        return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(clientsService.findAll()));
    }

    @GetMapping("/mail/{mail}")
    public Mono<ResponseEntity<Flux<Clients>>> findByMail(@PathVariable String mail) {
        return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(clientsService.findClientsByMail(mail)));
    }

    @GetMapping("/id/{identification}")
    public Mono<ResponseEntity<Mono<Clients>>> findByIdentification(@PathVariable String identification) {
        return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(clientsService.findClientsByIdentification(identification)));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Mono<Clients>>> findById(@PathVariable String id) {
        return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(clientsService.findById(id)));
    }

    @GetMapping("/contact/{contact}")
    public Mono<ResponseEntity<Flux<Clients>>> findByConctact(@PathVariable String contact) {
        return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(clientsService.findClientsByContact(contact)));
    }

    @GetMapping("/name/{name}")
    public Mono<ResponseEntity<Mono<Clients>>> findByName(@PathVariable String name) {
        return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(clientsService.findClientsByName(name)));
    }

    @PostMapping
    public Mono<ResponseEntity<Map<String, Object>>> newClient(@Valid @RequestBody Mono<Clients> monoClient) {
        Map<String, Object> response = new HashMap<>();
        return monoClient.flatMap(clients -> {
            return clientsService.save(clients).map(c -> {
                response.put("client", c);
                response.put("message", "Client create successful");
                return ResponseEntity.created(URI.create("api/clients".concat(c.getId())))
                        .contentType(MediaType.APPLICATION_JSON).body(response);
            });
        });
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Clients>> editClient(@Valid @RequestBody Clients monoClient,
                                                    @PathVariable(value = "id") String id) throws ParseException {
        return clientsService.findById(id).flatMap(c -> {
                    c.setIdentification(monoClient.getIdentification());
                    c.setContact(monoClient.getContact());
                    c.setMail(monoClient.getMail());
                    c.setName(monoClient.getName());
                    c.setScope(monoClient.getScope());
                    c.setTypeOfId(monoClient.getTypeOfId());
                    return this.clientsService.save(c);
                }).map(c -> ResponseEntity.created(URI.create("api/clients".concat(c.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(c))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/branches/all")
    public ResponseEntity<Flux<ClientsBranchOffice>> findAllBranches() {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(branchOfficeService.findAll());
    }

    @GetMapping("/branches/id/{id}")
    public ResponseEntity<Mono<ClientsBranchOffice>> findBranchById(@PathVariable String id) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(branchOfficeService.findById(id));
    }

    @GetMapping("/branches/client/{clientId}")
    public ResponseEntity<Flux<ClientsBranchOffice>> findByClientId(@PathVariable String clientId) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(branchOfficeService.findClientsBranchOfficeByClientId(clientId));
    }

    @GetMapping("/branches/{name}")
    public ResponseEntity<Mono<ClientsBranchOffice>> findBranchByName(@PathVariable String name) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(branchOfficeService.findClientsBranchOfficeByName(name));
    }

    @PostMapping(path = "/branches")
    public Mono<ResponseEntity<Map<String, Object>>> newBranch(@Valid @RequestBody Mono<ClientsBranchOffice> monoBranch) {
        Map<String, Object> response = new HashMap<>();
        return monoBranch.flatMap(branchOffice -> {
            return branchOfficeService.save(branchOffice).map(bo -> {
                response.put("Branch", bo);
                response.put("message", "New branch added successful");
                return ResponseEntity.created(URI.create("api/clients/clients")).contentType(MediaType.APPLICATION_JSON).body(response);
            });
        });
    }

    @PutMapping("/branches/{id}")
    public Mono<ResponseEntity<ClientsBranchOffice>> editBranch(@Valid @RequestBody ClientsBranchOffice monoBranch,
                                                                @PathVariable(value = "id") String id) throws ParseException {
        return branchOfficeService.findById(id).flatMap(c -> {
                    c.setClientId(monoBranch.getClientId());
                    c.setCanton(monoBranch.getCanton());
                    c.setId(monoBranch.getId());
                    c.setDistrict(monoBranch.getDistrict());
                    c.setNeighborhood(monoBranch.getNeighborhood());
                    c.setAddressDetails(monoBranch.getAddressDetails());
                    c.setProvince(monoBranch.getProvince());
                    c.setName(monoBranch.getName());
                    return this.branchOfficeService.save(c);
                }).map(c -> ResponseEntity.created(URI.create("api/clients".concat(c.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(c))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/warehouse/all")
    public ResponseEntity<Flux<ClientsBranchOfficeWarehouse>> findAllWarehouses() {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(warehouseService.findAll());
    }

    @GetMapping("/warehouse/id/{id}")
    public ResponseEntity<Mono<ClientsBranchOfficeWarehouse>> findWarehouseById(@PathVariable String id) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(warehouseService.findById(id));
    }

    @GetMapping("/warehouse/branch/{branchId}")
    public ResponseEntity<Flux<ClientsBranchOfficeWarehouse>> findByBranchId(@PathVariable String branchId) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(warehouseService.findClientsBranchOfficeWarehouseByBranchId(branchId));
    }

    @GetMapping("/warehouse/name/{name}")
    public ResponseEntity<Mono<ClientsBranchOfficeWarehouse>> findWarehouseByName(@PathVariable String name) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(warehouseService.findClientsBranchOfficeWarehouseByName(name));
    }

    @PostMapping(path = "/warehouse")
    public Mono<ResponseEntity<Map<String, Object>>> newWarehouse(@Valid @RequestBody Mono<ClientsBranchOfficeWarehouse> monoWarehouse) {
        Map<String, Object> response = new HashMap<>();
        return monoWarehouse.flatMap(warehouse -> {
            return warehouseService.save(warehouse).map(w -> {
                response.put("Warehouse", w);
                response.put("message", "New Warehouse added successful");
                return ResponseEntity.created(URI.create("api/clients/clients")).contentType(MediaType.APPLICATION_JSON).body(response);
            });
        });
    }

    @PutMapping("/warehouse/{id}")
    public Mono<ResponseEntity<ClientsBranchOfficeWarehouse>> editWarehouse(@Valid @RequestBody ClientsBranchOfficeWarehouse monoWarehouse,
                                                                         @PathVariable(value = "id") String id) throws ParseException {
        return warehouseService.findById(id).flatMap(c -> {
                    c.setBranchId(monoWarehouse.getBranchId());
                    c.setSketch(monoWarehouse.getSketch());
                    c.setName(monoWarehouse.getName());
                    c.setId(monoWarehouse.getId());
                    return this.warehouseService.save(c);
                }).map(c -> ResponseEntity.created(URI.create("api/clients".concat(c.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(c))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
