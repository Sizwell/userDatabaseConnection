package com.example.demo;

import com.example.demo.connection.ServerConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class VehicleManagementApplication  {

    public static void main(String[] args) {
        SpringApplication.run(VehicleManagementApplication.class, args);

        new ServerConnection().driver();

    }

}


