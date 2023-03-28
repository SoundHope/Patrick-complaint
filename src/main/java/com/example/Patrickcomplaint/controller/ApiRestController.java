package com.example.Patrickcomplaint.controller;

import com.example.Patrickcomplaint.entity.Client;
import com.example.Patrickcomplaint.entity.Complaint;
import com.example.Patrickcomplaint.service.ClientService;
import com.example.Patrickcomplaint.service.ComplaintService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiRestController {
    private final ClientService clientService;
    private final ComplaintService complaintService;

    public ApiRestController(ClientService clientService, ComplaintService complaintService) {
        this.clientService = clientService;
        this.complaintService = complaintService;
    }

    @GetMapping("/")
    @ResponseBody
    ResponseEntity<Optional<Client>> get(@RequestParam String dni){
        Optional<Client> client = clientService.getClient(dni);
        if (client.isPresent()){
            return new ResponseEntity<>(client, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    ResponseEntity<Optional<Client>> login(@RequestBody String data) throws JSONException {
        JSONObject parsed_data  = new JSONObject(data);
        String dni = parsed_data.get("dni").toString();
        String password = parsed_data.get("password").toString();
        Optional<Client> client_login = clientService.login(dni, password);
        if (client_login.isPresent()){
            return new ResponseEntity<>(client_login, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/complaint")
    ResponseEntity<Complaint> registerComplaint(@RequestBody Complaint newComplaint) {
        return new ResponseEntity<>(complaintService.register(newComplaint), HttpStatus.CREATED);
    }

    @GetMapping("/complaint")
    ResponseEntity<List<Complaint>> registerComplaint() {
        List<Complaint> complaints = complaintService.getAll();
        return new ResponseEntity<>(complaints, HttpStatus.OK);
    }


}
