/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 *
 * @author Daniel Varón
 */

@Service ("AnotherBlueprintsPersistence")
public class AnotherBlueprintsPersistence implements BlueprintsPersistence{

    @Override
    public void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException {

    }

    @Override
    public Blueprint getBlueprint(String author, String bprintname) throws BlueprintNotFoundException {
        return null;
    }

    @Override
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException {
        return null;      
    }

    @Override
    public Set<Blueprint> getAllBlueprints() throws BlueprintNotFoundException {
        return null;
    }

    @Override
    public void modyfyornewBlueprint(Blueprint bp, String author, String blueprintName) throws BlueprintPersistenceException {

    }
}
