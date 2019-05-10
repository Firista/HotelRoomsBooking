-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 30 Sty 2019, 11:11
-- Wersja serwera: 10.1.37-MariaDB
-- Wersja PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `hotel`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hotel`
--

CREATE TABLE `hotel` (
  `idHotelu` int(4) NOT NULL,
  `nazwaHotelu` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `iluGwiazdkowy` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `hotel`
--

INSERT INTO `hotel` (`idHotelu`, `nazwaHotelu`, `iluGwiazdkowy`) VALUES
(1, 'Primland Resort', 5),
(2, 'Slaby hotel', 2),
(3, 'cos', 2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `klient`
--

CREATE TABLE `klient` (
  `idKlienta` int(4) NOT NULL,
  `imie` varchar(20) COLLATE utf8_polish_ci DEFAULT NULL,
  `nazwisko` varchar(50) COLLATE utf8_polish_ci DEFAULT NULL,
  `dataZameldowania` date NOT NULL,
  `dataWymeldowania` date NOT NULL,
  `numerPokoju` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `klient`
--

INSERT INTO `klient` (`idKlienta`, `imie`, `nazwisko`, `dataZameldowania`, `dataWymeldowania`, `numerPokoju`) VALUES
(1, 'Magda', 'Przygodzka', '2019-02-05', '2019-02-10', 1),
(2, 'Artur', 'Szeszko', '2019-02-05', '2019-02-20', 2),
(3, 'Janusz', 'Szorc', '2019-03-03', '2019-03-06', 3),
(4, 'Gertruda', 'Patelnia', '2019-02-23', '2019-03-01', 3),
(5, 'dsfa', 'safsa', '2019-05-04', '2019-05-05', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pokoj`
--

CREATE TABLE `pokoj` (
  `numerPokoju` int(4) NOT NULL,
  `stanPokoju` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `iluOsobowy` int(2) NOT NULL,
  `iloscLozek` int(2) NOT NULL,
  `idHotelu` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `pokoj`
--

INSERT INTO `pokoj` (`numerPokoju`, `stanPokoju`, `iluOsobowy`, `iloscLozek`, `idHotelu`) VALUES
(1, 'zajety', 2, 2, 1),
(2, 'zajety', 2, 2, 1),
(3, 'zajety', 4, 2, 1),
(4, 'wolny', 1, 1, 1),
(5, 'wolny', 3, 3, 1),
(6, 'wolny', 3, 2, 1),
(7, 'wolny', 4, 3, 1),
(8, 'wolny', 4, 4, 1),
(9, 'wolny', 3, 3, 1),
(10, 'wolny', 4, 4, 1),
(11, 'wolny', 3, 3, 1),
(12, 'wolny', 1, 1, 2),
(13, 'wolny', 2, 2, 2),
(14, 'wolny', 1, 1, 1),
(15, 'wolny', 2, 2, 2),
(16, 'wolny', 2, 1, 2),
(17, 'wolny', 1, 1, 2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pracownik`
--

CREATE TABLE `pracownik` (
  `idPracownika` int(4) NOT NULL,
  `stanowisko` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `idHotelu` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `pracownik`
--

INSERT INTO `pracownik` (`idPracownika`, `stanowisko`, `idHotelu`) VALUES
(3, 'recepcjonista', 1),
(6, 'sprzatacz', 1),
(7, 'recepcjonista', 2);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`idHotelu`);

--
-- Indeksy dla tabeli `klient`
--
ALTER TABLE `klient`
  ADD PRIMARY KEY (`idKlienta`),
  ADD KEY `numerPokoju` (`numerPokoju`);

--
-- Indeksy dla tabeli `pokoj`
--
ALTER TABLE `pokoj`
  ADD PRIMARY KEY (`numerPokoju`),
  ADD KEY `idHotelu` (`idHotelu`);

--
-- Indeksy dla tabeli `pracownik`
--
ALTER TABLE `pracownik`
  ADD PRIMARY KEY (`idPracownika`),
  ADD KEY `idHotelu` (`idHotelu`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `hotel`
--
ALTER TABLE `hotel`
  MODIFY `idHotelu` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT dla tabeli `klient`
--
ALTER TABLE `klient`
  MODIFY `idKlienta` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT dla tabeli `pokoj`
--
ALTER TABLE `pokoj`
  MODIFY `numerPokoju` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT dla tabeli `pracownik`
--
ALTER TABLE `pracownik`
  MODIFY `idPracownika` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `klient`
--
ALTER TABLE `klient`
  ADD CONSTRAINT `klient_ibfk_1` FOREIGN KEY (`numerPokoju`) REFERENCES `pokoj` (`numerPokoju`);

--
-- Ograniczenia dla tabeli `pokoj`
--
ALTER TABLE `pokoj`
  ADD CONSTRAINT `pokoj_ibfk_1` FOREIGN KEY (`idHotelu`) REFERENCES `hotel` (`idHotelu`);

--
-- Ograniczenia dla tabeli `pracownik`
--
ALTER TABLE `pracownik`
  ADD CONSTRAINT `pracownik_ibfk_1` FOREIGN KEY (`idHotelu`) REFERENCES `hotel` (`idHotelu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
