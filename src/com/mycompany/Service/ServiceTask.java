/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Events;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author bhk
 */
public class ServiceTask {

    public void ajoutTask(Events ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/mobile/web/app_dev.php/api/new";
        con.setUrl(Url);
// Insertion de l'URL de notre demande de connexion
        con.setPost(true);
        System.out.println("eeeee");
        con.addArgument("nom_event", ta.getNom());
        con.addArgument("localisation_event", ta.getLocalisation());
        con.addArgument("prix_event", Integer.toString(ta.getPrix()));
        con.addArgument("place_dispo", Integer.toString(ta.getPlaceDispo()));
      //  con.addArgument("nombreExemplaire", Date.toString(ta.getDt()));

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<Events> parseListTaskJson(String json) {

        System.out.println("DEBUG, 48, parseListTaskJSON:" + json);
        ArrayList<Events> ListEvent = new ArrayList<>();

        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            ListEvent.add(jsonToEvent(jsonArray.getJSONObject(i)));
            
        }// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
             */
          

        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        System.out.println(ListEvent);
        return ListEvent;

    }

    ArrayList<Events> ListTasks = new ArrayList<>();

    public ArrayList<Events> getList2() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/web/app_dev.php/api/all");
        con.setPost(false);
       con.addResponseListener(((evt) -> {
           System.out.println(con.getResponseData());
            ListTasks= this.parseListTaskJson(new String(con.getResponseData()));
                    }));
        NetworkManager.getInstance().addToQueueAndWait(con);
        return ListTasks;
    }
       private Events jsonToEvent(JSONObject jsonObject) {
       Integer id = jsonObject.getInt("id");
        String nomL = jsonObject.getString("nomEvent");
        String nomA = jsonObject.getString("localisationEvent");
        Integer prixl = jsonObject.getInt("prixEvent");
        //String domL = jsonObject.getString("domaineLivre");
        Integer nbrE = jsonObject.getInt("placeDispo");
        
        
        return  new Events(id,nbrE,prixl,nomA,nomL);
    }
   public void Supprimer(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/web/app_dev.php/api/"+id+"/delete");
        con.setPost(false);
        con.addResponseListener((evt) -> {
            System.out.println(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
       

}
