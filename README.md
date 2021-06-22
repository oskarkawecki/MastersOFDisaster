Aplikacja do zarządzania czasem pracy w projekcie

Autorzy: Oskar Kawecki, Marcin Kura, Marcin Kubasiak, Dawid Stefanik, Aleksandra Zajdel, Łukasz Korzeń;  
Consulting: dr Kamil Piętak

Aplikacja umożliwia puszczenie dwóch raportów które sumują liczbę godzin przepracowaną w firmie w danym projekcie jak również liczbę godzin przepracowanych przez danego pracownika na poszczególnych projektach. Dane wyjściowe dla aplikacji powinnny być zapisane w formacie .xls w folderze reporter\src\main\resources lub wskazanym podczas uruchamiania programu.
Plik xls powinien zawierać trzy poniższe nagłówki.	

	Data		Zadanie		  	Czas [h]
	2012-02-08	Testy prototypu		3,5


Opcje do wyboru:
-report1, aby wyświetlić raport 1 który sumuje liczbę godzin przepracowaną w projekcie \n
-report2, aby wyświetlić raport 2 który sumuje liczbę godzin przepracowaną przez pracownika w projektach;
-report1 -report2, aby jednocześnie wyświetlić ww raporty,
-from DD/MM/YYYY, aby wyświetlić raport w określonym zakresie czasu
-path, aby wskazać ścieżkę dla zapisanych plików raportowych wpisz na konsoli. Jeśli parametr nie będzie podany aplikacja będzie korzystać z domyślnej ścieżki src/main/resources/reporter-dane";


Obsługa błędów

"Brak danych do wyświetlenia - sprawdź katalog" - sprawdź czy podana ścieżka dla pobrania plików wyjściowych jest poprawna
"Uwaga: wiersz o numerze X zostal pominiety. Niewlasciwe dane." - sprawdź czy zawartość wiersza X w którymś z plików jest pusta lub zawiera niewłaściwy typ danych


Jeśli masz problemy z obsługą aplikacji skontaktuj się z grupą support@MastersofDisaster.com
