package com.bigrestaurant.fmi.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditService {

    private static AuditService myInstance = new AuditService();

    public static AuditService getInstance() {
        return myInstance;
    }

    public void logAction(String action){
        LocalDateTime dateNow = LocalDateTime.now();
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String timestamp = dateNow.format(formatObj);
        FileTextService.getInstance().appendTextToFile(action + "," + timestamp, "./files/logs.csv");
    }

    private AuditService(){}
}
