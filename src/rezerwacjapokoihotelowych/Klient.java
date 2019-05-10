package rezerwacjapokoihotelowych;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Klient
{
    public String imie;
    public String nazwisko;
    public java.sql.Date dataZameldowania;
    public java.sql.Date dataWymeldowania;
    public int numerPokoju;
    
    public Klient(String imie, String nazwisko, java.sql.Date dataZameldowania, java.sql.Date dataWymeldowania, int numerPokoju)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataZameldowania= dataZameldowania;
        this.dataWymeldowania = dataWymeldowania;
        this.numerPokoju = numerPokoju;
    }
    
    public Klient(String imie, String nazwisko, java.sql.Date dataZameldowania, java.sql.Date dataWymeldowania)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataZameldowania= dataZameldowania;
        this.dataWymeldowania = dataWymeldowania;
    }
    
    public Klient()
    {  
    }
    
    public String GetImie()
    {        
        return imie;
    }
    
    public String GetNazwisko()
    {        
        return nazwisko;
    }
    
    public Date GetDataZameldowania()
    {        
        return dataZameldowania;
    }
    
    public Date GetDataWymeldowania()
    {        
        return dataWymeldowania;
    }
    
    public int GetNumerPokoju()
    {        
        return numerPokoju;
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
    
     void dodajKlienta(String imie, String nazwisko, java.sql.Date dataZameldowania, java.sql.Date dataWymeldowania, int numerPokoju) 
    {
		
        try 
        {
            Statement statementKlienta = con.createStatement();
            statementKlienta.executeUpdate("insert into Klient (imie,nazwisko,dataZameldowania,dataWymeldowania, numerPokoju)"
            + "values ('"+imie+"','"+nazwisko+"', '"+dataZameldowania+"', '"+dataWymeldowania+"', '"+numerPokoju+"')");
            statementKlienta.close();
	} 
        catch (Exception e) 
        {
            e.printStackTrace();
	}
    }
   
     void wypiszWolnePokoje(String nazwaHotelu, int iluOsobowy, int iloscLozek, java.sql.Date dataZameldowania, java.sql.Date dataWymeldowania) 
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
            
            System.out.println("Wszystkie dostępne pokoje o podanych preferancjach w hotelu " +nazwaHotelu+ " to:");
            
            ResultSet DanePokoi;
            Statement statement = con.createStatement();
            DanePokoi = statement.executeQuery("select numerPokoju from Pokoj where idHotelu = '"+idHotelu+"' and iluOsobowy = '"+iluOsobowy+"' and iloscLozek = '"+iloscLozek+"'");
              
            ResultSet DaneWolnychPokoi;
            Statement statementPokoi = con.createStatement();
            
            while (DanePokoi.next()) 
            {
                int numerPokoju = DanePokoi.getInt("numerPokoju");

                DaneWolnychPokoi = statementPokoi.executeQuery("select imie from Klient where numerPokoju = '"+numerPokoju+"' and ((dataZameldowania between '"+dataZameldowania+"' and '"+dataWymeldowania+"') or (dataWymeldowania between '"+dataZameldowania+"' and '"+dataWymeldowania+"'))");
            
                String imie = ""; 
            
                while (DaneWolnychPokoi.next()) 
                {
                    imie = DaneWolnychPokoi.getString("imie");
                }
                
                if (imie == "")
                {   
                    System.out.println("Pokoj numer " +numerPokoju+ " posiada wskazane preferencje i jest w wybranym terminie wolny.");
                }
            }
			
            statement.close();
            StatementHotelu.close();
            statementPokoi.close();

	}
        catch (Exception e) 
        {
            System.err.println("Wystapil problem z polaczeniem do bazy danych.");
            e.printStackTrace();
	}
    }
    
    void zarezerwujWybranyPokoj(int numerPokoju, java.sql.Date dataZameldowania, java.sql.Date dataWymeldowania, String imieKlienta, String nazwiskoKlienta) 
    {
	try 
        {
            Statement statement = con.createStatement();

            System.out.print(" Czy na pewno chcesz go zarezerwować wskazany pokoj? Wybierz 1. jesli tak lub 2. jesli nie.");
            Scanner wybor = new Scanner(System.in);
            int wyborKlienta = Integer.parseInt(wybor.nextLine());
                    
            if (wyborKlienta == 1)
            {
                dodajKlienta(imieKlienta, nazwiskoKlienta, dataZameldowania, dataWymeldowania, numerPokoju);
                zmienStanPokoju(numerPokoju);
                statement.close();
            }
            
            if (wyborKlienta == 2)
            {
                System.out.println("Rezerwacja zostala anulowana.");
                statement.close();
            }
	}
        catch (Exception e) 
        {
            System.err.println("Wystapil problem z polaczeniem do bazy danych.");
            e.printStackTrace();
	}
    }
     
    void zmienStanPokoju(int numerPokoju) 
    {
        try 
        {
            Statement statementPokoju = con.createStatement();
            statementPokoju.executeUpdate("update Pokoj set stanPokoju = 'zajety' where numerPokoju = '"+numerPokoju+"'");
            System.out.println("Pokoj numer " +numerPokoju+ " zostal pomyslnie zarezerwowany.");
            statementPokoju.close();
	} 
        catch (Exception e) 
        {
            e.printStackTrace();
	}
    }
    
        void wypiszWszystkieRezerwacje(String nazwaHotelu) 
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

            ResultSet danePokoi;
            Statement statementPokoi = con.createStatement();
            danePokoi = statementPokoi.executeQuery("select numerPokoju from Pokoj where idHotelu = '"+idHotelu+"'");
            ResultSet DaneKlientow;
            Statement statement = con.createStatement();
            
            if (danePokoi.next())
            {
                System.out.println("Wszystkie rezerwacje w hotelu " +nazwaHotelu+ " to:");
                int numerPokoju = danePokoi.getInt("numerPokoju");
                DaneKlientow = statement.executeQuery("select Klient.idKlienta, Klient.imie, Klient.nazwisko, Klient.dataZameldowania, Klient.dataWymeldowania, Klient.numerPokoju from Klient inner join Pokoj on Pokoj.numerPokoju = '"+numerPokoju+"'");
            
                while (DaneKlientow.next()) 
                {
                    int idKlienta = DaneKlientow.getInt("idKlienta");
                    String imie = DaneKlientow.getString("imie");
                    String nazwisko = DaneKlientow.getString("nazwisko");
                    String dataZameldowania = DaneKlientow.getString("dataZameldowania");
                    String dataWymeldowania = DaneKlientow.getString("dataWymeldowania");
                
                    System.out.println("Klient/ka " +imie+ " " +nazwisko+ " ma numer " +idKlienta+ " zarezerwowal/la pokoj " +numerPokoju+ " w okresie od " +dataZameldowania+ " do " +dataWymeldowania+ ".");
                }
            }
            else
            {
                System.out.println("Zaden pokoj w hotelu " +nazwaHotelu+ " nie zostal zarezerwowany.");
            }
	
            statement.close();
            statementPokoi.close();
            StatementHotelu.close();

	}
        catch (Exception e) 
        {
            System.err.println("Wystapil problem z polaczeniem do bazy danych.");
            e.printStackTrace();
	}
    }
}