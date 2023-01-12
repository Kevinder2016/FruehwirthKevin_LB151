# Projekt-Dokumentation

✍️ Frühwirth

| Datum | Version | Zusammenfassung                                              |
| ----- | ------- | ------------------------------------------------------------ |
|       | 0.0.1   | ✍️ Jedes Mal, wenn Sie an dem Projekt arbeiten, fügen Sie hier eine neue Zeile ein und beschreiben in *einem* Satz, was Sie erreicht haben. |
|       | 0.0.2   |                                                              |
|       | 0.0.3   |                                                              |
|       | 0.0.4   |                                                              |
|       | 0.0.5   |                                                              |
|       | 0.0.6   |                                                              |
|       | 1.0.0   |                                                              |

# 0 Ihr Projekt

✍️ Beschreiben Sie Ihr Projekt in einem griffigen Satz.

# 1 Analyse

✍️ Beschreiben Sie, auf welchem Tier Sie die dynamischen Elemente der Anwendung unterbringen möchten:

* Tier 1 (Presentation): Die Benutzeroberfläche, die dem Spieler das Rätsel, das Glücksrad, den Kontostand, die verbleibenden Leben und die Highscore-Liste anzeigt.
* Tier 2 (Webserver): Die Schicht, die die Anforderungen des Benutzers empfängt und an die nächste Schicht weiterleitet.
* Tier 3 (Application Server): Die Schicht, die die Business-Logik und die Verarbeitung der Anwendungsdaten enthält.
* Tier 4 (Dataserver): Die Schicht, die die Datenbanken enthält, in denen die Daten der Anwendung gespeichert und abgefragt werden.

# 2 Technologie

Asp.net und MySQL

# 3 Datenbank

Verwendung der ADO.NET-Bibliothek, die in ASP.NET enthalten ist, um direkt mit der Datenbank zu interagieren und SQL-Abfragen auszuführen.


# 4.1 User Stories

✍️ Formulieren Sie klare Anforderungen in der Form von User Stories (*„als … möchte ich … damit …“*) und zu jeder Anforderung mindestens einen dazugehörigen Testfall (in Kapitel 4.2). 

✍️ Formulieren Sie weitere, eigene Anforderungen und Testfälle, wie Sie Ihre Applikation erweitern möchten. Geben Sie diesen statt einer Nummer einen Buchstaben (`A`, `B`, etc.)

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
| 11 | Muss | Funktional | Als Spieler möchte ich jederzeit das Spiel verlassen und meinen Gewinn in die Highscore-Liste übernehmen können, damit ich meine Leistungen nicht verliere, wenn ich das Spiel verlassen muss. |
| 12 | Muss | Funktional | Als Spieler möchte ich eine spielbare Anzahl an Wörtern und Fragen haben, damit das Spiel genug Abwechslung bietet. |
| 13 | Muss | Funktional | Als Spieler möchte ich die Anzahl der Spielrunden gezählt sehen, damit ich weiß wie oft ich das Spiel gespielt habe. |

✍️ Jede User Story hat eine ganzzahlige Nummer (1, 2, 3 etc. oder Zahl), eine Verbindlichkeit (Muss oder Kann?), und einen Typ (Funktional, Qualität, Rand). 

# 4.2 Testfälle

| TC-№ | Vorbereitung | Eingabe | Erwartete Ausgabe |
| ---- | ------------ | ------- | ----------------- |
| 1.1  | Administrator legt Benutzername und Passwort an | Administrator gibt Benutzername und Passwort ein | Administrator wird erfolgreich authentifiziert und erhält Zugang zu den Administrationsfunktionen |
| 2.1  | Administrator ist authentifiziert | Administrator legt neue Phrase oder Rätselwort an oder ändert bestehendes | Neue Phrase oder Rätselwort wird erfolgreich angelegt oder bestehendes wurde erfolgreich geändert |
| 3.1  | Administrator hat bereits Kategorien angelegt und Phrasen und Rätselwörter hinzugefügt | Administrator ordnet Phrasen und Rätselwörter bestimmten Kategorien zu | Phrasen und Rätselwörter werden erfolgreich den entsprechenden Kategorien zugeordnet |
| 4.1  | Einträge in der Highscore-Liste sind vorhanden | Administrator wählt Eintrag aus und löscht ihn | Der ausgewählte Eintrag wird erfolgreich gelöscht |
| 5.1  | Spieler hat das Spiel gestartet | Spieler gibt seinen Namen ein | Name wird in der Highscore-Liste angezeigt |
| 6.1  | Spieler hat das Spiel gestartet | Spieler navigiert zur Anzeige des Kontostands und der Lebenspunkte | Aktueller Kontostand und Lebenspunkte werden angezeigt |
| 7.1  | Spieler hat eine Frage beantwortet | Spieler gibt Antwort ein | Benachrichtigung, ob die Antwort richtig oder falsch war |
| 8.1  | Es gibt Einträge in der Highscore-Liste | Spieler navigiert zur Highscore-Liste | Highscore-Liste wird angezeigt, sortiert nach Rang und enthält Rang, Name, Zeitpunkt des Spiels, Ge |
| 9.1  | Spieler hat bereits einige Rätsel gelöst | Spieler beginnt eine neue Runde | Kein Rätsel-Wort oder keine Phrase wurde dem Spieler bereits gestellt |
| 10.1 | Spieler hat einen Gewinn erzielt | Spieler wählt die Option, das Spiel zu verlassen und den Gewinn in die Highscore-Liste zu übernehmen | Spiel wird beendet und der Gewinn wird in der Highscore-Liste angezeigt |
| 11.1 | Anwendung ist bereit zum Spielen | Spieler beginnt eine neue Runde | Es stehen genügend Rätsel zur Verfügung |
| 12.1 | Spieler hat mehrere Runden gespielt | Spieler navigiert zur Anzeige der Anzahl der gespielten Runden | Anzahl der gespielten Runden wird angezeigt. |



✍️ Die Nummer hat das Format `N.m`, wobei `N` die Nummer der User Story ist, die der Testfall abdeckt, und `m` von `1` an nach oben gezählt. Beispiel: Der dritte Testfall, der die zweite User Story abdeckt, hat also die Nummer `2.3`.

# 5 Prototyp

✍️ Erstellen Sie Prototypen für das GUI (Admin-Interface und Quiz-Seite).

![image](https://user-images.githubusercontent.com/69578309/212023631-94995cf7-9e67-44a2-963b-61739a1ba10f.png)

# 6 Implementation

✍️ Halten Sie fest, wann Sie welche User Story bearbeitet haben

| User Story | Datum | Beschreibung |
| ---------- | ----- | ------------ |
| ...        |       |              |

# 7 Projektdokumentation

| US-№ | Erledigt? | Entsprechende Code-Dateien oder Erklärung |
| ---- | --------- | ----------------------------------------- |
| 1    | ja / nein |                                           |
| ...  |           |                                           |

# 8 Testprotokoll

✍️ Fügen Sie hier den Link zu dem Video ein, welches den Testdurchlauf dokumentiert.

| TC-№ | Datum | Resultat | Tester |
| ---- | ----- | -------- | ------ |
| 1.1  |       |          |        |
| ...  |       |          |        |

✍️ Vergessen Sie nicht, ein Fazit hinzuzufügen, welches das Test-Ergebnis einordnet.

# 9 `README.md`

✍️ Beschreiben Sie ausführlich in einer README.md, wie Ihre Applikation gestartet und ausgeführt wird. Legen Sie eine geeignete Möglichkeit (Skript, Export, …) bei, Ihre Datenbank wiederherzustellen.

# 10 Allgemeines

- [ ] Ich habe die Rechtschreibung überprüft
- [ ] Ich habe überprüft, dass die Nummerierung von Testfällen und User Stories übereinstimmen
- [ ] Ich habe alle mit ✍️ markierten Teile ersetzt
