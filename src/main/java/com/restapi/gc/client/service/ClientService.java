package com.restapi.gc.client.service;

import com.restapi.gc.client.data.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client addClient(Client newClient);

    Client updateClient(Client newClient);

    List<Client> findAll();

    void deleteById(int id);

    Optional<Client> findById(int id);
}
