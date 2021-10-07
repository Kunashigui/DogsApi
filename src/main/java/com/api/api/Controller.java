package com.api.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    
    @GetMapping("/")
    @ResponseStatus( HttpStatus.OK )
    public String home(){
        return "Dogs API";
    }

    @GetMapping("/dogs")
    public List<Dog> getDogs(){
        Dog dog1 = new Dog("Taffy", "Blanco");
        Dog dog2 = new Dog("Pucho", "Blanco");
        Dog dog3 = new Dog("El Orejas", "Blanco/Cafe");

        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);

        return dogs;
    }

    @PostMapping("/dogs")
    public Dog addDog(@RequestBody Dog dog){
        return dog;
    }
}
