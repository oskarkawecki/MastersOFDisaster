![image](https://user-images.githubusercontent.com/77232984/123149850-0292f100-d462-11eb-9f55-f8622f9feac8.png)

 
  Aplikacja do zarządzania czasem pracy w projektach

Autorzy: 
>>Oskar Kawecki 

>>Marcin Kura
 
>>Marcin Kubasiak 

>>Dawid Stefanik 

>>Łukasz Korzeń 

>>Aleksandra Zajdel


Consulting: dr inż. Kamil Piętak
________________________________________

O programie:

![image](https://user-images.githubusercontent.com/77232984/123150174-5a315c80-d462-11eb-8c1b-ab9c92d7a85e.png)


Program umożliwia użytkownikowi odczytywanie z plików .xls danych dotyczących godzin spędzonych przez pracowników przy wykonanych projektach oraz pozwala na sumowanie czasu potrzebnego do realizacji konkretnego projektu.
 ________________________________________

Wymagania:

Dane wyjściowe dla aplikacji powinny być zapisane w formacie .xls w folderze aplikacji lub wskazanym podczas uruchamiania programu. Plik xls powinien zawierać trzy poniższe nagłówki.

	Data		Zadanie		  	Czas [h]
	2012-02-08	Testy prototypu		3,5


________________________________________

Uruchomienie:

Uruchom wiersz poleceń wpisując "cmd" w Menu Start.

Aby uruchomić narzędzie  w wierszu poleceń należy wejść w katalog zawierający plik reporter.jar i użyć komendy:

java -jar reporter.jar "ścieżkaDoFolderuZPlikamiDanych"

np.

java -jar reporter.jar "C:\Users\olaaz\Desktop\reporter-project"
________________________________________

Użytkowanie:

-report1 -> wyświetla raport 1, który sumuje liczbę godzin spędzonych na pracy nad projektem

-report2 -> wyświetla raport 2, który sumuje liczbę godzin przepracowaną przez pracownika w projektach

-report1 -report2 -> pozwala jednocześnie wyświetlić obydwa raporty

-from DD/MM/YYYY -> pozwala wyświetlić raport w określonym przez użytkownika zakresie czasu

-path -> pozwala wskazać ścieżkę dla zapisanych plików raportowych wpisz na konsoli. Jeśli parametr nie będzie podany aplikacja będzie korzystać z domyślnej ścieżki którą jest folder aplikacji
________________________________________

Obsługa błędów:

-	„Brak danych do wyświetlenia - sprawdź katalog” - sprawdź czy podana ścieżka dla pobrania plików wyjściowych jest poprawna 

-	-"Uwaga: wiersz o numerze X został pominięty. Niewłaściwe dane." - sprawdź czy zawartość wiersza X w którymś z plików jest pusta lub zawiera niewłaściwy typ danych

-	-"Uwaga: wiersz o numerze X został pominięty.  Niepoprawny format daty." - sprawdź czy zawartość kolumny daty dla wiersza X w którymś z plików jest pusta lub zawiera niewłaściwy typ danych

-	-"Uwaga: wiersz o numerze X został pominięty.  Niepoprawna nazwa zadania." - sprawdź czy zawartość kolumny zadania dla wiersza X w którymś z plików jest pusta lub zawiera niewłaściwy typ danych

-	-"Uwaga: wiersz o numerze X został pominięty.  Niepoprawna liczba godzin." - sprawdź czy zawartość kolumny czasu dla wiersza X w którymś z plików jest pusta lub zawiera niewłaściwy typ danych


________________________________________

Pomoc

Jeśli masz problemy z obsługą aplikacji skontaktuj się z grupą support@MastersofDisaster.com

