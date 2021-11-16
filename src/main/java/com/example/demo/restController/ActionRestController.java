package com.example.demo.restController;

import com.example.demo.model.Action;
import com.example.demo.service.ActionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/action")
public class ActionRestController {
    private final ActionService actionService;

    public ActionRestController(ActionService actionService) {
        this.actionService = actionService;
    }

    @PostMapping("/add")
    public ResponseEntity<Action> addCashRegister(@RequestBody Action user) {
        Action action = actionService.add(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(action.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/update")
    public ResponseEntity<Action> updateCashRegister(@RequestBody Action user) {
        Action updateAction = actionService.update(user);
        return new ResponseEntity<>(updateAction, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCashRegister(@PathVariable("id") Long id) {
        actionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Action>> getAllCashRegister() {
        List<Action> user = actionService.findAll();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Action> getById(@PathVariable(value = "id") long id)
//    {
//        Action action = actionService.findById(id);
//        return ok().body(action);
//    }
}
