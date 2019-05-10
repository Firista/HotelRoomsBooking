package rezerwacjapokoihotelowych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pracownik
{
    public String stanowisko;
    public int idHotelu;
    
    public Pracownik(String stanowisko, int idHotelu)
    {
        this.stanowisko = stanowisko;
        this.idHotelu = idHotelu;
    }
    
    public Pracownik()
    {   
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
    
    void dodajPracownika(String stanowisko, String nazwaHotelu) 
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
            
            Statement statement = con.createStatement();
            statement.executeUpdate("insert into Pracownik (stanowisko,idHotelu) values ('"+stanowisko+"', '"+idHotelu+"')");
            statement.close();
            StatementHotelu.close();
	} 
        catch (Exception e) 
        {
            e.printStackTrace();
	}
    }
    
    void wypiszWszystkichPracownikow(String nazwaHotelu) 
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
            
            System.out.println("Wszyscy pracownicy w hotelu " +nazwaHotelu+ " to:");
            
            ResultSet DanePracownikow;
            Statement statement = con.createStatement();
            DanePracownikow = statement.executeQuery("select * from Pracownik where idHotelu = '"+idHotelu+"'");
                        
            while (DanePracownikow.next()) 
            {
                int idPracownika = DanePracownikow.getInt("idPracownika");
                String stanowisko = DanePracownikow.getString("stanowisko");
                
                System.out.println("Pracownik numer " +idPracownika+ " pracuje na stanowisku " +stanowisko+ " w hotelu " +nazwaHotelu);
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