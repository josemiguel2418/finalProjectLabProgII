/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.sql.Timestamp;
import vista.Menu;
import modelo.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Jose Miguel
 */
//100603475
public class Controlador {
    
    private Authors author;   
    private Employees employee; 
    private Publishers publisher;
    private Stores store;
    private Title title;
    private Sales sale;
      
    private ConsultasAuthors cAuthor;
    private ConsultasEmployees cEmployee;
    private ConsultasPublishers cPublishers;
    private ConsultasStores cStore;
    private ConsultasTitle cTitle;
    private ConsultasSales cSale;
    private ConsultasTitlexStores cTitlexStore;
    private ConsultasTitlexAuthors cTitlexAuthor;
    

    private ArrayList<Authors> authors = new ArrayList<Authors>();
    private ArrayList<Employees> employees = new ArrayList<Employees>();
    private ArrayList<Publishers> publishers = new ArrayList<Publishers>();
    private ArrayList<Stores> stores = new ArrayList<Stores>();
    private ArrayList<Title> titles = new ArrayList<Title>();
    private ArrayList<Sales> sales = new ArrayList<Sales>();
    private ArrayList<String> titlexStores = new ArrayList<String>();
    private ArrayList<String> titlexAuthors = new ArrayList<String>();
    
    private Menu menu;
    
    public Controlador(Authors au, Employees em,Publishers pu,Stores st,Title ti,Sales sa,ConsultasAuthors cAu,ConsultasEmployees cEm,ConsultasPublishers cPu,ConsultasStores cSt, ConsultasTitle cTi,ConsultasSales cS,ConsultasTitlexStores cTs,ConsultasTitlexAuthors cTa,Menu menu){
        this.author = au;
        this.employee = em;
        this.publisher = pu;
        this.store = st;
        this.title = ti;
        this.sale = sa;
        this.cAuthor = cAu;
        this.cEmployee = cEm;
        this.cPublishers = cPu;
        this.cStore = cSt;
        this.cTitle = cTi;
        this.cSale = cS;
        this.cTitlexStore = cTs;
        this.cTitlexAuthor = cTa;
        this.menu = menu;
    }
    
    private void gestionarAutores(int opcion){
        Scanner scanner = new Scanner(System.in);
        String au_id;
        String au_lname;
        String au_fname;
        String phone;
        String address;
        String city;
        String state;
        String zip;
        byte contract = 1;
        
        switch(opcion){
            case 1:
                authors = cAuthor.get();
                    for(Authors autor: authors){
                       System.out.println("------------------------------------------"); 
                       System.out.println("Id: " + autor.getAu_id());
                       System.out.println("Nombre: " + autor.getAu_fname() + " " + autor.getAu_lname());
                       System.out.println("Telefono: " + autor.getPhone());
                       System.out.println("Direccion: " + autor.getAddress());
                       System.out.println("Ciudad: " + autor.getCity());
                       System.out.println("Estado: " + autor.getState());
                       System.out.println("Zip: " + autor.getZip());
                       System.out.println("Contract: " + autor.getContract());
                       System.out.println("------------------------------------------");
                    }
                    System.out.println();
                    
                    break;
            case 2:
                System.out.println("Escribe el ID del autor:");
                au_id = scanner.next();
                
                System.out.println("Escribe el nombre del autor:");
                au_fname = scanner.next();
                
                System.out.println("Escribe el apellido del autor:");
                au_lname = scanner.next();
                
                System.out.println("Escribe el telefono del autor:");
                phone = scanner.next();
                
                System.out.println("Escribe la direccion del autor:");
                address = scanner.next();
                
                System.out.println("Escribe la ciudad del autor:");
                city = scanner.next();
                
                System.out.println("Escribe el estado del autor:");
                state = scanner.next();
                
                System.out.println("Escribe el codigo zip:");
                zip = scanner.next();
                
                author.setAu_id(au_id);
                author.setAu_lname(au_lname);
                author.setAu_fname(au_fname);
                author.setPhone(phone);
                author.setAddress(address);
                author.setCity(city);
                author.setState(state);
                author.setZip(zip);
                author.setContract(contract);
                          
                 
                if(cAuthor.post(author)){
                    System.out.println("-----Autor Agregada con exito-----");
                        
                }else{
                    System.out.println("No se ha podido agregar");
                }
                break;
            case 3:
                System.out.println("Escribe el id del autor que deseas modificar:");
                au_id = scanner.next();
                
                System.out.println("Escribe el nombre del autor:");
                au_fname = scanner.next();
                
                System.out.println("Escribe el apellido del autor:");
                au_lname = scanner.next();
                
                System.out.println("Escribe el telefono del autor:");
                phone = scanner.next();
                
                System.out.println("Escribe la direccion del autor:");
                address = scanner.next();
                
                System.out.println("Escribe la ciudad del autor:");
                city = scanner.next();
                
                System.out.println("Escribe el estado del autor:");
                state = scanner.next();
                
                System.out.println("Escribe el codigo zip:");
                zip = scanner.next();
                
                author.setAu_id(au_id);
                author.setAu_lname(au_lname);
                author.setAu_fname(au_fname);
                author.setPhone(phone);
                author.setAddress(address);
                author.setCity(city);
                author.setState(state);
                author.setZip(zip);
                author.setContract(contract);
                    
                   
                if(cAuthor.put(author)){
                    System.out.println("-----Autor modificado con exito-----");
                }else{
                    System.out.println("-----No se pudo modificar-----");
                }
                break;
            case 4:
                System.out.println("Escribe el id del autor que deseas eliminar");
                    au_id = scanner.next();
                    author.setAu_id(au_id);
                    
                    if(cAuthor.delete(author)){
                        System.out.println("-----Autor eliminado-----");
                    }
                        
                    else{
                        System.out.println("-----No se pudo eliminar-----");
                    }
           
                    break;
            case 5:
                System.out.println("Volviendo atras...");
                break;
            default: 
                System.out.println("---------------Opcion no disponible---------------");
        }
        System.out.println("\n");     
    }
    
    private void gestionarEmpleados(int opcion){
        Scanner scanner = new Scanner(System.in);
        String emp_id;
        String fname;
        String minit = "A";
        String lname;
        int job_id;
        int job_lvl;
        String pub_id;
        Timestamp hire_date = new Timestamp(System.currentTimeMillis());
        
        
        switch(opcion){
            case 1:
                employees = cEmployee.get();
                    for(Employees empleado: employees){
                       System.out.println("------------------------------------------"); 
                       System.out.println("Id empleado: " + empleado.getEmp_id());
                       System.out.println("Nombre: " + empleado.getFname() + " " + empleado.getLname());
                       System.out.println("Minit: " + empleado.getMinit());
                       System.out.println("Job Id: " + empleado.getJob_id());
                       System.out.println("Job level: " + empleado.getJob_lvl());
                       System.out.println("Pub id: " + empleado.getPub_id());
                       System.out.println("Hire date: " + empleado.getHire_date());
                      
                       System.out.println("------------------------------------------");
                    }
                    System.out.println();
                    
                    break;
            case 2:
                System.out.println("Escribe el ID del empleado:");
                emp_id = scanner.next();
                
                System.out.println("Escribe el nombre del empleado:");
                fname = scanner.next();
                
                System.out.println("Escribe el apellido del empleado:");
                lname = scanner.next();
                
                System.out.println("Escribe el job id:");
                job_id = scanner.nextInt();
                
                System.out.println("Escribe el job lvl:");
                job_lvl = scanner.nextInt();
                
                System.out.println("Escribe el pub id:");
                pub_id = scanner.next();
              
                employee.setEmp_id(emp_id);
                employee.setFname(fname);
                employee.setLname(lname);
                employee.setJob_id(job_id);
                employee.setJob_lvl(job_lvl);
                employee.setPub_id(pub_id);
                employee.setMinit(minit);
                employee.setHire_date(hire_date);
                                
                if(cEmployee.post(employee)){
                    System.out.println("-----Empleado Agregado con exito-----");
                        
                }else{
                    System.out.println("No se ha podido agregar");
                }
                break;
            case 3:
                System.out.println("Escribe el id del empleado que deseas modificar:");
                emp_id = scanner.next();
                
                System.out.println("Escribe el nombre del empleado:");
                fname = scanner.next();
                
                System.out.println("Escribe el apellido del empleado:");
                lname = scanner.next();
                
                System.out.println("Escribe el job id:");
                job_id = scanner.nextInt();
                
                System.out.println("Escribe el job lvl:");
                job_lvl = scanner.nextInt();
                
                System.out.println("Escribe el pub id:");
                pub_id = scanner.next();
                
                employee.setEmp_id(emp_id);
                employee.setFname(fname);
                employee.setLname(lname);
                employee.setJob_id(job_id);
                employee.setJob_lvl(job_lvl);
                employee.setPub_id(pub_id);
                employee.setMinit(minit);
                employee.setHire_date(hire_date);
                          
                if(cEmployee.put(employee)){
                    System.out.println("-----Emoleado modificado con exito-----");
                }else{
                    System.out.println("-----No se pudo modificar-----");
                }
                break;
            case 4:
                System.out.println("Escribe el id del empleado que deseas eliminar");
                    emp_id = scanner.next();
                    employee.setEmp_id(emp_id);
                    
                    if(cEmployee.delete(employee)){
                        System.out.println("-----Empleado eliminado-----");
                    }
                        
                    else{
                        System.out.println("-----No se pudo eliminar-----");
                    }
           
                    break;
            case 5:
                System.out.println("Volviendo atras...");
                break;
            default: 
                System.out.println("---------------Opcion no disponible---------------");
        }
        System.out.println("\n");     
    }
    
    private void gestionarTiendas(int opcion){
        Scanner scanner = new Scanner(System.in);
        String stor_id;
        String stor_name;
        String stor_address;
        String city;
        String state;
        String zip;
        
        switch(opcion){
            case 1:
                stores = cStore.get();
                    for(Stores tienda: stores){
                       System.out.println("------------------------------------------"); 
                       System.out.println("Id: " + tienda.getStor_id());
                       System.out.println("Nombre: " + tienda.getStor_name());
                       System.out.println("Direccion: " + tienda.getStor_address());
                       System.out.println("Ciudad: " + tienda.getCity());
                       System.out.println("Estado: " + tienda.getState());
                       System.out.println("Zip: " + tienda.getZip());
                       System.out.println("------------------------------------------");
                    }
                    System.out.println();
                    
                    break;
            case 2:
                System.out.println("Escribe el ID de la tienda:");
                stor_id = scanner.next();
                
                System.out.println("Escribe el nombre de la tienda:");
                stor_name = scanner.next();
                
                System.out.println("Escribe la direccion de la tienda:");
                stor_address = scanner.next();
                
                System.out.println("Escribe la ciudad en que esta la tienda:");
                city = scanner.next();
                
                System.out.println("Escribe el estado en que esta la tienda:");
                state = scanner.next();
                
                System.out.println("Escribe el zip:");
                zip = scanner.next();

                
                store.setStor_id(stor_id);
                store.setStor_address(stor_address);
                store.setStor_name(stor_name);
                store.setCity(city);
                store.setState(state);
                store.setZip(zip);
                
                          
                 
                if(cStore.post(store)){
                    System.out.println("-----Tienda Agregada con exito-----");
                        
                }else{
                    System.out.println("No se ha podido agregar");
                }
                break;
            case 3:
                System.out.println("Escribe el id de la tienda que deseas modificar:");
                stor_id = scanner.next();
                
                System.out.println("Escribe el nombre de la tienda:");
                stor_name = scanner.next();
                
                System.out.println("Escribe la direccion de la tienda:");
                stor_address = scanner.next();
                
                System.out.println("Escribe la ciudad en que esta la tienda:");
                city = scanner.next();
                
                System.out.println("Escribe el estado en que esta la tienda:");
                state = scanner.next();
                
                System.out.println("Escribe el zip:");
                zip = scanner.next();
                
                store.setStor_id(stor_id);
                store.setStor_address(stor_address);
                store.setStor_name(stor_name);
                store.setCity(city);
                store.setState(state);
                store.setZip(zip);
                   
                if(cStore.put(store)){
                    System.out.println("-----Tienda modificada con exito-----");
                }else{
                    System.out.println("-----No se pudo modificar-----");
                }
                break;
            case 4:
                System.out.println("Escribe el id de la tienda que deseas eliminar");
                    stor_id = scanner.next();
                    store.setStor_id(stor_id);
                    
                    if(cStore.delete(store)){
                        System.out.println("-----Tienda eliminada-----");
                    }
                        
                    else{
                        System.out.println("-----No se pudo eliminar-----");
                    }
           
                    break;
            case 5:
                System.out.println("Volviendo atras...");
                break;
            default: 
                System.out.println("---------------Opcion no disponible---------------");
        }
        System.out.println("\n");     
    }
    
    private void gestionarTitulos(int opcion){
        Scanner scanner = new Scanner(System.in);
        String title_id;
	String bookTitle;
	String type;
	String pud_id;
	double price;
	double advance = 0;
	int royalti = 0;
	int ytd_sales = 0;
	String notes;
	Timestamp pudDate = new Timestamp(System.currentTimeMillis());
        
        
        switch(opcion){
            case 1:
                titles = cTitle.get();
                    for(Title titulo: titles){
                       System.out.println("------------------------------------------"); 
                       System.out.println("Id: " + titulo.getTitle_id());
                       System.out.println("Titulo: " + titulo.getTitle());
                       System.out.println("Type: " + titulo.getType());
                       System.out.println("pub_id: " + titulo.getPud_id());
                       System.out.println("price: " + titulo.getPrice());
                       System.out.println("advance: " + titulo.getAdvance());
                       System.out.println("Royalty: " + titulo.getRoyalti());
                       System.out.println("ytd_sales: " + titulo.getYtd_sales());
                       System.out.println("notes: " + titulo.getNotes());
                       System.out.println("Pub date: " + titulo.getPudDate());
                       System.out.println("------------------------------------------");
                    }
                    System.out.println();
                    
                    break;
            case 2:
                System.out.println("Escribe el ID del Titulo:");
                title_id = scanner.next();
                
                System.out.println("Escribe el titulo:");
                bookTitle = scanner.next();
                
                System.out.println("Escribe el tipo:");
                type = scanner.next();
                
                System.out.println("Escribe el pub_id:");
                pud_id = scanner.next();
                
                System.out.println("Escribe el precio:");
                price = scanner.nextDouble();
                
                System.out.println("Escribe una nota sobre el libro:");
                notes = scanner.next();
                   
                title.setTitle_id(title_id);
                title.setTitle(bookTitle);
                title.setType(type);
                title.setPud_id(pud_id);
                title.setPrice(price);
                title.setNotes(notes);
                title.setAdvance(advance);
                title.setRoyalti(royalti);
                title.setYtd_sales(ytd_sales);
                title.setPudDate(pudDate);
                          
                 
                if(cTitle.post(title)){
                    System.out.println("-----Titulo Agregado con exito-----");
                        
                }else{
                    System.out.println("No se ha podido agregar");
                }
                break;
            case 3:
                System.out.println("Escribe el id del titulo que deseas modificar:");
                title_id = scanner.next();
                
                System.out.println("Escribe el titulo:");
                bookTitle = scanner.next();
                
                System.out.println("Escribe el tipo:");
                type = scanner.next();
                
                System.out.println("Escribe el pub_id:");
                pud_id = scanner.next();
                
                System.out.println("Escribe el precio:");
                price = scanner.nextDouble();
                
                System.out.println("Escribe una nota sobre el libro:");
                notes = scanner.next();
                
                title.setTitle_id(title_id);
                title.setTitle(bookTitle);
                title.setType(type);
                title.setPud_id(pud_id);
                title.setPrice(price);
                title.setNotes(notes);
                title.setAdvance(advance);
                title.setRoyalti(royalti);
                title.setYtd_sales(ytd_sales);
                title.setPudDate(pudDate);
                    
                   
                if(cTitle.put(title)){
                    System.out.println("-----Titulo modificado con exito-----");
                }else{
                    System.out.println("-----No se pudo modificar-----");
                }
                break;
            case 4:
                System.out.println("Escribe el id del titulo que deseas eliminar");
                    title_id = scanner.next();
                    title.setTitle_id(title_id);
                    
                    if(cTitle.delete(title)){
                        System.out.println("-----Titulo eliminado-----");
                    }
                        
                    else{
                        System.out.println("-----No se pudo eliminar-----");
                    }
           
                    break;
            case 5:
                System.out.println("Volviendo atras...");
                break;
            default: 
                System.out.println("---------------Opcion no disponible---------------");
        }
        System.out.println("\n");     
    }
    
    private void gestionarEditoras(int opcion){
        Scanner scanner = new Scanner(System.in);
        String pubId;
        String pubName;
        String city;
        String state;
        String country;
        
        switch(opcion){
            case 1:
                publishers = cPublishers.get();
                    for(Publishers editoras: publishers){
                       System.out.println("------------------------------------------"); 
                       System.out.println("Pub Id: " + editoras.getPubId());
                       System.out.println("Pub name: " + editoras.getPubName());
                       System.out.println("Estado: " + editoras.getState());
                       System.out.println("Ciudad: " + editoras.getCity());
                       System.out.println("Pais: " + editoras.getCountry());
                       System.out.println("------------------------------------------");
                    }
                    System.out.println();
                    
                    break;
            case 2:
                System.out.println("Escribe el ID de la editora:");
                pubId = scanner.next();
                
                System.out.println("Escribe el nombre de la editora:");
                pubName = scanner.next();
                
                System.out.println("Escribe la ciudad de donde es la editora:");
                city = scanner.next();
                
                System.out.println("Escribe el estado de donde es la editora:");
                state = scanner.next();
                
                System.out.println("Escribe el pais de donde es la editora:");
                country = scanner.next();
         
                publisher.setPubId(pubId);
                publisher.setPubName(pubName);
                publisher.setCity(city);
                publisher.setState(state);
                publisher.setCountry(country);
               
                if(cPublishers.post(publisher)){
                    System.out.println("-----Editora Agregada con exito-----");
                        
                }else{
                    System.out.println("No se ha podido agregar");
                }
                break;
            case 3:
                System.out.println("Escribe el id de la editora que deseas modificar:");
                pubId = scanner.next();
                
                System.out.println("Escribe el nombre de la editora:");
                pubName = scanner.next();
                
                System.out.println("Escribe la ciudad de donde es la editora:");
                city = scanner.next();
                
                System.out.println("Escribe el estado de donde es la editora:");
                state = scanner.next();
                
                System.out.println("Escribe el pais de donde es la editora:");
                country = scanner.next();
           
                publisher.setPubId(pubId);
                publisher.setPubName(pubName);
                publisher.setCity(city);
                publisher.setState(state);
                publisher.setCountry(country);

                if(cPublishers.put(publisher)){
                    System.out.println("-----Editora modificada con exito-----");
                }else{
                    System.out.println("-----No se pudo modificar-----");
                }
                break;
            case 4:
                System.out.println("Escribe el id de la editora que deseas eliminar");
                    pubId = scanner.next();
                    publisher.setPubId(pubId);
                    
                    if(cPublishers.delete(publisher)){
                        System.out.println("-----Editora eliminada-----");
                    }
                        
                    else{
                        System.out.println("-----No se pudo eliminar-----");
                    }
           
                    break;
            case 5:
                System.out.println("Volviendo atras...");
                break;
            default: 
                System.out.println("---------------Opcion no disponible---------------");
        }
        System.out.println("\n");     
    }
    
    private void gestionarVentas(int opcion){
        Scanner scanner = new Scanner(System.in);
        String stor_id;
        String ord_num;
        Timestamp ord_date = new Timestamp(System.currentTimeMillis());
        int qty;
        String payterms;
        String title_id;
        
        switch(opcion){
            case 1:
                sales = cSale.get();
                    for(Sales venta: sales){
                       System.out.println("------------------------------------------"); 
                       System.out.println("Store Id: " + venta.getStor_id());
                       System.out.println("ord_num: " + venta.getOrd_num());
                       System.out.println("ord_date: " + venta.getOrd_date());
                       System.out.println("qty: " + venta.getQty());
                       System.out.println("payterms: " + venta.getPayterms());
                       System.out.println("title_id: " + venta.getTitle_id());
                       System.out.println("------------------------------------------");
                    }
                    System.out.println();
                    
                    break;
            case 2:
                System.out.println("Escribe el ID de la tienda:");
                stor_id = scanner.next();
                
                System.out.println("Escribe el numero de la orden:");
                ord_num = scanner.next();
                
                
                System.out.println("Escribe la cantidad de la venta:");
                qty = scanner.nextInt();
                
                System.out.println("Escribe el tipo de pago(contado,tarjeta,etc):");
                payterms = scanner.next();
                
                System.out.println("Escribe el id del libro:");
                title_id = scanner.next();
         
                sale.setStor_id(stor_id);
                sale.setOrd_num(ord_num);
                sale.setOrd_date(ord_date);
                sale.setQty(qty);
                sale.setPayterms(payterms);
                sale.setTitle_id(title_id);
               
                if(cSale.post(sale)){
                    System.out.println("-----Venta Agregada con exito-----");
                        
                }else{
                    System.out.println("No se ha podido agregar");
                }
                break;
            case 3:
                System.out.println("Escribe el numero de orden de la venta que deseas modificar:");
                ord_num = scanner.next();
                
                System.out.println("Escribe el ID de la tienda:");
                stor_id = scanner.next();
                
                System.out.println("Escribe la cantidad de la venta:");
                qty = scanner.nextInt();
                
                System.out.println("Escribe el tipo de pago(contado,tarjeta,etc):");
                payterms = scanner.next();
           
                System.out.println("Escribe el id del libro:");
                title_id = scanner.next();
         
                sale.setStor_id(stor_id);
                sale.setOrd_num(ord_num);
                sale.setOrd_date(ord_date);
                sale.setQty(qty);
                sale.setPayterms(payterms);
                sale.setTitle_id(title_id);

                if(cSale.put(sale)){
                    System.out.println("-----Venta modificada con exito-----");
                }else{
                    System.out.println("-----No se pudo modificar-----");
                }
                break;
            case 4:
                System.out.println("Escribe el id de la venta que deseas eliminar");
                    ord_num = scanner.next();
                    sale.setOrd_num(ord_num);
                    
                    if(cSale.delete(sale)){
                        System.out.println("-----Venta eliminada-----");
                    }
                        
                    else{
                        System.out.println("-----No se pudo eliminar-----");
                    }
           
                    break;
            case 5:
                System.out.println("Volviendo atras...");
                break;
            default: 
                System.out.println("---------------Opcion no disponible---------------");
        }
        System.out.println("\n");     
    }
    
    public void gestionarTitlexStores(){
        titlexStores = cTitlexStore.get();
                    for(String librosXtienda: titlexStores){
                       System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------"); 
                       System.out.println(librosXtienda);
                       System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    }
                    System.out.println();
    }
    
    public void gestionarTitlexAuthor(){
        titlexAuthors  = cTitlexAuthor.get();
                    for(String libroXautor: titlexAuthors){
                       System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------"); 
                       System.out.println(libroXautor);
                       System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    }
                    System.out.println();
    }
    
    public void run(){
        int opcion;
        int opcionDos;
        Scanner scanner = new Scanner(System.in);
        
        do{
            menu.mostrarMenuPrincipal();
            opcion = scanner.nextInt();
  
            switch(opcion){
                case 1: 
                    do{
                        System.out.println("\n");
                        menu.mostrarMenuAutores();
                        opcionDos = scanner.nextInt();
                        gestionarAutores(opcionDos);
                    }while(opcionDos !=5);
                    break;
                case 2:
                    do{
                        System.out.println("\n");
                        menu.mostrarMenuEmpleados();
                        opcionDos = scanner.nextInt();
                        gestionarEmpleados(opcionDos);
                    }while(opcionDos !=5);
                    break;
                case 3:
                    do{
                        System.out.println("\n");
                        menu.mostrarMenuTiendas();
                        opcionDos = scanner.nextInt();
                        gestionarTiendas(opcionDos);
                    }while(opcionDos !=5);
                    break;
                case 4:
                    do{
                        System.out.println("\n");
                        menu.mostrarMenuTitulos();
                        opcionDos = scanner.nextInt();
                        gestionarTitulos(opcionDos);
                    }while(opcionDos !=5);
                    break;
                case 5: 
                    do{
                        System.out.println("\n");
                        menu.mostrarMenuEditoras();
                        opcionDos = scanner.nextInt();
                        gestionarEditoras(opcionDos);
                    }while(opcionDos !=5);
                    break;
                case 6:
                    do{
                        System.out.println("\n");
                        menu.mostrarMenuVentas();
                        opcionDos = scanner.nextInt();
                        gestionarVentas(opcionDos);
                    }while(opcionDos !=5);
                    break;
                case 7:
                    System.out.println("\n");
                    gestionarTitlexStores();
                    break;
                case 8:
                    System.out.println("\n");
                    gestionarTitlexAuthor();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("---------------Opcion no disponible---------------");
                    
            }
            System.out.println("\n");
        }while(opcion != 9);
    }
    
    
}
