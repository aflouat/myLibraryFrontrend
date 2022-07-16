/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.myLibrary.front;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author itpm
 */
@Data
@Configuration
@ConfigurationProperties(prefix="co.mylibrary.front")
public class CustomProperties {
    private String apiUrl;
    
}
