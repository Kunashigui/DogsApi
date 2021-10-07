package com.api.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    List<Dog> dogs = new ArrayList<>();
    
    @GetMapping("/")
    @ResponseStatus( HttpStatus.OK )
    public String home(){
        if(dogs.isEmpty()) {
            Dog dog1 = new Dog("Taffy", "Blanco");
            Dog dog2 = new Dog("Pucho", "Blanco");
            Dog dog3 = new Dog("El Orejas", "Blanco/Cafe");
            dogs.add(dog1);
            dogs.add(dog2);
            dogs.add(dog3);
        }
        
        return "Dogs API";
    }

    @GetMapping("/dogs")
    public List<Dog> getDogs(){
        return dogs;
    }

    @PostMapping("/dogs")
    public Dog addDog(@RequestBody Dog dog){
        dogs.add(dog);
        return dog;
    }
}
