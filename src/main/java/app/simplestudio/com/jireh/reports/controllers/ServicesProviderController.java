package app.simplestudio.com.jireh.reports.controllers;

import app.simplestudio.com.jireh.reports.db.NbDbRefResolver;
import app.simplestudio.com.jireh.reports.documents.report.ServicesProvider;
import app.simplestudio.com.jireh.reports.documents.report.ServicesProviderDetails;
import app.simplestudio.com.jireh.reports.documents.report.ServicesProviderDetailsV1;
import app.simplestudio.com.jireh.reports.documents.report.ServicesProviderPestTypeDetail;
import app.simplestudio.com.jireh.reports.documents.report.ServicesProviderRecommendations;
import app.simplestudio.com.jireh.reports.service.inteface.report.ServicesProviderDetailsService;
import app.simplestudio.com.jireh.reports.service.inteface.report.ServicesProviderDetailsV1Service;
import app.simplestudio.com.jireh.reports.service.inteface.report.ServicesProviderPestTypeDetailService;
import app.simplestudio.com.jireh.reports.service.inteface.report.ServicesProviderRecommendationsService;
import app.simplestudio.com.jireh.reports.service.inteface.report.ServicesProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/service-provider")
public class ServicesProviderController {

    @Autowired
    ServicesProviderDetailsService providerDetailsService;

    @Autowired
    ServicesProviderRecommendationsService providerRecommendationsService;

    @Autowired
    ServicesProviderService providerService;

    @Autowired
    ServicesProviderPestTypeDetailService pestTypeDetailService;

    @Autowired
    ServicesProviderDetailsV1Service servicesProviderDetailsV1;

    @Autowired
    NbDbRefResolver nbDbRefResolver;

    @PostMapping("/save-main")
    Mono<ResponseEntity<Map<String, Object>>> saveServiceProvider(@Valid @RequestBody Mono<ServicesProvider> monoServicesProvider) {
        Map<String, Object> response = new HashMap<>();
        return monoServicesProvider.flatMap(servicesProvider -> {
            if (servicesProvider.getCreateAt() == null)
                servicesProvider.setCreateAt(new Date());
            return this.providerService.save(servicesProvider).map(sP -> {
                response.put("ServiceProvider", sP);
                response.put("message", "Service create successful");
                return ResponseEntity.created(URI.create("api/clients".concat(sP.getId())))
                        .contentType(MediaType.APPLICATION_JSON).body(response);
            });
        });
    }

    @PostMapping("/save-recommendations")
    Mono<ResponseEntity<Map<String, Object>>> saveServiceProviderRecommendations(@Valid @RequestBody Mono<ServicesProviderRecommendations> recommendationsMono) {
        Map<String, Object> response = new HashMap<>();
        return recommendationsMono.flatMap(recommendations -> this.providerRecommendationsService
                .save(recommendations).map(servicesProviderRecommendations -> {
                    response.put("Recommendations", servicesProviderRecommendations);
                    response.put("message", "Recommendations create successful");
                    return ResponseEntity.created(URI.create("api/clients".concat(servicesProviderRecommendations.getId())))
                            .contentType(MediaType.APPLICATION_JSON).body(response);
                }));
    }

    @PostMapping("/save-details")
    Mono<ResponseEntity<Map<String, Object>>> saveServiceProviderDetails(@Valid @RequestBody Mono<ServicesProviderDetails> detailsMono) {
        Map<String, Object> response = new HashMap<>();
        return detailsMono.flatMap(servicesProviderDetails -> this.providerDetailsService
                .save(servicesProviderDetails).map(details -> {
                    response.put("Recommendations", details);
                    response.put("message", "Recommendations create successful");
                    return ResponseEntity.created(URI.create("api/clients".concat(details.getId())))
                            .contentType(MediaType.APPLICATION_JSON).body(response);
                }));
    }

    @PostMapping("/save-details-v1")
    Mono<ResponseEntity<Map<String, Object>>> saveServiceProviderDetailsV1(@Valid @RequestBody Mono<ServicesProviderDetailsV1> detailsMono) {
        Map<String, Object> response = new HashMap<>();
        return detailsMono.flatMap(servicesProviderDetails -> this.servicesProviderDetailsV1
                .save(servicesProviderDetails).map(details -> {
                    response.put("Recommendations", details);
                    response.put("message", "Recommendations create successful");
                    return ResponseEntity.created(URI.create("api/clients".concat(details.getId())))
                            .contentType(MediaType.APPLICATION_JSON).body(response);
                }));
    }

    @PostMapping("/save-pest-type")
    Mono<ResponseEntity<Map<String, Object>>> saveServiceProviderPestTypeDetails(@Valid @RequestBody Mono<ServicesProviderPestTypeDetail> detailsMono) {
        Map<String, Object> response = new HashMap<>();
        return detailsMono.flatMap(pestTypeDetail -> this.pestTypeDetailService
                .save(pestTypeDetail).map(details -> {
                    response.put("PestType", details);
                    response.put("message", "Pest create successful");
                    return ResponseEntity.created(URI.create("api/clients".concat(details.getId())))
                            .contentType(MediaType.APPLICATION_JSON).body(response);
                }));
    }

    @GetMapping("/get-main-by-client/{client}/{pageNo}/{pageSize}")
    ResponseEntity<?> getServiceProvider(@PathVariable(value = "client") String client,
                                         @PathVariable(value = "pageNo") int pageNo,
                                         @PathVariable(value = "pageSize") int pageSize) {
        return ResponseEntity.ok(this.providerService.findByClientId(client, pageNo, pageSize));
    }

    @GetMapping("/get-pest-type-by-service-provider/{serviceProviderId}")
    ResponseEntity<?> getServiceProviderPestTypeDetails(@PathVariable(value = "serviceProviderId") String serviceProviderId) {
        return ResponseEntity.ok(this.pestTypeDetailService.findByServiceProviderId(serviceProviderId));
    }

    @GetMapping("/get-recommendations-by-service-provider/{serviceProviderId}")
    ResponseEntity<?> getServiceRecommendationsDetails(@PathVariable(value = "serviceProviderId") String serviceProviderId) {
        return ResponseEntity.ok(this.providerRecommendationsService.findByServiceProviderId(serviceProviderId));
    }

    @GetMapping("/get-details-by-service-provider/{serviceProviderId}")
    ResponseEntity<?> getServiceDetails(@PathVariable(value = "serviceProviderId") String serviceProviderId) {
        return ResponseEntity.ok(this.providerDetailsService.findByServiceProviderId(serviceProviderId));
    }

    @GetMapping("/get-details-v1-by-service-provider/{serviceProviderId}")
    ResponseEntity<?> getServiceDetailsV1(@PathVariable(value = "serviceProviderId") String serviceProviderId) {
        return ResponseEntity.ok(this.servicesProviderDetailsV1.findByServiceProviderId(serviceProviderId));
    }
}
