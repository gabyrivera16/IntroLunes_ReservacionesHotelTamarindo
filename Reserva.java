
package com.sc202.proyectofinal4;

import javax.swing.JOptionPane;

public class Reserva {
    //--------------------------------------------- Arreglos de Objetos ---------------------------------------------//
    public static Factura facturas[] = new Factura[100];
    public static Habitacion habitaciones[] = new Habitacion[100];
    public static Cliente clientes[] = new Cliente[100];
    public static Vehiculo vehiculo[] = new Vehiculo[5];
    public static RentaVehiculo rentaVehiculo[] = new RentaVehiculo[100];
    public static Tours tour[] = new Tours[5];
    public static Amenidades amenidades[] = new Amenidades[5];
    public static Bitacora bitacora[] = new Bitacora[100];
    
    //---------------------------------------------- Arreglo de String ----------------------------------------------//
    public static String metodoPago[] = {"Efectivo","Tarjeta de Crédito","Tarjeta de Débito","Cheque"};
    
    //----------------------------------------------- Otras Variables -----------------------------------------------//
    public static int posCliente = 5;
    private int idFactura = 0;
    private int posBitacora = 0;

    //---------------------------------------------- Metodo de Llenado ----------------------------------------------//
    //Llena los vectores con valores vacios para evitar erroes
    public void LlenaVectores(){
        for (int i = 0; i < 100; i++) {
            facturas[i] = new Factura(0,0,"",0,0,0,"");
            clientes[i] = new Cliente(0,"","",0);
            habitaciones[i] = new Habitacion("vacio","",0,false,0);
            rentaVehiculo[i] = new RentaVehiculo(0,null,0,0);
            bitacora[i] = new Bitacora(0,0,"",0);
        }
        
        clientes[0] = new Cliente(101,"Carlos","Monge",11111111);
        clientes[1] = new Cliente(102,"Jessica","Miller",22222222);
        clientes[2] = new Cliente(103,"Juddith","Palmer",33333333);
        clientes[3] = new Cliente(104,"Minor","Rojas",44444444);
        clientes[4] = new Cliente(105,"Andy","Hudson",55555555);
        
        habitaciones[0] = new Habitacion("A1","sencilla",1,true,10000);
        habitaciones[1] = new Habitacion("B1","matrimonial",1,true,15000);
        habitaciones[2] = new Habitacion("C1","doble",2,true,20000);
        habitaciones[3] = new Habitacion("D1","triple",3,true,28500);
        habitaciones[4] = new Habitacion("E1","comunicada",4,true,35000);
        
        vehiculo[0] = new Vehiculo("111","Toyota","Yaris","automatico",10000,5);
        vehiculo[1] = new Vehiculo("222","Mitsubishi","L200","manual",20000,5);
        vehiculo[2] = new Vehiculo("333","Honda","CRV","manual",15000,5);
        vehiculo[3] = new Vehiculo("444","Nissan","Sentra","manual",8000,5);
        vehiculo[4] = new Vehiculo("555","Suzuki","Ertiga","automatico",25000,7);
        
        tour[0] = new Tours(1,"Visita a las 5 playas","10 horas", "Playa Hoja, Playa Camaron, Playa Soleada, Playa Perlas, Playa Cascada", 30000, 7, 10, true);
        tour[1] = new Tours(2,"Nadar con delfines","2 horas", "Reserva SMART", 15000, 15, 15, false);
        tour[2] = new Tours(3,"Caminata por la montaña","5 horas", "Reserva SMART", 7500, 3, 8, true);
        tour[3] = new Tours(4,"Clases de Surf","1 hora", "Playa Cascada", 3000, 5, 15, true);
        tour[4] = new Tours(5,"Aventura por la selva","6 horas", "Reserva SMART", 9000, 10, 15, true);
        
        amenidades[0] = new Amenidades(1,"Toalla extra",500);
        amenidades[1] = new Amenidades(2,"Refresco Natural/Gaseoso",1000);
        amenidades[2] = new Amenidades(3,"Bebida alcoholica",2000);
        amenidades[3] = new Amenidades(4,"Jabón/Shampoo extra",1500);
        amenidades[4] = new Amenidades(5,"Servicio de comida a la habitación",1000);
    }
    
    //---------------------------------------- Metodos que devuelven Objetos ----------------------------------------//
    //Devuelve una habitacion disponible que sea del tipo recibido
    public Habitacion buscarHabitacion(String tipo){
        for (int i = 0; i < 100; i++) {
            if(!habitaciones[i].getId().equals("vacio") // verifica que el id no sea vacio
                    && habitaciones[i].isDisponibilidad() == true // verifica que la disponibilidad sea true
                    && habitaciones[i].getTipo().equals(tipo)){ // verifica que el tipo de habitacion sea el mismo que la persona escogio
                return habitaciones[i];
            }
        }
        return null; // si no encuentra la habitacion, retorna null
    }
    
    //Devuelve la habitacion que coincide con el id recibido
    public Habitacion obtenerHabitacionConId(String id){
        for (int i = 0; i < 100; i++) {
            if(habitaciones[i].getId().equals(id)){
                return habitaciones[i];
            }
        }
        return null;
    }
    
    //Devuelve el vehiculo que coincide con la placa
    public Vehiculo obtenerVehiculo(String placa){
        String id = "";
        //Toma solo la placa del carro ignorando el resto del texto
        for (int i = 1; i < placa.length(); i++) {
            if(placa.charAt(i) != ')'){
                id += placa.charAt(i);
            }else{break;}
        }
 
        //Compara la placa obtenida con la de los carros en el arreglo
        for (int i = 0; i < vehiculo.length; i++) {
            if(vehiculo[i].getPlaca().equals(id)){
                return vehiculo[i];
            }
        }
        return null;
    }
    
    //Devuelve el tour que coincide con el seleccionado en el menu desplegable
    public Tours obtenerTour(String txtTour){
        String id = "";
        //Toma solo el id del tour ignorando el resto del texto
        for (int i = 0; i < txtTour.length(); i++) {
            if(txtTour.charAt(i) != ')'){
                id += txtTour.charAt(i);
            }else{break;}
        }
        //Compara el id obtenido con la de los tours en el arreglo
        for (int i = 0; i < tour.length; i++) {
            if(tour[i].getId() == (Integer.parseInt(id))){
                return tour[i];
            }
        }
        return null;
    }
    
    //Devuelve la amenidad que coincide con la seleccionada en el menu desplegable
    public Amenidades obtenerAmenidades(String txtAmenidad){
        String idTxt = "";
        //Toma solo el id de la amenidad ignorando el resto del texto
        for (int i = 0; i < txtAmenidad.length(); i++) {
            if(txtAmenidad.charAt(i) != ')'){
                idTxt += txtAmenidad.charAt(i);
            }else{break;}
        }
 
        int id = Integer.parseInt(idTxt);
        
        //Compara el id obtenido con la de las amenidades en el arreglo
        for (int i = 0; i < amenidades.length; i++) {
            if(amenidades[i].getId() == id){
                return amenidades[i];
            }
        }
        return null;
    }
    
    //------------------------------------------ Metodos que devuelven Int ------------------------------------------//
    //Sirve para obtener el numero de la renta
    public int obtenerIdRenta(){
        for (int i = 0; i < 100; i++) {
            if(rentaVehiculo[i].getId() == 0){
                return i;
            }
        }
        return -1;
    }
    
    //Sirve para obtener el numero de la factura
    public int obtenerIdFactura(int id){
        for (int i = 0; i < 100; i++) {
            if(facturas[i].getIdCliente()== id){
                return i;
            }
        }
        return -1;
    }
    
    //--------------------------------------- Metodos que devuelven Booleans ---------------------------------------//
    //Verifica que el cliente no exista
    public boolean existeReserva(int id){
        for (int i = 0; i < 100; i++) {
            if(facturas[i].getIdCliente() == id){
                return true;
            }
        }
        return false;
    }
    
    //Verifica que el cliente exista
    public boolean existeCliente(int id){
        for (int i = 0; i < 100; i++) {
            if(clientes[i].getIdCliente() == id){
                return true;
            }
        }
        return false;
    }

    //----------------------------------------- Metodo que devuelve String -----------------------------------------//
    //Obtiene el nombre del cliente segun el ID
    public static String obtenerCliente(int id){
        for (int i = 0; i < 100; i++) {
            if(clientes[i].getIdCliente() == id && clientes[i].getIdCliente() != 0){
                return clientes[i].getNombre()+" "+clientes[i].getApellido();
            }
        }
        return "vacio";
    }


    //----------------------------------------------- Menu Principal -----------------------------------------------//
    public void menu() {
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("Digite la opción \n"
                    + "1) Registro de nuevo cliente \n"
                    + "2) Realizar reserva \n"
                    + "3) Reservar Tour\n"
                    + "4) Rentar vehiculo\n"
                    + "5) Amenidades\n"
                    + "6) Bitacora \n"
                    + "7) Ver Factura de cliente \n"
                    + "8) Terminar estadia de cliente \n"
                    + "9) Salir"));

            switch (op) {
                case 1: registrarCliente(); break;
                case 2: EscogerHabitacion(); break;
                case 3: ReservarTour(); break;
                case 4: RentarVehiculo(); break;
                case 5: EscogerAmenidades(); break;
                case 6: VerBitacora(); break;
                case 7: VerFactura(); break;
                case 8: RetirarReserva(); break;
                case 9: System.exit(0); break;
                default: JOptionPane.showMessageDialog(null, "La opción ingresada no es válida"); break;
            }
        } while (op != 9); //Se termina el ciclo si se escoge la opcion 9
    }
    
    //--------------------------------------- Registro de un nuevo cliente -----------------------------------------//
    public void registrarCliente(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de cédula del nuevo cliente"));

        //Valida si existe el cliente, si es asi vuelve a pedir el Id, sino continua con los otros datos
        if (existeCliente(id)) {
            JOptionPane.showMessageDialog(null, "El id ingresado corresponde a otro usuario ya registrado o no es válido");
        }else{
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del nuevo cliente");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido del nuevo cliente");
            int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el teléfono del nuevo cliente"));

            clientes[posCliente] = new Cliente(id, nombre, apellido, telefono);
            JOptionPane.showMessageDialog(null, clientes[posCliente]);
            posCliente++;
        }
    }
    
    //------------------------------------------ Seleccion de Habitacion -------------------------------------------//
    //Este metodo muestra un cuadro de texto donde el usuario escoge el tipo de habitación
    public void EscogerHabitacion(){
        //Captura la opcion ingresada y la almacena en la variable "opcion"
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "Digite el numero de opción: \n"
                + "1) Habitación Sencilla   (una cama individual)\n"
                + "2) Habitación Matrimonial   (una cama matrimonial)\n"
                + "3) Habitación Doble   (dos camas individuales)\n"
                + "4) Habitación Triple   (tres camas individuales)\n"
                + "5) Habitación Comunicada   (cuatro camas individuales)\n"
                + "6) Salir"));

        //Segun la opcion escogida envia el tipo de habitacion para realizar la reserva
        switch (opcion) {
            case 1: facturacion("sencilla"); break;
            case 2: facturacion("matrimonial"); break;
            case 3: facturacion("doble"); break;
            case 4: facturacion("triple"); break;
            case 5: facturacion("comunicada"); break;
            case 6: break;
            default: JOptionPane.showMessageDialog(null, "La opción ingresada no es válida"); EscogerHabitacion();
        }
    }

    //--------------------------------------- Completar datos de facturacion ---------------------------------------//
    //Se crea la reserva, se cambia la disponibilidad de la habitacion y se imprime la factura
    public void facturacion(String tipo){
        //Se guarda la habitacion disponible en la variable h
        Habitacion h = buscarHabitacion(tipo);

        //Valida que la habitacion realmente exista
        if (h != null) {
            //Captura el id del cliente
            int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cédula del cliente"));

            //Si el cliente no existe pregunta de nuevo hasta que ingrese un id valido
            while (existeCliente(idCliente) == false) {
                idCliente = Integer.parseInt(JOptionPane.showInputDialog("El id ingresado no existe, intente de nuevo"));
            }

            //Captura la cantidad de noches que el usuario ingreso
            int noches = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Noches ha reservar"));

            //Crea la factura
            facturas[idFactura].setIdFactura(idFactura+1);
            facturas[idFactura].setIdCliente(idCliente);
            facturas[idFactura].setIdHabitacion(h.getId());
            facturas[idFactura].setCantDias(noches);
            facturas[idFactura].setMonto(h.getPrecioxNoche() * noches);

            //Cambia la disponibilidad de la habitacion a ocupada (false)
            h.setDisponibilidad(false);

            MetodoDePago();

            //Imprime la factura
            JOptionPane.showMessageDialog(null, facturas[idFactura]);
            
            //Crea un nuevo registro en la bitacora con los datos de la habitacion reservada
            bitacora[posBitacora].setRegistro(posBitacora + 1);
            bitacora[posBitacora].setIdCliente(idCliente);
            bitacora[posBitacora].setServicio("Habitacion " + tipo + " (" + noches + " noches)");
            bitacora[posBitacora].setCosto(facturas[idFactura].getMonto());
            
            posBitacora++;
            idFactura++;

        } else {
            JOptionPane.showMessageDialog(null, "No hay habitaciones de este tipo disponibles");
            EscogerHabitacion();
        }
    }
    
    //----------------------------------------------- Metodo de pago -----------------------------------------------//
    public void MetodoDePago(){
        //Muestra un menu desplegable con los metodos de pago
        Object pago = JOptionPane.showInputDialog(null,"Seleccione el metodo de pago", "Metodo de Pago", 
                JOptionPane.QUESTION_MESSAGE,null,metodoPago, metodoPago[0]); //Esta es la parte que crea el menu desplegable usando el arreglo metodoPago
        facturas[idFactura].setMetodoDePago(pago.toString());
    }

    //-------------------------------------------- Rentar un Vehiculo  ---------------------------------------------//
    public void RentarVehiculo(){
        int idCli = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cedula del cliente"));
        
        //Valida si la cedula ingresada pertenece a un cliente que tiene reservada una habitacion
        if(existeReserva(idCli)){
            
            //Asigna a la variable idFact, la posicion que tiene la factura del cliente en el arreglo "factura"
            int idFact = obtenerIdFactura(idCli);

            Object v = JOptionPane.showInputDialog(null, "Seleccione el vehiculo", "Renta de vehiculo", 
                    JOptionPane.QUESTION_MESSAGE, null, vehiculo, vehiculo[0]); //Esta es la parte que crea el menu desplegable usando el arreglo vehiculo
            
            //Coloca en la variable carro el vehiculo que corresponde al seleccionado en el menu desplegable
            Vehiculo carro = obtenerVehiculo(v.toString());

            int horas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de horas de la renta"));

            //obtine la siguiente posicion vacia de rentaVehiculo para colocar dentro la renta que se esta creado
            int id = obtenerIdRenta();
            rentaVehiculo[id].setId(id + 1);
            rentaVehiculo[id].setVehiculo(carro);
            rentaVehiculo[id].setHoras(horas);
            rentaVehiculo[id].setTotalPagar(horas * carro.getCostoHora());

            int totalFactura = facturas[idFact].getMonto();
            int totalVehiculo = rentaVehiculo[id].getTotalPagar();
            int total = totalFactura+totalVehiculo;

            facturas[idFact].setMonto(total);
            
            JOptionPane.showMessageDialog(null, rentaVehiculo[id]+"\n\nTotal Actual de la factura: "+facturas[idFact].getMonto());
            
            //Aumenta el monto de extras en la factura del usuario
            facturas[idFact].setExtras(facturas[idFact].getExtras()+totalVehiculo);
            
            //Crea un nuevo registro en la bitacora con los datos de la renta del vehiculo
            bitacora[posBitacora].setRegistro(posBitacora + 1);
            bitacora[posBitacora].setIdCliente(idCli);
            bitacora[posBitacora].setServicio("Vehiculo " + carro.getMarca() + " " + carro.getModelo() + " (" + horas + " horas)");
            bitacora[posBitacora].setCosto(totalVehiculo);
            
            posBitacora++;
            
        }else{
            JOptionPane.showMessageDialog(null, "El cliente no tiene ninguna reserva hecha en el hotel actualmente");
        }
    }
    
    //---------------------------------------- Reservar Espacio en un Tour  ----------------------------------------//
    public void ReservarTour(){
        int idCli = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cedula del cliente"));
        
        //Valida si la cedula ingresada pertenece a un cliente que tiene reservada una habitacion
        if(existeReserva(idCli)){
            
            //Asigna a la variable idFact, la posicion que tiene la factura del cliente en el arreglo "factura"
            int idFact = obtenerIdFactura(idCli);
            
            Object v;
            Tours t;

            //Este ciclo se repite hasta encontrar un tour que este disponible
            do {
                v = JOptionPane.showInputDialog(null, "Seleccione el tour", "Tours", 
                        JOptionPane.QUESTION_MESSAGE, null, tour, tour[0]); //Esta es la parte que crea el menu desplegable usando el arreglo tour
                
                //guarda en la variable t el tour seleccionado en el menu desplegable
                t = obtenerTour(v.toString());
                
                //Valida que el tour esta disponible, en este caso revisa la disponibilidad y si es false tira un error
                if(!t.isDisponible())
                    JOptionPane.showMessageDialog(null, "El tour seleccionado no esta disponible actualmente");
                
            } while(!t.isDisponible());
            
            int personas;
            
            //Este ciclo se repite hasta que se escoge un tour con espacio suficiente
            do{
                personas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de espacios a reservar"));
                
                //Valida que el tour tenga espacio suficiente, en este caso suma los registrados con las personas y si son mayor al cupo tira un error
                if(t.getRegistrados() + personas > t.getCupos())
                    JOptionPane.showMessageDialog(null, "El tour seleccionado no tiene espacio suficiente para esa cantidad de personas");
                
            }while(t.getRegistrados() + personas > t.getCupos());

            t.setRegistrados(t.getRegistrados() + personas);

            //Si el nuevo numero de registrados es igual al de cupos entonces cambia la disponibilidad del tour a false
            if (t.getRegistrados() == t.getCupos()) {
                t.setDisponible(false);
            }

            int totalFactura = facturas[idFact].getMonto();
            int totalTour = t.getCosto();
            int total = totalFactura + totalTour;

            facturas[idFact].setMonto(total);

            JOptionPane.showMessageDialog(null, t.toString() + "\n\nTotal Actual de la factura: " + facturas[idFact].getMonto());
            
            //Aumenta el monto de extras en la factura del usuario
            facturas[idFact].setExtras(facturas[idFact].getExtras()+totalTour);
            
            //Crea un nuevo registro en la bitacora con los datos de la reserva del tour
            bitacora[posBitacora].setRegistro(posBitacora + 1);
            bitacora[posBitacora].setIdCliente(idCli);
            bitacora[posBitacora].setServicio("Tour " + t.getNombre() + " (" + personas + " personas)");
            bitacora[posBitacora].setCosto(totalTour);
            
            posBitacora++;
        }else{
            JOptionPane.showMessageDialog(null, "El cliente no tiene ninguna reserva hecha en el hotel actualmente");
        }
    }
    
    //--------------------------------------------- Escoger aminidades ---------------------------------------------//
    public void EscogerAmenidades(){
        int idCli = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cedula del cliente"));
        
        //Valida si la cedula ingresada pertenece a un cliente que tiene reservada una habitacion
        if(existeReserva(idCli)){
            
            //Asigna a la variable idFact, la posicion que tiene la factura del cliente en el arreglo "factura"
            int idFact = obtenerIdFactura(idCli);
            
            Object a = JOptionPane.showInputDialog(null, "Seleccione el producto o servicio", "Amenidades", 
                    JOptionPane.QUESTION_MESSAGE, null, amenidades, amenidades[0]); //Esta es la parte que crea el menu desplegable usando el arreglo amenidades
            
            //guarda en la variable "amenidad" la amenidad seleccionada en el menu desplegable
            Amenidades amenidad = obtenerAmenidades(a.toString());

            int cantidad = 1;
            
            //Si la amenidad seleccionada no es un servicio entonces pide cantidad
            if(!amenidad.getNombre().equals("Servicio de comida a la habitación")){
                cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del producto"));
            }

            int totalFactura = facturas[idFact].getMonto();
            int totalAmenidad = amenidad.getCosto() * cantidad;
            int total = totalFactura+totalAmenidad;

            facturas[idFact].setMonto(total);
            
            //Si la amenidad seleccionada no es un servicio entonces imprime la cantidad y el costo unitario
            if(!amenidad.getNombre().equals("Servicio de comida a la habitación")){
                JOptionPane.showMessageDialog(null, "Amenidad: "+ amenidad.getNombre()
                    + "\n - Cantidad: "+cantidad
                    + "\n - Costo Unitario: "+ amenidad.getCosto()
                    + "\n - Costo Total: "+totalAmenidad
                    +"\n\nTotal Actual de la factura: "+facturas[idFact].getMonto());
            }
            //Sino solo imprime el nombre y el costo total
            else{
                JOptionPane.showMessageDialog(null, "Amenidad: "+ amenidad.getNombre()
                    + "\n - Costo Total: "+totalAmenidad
                    +"\n\nTotal Actual de la factura: "+facturas[idFact].getMonto());
            }
            
            //Aumenta el monto de extras en la factura del usuario
            facturas[idFact].setExtras(facturas[idFact].getExtras()+totalAmenidad);
            
            //Crea un nuevo registro en la bitacora con los datos de la amenidad
            bitacora[posBitacora].setRegistro(posBitacora + 1);
            bitacora[posBitacora].setIdCliente(idCli);
            bitacora[posBitacora].setServicio("Amenidad " + amenidad.getNombre() + " ( cantidad: " + cantidad + " )");
            bitacora[posBitacora].setCosto(totalAmenidad);
            
            posBitacora++;
            
        }else{
            JOptionPane.showMessageDialog(null, "El cliente no tiene ninguna reserva hecha en el hotel actualmente");
        }
    }
    
    //--------------------------------------------- Imprimir la factura --------------------------------------------//
    public void VerFactura(){
        int idCli = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cedula del cliente"));
        
        //Valida si la cedula ingresada pertenece a un cliente que tiene reservada una habitacion
        if(existeReserva(idCli)){
            
            //Asigna a la variable idFact, la posicion que tiene la factura del cliente en el arreglo "factura"
            int idFact = obtenerIdFactura(idCli);
            
            //Imprime toda la factura con el monto total de los extras
            JOptionPane.showMessageDialog(null, facturas[idFact]+"\n\n   - Monto total de los extras: "+facturas[idFact].getExtras());
        }else{
            JOptionPane.showMessageDialog(null, "El cliente no tiene ninguna reserva hecha en el hotel actualmente");
        }
    }
    
    //----------------------------------------- Retirar reserva del cliente ----------------------------------------//
    public void RetirarReserva(){
        int idCli = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cedula del cliente"));
        
        //Valida si la cedula ingresada pertenece a un cliente que tiene reservada una habitacion
        if(existeReserva(idCli)){
            
            //Asigna a la variable idFact, la posicion que tiene la factura del cliente en el arreglo "factura"
            int idFact = obtenerIdFactura(idCli);

            JOptionPane.showMessageDialog(null, facturas[idFact]
                    +"\n\n   - Monto total de los extras: "+facturas[idFact].getExtras());
            
            //Guarda en la variable h, la habitacion que estaba reservada por el cliente
            Habitacion h = obtenerHabitacionConId(facturas[idFact].getIdHabitacion());
            
            //Cambia la disponibilidad de la habitacion a true osea libre
            h.setDisponibilidad(true);
            
            //Elimina la reserva
            facturas[idFact] = new Factura(0,0,"",0,0,0,"");
            
            JOptionPane.showMessageDialog(null, "Se retiró la reserva con exito");
            
        }else{
            JOptionPane.showMessageDialog(null, "El cliente no tiene ninguna reserva hecha en el hotel actualmente");
        }
    }
    
    //--------------------------------------- Ver la bitacora de los ingresos --------------------------------------//
    public void VerBitacora(){
        String impresion = "Ingresos del Dia\n";
        int total = 0;
        
        //Este ciclo coloca en la variable impresion, todos los ingresos del dia y los suma para posteriormente imprimirlos
        for (int i = 0; i < bitacora.length; i++) {
            if(bitacora[i].getRegistro()!=0){
                impresion += "\n"+bitacora[i].toString();
                total += bitacora[i].getCosto();
            }
        }
        JOptionPane.showMessageDialog(null, impresion);
        JOptionPane.showMessageDialog(null, "Ganancia total: "+ total);
    }
}
