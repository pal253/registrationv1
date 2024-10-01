package com.api1.controller;

import com.api1.entity.Registration;
import com.api1.payload.RegistrationDto;
import com.api1.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    private RegistrationService rs;


    public RegistrationController(RegistrationService rs) {
        this.rs = rs;
    }

    @GetMapping
    public ResponseEntity<List<RegistrationDto>> getAllRegistrations() {
        List<RegistrationDto> dtos = rs.getRegistrations();
        return new ResponseEntity<>(dtos, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<?> createAllRegistrations(
@Valid  @RequestBody RegistrationDto registrationDto , BindingResult result
    ) {
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.CREATED);
        }
        RegistrationDto regdto = rs.createReg(registrationDto);
        return new ResponseEntity<>(regdto , HttpStatus.CREATED);


    }
    @DeleteMapping
    public ResponseEntity <String> deleteRegistrations(
            @RequestParam long id
    ){
rs.deleteReg(id);
return new ResponseEntity<>("deleted" , HttpStatus.OK);
    }
@PutMapping ("/{id}")
    public ResponseEntity <Registration> updateRegistrations(@PathVariable long id ,
@RequestBody Registration registration){
Registration h = rs.updateReg(id , registration);
return new ResponseEntity<>(h , HttpStatus.OK);
}
@GetMapping("/{id}")
    public ResponseEntity <RegistrationDto> getRegistrationById(@PathVariable long id){
      RegistrationDto dto =  rs.getRegById(id);
      return new ResponseEntity<>(dto ,HttpStatus.OK );

}











}

