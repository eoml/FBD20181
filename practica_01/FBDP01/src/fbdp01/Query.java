package fbdp01;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.csvreader.CsvReader;
import java.util.LinkedList;

/**
 *
 * @author EdgarOmar
 */
public class Query
{

    private static LinkedList<Client> clients;
    
    private static void readCSVFile()
    {
        clients = new LinkedList();
        try
        {
            CsvReader csvFile = new CsvReader("C:\\Users\\EdgarOmar\\Google Drive\\fciencias20181\\fundamentos_de_bases_de_datos\\laboratorio\\practica_01\\FBDP01\\P1.csv");
            csvFile.readHeaders();
        
            while (csvFile.readRecord())
            {
                clients.add(new Client(
                    csvFile.get(0),
                    csvFile.get(1),
                    csvFile.get(2),
                    csvFile.get(3),
                    Integer.parseInt(csvFile.get(4)),
                    Float.parseFloat(csvFile.get(5)),
                    Float.parseFloat(csvFile.get(6))
                ));
            }
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
    }
    
    /**
     * Devuelve una lista de clientes cuyas propiedades miden menos de 200 m2 y
     * cuyo precio de venta está entre 50,000 y 500,000.
     * @return lista de clientes.
     */
    private static LinkedList<Client> query1()
    {
        LinkedList<Client> list = new LinkedList();
        for (Client c : clients)
        {
            if (c.area < 200 && c.price >= 50000 && c.price <= 500000)
            {list.add(c);}
        }
        return list;
    }
    
    /**
     * Devuelve una lista de clientes con más de una propiedad.
     * @return lista de clientes.
     */
    private static LinkedList<Client> query2()
    {
        LinkedList<Client> list = new LinkedList();
        LinkedList<Client> list2 = new LinkedList(clients);
        int i, j;
        Client tmp;
        for (i = 0; i < list2.size(); i++)
        {
            for (j = i + 1; j < list2.size(); j++)
            {
                if (list2.get(i).name.equals(list2.get(j).name))
                {
                    tmp = list2.get(i);
                    list.add(new Client(tmp));
                    for (int k = 0; k < list2.size(); k++)
                    {
                        if (list2.get(k).name.equals(tmp.name))
                        {list2.remove(k);}
                    }
                    j = list2.size();
                }
            }
        }
        return list;
    }
    
    /**
     * Devuelve una lista de clientes con las 10 propiedades mas baratas.
     * @return lista de clientes.
     */
    private static LinkedList<Client> query3()
    {
        LinkedList<Client> list = new LinkedList();
        LinkedList<Client> list2 = new LinkedList(clients);
        Client tmpC;
        
        for (int i = 1; i <= 10; i++)
        {
            tmpC = list2.getFirst();
            for (Client c : list2)
            {
                if (c.sellPrice < tmpC.sellPrice)
                {tmpC = c;}
            }
            list.add(new Client(tmpC));
            list2.remove(tmpC);
        }
        
        return list;
    }
    
    /**
     * Devuelve una lista de clientes con las 5 propiedades mas caras.
     * @return lista de clientes.
     */
    private static LinkedList<Client> query4()
    {
        LinkedList<Client> list = new LinkedList();
        LinkedList<Client> list2 = new LinkedList(clients);
        Client tmpC;
        
        for (int i = 1; i <= 5; i++)
        {
            tmpC = list2.getFirst();
            for (Client c : list2)
            {
                if (c.sellPrice > tmpC.sellPrice)
                {tmpC = c;}
            }
            list.add(new Client(tmpC));
            list2.remove(tmpC);
        }
        
        return list;
    }
    
    /**
     * Devuelve una lista de clientes con las 5 propiedades con mayor margen
     * de ganancia.
     * @return lista de clientes.
     */
    private static LinkedList<Client> query5()
    {
        LinkedList<Client> list = new LinkedList();
        LinkedList<Client> list2 = new LinkedList(clients);
        Client tmpC;
        float margin, margin2;
        
        for (int i = 1; i <= 5; i++)
        {
            tmpC = list2.getFirst();
            margin = tmpC.sellPrice - tmpC.price;
            for (Client c : list2)
            {
                margin2 = c.sellPrice - c.price;
                if (margin2 > margin)
                {
                    tmpC = c;
                }
            }
            list.add(new Client(tmpC));
            list2.remove(tmpC);
        }
        
        return list;
    }
   
    
    public static void main (String[] args)
    {
        LinkedList<Client> list;
        readCSVFile();
        
        list = query1();
        System.out.println("Query 1: Cantidad de propiedades de menos de 200 m2 y precio entre $50,000 y $500,000.");
        System.out.println(list.size());
        
        list = query2();
        System.out.println("Query 2: Nombres de personas con más de una propiedad.");
        for (Client c : list)
        {System.out.println(c.name);}
        
        list = query3();
        System.out.println("Query 3: Las 10 propiedades más baratas.");
        for (Client c : list)
        {System.out.println(c);}
        
        list = query4();
        System.out.println("Query 4: Las 5 propiedades más caras.");
        for (Client c : list)
        {System.out.println(c);}
        
        list = query5();
        System.out.println("Query 5: Las 5 propiedades con mayor margen de ganancia.");
        for (Client c : list)
        {System.out.println(c);}
    }
    
}
