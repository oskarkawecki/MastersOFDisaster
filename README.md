Aplikacja do zarządzania czasem pracy w projekcie

Aplikacja umożliwia puszczenie dwóch raportów które sumują liczbę godzin przepracowaną w firmie w danym projekcie jak również liczbę godzin przepracowanych przez danego pracownika na poszczególnych projektach. Dane wyjściowe dla aplikacji powinnny być zapisane w formacje .xls .w folderze domyślnym lub wskazanym podczas uruchamiania programu.
Plik xls powinien zawierać trzy poniższe nagłówki.	

	Data		Zadanie		  Czas [h]
2012-02-08	Testy prototypu		3



Autorzy: Oskar Kawecki, Marcin Kura, Marcin Kubasia, Dawid Stefanik, Aleksandra Zajdel, Łukasz Korzeń 
Consulting: dr Kamil Piętak




Opcje do wyboru:
-t	Aby wyświetlić raport 1 który sumuje liczbę godzin przepracowaną w projekcie, wpisz na konsoli:  -t
Aby wyświetlić raport 2 który sumuje liczbę godzin przepracowaną przez pracownika w projektach, wpisz na konsoli:  -r
Aby wyświetlić raport w określonym zakresie czasu wpisz na konsoli - from DD/MM/YYYY
Aby wskazać ściężkę dla zapisanych plików raportowych wpisz na konsoli: -path, jeśli parametr nie będzie podany aplikacja będzie korzystać z domyślnej ścieżki src/main/resources/reporter-dane";


Obsługa błędów

"Brak danych do wyświetlenia - sprawdz katalog" - sprawdź czy podana ścieżka dla pobrania plików wyjściowych jest poprawna
"Uwaga: wiersz o numerze X zostal pominiety. Niewlasciwe dane." - sprawdz czy zawartość wiersza X wktórymś z plików jest pusta


Jeśli masz problemy z obsługą aplikacji skontaktuj się z grupą support@MastersofDisaster.com