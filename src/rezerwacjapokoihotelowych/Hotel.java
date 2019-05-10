package rezerwacjapokoihotelowych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Hotel 
{   
    public String nazwaHotelu;
    public int iluGwiazdkowy;
    
    public Hotel(String nazwaHotelu, int iluGwiazdkowy)
    {
        this.nazwaHotelu = nazwaHotelu;
        this.iluGwiazdkowy = iluGwiazdkowy;
    }
    
    public Hotel()
    {
    }
    
    public String GetNazwaHotelu()
    {
        return nazwaHotelu;
    }
    
        public int GetIluGwiazdkowy()
    {        
        return iluGwiazdkowy;
    }

    Connection con = null;
    
    void polacz() 
    {
	try 
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost/hotel?verifyServerCertificate=false&useSSL=true", "root", "");
	} 
        catch (SQLException e) 
        {
            e.printStackTrace();
	}
    }

    void rozlacz() 
    {
	try 
        {
            con.close();
	} 
        catch (SQLException e) 
        {
            e.printStackTrace();
	}
    }
   
    void dodajHotel(String nazwaHotelu, int iluGwiazdkowy) 
    {
        try 
        {
            Statement statement = con.createStatement();
            statement.executeUpdate("insert into Hotel (nazwaHotelu,iluGwiazdkowy)"
            + "values ('"+nazwaHotelu+"','"+iluGwiazdkowy+"')");
            statement.close();
	} 
        catch (Exception e) 
        {
            e.printStackTrace();
	}
    }
    
    void wypiszWszystkieHotele() 
    {
        System.out.println("Dostepne hotele:");
	ResultSet DaneHoteli;

	try 
        {
            Statement statement = con.createStatement();
            DaneHoteli = statement.executeQuery("select * from Hotel");
                        
            while (DaneHoteli.next()) 
            {
                String nazwaHotelu = DaneHoteli.getString("nazwaHotelu");
                int iluGwiazdkowy = DaneHoteli.getInt("iluGwiazdkowy");
                int idHotelu = DaneHoteli.getInt("idHotelu");
                
                System.out.println("Hotel " +nazwaHotelu+ "na " +iluGwiazdkowy+ " gwiazdek i numer " +idHotelu);
            }
			
            statement.close();

	}
        catch (Exception e) 
        {
            System.err.println("Wystapil problem z polaczeniem do bazy danych.");
            e.printStackTrace();
	}
    }
}