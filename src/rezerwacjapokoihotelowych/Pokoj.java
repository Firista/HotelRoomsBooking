package rezerwacjapokoihotelowych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pokoj 
{
    public int numerPokoju;
    public String stanPokoju;
    public int iloscLozek;
    public int iluOsobowy;
    public int idHotelu;
    
    public Pokoj(int iloscLozek, int iluOsobowy, int idHotelu)
    {
        this.stanPokoju = "wolny";
        this.iloscLozek = iloscLozek;
        this.iluOsobowy = iluOsobowy;
        this.idHotelu = idHotelu;
    }
    
    public Pokoj()
    {   
    }
    
    public void SetStanPokoju(String stanPokoju)
    {
        this.stanPokoju = stanPokoju;
    }
    
    public int GetNumerPokoju()
    {
        return numerPokoju;
    }
    
    public String GetStanPokoju()
    {
        return stanPokoju;
    }
    
    public int GetIloscLozek()
    {
        return iloscLozek;
    }
    
    public int GetIluOsobowy()
    {
        return iluOsobowy;
    }
    
    public int GetIdHotelu()
    {
        return idHotelu;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Pokoj))
        {
            return false;
        }

        Pokoj pokoj = (Pokoj) o;
        if (this.iluOsobowy == (pokoj.iluOsobowy))
        {
            return true;
        }
        else
        return false;  
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
        
    void dodajPokoj() 
    {
        try 
        {
            Statement statement = con.createStatement();
            statement.executeUpdate("insert into Pokoj (stanPokoju,iluOsobowy,iloscLozek,idHotelu)"
            + "values ('"+GetStanPokoju()+"', '"+GetIluOsobowy()+"', '"+GetIloscLozek()+"', '"+GetIdHotelu()+"')");
            statement.close();
	} 
        catch (Exception e) 
        {
            e.printStackTrace();
	}
    }
        
    void zmienStanPokoju(int numerPokoju, int stan) 
    {
        try 
        {
            Statement statement = con.createStatement();
            
            if (stan == 1)
            {
                statement.executeUpdate("update Pokoj set stanPokoju = 'wolny' where numerPokoju = '"+numerPokoju+"'");
                System.out.println("Stan pokoju " +numerPokoju+ " zostal zmieniony na wolny.");
                statement.close();
            }
            
            if (stan == 2)
            {
                statement.executeUpdate("update Pokoj set stanPokoju = 'zajety' where numerPokoju = '"+numerPokoju+"'");
                System.out.println("Stan pokoju " +numerPokoju+ " zostal zmieniony na zajety.");
                statement.close();
            }
            
	} 
        catch (Exception e) 
        {
            e.printStackTrace();
	}
    }
    
    void wypiszWszystkiePokojeWHotelu(String nazwaHotelu) 
    {
	try 
        {
            ResultSet DaneHotelu;
            Statement StatementHotelu = con.createStatement();
            DaneHotelu = StatementHotelu.executeQuery("select idHotelu from Hotel where nazwaHotelu = '"+nazwaHotelu+"'");
            
            int idHotelu = 0;
            
            while (DaneHotelu.next()) 
            {
                idHotelu = DaneHotelu.getInt("idHotelu");
                
                System.out.println("Id hotelu to " +idHotelu+ " .");
            }
            
            System.out.println("Wszyspokoje w hotelu " +nazwaHotelu+ " to:");
            
            ResultSet DanePokoi;
            Statement statement = con.createStatement();
            DanePokoi = statement.executeQuery("select * from Pokoj where idHotelu = '"+idHotelu+"'");
                        
            while (DanePokoi.next()) 
            {
                int numerPokoju = DanePokoi.getInt("numerPokoju");
                String stanPokoju = DanePokoi.getString("stanPokoju");
                int iluOsobowy = DanePokoi.getInt("iluOsobowy");
                int iloscLozek = DanePokoi.getInt("iloscLozek");
                
                System.out.println("Pokoj numer " +numerPokoju+ " jest " +iluOsobowy+ " osobowy, posiada " +iloscLozek+ " lozka i aktualnie jest " +stanPokoju+ ".");
            }
			
            statement.close();
            StatementHotelu.close();

	}
        catch (Exception e) 
        {
            System.err.println("Wystapil problem z polaczeniem do bazy danych.");
            e.printStackTrace();
	}
    }
}