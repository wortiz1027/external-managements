package co.edu.javeriana.external.services.aa.infraestructure.controller;

import co.edu.javeriana.external.services.aa.application.FlightsServices;
import co.edu.javeriana.external.services.aa.domain.Status;
import co.edu.javeriana.external.services.aa.dtos.all.Request;
import co.edu.javeriana.external.services.aa.dtos.all.Response;
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
public class FlightsAllQueryController {

    private final FlightsServices service;

    @GetMapping(value = "/flights/{availables}")
    public ResponseEntity<CompletableFuture<Response>> all(@PathVariable String availables) throws ExecutionException, InterruptedException, UnknownHostException {

        if (availables == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (availables.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Request data = new Request();
        data.setAvailable(availables);

        CompletableFuture<Response> rs = service.getAllFlights(data);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.SUCCESS.name()))
            return new ResponseEntity<>(rs, HttpStatus.OK);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.EMPTY.name()))
            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.ERROR.name()))
            return new ResponseEntity<>(rs, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(rs, HttpStatus.ACCEPTED);
    }

}
