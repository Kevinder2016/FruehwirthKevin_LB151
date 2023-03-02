# Projekt-Dokumentation

Frühwirth

| Datum | Version | Zusammenfassung                                              |
| ----- | ------- | ------------------------------------------------------------ |
| 12.01.2023 | 0.0.1   | Für das Projekt wurde eine Beschreibung erstellt, die Technologie und Datenbank ausgewählt und auf Basis der Anforderungen User Stories mit zugehörigen Testfällen definiert, zusätzlich wurden GUI-Prototypen erstellt. |
| 26.01.2023 | 0.0.2   | Projekt erstellt, Beanklasse erstell, mit Programmieren begonnen |
| 16.02.2023 | 0.0.3   | Datenbank eingebunden, Testfälle angepasst |
| 17.02.2023 | 0.0.4   | Arbeit an Administrator Login und den Funktionen die zum Admin dazugehören |
| 27.02.2023 | 0.0.5   | Arbeit am Quiz und wichtigste Quizfunktionalitäten |
| 01.03.2023 | 0.0.6   | Arbeit an Highscore Liste und weiteren Spielfunktionen |
| 02.03.2023 | 1.0.0   | Projektdokumentation fertig gemacht, Programm feinschliff|

# 0 Ihr Projekt

In der Webapplikation soll der Nutzer ein Quiz spielen können, dass dem Quiz aus der Fernsehserie "Glückspiel" ähnelt, es geht darum, Wörter und Sätze für Münzen zu erraten und sich dann mit anderen Spielern in einer Highscore Liste zu messen.

# 1 Analyse

* Tier 1 (Presentation): Die Benutzeroberfläche, die das Rätselwort mit der passenden Kategorie, den Kontostand, die verbleibenden Leben, die Highscore-Liste, die Login Seite für den Administrator und die Seite für die Verwaltung von Wörtern anzeigt.
* Tier 2 (Webserver): empfängt die Anforderungen des Benutzers und leitet sie weiter an tiefere Schichten.
* Tier 3 (Application Server): beinhaltet die Logik der Anwendung. Ist für das auslesen und schreiben in die Datenbank verantwortlich und überprüft Eingaben serverseitig.
* Tier 4 (Dataserver): Speichert die Daten des Nutzers für die Highscore-liste(name, coins...), die Login-Daten für den Administrator und weiter Daten, die für das Spiel gebraucht werden (z:B: die Wörter)

# 2 Technologie

* Tier 1 (Presentation): XHTML und CSS
* Tier 2 (Webserver): JSF
* Tier 3 (Application Server): JSF
* Tier 4 (Dataserver): MySQL

# 3 Datenbank

Für die Verwendung der MySQL Datenbank wird JDBC (Java Database Connectivity) in Kombination mit PreparedStatements genutzt. Mit JDBC kann eine Verbindung zur MySQL Datenbank hergestellt werden. PreparedStatements ermöglichen das vorbereitete Ausführen von SQL-Abfragen, wodurch die Ausführung schneller und sicherer wird. Durch die Verwendung von PreparedStatements wird die Gefahr von SQL-Injection-Angriffen minimiert. Die MySQL Datenbank speichert die Daten in Tabellen und man kann durch SQL-Abfragen auf die Daten zugreifen und diese manipulieren. Die Verbindung zur Datenbank wird über eine URL und Anmeldedaten wie Benutzername und Passwort hergestellt. Durch die Nutzung von JDBC und PreparedStatements können Daten sicher in der MySQL Datenbank gespeichert und abgerufen werden.


# 4.1 User Stories


| US-№ | Verbindlichkeit | Typ  | Beschreibung                       |
| ---- | --------------- | ---- | ---------------------------------- |
| 1    | Muss | Funktional | Als Administrator möchte ich mich durch Benutzername und Passwort authentifizieren können, damit ich Zugang zu den Administrationsfunktionen habe. |
| 2  | Muss | Funktional | Als Administrator möchte ich Phrasen und Rätselwörter anlegen, ändern und löschen können, damit ich das Angebot der Anwendung aktualisieren kann. |
| 3  | Muss | Funktional | Als Administrator möchte ich Kategorien anlegen und jedes Wort oder jede Frage einer Kategorie zuordnen können, damit ich die Rätsel organisieren und sortieren kann. |
| 4  | Muss | Funktional | Als Administrator möchte ich einzelne Einträge der Highscore-Liste löschen können, damit ich unerwünschte Einträge entfernen kann. |
| 5  | Muss | Funktional | Als Spieler möchte ich einen Namen eingeben können, der auf der Highscore-Liste erscheint, damit ich meine Leistungen nachverfolgen kann. |
| 6  | Muss | Funktional | Als Spieler möchte ich zu jeder Zeit meinen Kontostand sehen können, damit ich weiß, wie viel Geld ich im Spiel gewonnen habe. |
| 7  | Muss | Funktional | Als Spieler möchte ich zu jeder Zeit meine Lebenspunkte sehen können, damit ich weiß, wie viele Versuche ich noch habe, um das Rätsel zu lösen. |
| 8  | Muss | Funktional | Als Spieler möchte ich erfahren, ob meine Antwort richtig oder falsch war, damit ich weiß, ob ich dem Rätsel näher komme. |
| 9  | Muss | Funktional | Als Spieler möchte ich in der Highscore-Liste Rang, Name, Zeitpunkt des Spiels, Geldbetrag und Anzahl Spielrunden sehen können, damit ich die Leistungen anderer Spieler vergleichen und meine eigene Leistung nachverfolgen kann. |
| 10 | Muss | Funktional | Als Spieler möchte ich kein Rätsel-Wort oder keine Phrase mehr als einmal gestellt bekommen, damit das Spiel interessant bleibt. |
| 11 | Muss | Funktional | Als Spieler möchte ich jederzeit das Spiel verlassen und meinen Gewinn in die Highscore-Liste übernehmen können, damit ich meine Leistungen sehen und mit anderen Vergleichen kann. |
| 12 | Muss | Funktional | Als Spieler möchte ich eine spielbare Anzahl an Wörtern und Fragen haben, damit das Spiel genug Abwechslung bietet. |
| 13 | Muss | Funktional | Als Spieler möchte ich die Anzahl der Spielrunden gezählt sehen, damit ich weiß wie oft ich das Spiel gespielt habe. |



# 4.2 Testfälle

| TC-№ | Vorbereitung | Eingabe | Erwartete Ausgabe |
| ---- | ------------ | ------- | ----------------- |
| 1.1  | Administrator legt Benutzername und Passwort an | Administrator gibt Benutzername und Passwort ein | Administrator wird erfolgreich authentifiziert und erhält Zugang zu den Administrationsfunktionen |
| 2.1  | Administrator ist authentifiziert | Administrator legt neue Phrase oder Rätselwort an oder ändert bestehendes | Neue Phrase oder Rätselwort wird erfolgreich angelegt oder bestehendes wurde erfolgreich geändert |
| 3.1  | Administrator hat bereits Kategorien angelegt und Phrasen und Rätselwörter hinzugefügt | Administrator ordnet Phrasen und Rätselwörter bestimmten Kategorien zu | Phrasen und Rätselwörter werden erfolgreich den entsprechenden Kategorien zugeordnet |
| 4.1  | Einträge in der Highscore-Liste sind vorhanden | Administrator wählt Eintrag aus und löscht ihn | Der ausgewählte Eintrag wird erfolgreich gelöscht |
| 5.1  | Spieler hat das Spiel gestartet | Spieler gibt seinen Namen ein | Name wird in der Highscore-Liste angezeigt |
| 6.1  | Spieler hat das Spiel gestartet | Spieler navigiert zur Anzeige des Kontostands | Aktueller Kontostand wird angezeigt. |
| 7.1  | Spieler hat das Spiel gestartet | Spieler navigiert zur Anzeige der Lebenspunkte | Aktuelle Lebenspunkte werden angezeigt.|
| 8.1  | Spieler hat eine Frage beantwortet | Spieler gibt Antwort ein | Benachrichtigung, ob die Antwort richtig oder falsch war |
| 9.1  | Es gibt Einträge in der Highscore-Liste | Spieler navigiert zur Highscore-Liste | Highscore-Liste wird angezeigt, sortiert nach Rang und enthält Rang, Name, Zeitpunkt des Spiels, Gespielte Runden |
| 10.1  | Spieler hat bereits einige Rätsel gelöst | Spieler beginnt eine neue Runde | Kein Rätsel-Wort oder keine Phrase wurde dem Spieler bereits gestellt |
| 11.1 | Spieler hat einen Betrag an coins angesammelt | Spieler wählt die Option, den Betrag in die Highscore-Liste zu übernehmen | Der Gewinn wird in der Highscore-Liste angezeigt |
| 12.1 | Anwendung ist bereit zum Spielen | Spieler beginnt eine neue Runde | Es stehen genügend Rätsel zur Verfügung |
| 13.1 | Spieler hat mehrere Runden gespielt | Spieler navigiert zur Anzeige der Anzahl der gespielten Runden | Anzahl der gespielten Runden wird angezeigt. |


# 5 Prototyp


![image](https://user-images.githubusercontent.com/69578309/222433956-ab388f2e-103e-4fab-9c37-ba5ce37ff0f3.png) ![image](https://user-images.githubusercontent.com/69578309/222433256-a5de634e-dc30-4f3a-92c8-c3eb9f3bdd64.png)

![image](https://user-images.githubusercontent.com/69578309/222435379-f9ccd887-3b82-465f-8387-12c4999e114e.png) ![image](https://user-images.githubusercontent.com/69578309/222436642-cdeb3c38-31ff-4752-81c1-1dbeb15c6225.png)




# 6 Implementation

✍️ Halten Sie fest, wann Sie welche User Story bearbeitet haben

| User Story | Datum | Beschreibung |
| ---------- | ----- | ------------ |
| 1 | 17.02.2023 | Geschafft |
| 2 | 17.02.2023 | Nicht Geschafft |
| 3 | 17.02.2023 | Nicht Geschafft |
| 4 | 17.02.2023 | Geschafft |
| 5 | 27.02.2023 | Geschafft |
| 6 | 27.02.2023 | Geschafft |
| 7 | 27.02.2023 | Geschafft |
| 8 | 27.02.2023 | Geschafft |
| 9 | 01.02.2023 | Geschafft |
| 10 | 01.03.2023 | Geschafft |
| 11 | 01.03.2023 | Geschafft |
| 12 | 01.03.2023 | Geschafft |
| 13 | 01.03.2023 | Geschafft |

# 7 Projektdokumentation

| US-№ | Erledigt? | Entsprechende Code-Dateien oder Erklärung |
| ---- | --------- | ----------------------------------------- |
| 1 | ja | AdminLoginBean.java, adminLogin.xhtml |
| 2 | nein | AdminPhraseBean.java, AdminPhrase.java, phrase.xhtml |
| 3 | nein | AdminPhraseBean.java, AdminPhrase.java, phrase.xhtml |
| 4 | ja | adminHome.xhtml, AdminBean.java, Phrase.java |
| 5 | ja | index.xhtml, GameBean.java |
| 6 | ja |                                           |
| 7 | ja |                                           |
| 8 | ja |                                           |
| 9 | ja |                                           |
| 10 | ja |                                           |
| 11 | ja |                                           |
| 12 | ja |                                           |
| 13 | ja |                                           |

# 8 Testprotokoll


https://user-images.githubusercontent.com/69578309/222451688-c5f04bbe-6e91-48f9-ad53-f174337715c3.mp4




| TC-№ | Datum | Resultat | Tester |
| ---- | ----- | -------- | ------ |
| 1.1.1 | 02.03.2023 | OK | Kevin Frühwirth |
| 2.2.2 | 02.03.2023 | NOK | Kevin Frühwirth |
| 3.3.3 | 02.03.2023 | NOK | Kevin Frühwirth |
| 4.4.4 | 02.03.2023 | OK | Kevin Frühwirth |
| 5.5.5 | 02.03.2023 | OK | Kevin Frühwirth |
| 6.6.6 | 02.03.2023 | OK | Kevin Frühwirth |
| 7.7.7 | 02.03.2023 | OK | Kevin Frühwirth |
| 8.8.8 | 02.03.2023 | OK | Kevin Frühwirth |
| 9.9.9 | 02.03.2023 | OK | Kevin Frühwirth |
| 10.10.10 | 02.03.2023 | OK | Kevin Frühwirth |
| 11.11.11 | 02.03.2023 | OK | Kevin Frühwirth |
| 12.12.12 | 02.03.2023 | OK | Kevin Frühwirth |
| 13.13.13 | 02.03.2023 | OK | Kevin Frühwirth |

Fazit: Die Wichtigsten Anforderungen funktionieren, man kann das Spiel als Nutzer Spielen und sich mit anderen oder sich selbst durch die Highscore Liste vergleichen. Jedoch gibt es auch einige kleiner Probleme, für Administratoren fehlen z.B. einige Funktionen wie das Hinzufügen von anderen Kategorien und Rätselwörtern.

# 9 `README.md`

✍️ Beschreiben Sie ausführlich in einer README.md, wie Ihre Applikation gestartet und ausgeführt wird. Legen Sie eine geeignete Möglichkeit (Skript, Export, …) bei, Ihre Datenbank wiederherzustellen.

ändere jdk auf 1.8

# 10 Allgemeines

- [ ] Ich habe die Rechtschreibung überprüft
- [ ] Ich habe überprüft, dass die Nummerierung von Testfällen und User Stories übereinstimmen
- [ ] Ich habe alle mit ✍️ markierten Teile ersetzt
