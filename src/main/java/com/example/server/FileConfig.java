package com.example.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class FileConfig {

    @Bean
    public String directoryLocation() {
        System.out.print("\n\n\n\n\nУкажите полный путь до директории с файлами, названия файлов могут содержать A-Z,a-z,0-9: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
