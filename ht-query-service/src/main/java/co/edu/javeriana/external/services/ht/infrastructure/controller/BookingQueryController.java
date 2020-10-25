package co.edu.javeriana.external.services.ht.infrastructure.controller;

import co.edu.javeriana.external.services.ht.application.BookingService;
import co.edu.javeriana.external.services.ht.dtos.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BookingQueryController {
    private final BookingService service;

    @GetMapping(value = "/booking")
    public ResponseEntity<Response> get() {
        final Response response = service.booking();
        return new ResponseEntity<>(response, HttpStatus.OK) ;
    }
}
