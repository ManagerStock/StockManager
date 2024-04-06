package com.allali.Stock.service.notification;

import com.allali.Stock.entitie.Notification;

public interface NotificationService {
    public Notification addNotification(Notification notification);
    public void deleteNotification(Long id);
    public Notification updateNotification(Notification notification , Long id);

}
