/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author hcadavid
 */
@Service("InMemoryBlueprintPersistence")
public class InMemoryBlueprintPersistence implements BlueprintsPersistence{

    private final Map<Tuple<String,String>,Blueprint> blueprints=new HashMap<>();

    public InMemoryBlueprintPersistence() {
        //load stub data
        Point[] pts=new Point[]{new Point(140, 140),new Point(115, 115)};
        Blueprint bp=new Blueprint("Pepito", "plano1",pts);
        blueprints.put(new Tuple<>(bp.getAuthor(),bp.getName()), bp);
        pts=new Point[]{new Point(10, 20),new Point(50, 60)};
        bp=new Blueprint("Pepito", "plano2",pts);
        blueprints.put(new Tuple<>(bp.getAuthor(),bp.getName()), bp);
        pts=new Point[]{new Point(40, 30),new Point(70, 80)};
        bp=new Blueprint("Juanito", "plano3",pts);
        blueprints.put(new Tuple<>(bp.getAuthor(),bp.getName()), bp);
        
    }    
    
    @Override
    public synchronized void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        if (blueprints.containsKey(new Tuple<>(bp.getAuthor(),bp.getName()))) throw new BlueprintPersistenceException("The given blueprint already exists: "+bp);
        else{
            blueprints.put(new Tuple<>(bp.getAuthor(),bp.getName()), bp);
        }        
    }

    @Override
    public synchronized Blueprint getBlueprint(String author, String bprintname) throws BlueprintNotFoundException {
        if(!blueprints.containsKey(new Tuple<>(author, bprintname))) throw new BlueprintNotFoundException("No existe blueprint con nombre "+bprintname+" del autor "+author);
        return blueprints.get(new Tuple<>(author, bprintname));
    }

    @Override
    public synchronized Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException {

        Set<Blueprint> bpByAuthor = new HashSet<>();
        for (Tuple<String, String> x : blueprints.keySet()){
            if (author.equals(x.getElem1())) {
                bpByAuthor.add(blueprints.get(x));
            }
        }
        if(bpByAuthor.isEmpty()) throw new BlueprintNotFoundException("No existen blueprints del autor "+author+"." );
        return bpByAuthor;
    }

    @Override
    public synchronized Set<Blueprint> getAllBlueprints() throws BlueprintNotFoundException {
        Set<Blueprint> bps = new HashSet<>();
        for (Tuple<String, String> x : blueprints.keySet()){
            bps.add(blueprints.get(x));
        }
        if(bps.isEmpty()) throw new BlueprintNotFoundException("No existen blueprints.");
        return bps;
    }

    @Override
    public synchronized void modyfyornewBlueprint(Blueprint bp, String author, String blueprintName) throws BlueprintPersistenceException {
        if(!blueprints.containsKey(new Tuple<>(author, blueprintName))) saveBlueprint(bp);
        else blueprints.put(new Tuple<>(author, blueprintName),bp);
    }


}
