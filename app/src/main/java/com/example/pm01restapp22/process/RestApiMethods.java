package com.example.pm01restapp22.process;

public class RestApiMethods {
    public static final String ipaddress = "192.168.1.10/";
    public static final String localhost = "localhost/";

    public static final String WebAPI = "PM01/";
    public static final String CreateEmpoint = "CrearAuto.php";
    public static final String ReadEmpoint = "ListaAutos.php";

    public static final String ApiCreate = "http://" + ipaddress + WebAPI + CreateEmpoint;
    public static final String ApiRead = "http://" + ipaddress + WebAPI + ReadEmpoint;

}
