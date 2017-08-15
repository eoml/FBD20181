package fbdp01;

/**
 *
 * @author EdgarOmar
 */
public class Client
{
    public String name, telephone, address, email;
    public int area;
    public float price, sellPrice;

    public Client (String name, String telephone, String address, String email,
        int area, float price, float sellPrice)
    {
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.email = email;
        this.area = area;
        this.price = price;
        this.sellPrice = sellPrice;
    }

    public Client ()
    {
        this.name = "";
        this.telephone = "";
        this.address = "";
        this.email = "";
        this.area = 0;
        this.price = 0f;
        this.sellPrice = 0f;
    }

    public Client (Client c)
    {
        this.name = c.name;
        this.telephone = c.telephone;
        this.address = c.address;
        this.email = c.email;
        this.area = c.area;
        this.price = c.price;
        this.sellPrice = c.sellPrice;
    }
    
    @Override
    public String toString()
    {
        return
            "Name:\t" + name + "\n" +
            "Telephone:\t" + telephone + "\n" +
            "Adress:\t" + address + "\n" +
            "E-mail:\t" + email + "\n" +
            "Area:\t" + area + "m2\n" +
            "Price:\t$" + price + "\n" +
            "Sell price:\t$" + sellPrice + "\n"; 
    }
    
}
