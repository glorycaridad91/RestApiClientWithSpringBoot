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
        client2.get().setNombre(newClient.getNombre());
        client2.get().setApellidos(newClient.getApellidos());
        client2.get().setNombreRazonSocial(newClient.getNombreRazonSocial());
        client2.get().setIdEmpresa(newClient.getIdEmpresa());
        client2.get().setCorreo(newClient.getCorreo());
        client2.get().setDireccion(newClient.getDireccion());
        client2.get().setTelefono(newClient.getTelefono());
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
