package com.restapi.gc.client.controller;

import com.restapi.gc.client.data.Client;
import com.restapi.gc.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping()
    public ResponseEntity<Client> newClient(@RequestBody Client newClient) {

        return new ResponseEntity<>(clientService.addClient(newClient), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> updateClient(@RequestBody Client newClient) {

        Optional<Client> optionalClient = clientService.findById(newClient.getClientID());

        if (!optionalClient.isPresent()) {
            return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Client>(clientService.updateClient(newClient), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneClient(@PathVariable Integer id) {

        Optional<Client> optionalClient = clientService.findById(id);
        if (!optionalClient.isPresent()) {
            return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalClient, HttpStatus.OK);
    }

    @GetMapping("/allClient")
    public List<Client> getAllCourseMap() {
        return clientService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable int id) {

        if (!clientService.findById(id).isPresent()) {
            return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);
        }
        clientService.deleteById(id);
        return new ResponseEntity<>("Client deleted", HttpStatus.OK);
    }

}
