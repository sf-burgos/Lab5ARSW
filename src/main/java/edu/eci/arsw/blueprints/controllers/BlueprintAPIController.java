package edu.eci.arsw.blueprints.controllers;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/blueprints")
public class BlueprintAPIController {

    @Autowired
    BlueprintsServices bps;


    /*GET*/

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> GetBlueprints() {


        try {
            return new ResponseEntity<>(bps.getAllBlueprints(), HttpStatus.ACCEPTED);
        } catch (BlueprintNotFoundException ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path ="/{author}",method = RequestMethod.GET)
    public ResponseEntity<?> GetBlueprintsByAuthor(@PathVariable("author") String authorName){
        try {
            return new ResponseEntity<>(bps.getBlueprintsByAuthor(authorName),HttpStatus.ACCEPTED);
        } catch (BlueprintNotFoundException ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path ="/{author}/{name}",method = RequestMethod.GET)
    public ResponseEntity<?> GetBlueprintByAuthorAndName(@PathVariable ("author") String authorName, @PathVariable ("name") String blueprintName){
        try {
            return new ResponseEntity<>(bps.getBlueprint(authorName, blueprintName),HttpStatus.ACCEPTED);
        } catch (BlueprintNotFoundException ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    /*Post*/

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> AddBlueprint(@RequestBody Blueprint o){
        try {
            bps.addNewBlueprint(o);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (BlueprintPersistenceException ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }

    }

    @RequestMapping(path = "/{author}/{name}",method = RequestMethod.PUT)
    public ResponseEntity<?> PutBlueprint(@PathVariable ("author") String authorName, @PathVariable ("name") String blueprintName, @RequestBody Blueprint o ){

        try {
            bps.modyfyornewBlueprint(o, authorName, blueprintName);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (BlueprintPersistenceException ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }
    }

}
