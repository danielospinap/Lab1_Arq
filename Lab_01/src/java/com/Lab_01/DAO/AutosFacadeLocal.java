/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Lab_01.DAO;

import com.Lab_01.modelo.Autos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Felipe
 */
@Local
public interface AutosFacadeLocal {

    void create(Autos autos);

    void edit(Autos autos);

    void remove(Autos autos);

    Autos find(Object id);

    List<Autos> findAll();

    List<Autos> findRange(int[] range);

    int count();
    
    //metodo para ver si compila
    void clear();
}
