/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.myLibrary.front.repository;

import co.myLibrary.front.CustomProperties;
import co.myLibrary.front.model.Book;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author itpm
 */
@Slf4j
@Component
public class BookProxy {
    
    @Autowired
    private CustomProperties customProperties;
    
    public Iterable<Book> getBooks(){
        String baseApiUrl = customProperties.getApiUrl();
        String getBooksUrl = baseApiUrl + "/books";
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Book>> response = restTemplate.exchange(getBooksUrl, HttpMethod.GET,null,
                new ParameterizedTypeReference<Iterable<Book>>(){});
        log.info("getBooksUrl call " + response.getStatusCode().toString());
        return response.getBody();
    }
    
    public Book createBook(Book book){
         String baseApiUrl = customProperties.getApiUrl();
        String postBookUrl = baseApiUrl + "/book";
        HttpEntity<Book> request = new HttpEntity<Book>(book);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Book> response = restTemplate.exchange(postBookUrl, HttpMethod.POST,request,
                Book.class);
        log.debug("postBooksUrl call " + response.getStatusCode().toString());
        return response.getBody();
    }
    
    public Book updateBook(Book book, Long id){
         String baseApiUrl = customProperties.getApiUrl();
        String putBookUrl = baseApiUrl + "/book/{" + id + "}";
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Book> response = restTemplate.exchange(putBookUrl, HttpMethod.PUT,null,
                Book.class);
        log.info("postBooksUrl call " + response.getStatusCode().toString());
        return response.getBody();
    }

    public Book getBook(Long id) {
            String baseApiUrl = customProperties.getApiUrl();
        String getBookUrl = baseApiUrl + "/book/{" + id + "}";
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Book> response = restTemplate.exchange(getBookUrl, HttpMethod.GET,null,
                Book.class);
        log.info("getBooksUrl call " + response.getStatusCode().toString());
        return response.getBody(); 
    }

    public void deleteBook(Long id) {
            String baseApiUrl = customProperties.getApiUrl();
        String deleteBookUrl = baseApiUrl + "/book/{id}";
        Map < String, Long > params = new HashMap<String, Long > ();
        params.put("id", id);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(deleteBookUrl, params);
    }
    
    
    
}
