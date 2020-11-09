package co.edu.javeriana.external.services.dc.infraestructure.controller;

import co.edu.javeriana.external.services.dc.application.BookingServices;
import co.edu.javeriana.external.services.dc.domain.Codes;
import co.edu.javeriana.external.services.dc.dtos.all.Request;
import co.edu.javeriana.external.services.dc.dtos.all.Response;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BookingsQueryController {

    private static final Logger LOG = LoggerFactory.getLogger(BookingsQueryController.class);
    private final BookingServices service;

    @GetMapping(value = "/bookings/{text}")
    public ResponseEntity<CompletableFuture<Response>> reservas(@PathVariable(required = true) String text) throws ExecutionException, InterruptedException, UnknownHostException {

        Request data = new Request();
        data.setKey(text);

        if (data == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (data.getKey().isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        CompletableFuture<Response> rs = this.service.getAllBookings(data);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Codes.SUCCESS.name()))
            return new ResponseEntity<>(rs, HttpStatus.OK);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Codes.EMPTY.name()))
            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Codes.ERROR.name()))
            return new ResponseEntity<>(rs, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(rs, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/bookings/code")
    public ResponseEntity<CompletableFuture<co.edu.javeriana.external.services.dc.dtos.code.Response>> codigo(@RequestBody(required = true) co.edu.javeriana.external.services.dc.dtos.code.Request data) throws ExecutionException, InterruptedException, UnknownHostException {

        if (data == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (data.getCode().isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        CompletableFuture<co.edu.javeriana.external.services.dc.dtos.code.Response> rs = this.service.getBookingsByCode(data);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Codes.SUCCESS.name()))
            return new ResponseEntity<>(rs, HttpStatus.OK);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Codes.EMPTY.name()))
            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Codes.ERROR.name()))
            return new ResponseEntity<>(rs, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(rs, HttpStatus.ACCEPTED);
    }

}
