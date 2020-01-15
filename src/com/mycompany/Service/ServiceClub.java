/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.mycompany.Entite.Club;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author bhk
 */
public class ServiceClub {

    public void ajoutClub(Club c) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/mobile/web/app_dev.php/api/new";// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
         con.setPost(true);
          con.addArgument("nom_club", c.getNom_club());
          con.addArgument("domaine_club", c.getDomaine_club());
        con.addArgument("PlaceDesponible_club", Integer.toString(c.getPlaceDesponible_club()));

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<Club> parseListClubJson(String json) {
          System.out.println("DEBUG, 48, parseListClubJSON:" + json);

        ArrayList<Club> listClubs = new ArrayList<>();
       JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            listClubs.add(jsonToClub(jsonArray.getJSONObject(i)));
            
        }
         System.out.println(listClubs);
        return listClubs;

    }
       
    
    ArrayList<Club> listClubs = new ArrayList<>();
    
    public ArrayList<Club> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/web/app_dev.php/api/tasks/all");  
         con.setPost(false);
        con.addResponseListener((NetworkEvent evt) -> {
            System.out.println(con.getResponseData());
            listClubs = this.parseListClubJson(new String(con.getResponseData()));
        });
      
    
    
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listClubs;
    }
 public static void main(String[] args) {
        (new ServiceClub()).getList2();
    }
 private Club jsonToClub(JSONObject jsonObject) {
        Integer id = jsonObject.getInt("idClub");
        String nomc = jsonObject.getString("nomClub");
       
        String domc = jsonObject.getString("domaineClub");
        Integer place = jsonObject.getInt("placedesponibleClub");
        
        
        return  new Club(id,nomc, domc, place);
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



