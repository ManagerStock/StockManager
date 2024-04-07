package com.allali.Stock.service.notification;

import com.allali.Stock.entitie.Client;
import com.allali.Stock.entitie.Notification;
import com.allali.Stock.exceptions.UserNotFoundException;
import com.allali.Stock.repositorie.NotificationRepository;
import com.allali.Stock.repositorie.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private NotificationRepository notificationRepository ;
    private UserRepository userRepository ;
    @Override
    public Notification addNotification(Notification notification) {
        return notificationRepository.save(notification);
    }
    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public void sendNotificationToClient(Notification notification, Long clientId) throws UserNotFoundException {
        Client client = (Client) userRepository.findById(clientId).orElseThrow(() -> new UserNotFoundException("Client not found"));
        client.getNotificationList().add(notification);
        userRepository.save(client);
    }

    @Override
    public void sendNotificationToClients(Notification notification, List<Long> clientIds) {
        List<Client> clients = Collections.singletonList((Client) userRepository.findAllById(clientIds));
        clients.forEach(client -> client.getNotificationList().add(notification));
        userRepository.saveAll(clients);
    }

}
