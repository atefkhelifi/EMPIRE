/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entitie.Livre;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ASUS
 */
 public class ServiceAjout {

    public void ajoutLivre(Livre li) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/mobile/web/app_dev.php/api/new";
        /* + li.getNom_livre() + "/" + li.getAuteur_livre()+ "/" + li.getEtat_livre()+ "/" + li.getDomaine_livre()+ "/" + li.getNombreExemplaire();// création de l'URL*/
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        con.setPost(true);
        con.addArgument("nom_livre", li.getNom_livre());
        con.addArgument("auteur_livre", li.getAuteur_livre());
        con.addArgument("etat_livre", li.getEtat_livre());
        con.addArgument("domaine_livre", li.getDomaine_livre());
        con.addArgument("nombreExemplaire", Integer.toString(li.getNombreExemplaire()));

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<Livre> parseListTaskJson(String json) {

        System.out.println("DEBUG, 48, parseListTaskJSON:" + json);
        ArrayList<Livre> ListLivres = new ArrayList<>();

        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            ListLivres.add(jsonToLivre(jsonArray.getJSONObject(i)));

        }

//            
//            /*
//            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
//
//            /*
//                On doit convertir notre réponse texte en CharArray à fin de
//            permettre au JSONParser de la lire et la manipuler d'ou vient 
//            l'utilité de new CharArrayReader(json.toCharArray())
//
//            La méthode parse json retourne une MAP<String,Object> ou String est 
//            la clé principale de notre résultat.
//            Dans notre cas la clé principale n'est pas définie cela ne veux pas
//            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
//            qui est root.
//            En fait c'est la clé de l'objet qui englobe la totalité des objets 
//                    c'est la clé définissant le tableau de tâches.
//             */
//            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
//
//            /* Ici on récupère l'objet contenant notre liste dans une liste
//            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
//             */
//            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
//
//            //Parcourir la liste des tâches Json
//            for (Map<String, Object> obj : list) {
//                //Création des tâches et récupération de leurs données
//                Livre e = new Livre();
//
//                float id = Float.parseFloat(obj.get("id_livre").toString());
//                float nbr = Float.parseFloat(obj.get("nombreExemplaire").toString());
//
//                e.setId_livre((int) id);
//                e.setEtat_livre(obj.get("etat_livre").toString());
//                e.setNom_livre(obj.get("nom_livre").toString());
//                e.setDomaine_livre(obj.get("domaine_livre").toString());
//                e.setAuteur_livre(obj.get("auteur_livre").toString());
//                e.setNombreExemplaire((int) nbr);
//                System.out.println(e);
//
//                ListLivres.add(e);
//
//            }
//

        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        System.out.println(ListLivres);
        return ListLivres;

    }

    ArrayList<Livre> listTasks = new ArrayList<>();

    public ArrayList<Livre> getList2() {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/web/app_dev.php/api/all");
        con.setPost(false);
        con.addResponseListener((NetworkEvent evt) -> {
            System.out.println(con.getResponseData());
            listTasks = this.parseListTaskJson(new String(con.getResponseData()));
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }

    private Livre jsonToLivre(JSONObject jsonObject) {
        Integer id = jsonObject.getInt("idLivre");
        String nomL = jsonObject.getString("nomLivre");
        String nomA = jsonObject.getString("auteurLivre");
        String etatL = jsonObject.getString("etatLivre");
        String domL = jsonObject.getString("domaineLivre");
        Integer nbrE = jsonObject.getInt("nombreexemplaire");

        return new Livre(id, nomL, nomA, etatL, domL, nbrE);
    }

    public void Supprimer(int id_livre) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/mobile/web/app_dev.php/api/"+id_livre+"/delete");
        con.setPost(false);
        con.addResponseListener((evt) -> {
            System.out.println(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }

}
