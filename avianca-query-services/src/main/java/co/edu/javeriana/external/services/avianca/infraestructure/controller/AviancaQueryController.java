package co.edu.javeriana.external.services.avianca.infraestructure.controller;

import co.edu.javeriana.external.services.avianca.application.FlightsServices;
import co.edu.javeriana.external.services.avianca.dtos.Request;
import co.edu.javeriana.external.services.avianca.dtos.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AviancaQueryController {

    private final FlightsServices service;

    @PostMapping("/flights")
    public ResponseEntity<CompletableFuture<Response>> getFlights(@RequestBody(required = true) Request request) {

        if (request == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        // CompletableFuture<Response> rs = service.getFlights(request);
        CompletableFuture<Response> rs = CompletableFuture.completedFuture(service.getFlights(request));

        return new ResponseEntity<>(rs, HttpStatus.ACCEPTED);
    }
}
