package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.FiltersPersistence;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brayan Burgos
 * @author Daniel Varón
 */
@Service("SubSampling")
public class SubSamplingFilters implements FiltersPersistence {
    @Override
    public Blueprint Filters(Blueprint bpp) {
        List<Point> lista = bpp.getPoints();
        List<Point> salida = new ArrayList<Point>();
        boolean it=true;
        for(Point p : lista){
            if(it) salida.add(p);
            it=!it;
        }
        return new Blueprint(bpp.getAuthor(),bpp.getName(),salida);
    }
}
