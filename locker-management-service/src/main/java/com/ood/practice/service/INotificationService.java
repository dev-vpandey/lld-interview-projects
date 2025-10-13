package com.ood.practice.service;

import com.ood.practice.model.Account;

public interface INotificationService {

    void sendNotification(String message, Account user);

}
