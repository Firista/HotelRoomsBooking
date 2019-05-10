package rezerwacjapokoihotelowych;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RezerwacjaPokoiHotelowych 
{
    public static void main(String[] args) throws ParseException 
    { 
        int numerZadania = 10;
        int kolejnyNumerZadania = 10;
        int jeszczeJedenNumerZadania = 10;
        
        while(numerZadania != 0)
        {
        
        System.out.println("Wybierz co chcesz zrobić:");
        System.out.println("1. Edytować dane hotelu");
        System.out.println("2. Zarezerwować wizytę w hotelu");
        System.out.println("0. Zakoncz dzialanie programu");
        
        Scanner wybranyNumer = new Scanner(System.in);

	numerZadania = Integer.parseInt(wybranyNumer.nextLine());
       
        if((numerZadania != 1) && (numerZadania != 2) && (numerZadania != 0))
        {
            while((numerZadania != 1) && (numerZadania != 2)){
                System.out.println("Wybrales nieodpowiednia wartosc. Mozesz wybrac opcje nr 1. lub opcje nr. 2. Podałeś: " + numerZadania);
                System.out.println("Wybierz jedna z pocji z listy: ");
                System.out.println("1. Edytować dane hotelu");
                System.out.println("2. Zarezerwować wizytę w hotelu");
                System.out.println("0. Zakoncz dzialanie programu");
                
                numerZadania = Integer.parseInt(wybranyNumer.nextLine());
                
                if((numerZadania == 1) || (numerZadania == 2) || (numerZadania == 0))
                {
                    System.out.println("Wybrales opcje: " + numerZadania);
                }
            }
        }
        
        if((numerZadania == 1) || (numerZadania == 2) || (numerZadania == 0))
        {
            System.out.println("Wybrales opcje: " + numerZadania);
        }
        
        switch(numerZadania)
        {
            case 1:

                System.out.println("Wybierz co chcesz zrobić:");
                System.out.println("1. Wyswietlic dane o hotelach");
                System.out.println("2. Dodać nowy hotel");
                System.out.println("3. Wyswietlic liste pracownikow");
                System.out.println("4. Dodać pracownika");
                System.out.println("5. Wyswietlic liste pokoi");
                System.out.println("6. Dodac nowy pokoj do hotelu");
                System.out.println("7. Zmienić stan pokoju");
                System.out.println("8. Zobaczyc liste rezerwacji");
                System.out.println("0. Zakoncz dzialanie programu");
        
                Scanner wybranyKolejnyNumer = new Scanner(System.in);

                kolejnyNumerZadania = Integer.parseInt(wybranyKolejnyNumer.nextLine());
                
                if((kolejnyNumerZadania != 1) && (kolejnyNumerZadania != 2) && (kolejnyNumerZadania != 3) && (kolejnyNumerZadania != 4) && (kolejnyNumerZadania != 5) && (kolejnyNumerZadania != 6) && (kolejnyNumerZadania != 7) && (kolejnyNumerZadania != 8) && (kolejnyNumerZadania != 0))
                {
                    while((kolejnyNumerZadania != 1) && (kolejnyNumerZadania != 2) && (kolejnyNumerZadania != 3) && (kolejnyNumerZadania != 4) && (kolejnyNumerZadania != 5) && (kolejnyNumerZadania != 6) && (kolejnyNumerZadania != 7) && (kolejnyNumerZadania != 8) && (kolejnyNumerZadania != 0))
                    {
                        System.out.println("Wybrales nieodpowiednia wartosc. Mozesz wybrac opcje od nr 1. do nr. 8. Podałeś: " + kolejnyNumerZadania);
                        System.out.println("Wybierz jedna z pocji z listy: ");
                        System.out.println("1. Wyswietlic dane o hotelach");
                        System.out.println("2. Dodać nowy hotel");
                        System.out.println("3. Wyswietlic liste pracownikow");
                        System.out.println("4. Dodać pracownika");
                        System.out.println("5. Wyswietlic liste pokoi");
                        System.out.println("6. Dodac nowy pokoj do hotelu");
                        System.out.println("7. Zmienić stan pokoju");
                        System.out.println("8. Zobaczyc liste rezerwacji");
                        System.out.println("0. Zakoncz dzialanie programu");
                        
                        kolejnyNumerZadania = Integer.parseInt(wybranyKolejnyNumer.nextLine());
                
                        if((kolejnyNumerZadania == 1) || (kolejnyNumerZadania == 2) || (kolejnyNumerZadania == 3) || (kolejnyNumerZadania == 4) || (kolejnyNumerZadania == 5) || (kolejnyNumerZadania == 6) || (kolejnyNumerZadania == 7) || (kolejnyNumerZadania == 8) || (kolejnyNumerZadania == 0))
                        {
                            System.out.println("Wybrales opcje: " + kolejnyNumerZadania);
                            
                            if (kolejnyNumerZadania == 0) break;
                        }
                    }
                }
        
                if((kolejnyNumerZadania == 1) || (kolejnyNumerZadania == 2) || (kolejnyNumerZadania == 3) || (kolejnyNumerZadania == 4) || (kolejnyNumerZadania == 5) || (kolejnyNumerZadania == 6) || (kolejnyNumerZadania == 7) || (kolejnyNumerZadania == 8) || (kolejnyNumerZadania == 0))
                {
                    System.out.println("Wybrales opcje: " + kolejnyNumerZadania);
                    
                    if (kolejnyNumerZadania == 0) break;
                }
                
                switch(kolejnyNumerZadania)
                {    
                    case 1:
                        
                        Hotel hotel = new Hotel();
                        hotel.polacz();
                        hotel.wypiszWszystkieHotele();
                        hotel.rozlacz();
                        
                        break;
                        
                    case 2:
                        
                        System.out.println("Podaj nazwe nowego hotelu:");
                        
                        Scanner nowaNazwaHotelu = new Scanner(System.in);
                        String wybranaNowaNazwaHotelu = nowaNazwaHotelu.nextLine();
                        
                        System.out.println("Ilu gwiazdkowy jest wprowadzany hotel:");
                        
                        Scanner iluGwiazdkowy = new Scanner(System.in);
                        int wybranaIloscGwiazdek = Integer.parseInt(iluGwiazdkowy.nextLine());
                        
                        Hotel nowyHotel = new Hotel();
                        nowyHotel.polacz();
                        nowyHotel.dodajHotel(wybranaNowaNazwaHotelu, wybranaIloscGwiazdek);
                        nowyHotel.rozlacz();
                        
                        break;
                        
                    case 3:
                        
                        System.out.println("Podaj nazwe hotelu, ktorego pracownikow chcesz zobaczyc:");
                        
                        Scanner nazwaHoteluDoWyswietleniaPracownikow = new Scanner(System.in);
                        String wybranaNazwaHoteluDoWyswietleniaPracownikow = nazwaHoteluDoWyswietleniaPracownikow.nextLine();
                        
                        Pracownik pracownik = new Pracownik();
                        pracownik.polacz();
                        pracownik.wypiszWszystkichPracownikow(wybranaNazwaHoteluDoWyswietleniaPracownikow);
                        pracownik.rozlacz();
                        
                        break;
                        
                    case 4:
                        
                        System.out.println("Podaj nazwe hotelu, do ktorego chcesz dodac pracownika:");
                        
                        Scanner nazwaHotelu = new Scanner(System.in);
                        String wybranaNazwaHotelu = nazwaHotelu.nextLine();
                        
                        System.out.println("Na jakim stanowisku ma pracowac:");
                        
                        Scanner stanowisko = new Scanner(System.in);
                        String wybraneStanowisko = stanowisko.nextLine(); 
                        
                        Pracownik nowyPracownik = new Pracownik();
                        
                        nowyPracownik.polacz();
                        nowyPracownik.dodajPracownika(wybraneStanowisko, wybranaNazwaHotelu);
                        nowyPracownik.rozlacz();
                        
                        break;
                        
                    case 5:
                        
                        System.out.println("Podaj nazwe hotelu, ktorego pokoje chcesz zobaczyc:");
                        
                        Scanner nazwaHoteluDoWyswietleniaPokoi = new Scanner(System.in);
                        String wybranaNazwaHoteluDoWyswietleniaPokoi = nazwaHoteluDoWyswietleniaPokoi.nextLine();
                        
                        Pokoj pokoj = new Pokoj();
                        
                        pokoj.polacz();
                        pokoj.wypiszWszystkiePokojeWHotelu(wybranaNazwaHoteluDoWyswietleniaPokoi);
                        pokoj.rozlacz();
                        
                        break;
                        
                    case 6:
                        
                        System.out.println("Podaj ilu osobowy bedzie pokoj:");
                        
                        Scanner iluOsobowyPokoj = new Scanner(System.in);
                        int wybranyIluOsobowyPokoj = Integer.parseInt(iluOsobowyPokoj.nextLine());
                        
                        System.out.println("Podaj ile lozek jest w pokoju:");
                        
                        Scanner ileLozekPokoj = new Scanner(System.in);
                        int wybranyIleLozekPokoj = Integer.parseInt(ileLozekPokoj.nextLine());
                        
                        System.out.println("Podaj id hotelu do ktorego dodajesz pokoj:");
                        
                        Scanner idHoteluDoPokoju = new Scanner(System.in);
                        int wybranyIdHoteluDoPokoju = Integer.parseInt(idHoteluDoPokoju.nextLine());
                        
                        Pokoj nowyPokoj = new Pokoj(wybranyIleLozekPokoj, wybranyIluOsobowyPokoj, wybranyIdHoteluDoPokoju);
                        
                        nowyPokoj.polacz();
                        nowyPokoj.dodajPokoj();
                        nowyPokoj.rozlacz();
                        
                        break;
                        
                    case 7:
                        
                        System.out.println("Podaj numer pokoju, ktorego stan chcesz zmienic:");
                        
                        Scanner numerPokoju = new Scanner(System.in);
                        int wybranyNumerPokoju = Integer.parseInt(numerPokoju.nextLine());
                        
                        System.out.println("Wybierz stan pokoju z listy:\n1.wolny\n2.zajety");
                        
                        Scanner stanPokoju = new Scanner(System.in);
                        int stan = Integer.parseInt(stanPokoju.nextLine());
                        
                        Pokoj edytowanyPokoj = new Pokoj();
                        
                        edytowanyPokoj.polacz();
                        edytowanyPokoj.zmienStanPokoju(wybranyNumerPokoju,stan);
                        edytowanyPokoj.rozlacz();
                        
                        break;
                        
                    case 8:
                        
                        System.out.println("Podaj nazwe hotelu, ktorego chcesz zobaczyc rezerwacje:");
                        
                        Scanner nazwaHoteluDoWyswietleniaRezerwacji = new Scanner(System.in);
                        String wybranaNazwaHoteluDoWyswietleniaRezerwacji = nazwaHoteluDoWyswietleniaRezerwacji.nextLine();
                        
                        Klient klient = new Klient();
                        
                        klient.polacz();
                        klient.wypiszWszystkieRezerwacje(wybranaNazwaHoteluDoWyswietleniaRezerwacji);
                        klient.rozlacz();
                        
                        break;
                        
                    case 0:
                        
                        numerZadania = 0;
                        
                        break;
                }
                
                break;
                
            case 2:

                System.out.println("Wybierz co chcesz zrobić:");
                System.out.println("1. Wyswietlic liste hoteli");
                System.out.println("2. Zarezerwowac pokoj w wybranym hotelu.");
                System.out.println("0. Zakoncz dzialanie programu");
        
                Scanner wybranyJeszczeJedenNumer = new Scanner(System.in);

                jeszczeJedenNumerZadania = Integer.parseInt(wybranyJeszczeJedenNumer.nextLine());

                if((jeszczeJedenNumerZadania != 1) && (jeszczeJedenNumerZadania != 2) && (jeszczeJedenNumerZadania != 0))
                {
                    while((jeszczeJedenNumerZadania != 1) && (jeszczeJedenNumerZadania != 2) && (jeszczeJedenNumerZadania != 0))
                    {
                        System.out.println("Wybierz co chcesz zrobić:");
                        System.out.println("1. Wyswietlic liste hoteli");
                        System.out.println("2. Zarezerwowac pokoj w wybranym hotelu.");
                        System.out.println("0. Zakoncz dzialanie programu");
                        
                
                        jeszczeJedenNumerZadania = Integer.parseInt(wybranyJeszczeJedenNumer.nextLine());
                
                        if((jeszczeJedenNumerZadania == 1) || (jeszczeJedenNumerZadania == 2) || (jeszczeJedenNumerZadania == 0))
                        {
                            System.out.println("Wybrales opcje: " + jeszczeJedenNumerZadania);
                            
                            if (jeszczeJedenNumerZadania == 0) break;
                        }
                    }
                }
        
                if((jeszczeJedenNumerZadania == 1) || (jeszczeJedenNumerZadania == 2) || (jeszczeJedenNumerZadania == 0))
                {
                    System.out.println("Wybrales opcje: " + jeszczeJedenNumerZadania);
                    
                    if (jeszczeJedenNumerZadania == 0) break;
                }
                
                switch(jeszczeJedenNumerZadania)
                {
                    case 1:
                        
                        Hotel hotel = new Hotel();
                        
                        hotel.polacz();
                        hotel.wypiszWszystkieHotele();
                        hotel.rozlacz();
                        
                        break;
                        
                    case 2:
                        
                        System.out.println("Podaj swoje imie:");
                        Scanner imie = new Scanner(System.in);
                        String wybraneImie = imie.nextLine();
                        
                        System.out.println("Podaj swoje nazwisko:");
                        Scanner nazwisko = new Scanner(System.in);
                        String wybraneNazwisko = nazwisko.nextLine();
                        
                        System.out.println("Podaj date planowanego rozpoczecia pobytu w formacie YYYY-MM-DD:");
                        Scanner dataZameldowania = new Scanner(System.in);
                        String data1 = dataZameldowania.nextLine();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        Date wybranaDataZameldowania = format.parse(data1);
                        java.sql.Date sqlDate1 = new java.sql.Date(wybranaDataZameldowania.getTime());

                        System.out.println("Podaj date planowanego zakonczenia pobytu w formacie YYYY-MM-DD:");
                        Scanner dataWymeldowania = new Scanner(System.in);
                        String data2 = dataWymeldowania.nextLine();
                        Date wybranaDataWymeldowania = format.parse(data2);
                        java.sql.Date sqlDate2 = new java.sql.Date(wybranaDataWymeldowania.getTime());
                        
                        Klient nowyKlient = new Klient();
                        
                        nowyKlient.polacz();
                        
                        System.out.println("Podaj nazwe hotelu, ktorego pokoje chcesz zobaczyc:");
                        Scanner nazwaHoteluDoWyswietleniaPokoi = new Scanner(System.in);
                        String wybranaNazwaHoteluDoWyswietleniaPokoi = nazwaHoteluDoWyswietleniaPokoi.nextLine();
                        
                        System.out.println("Ilu osobowy ma byc pokoj:");
                        Scanner iluOsobowy = new Scanner(System.in);
                        int wybranyIluOsobowy = Integer.parseInt(iluOsobowy.nextLine());
                        
                        System.out.println("Ile lozek ma byc w pokoju:");
                        Scanner iloscLozek = new Scanner(System.in);
                        int wybranaIloscLozek = Integer.parseInt(iloscLozek.nextLine());

                        nowyKlient.wypiszWolnePokoje(wybranaNazwaHoteluDoWyswietleniaPokoi, wybranyIluOsobowy, wybranaIloscLozek, sqlDate1, sqlDate2);
                        
                        System.out.println("Podaj numer pokoju, ktory chcesz zarezerwowac sposrod przedstawionych:");
                        Scanner numerPokoju = new Scanner(System.in);
                        int wybranynumerPokoju = Integer.parseInt(numerPokoju.nextLine());

                        nowyKlient.zarezerwujWybranyPokoj(wybranynumerPokoju, sqlDate1, sqlDate2, wybraneImie, wybraneNazwisko);
                        nowyKlient.rozlacz();
                        
                        break;
                        
                    case 0:
                        
                        numerZadania = 0;
                        
                        break;
                }
                
                break;
                
            case 0:
                
                numerZadania = 0;
                
                break;  
            }                    
        }
    }
}