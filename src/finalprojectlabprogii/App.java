/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalprojectlabprogii;

import vista.Menu;
import controlador.Controlador;
import modelo.*;

/**
 *
 * @author Jose Miguel
 */
//100603475
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        Authors author = new Authors();
        ConsultasAuthors cAuthor = new ConsultasAuthors();
        
        Employees employee = new Employees();
        ConsultasEmployees cEmployees = new ConsultasEmployees();
         
        Publishers publisher = new Publishers();
        ConsultasPublishers cPublishers = new ConsultasPublishers();
  
        Stores store = new Stores();
        ConsultasStores cStore = new ConsultasStores();
        
        Title title = new Title();
        ConsultasTitle cTitle = new ConsultasTitle();
        
        Sales sale = new Sales();
        ConsultasSales cSale = new ConsultasSales();
        
        ConsultasTitlexStores cTitlexStores = new ConsultasTitlexStores();
        ConsultasTitlexAuthors cTitlexAuthor = new ConsultasTitlexAuthors();

        Menu menu = new Menu();
        Controlador controlador = new Controlador(author,employee,publisher,store,title,sale,cAuthor,cEmployees,cPublishers,cStore,cTitle,cSale,cTitlexStores,cTitlexAuthor,menu);
        controlador.run();
        
    }
    
}
