package repository;

import model.Client.Client;
import model.autor.Author;

import java.util.ArrayList;

public class ClientRepository {
    ArrayList<Client> clientsList = new ArrayList <Client>();

    public Client add(Client client) {
        clientsList.add(client);
        System.out.println(clientsList);
        return client;
    }

    public Client get(int index) {
        if(index< clientsList.size())
            return clientsList.get(index);
        return null;
    }

    public ArrayList<Client> getAll() {
        return clientsList;
    }

    public boolean update(Client client, int age) {
        client.setAge(age);
        return true;
    }

    public boolean delete(int index) {
        if(index< clientsList.size())
        {
            clientsList.remove(index);
            return true;
        }
        return false;
    }

    public boolean sumaTotalaPlatita(int index)
    {
        if(index< clientsList.size())
        {
            ArrayList<Float> taxe;
            taxe = clientsList.get(index).getTaxes();
            float suma = 0;
            for(int i=0; i<taxe.size(); i++)
            {
                suma += taxe.get(i);
            }
            System.out.println(suma);
            return true;
        }
        else
            System.out.println("Nu exista acest index.");
        return false;
    }

    public boolean checkRetired(int index)
    {
        if(index< clientsList.size())
        {
            if(clientsList.get(index).getAge()>60)
                System.out.println("Retired");
            else
                System.out.println("Not retired");
            return true;
        }
        else
            System.out.println("Nu exista acest index.");
        return false;
    }
}
