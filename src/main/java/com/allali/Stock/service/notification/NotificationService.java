package com.allali.Stock.service.notification;

import com.allali.Stock.entitie.Client;
import com.allali.Stock.entitie.Notification;
import com.allali.Stock.exceptions.UserNotFoundException;

import java.util.List;

public interface NotificationService {
    public Notification addNotification(Notification notification);
    public void deleteNotification(Long id);
    public void sendNotificationToClient(Notification notification , Long id) throws UserNotFoundException;
    void sendNotificationToClients(Notification notification, List<Long> clientIds);
}
