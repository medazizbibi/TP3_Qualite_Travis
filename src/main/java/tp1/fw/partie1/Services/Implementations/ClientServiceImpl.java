package tp1.fw.partie1.Services.Implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tp1.fw.partie1.Domain.Client;
import tp1.fw.partie1.Domain.Models.ModelClient;
import tp1.fw.partie1.Repositories.ClientRepository;
import tp1.fw.partie1.Services.Interfaces.IClientService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service("clientService")
public class ClientServiceImpl implements UserDetailsService, IClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    @Transactional
    public List<Client> getAllClients() {
        List<Client> result = new ArrayList<>();
        Iterable<Client> iter= clientRepository.findAll();
        for (Client c : iter) {
            result.add(c);
        }
        return result;
    }

    @Override
    @Transactional
    public Client addClient(ModelClient modelClient){

        Client clientToBeAdded= new Client(
                UUID.randomUUID().toString(),
                modelClient.getNom(),
                modelClient.getPrenom(),
                modelClient.getAdresse(),
                modelClient.getTelephone(),
                null,
                null
                ) ;
        clientRepository.save(clientToBeAdded);
        return clientToBeAdded;

    }

    @Override
    @Transactional
    public Client editClient(Client client){

        clientRepository.save(client);
        Client client1=clientRepository.findById(client.getIdClient()).get();

        return client1;
    }

    @Override
    @Transactional
    public void deleteClient(String idClient){

        clientRepository.deleteById(idClient);

    }

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Client client = clientRepository.findByUsername(userId);
        if(client == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(client.getUsername(), client.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
