package com.atanu.userService.Controller;

import com.atanu.userService.dto.UserDto;
import com.atanu.userService.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/user")
public class UserServiceController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        String userId= UUID.randomUUID().toString();
        user.setUserId(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.creteUser(user));
    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<UserDto> getSingleUser(@PathVariable String id){
//        return ResponseEntity.status(HttpStatus.OK).body(userService.getSingleUser(id));
//    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity getRating(@PathVariable String username){
        WebClient webClient = WebClient.create("http://localhost:8082");
        Mono<List> ratingList = webClient.get().uri("/rating/"+username).retrieve().bodyToMono(List.class);
        System.out.println(ratingList.block());
        return ResponseEntity.ok(ratingList.block());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUser(user));
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteUser(@PathVariable String id){
        return userService.deleteUser(id);
    }


}
