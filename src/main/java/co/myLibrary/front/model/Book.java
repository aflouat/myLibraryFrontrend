/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.myLibrary.front.model;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
 
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author itpm
 */
@Data @NoArgsConstructor
 public class Book implements Serializable {
    
    
    private Long id;
    @NotEmpty (message = "Title can not be empty!!")
    @javax.validation.constraints.NotNull(message = "Title can not be null!!")
    private String title;
    private int year;
    
}
