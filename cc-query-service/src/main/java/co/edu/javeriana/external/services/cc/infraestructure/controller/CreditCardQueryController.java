package co.edu.javeriana.external.services.cc.infraestructure.controller;

import co.edu.javeriana.external.services.cc.application.CreditCardServices;
import co.edu.javeriana.external.services.cc.domain.Status;
import co.edu.javeriana.external.services.cc.dtos.Request;
import co.edu.javeriana.external.services.cc.dtos.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CreditCardQueryController {

    private final CreditCardServices service;

    @GetMapping(value = "/creditCardValidation/{number}")
    public ResponseEntity<CompletableFuture<Response>> creditCardValidation(@PathVariable String number) throws ExecutionException, InterruptedException, UnknownHostException {

        if (number == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (number.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Request data = new Request();
        data.setNumber(number);

        CompletableFuture<Response> rs = service.getCreditCardValidation(data);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.SUCCESS.name()))
            return new ResponseEntity<>(rs, HttpStatus.OK);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.EMPTY.name()))
            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.ERROR.name()))
            return new ResponseEntity<>(rs, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(rs, HttpStatus.ACCEPTED);
    }
}
