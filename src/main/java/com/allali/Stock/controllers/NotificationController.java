package com.allali.Stock.controllers;

import com.allali.Stock.entitie.Notification;
import com.allali.Stock.exceptions.UserNotFoundException;
import com.allali.Stock.service.notification.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notification")
@AllArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping("/add")
    public ResponseEntity<Notification> addNotification(@RequestBody Notification notification) {
        Notification addedNotification = notificationService.addNotification(notification);
        return new ResponseEntity<>(addedNotification, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/send-to-client/{clientId}")
    public ResponseEntity<Void> sendNotificationToClient(@RequestBody Notification notification, @PathVariable Long clientId) throws UserNotFoundException {
        notificationService.sendNotificationToClient(notification, clientId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/send-to-clients")
    public ResponseEntity<Void> sendNotificationToClients(@RequestBody Notification notification, @RequestParam List<Long> clientIds) {
        notificationService.sendNotificationToClients(notification, clientIds);
        return ResponseEntity.ok().build();
    }
}