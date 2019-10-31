/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionbib.gui;

/**
 *
 * @author Admin
 */
import edu.gestionbib.entities.Livres;
import javafx.util.StringConverter;
 
public class LivresConverter extends StringConverter<Livres>
{
    public LivresConverter()
    {
    }

    // Method to convert a Person-Object to a String
    @Override
    public String toString(Livres person) {
        return person == null? null : person.getNom_livre() + ", " + person.getId_livre();
    }
 
    // Method to convert a String to a Person-Object
    @Override
    public Livres fromString(String string)
    {
        Livres person = null;
 
        if (string == null)
        {
            return person;
        }
 
        int commaIndex = string.indexOf(",");
 
        if (commaIndex == -1)
        {
           // person = new Livres(string, null);
        }
        else
        {
           // String firstName = string.substring(commaIndex + 2);
            String lastName = string.substring(0, commaIndex);
            person = new Livres(commaIndex, lastName);
        }
 
        return person;
    }
}
