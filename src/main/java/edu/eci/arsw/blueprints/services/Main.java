package edu.eci.arsw.blueprints.services;


import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

public class Main {
    /*
    public static void  main(String[] args )  {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bpp = ac.getBean(BlueprintsServices.class);
        try {
            Point[] pts0 = new Point[]{new Point(30, 30), new Point(5, 5), new Point(5, 5), new Point(8,5), new Point(5,8), new Point(1,1), new Point(1,1)};
            Blueprint bp0 = new Blueprint("intento", "onepaint", pts0);
            Blueprint bp1 = new Blueprint("intento", "twopaint", pts0);
            bpp.addNewBlueprint(bp0);
            bpp.addNewBlueprint(bp1);
            Set<Blueprint> byAuthor = bpp.getBlueprintsByAuthor("intento");
            System.out.println("-----Por autores:-----");
            for(Blueprint e : byAuthor){
                System.out.print("Autor: "+e.getAuthor()+ " Plano: "+e.getName());
                for(Point f:e.getPoints()){
                    System.out.print("["+f.getX()+","+f.getY()+"]");
                }
                System.out.println("\n");
            }

            System.out.println("\n-----Por autor y nombre:-----");
            System.out.print(bpp.getBlueprint("intento", "onepaint").getName());
            for(Point e:bpp.getBlueprint("intento", "onepaint").getPoints()){
                System.out.print("["+e.getX()+","+e.getY()+"]");
            }
        }catch (BlueprintNotFoundException | BlueprintPersistenceException e) {
            e.printStackTrace();
        }


    }
     */
}
