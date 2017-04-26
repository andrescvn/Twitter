package ttwiter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class Autorizacion {

    static ConfigurationBuilder cb;
    static Twitter twitter;
    static Status status;
    static DirectMessage message;
    static ArrayList <Status> twits = new ArrayList<Status>();
    static Iterator <Status>it = twits.iterator();
    /**
     * Permission to use twiter
     */
    public Autorizacion() {
        
    }
    
    public static void conexion(){
        
        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("o3jgg5Hn4yTLGCY6snhMVi0dq");
        cb.setOAuthConsumerSecret("YOq2miI66A5B3sWym1YhLtx4hhF1h5ielvSpgL0OqRDdUpB2uj");
        cb.setOAuthAccessToken("1678793768-UrxhKjGexngzxns58ZrZC2nwJYLibnlAiWssWC4");
        cb.setOAuthAccessTokenSecret("y7B0sMexOmeb86MnGTzhwnwOiSejn46QscuUVj7FbbNcX");
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }
/**
 * get the twitter timeline
 */
    public static void lineaTiempo() {

        List<Status> statuses = null;

        try {
            statuses = twitter.getHomeTimeline();
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Showing home timeline.");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":"
                        + status.getText());
                twits.add(status);
            }
    }
/**
 * post a new twit
 * @param latestStatus new twit
 */
    public static void twitearN(String latestStatus) {

        try {
            status = twitter.updateStatus(latestStatus);
            System.out.println("Successfully updated the status to [" + status.getText() + "].");
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
 * Seach for twits
 * 
 * @param busqueda word to find
 */
    public static void buscarTwit(String busqueda) {

        Query query = new Query(busqueda);
        QueryResult result;
        try {
            result = twitter.search(query);
            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
                
            }
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * send a md
     * 
     *
     * @param destinatario profile that will recive the md
     * 
     * @param mensaje messege to send
     */
    public static void enviarMensaje(String destinatario, String mensaje) {

        try {

            message = twitter.sendDirectMessage(destinatario, mensaje);
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sent: " + message.getText() + " to @" + message.getRecipientScreenName());

    }
    /**
     * get a status list
     */
    public static void seleccion(){
      while(it.hasNext()){
          
        
      }
    for(int i=0;i<twits.size();i++){
  System.out.println(twits.get(i).getUser()+""+twits.get(i).getGeoLocation()+""+twits.get(i).getText());
        
    }
       
    }
}
