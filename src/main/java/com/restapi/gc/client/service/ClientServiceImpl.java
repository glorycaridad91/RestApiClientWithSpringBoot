package com.restapi.gc.client.service;

import com.restapi.gc.client.data.Client;
import com.restapi.gc.client.data.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client addClient(Client newClient) {
        return clientRepository.save(newClient);
    }

    @Override
    public Client updateClient(Client newClient) {
        Optional<Client> client2 = clientRepository.findById(newClient.getClientID());
        client2.get().setClientID(newClient.getClientID());
        client2.get().setName(newClient.getName());
        client2.get().setLastname(newClient.getLastname());
        client2.get().setCompanyName(newClient.getCompanyName());
        client2.get().setIdCompany(newClient.getIdCompany());
        client2.get().setEmail(newClient.getEmail());
        client2.get().setAddress(newClient.getAddress());
        client2.get().setPhone(newClient.getPhone());
        return clientRepository.save(client2.get());
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Optional<Client> findById(int id) {
        return clientRepository.findById(id);
    }
}
