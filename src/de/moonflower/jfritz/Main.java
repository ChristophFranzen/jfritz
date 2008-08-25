/**
 * JFritz
 * http://jfritz.sourceforge.net/
 *
 *
 * (c) Arno Willig <akw@thinkwiki.org>
 *
 * Created on 08.04.2005
 *
 * Authors working on the project:
 * 		akw			Arno Willig <akw@thinkwiki.org>
 * 		robotniko	Robert Palmer <robotniko@gmx.de>
 * 		kleinc		Christian Klein <kleinch@users.sourceforge.net>
 *      little_ben  Benjamin Schmitt <little_ben@users.sourceforge.net>
 *      baefer		Bastian Schaefer <baefer@users.sourceforge.net>
 *      capncrunch	Brian Jensen <capncrunch@users.sourceforge.net>
 *
 * This tool is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This piece of software is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this software; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *
 * BUGS: bitte bei Sourceforge nachschauen und dort auch den Status ändern
 * BUGS: http://sourceforge.net/tracker/?group_id=138196&atid=741413
 *
 * FeatureRequests: bitte bei Sourceforge nachschauen und dort auch den Status ändern
 * FeatureRequests: http://sourceforge.net/tracker/?func=browse&group_id=138196&atid=741416

 *
 * (TODO: Checken, ob alle Bibliotheken vorhanden sind)
 * (TODO: Neue Kurzwahlen von der Beta-FW ins Telefonbuch aufnehmen)
 * (TODO: Import der Anrufliste im XML-Format beim Kontextmenü einbauen)
 * TODO: Language-Files checken, ob tatsächlich alle Werte benötigt werden
 * TODO: Sonderzeichen werden in den Balloontips unter Windows nicht korrekt angezeigt. Scheint ein Windowsproblem zu sein. Lösung/Workaround noch nicht gefunden.
 * TODO: JFritz.ico mitliefern
 * TODO: Linux-Startscript mitliefern
 * TODO: LANG/jfritz.properties bei einem neuen Release aktuell halten
 * TODO: Vor dem Release noch den installDirectory-Pfad in JFritzUpdate auf "." anpassen
 *
 * Roadmap:
 * JFritz 1.0
 * Bewertung - Feature
 * rob - brian
 * 10 - 10 - Fehlermeldung an den Benutzer, wenn Daten nicht auf Festplatte gespeichert werden können. (Vielleicht schon implementiert -- Rob)
 * 10 - 10 - Kommentarspalte im Telefonbuch
 * 10 - 10 - Einstellen der Landes- und Ortsvorwahlen pro SIP-Account und nicht nur global (SF [ 1438932 ])
 * 10 - 7 - Webverkehr über Proxy (Was für Proxys sind gemeint: Socks 4 /5, oder HTTP(S)?)
 * 9 -  9 - Einstellungen-Seiten überarbeiten.       Größe veränderbar machen!(bei modalen Dialoge geht das nicht)
 * 9 -  9 - Name für die Nebenstellen aus der Weboberfläche auslesen und zuweisen (SF [ 1498487 ])
 * 9 -  8 - Export des gesamten Adressbuchs als VCard (http://www.ip-phone-forum.de/showthread.php?t=106758)
 * 9 -  7 - Vollständiger Outlook-Support (SF [ 1498489 ])
 * 8 -  8 - Analoge Rufnummer aus der FritzBox auslesen
 * 6 -  8 - Synchronisierung von JFritz Telefonbuch und FritzBox Telefonbuch (SF [ 1494436 ])
 * 6 -  8 - Datumsfilter konfigurierbar gestalten (SF [ 1498488 ])
 * 7 -  7 - Einige Icons auslagern - unterschiedliche Icon-Packs
 * 7 -  7 - Sounddateien auslagern - unterschiedliche Sound-Packs (gute Ideen, Brian)
 * 7 -  7 - Popup und Tray-Message für Anrufmonitor anpassbar machen (Name, Nummer, Adresse, Nebenstelle, Stadt, "von Arbeit", "von SIP", anderer Text, Größe des Popups)
 * 7 -  5 - CSV-Export nicht nur mit ";", sondern auch mit "TAB", "SPACE" und "," (SF [ 1509248 ])
 * 5 -  7 - Mehrere FritzBoxen abfragen (SF [ 1515855 ]) Dafür sollten wir alle zugriffe auf die Box in eigene Threads unterbringen.
 *                      Dann würde JFritz sich beim Hochfahren nicht so lange verzögern, wenn die Box nicht erreichbar ist.
 *                      Unterscheidung der Boxen anhand der MAC-Adresse (jpcap-Biblipthek für Java für ARP-Anfragen)
 * 6 -  6 - Internationalisierung abschließen, drunter Flaggencode optimieren (Nummer <-> flaggenfile Zuordnung in einer Hashmap ablegen).
 * 5 -  5 - Anrufmonitor: Anrufmonitor mächtiger machen (Aktionen nur für best. Nummern, verschiedene Aktionen, Log der Anrufe, Notizen zu einem laufenden Anruf) (SF [ 1525107 ])
 * 5 -  5 - Signalisieren der neu eingegangenen Anrufe im Tray (blinken, oder Zahl)
 * 5 -  5 - Button zum Löschen der Anrufliste
 * 4 -  5 - Visualisierung der aktuellen Gespräche (Frei, Nummer, Name, Dauer des Gesprächs ...)
 * 4 -  4 - Plugins (Mögliche Plugins: Drucken, Anrufmonitor)
 * 4 -  4 - Begrenzen der Anzeige der Anrufe in der Anrufliste (z.B. maximal 100 Einträge)
 * 4 -  4 - CSV-Export anpassbar machen (wie bei Thunderbird).
 * 4 -  4 - Registrierstatus der VoIP-Provider (SF [ 1315159 ])
 * 4 -  3 - Exportieren/Anzeige der Anrufliste nach Monaten getrennt
 * 4 -  2 - Import vom Tool Fritzinfo (http://www.ip-phone-forum.de/showthread.php?t=101090)
 * 4 -  1 - Einstellen der Farben, Symbolleisten, Schriftart, -größe (SF [ 1458892 ])
 * 3 -  3 - Anzeige des letzten Telefonats nicht nur abhängig von der Standardnummer und anzeige der gesprochenen Minuten pro Telefonbucheintrag
 * 3 -  2 - SQL-Anbindung (SF [ 1515305 ])
 * 3 -  2 - Tastaturkürzel für Aktionen sollen editierbar sein
 * 3 -  2 - Netzwerkfunktionen (Client/Server) (SF [ 1485417 ]) Das wird das allerschwierigste von allen, und am meisten Planung benötigen.
 * 3 -  2 - Spalte "Privatkontakt" in CSV-Liste hinzufügen (SF [ 1480617 ])
 * 2 -  2 - 64-bit Unterstützung
 * 1 -  1 - LDAP-Anbindung
 * 1 -  1 - SMS Benachrichtigung (Über Festnetzgateway)
 * 1 -  1 - Style-Sheet für die Anzeige der Anrufliste als HTML
 * 1 -  1 - Einige ausgewählte Statisken über die DSL benutzung, damit JFritz eine komplette Lösung für die Fritz!Box anbietet.
 * 1 -  1 - umstieg auf Mustang, damit verbunden jdic rauswerfen und nur noch Java-interne Bibliotheken nutzen
 * 					Gut, dann können wir endlich diese ganze String.indexOf('@') > 0 rausschmeißen :)
 *                  Das würde aber heissen, dass wir nicht mehr zu Java 1.4 kompatibel sind. Einige Plattformen (wie MAC) werden
 *                      bestimmt noch über längere Zeit kein Java SE 6 anbieten. -- Rob
 * 1 -  1 - Statistikfunktionen
 * 1 -  1 - WAN IP beim Tray-Icon anzeigen lassen ?
 * 1 -  1 - Skinns (SF [ 1471202 ])
 * 1 - (-1) - Unterstützung für das Adressbuch von Lotus Notes (SF [ 1445456 ]) (Ich bin dagegen, denn man bräuchte nochmal so ne Plugin wie bei Outlook,
 * 						nur ich schätze es gibt gar keins => wir müssten eine schreiben.
 * 						Habe das programm bei mir in der Arbeit, und ich hasse es. Ich werde nicht mehr Zeit als notwendig ist damit verbringen.
 * 1 -  1 - Rufton / Farbe eines bestimmten Anrufers
 * 1 -  1 - Verschiedene Klingeltöne per Rufnummer
 * - Einteilung der Benutzer in Gruppen
 * - Einfachere Verwaltung der Telefonbucheinträge, speziell das mergen zweier Einträge. Speziell wenn jemand mehrere Nummern hat, also Handy, Privat und SIP. Hier wäre es schön, wenn die eine Nummer leicht einem bestehenden Telefonbucheintrag hinzugefügt werden könnte und eben der 2te Eintrag dann gelöscht werden würde
 * - Adressbuchimport nur XML :-(    CSV!?
 * - Adressbuchabgleich mit SeaMonkey oder Thunderbird
 * - Adressbuchabgleich mit Outlook
 * - Adressbuchabgleich jfritz <-> FritzBox
 * - Mehrere lokale Benutzer?
 *
 * CHANGELOG:
 *
 * * TODO:
 * - Alle Zugriffe auf FritzBox in eigenen Threads
 * - Bug: Eingabe der IP-Nummer nach Ruhezustand
 * - Markieren der Zeilen per STRG auch in der "Teilnehmer"-Spalte
 * - Ändern der Standardrufnummer per Häckchen führt nicht zur Speicherung, erst wenn man noch ein Datum ändert
 * - Filter für Nebenstelle (Port) kombiniert mit eingetragenem Namen in der Weboberfläche
 * - Copy & Paste für Spalteneinträge (in Anrufliste, Telefonbuch und Kurzwahlliste)
 * - Importierte Rufnummern auf Sonderzeichen ( -, /, (, ) ) überprüfen
 * - Durchwahlnummern vor Zentrale-Nummern bei der Anzeige bevorzugen (sollte eigentlich gehen, aber scheint einen Bug zu haben)
 * - Schnittstelle zu externen Inverssuche-Programmen
 * - Andere Anrufmonitore noch an die neuen Listener anpassen und TestCases schreiben
 * - Kurzwahlliste sortierbar und Spaltenreihenfolge änderbar
 * - Bug "Doppelt erfasste Anrufe" behoben?
 * - http://www.ip-phone-forum.de/showthread.php?t=112348
 * - Überprüfen, geht wohl nicht mehr: Rückwärtssuche für Österreich über dasoertliche.de wieder eingebaut
 * - Connection-Timeout für ReverseLookup setzen
 * - Möglichst alle Fenstergrößen und -positionen speichern und wiederherstellen
 * - Alle Strings im Wizard überprüfen, vor allem die Sprache sollte stimmen
 * - Hilfe für jede Einstellungsseite, womit zur Wiki-Seite verlinkt wird
 * - .jfritz eigentlich unter Windows unter Anwendungsdaten\.jfritz
 * - Eigenständige Inverssuche nach beliebiger Nummer
 * - Fertigstellen von Event/Action
 * - Umbau auf Plugin-Konzept
 * - Integration von Klingeling
 * - Gesprächigeres JFritz, bessere Statusleiste
 * - Umbau der Filter: Kein vorhergehendes Klicken in der Anrufliste, sondern alle Optionen als Kontextmenü
 * - Zentrieren des Wizards
 * - Popup trotz fehlender Inverssuche
 * - Überprüfen, ob Internetüberwachung auch mit neueren Firmwares geht
 * - Popup am Bildschirmrand andocken.
 * TODO-END
 *
 * FIXME:
 * - Einstellungsseite muß gescrollt werden, obwohl viel Platz am Bildschirm wäre
 * - Bestehenden dummy Eintrag überschreiben
 * - Rechtsklick in Teilnehmerspalte
 * - Text ändern für reverse_lookup_dummy
 * - Falls VoIP-Provider unbekannt, soll in der FritzBox gesucht werden
 * - Popup wird beim Anrufmonitor mehrfach gestartet
 * - Änderungen einer Telefonnummer im Client wird beim Server nicht aktualisiert
 * - ^ auch Löschen von Rufnummern funktioniert nicht, Hinzufügen EINER Nummer jedoch schon (mehrerer nicht)
 * - Rückwärtssuche beim Client funktioniert nicht
 * FIXME-END
 *
 * JFritz 0.7.1.9
 * - Bugfix: FritzBox-Einstellungen, defaultBox und ComboBox
 * - Bugfix: Fritz!Box-Anrufmonitor wird im Wizard als Standard gewählt und nach Abschluss des Wizards automatisch gestartet.
 * 			 Auch anzeigen ausgehender Anrufe nun per default aktiviert.
 * - Neu: Abbruch eines Wählhilfe-Anrufs möglich.
 * Strings:
 * calldialog_pending_call
 *
 * JFritz 0.7.1.8
 * - Reboot-Bug unter Windows und Java 1.5 behoben.
 *
 * JFritz 0.7.1
 * - Umstrukturierung des Aufrufs von externen Programmen (noch nicht abgeschlossen)
 * - Bugfix: Internet Monitoring funktioniert wieder
 * - Umstrukturierung des Statiskdialogs, funktioniert jetzt wieder.
 * - Anpassung des Bearbeiten-Dialogs im Telefonbuch an unterschiedliche Bildschirmauflösungen.
 * - Neu: Clients können über den Server die Anrufliste von der Box löschen
 * - Neu: Clients können die Wahlhilfe über den Server verwenden.
 * - Neu: Bild bei jedem Kontakt möglich. Noch nicht im Client/Server-Modus getestet.
 * - Neu: NoPic.png hinzugefügt, welches im Telefonbuch bei Kontakten ohne Bild angezeigt wird.
 * - Änderung: Keine Zwangspopup mehr beim Abholen der Anrufliste.
 * - Änderung: Anzeige der Adresse im Telefonbuch in einer Spalte (Stadt-Spalte entfallen).
 * - Änderung: Abgespielter Sound bei einem Anruf nur halb so laut.
 * - Bugfix für Java 1.5: JFritz-Menü manchmal nicht sichtbar - Part 2
 * - Bugfix: Aktualisierung der Rückwärtssuche mit "Das Telefonbuch"
 * - Bugfix: Rückwärtssuche für Türkei und andere Länder korrigiert. CountryCode wurde nicht korrekt extrahiert.
 * - Bugfix: Korrektes Beenden des Lookup-Threads.
 * - Bugfix: Kein "Beenden"-Bug mehr nach dem Darstellen eines Popups.
 * - Bugfix: Inverssuche aktualisiert.
 * - Bugfix: Erstellen eines neuen Eintrags für einen unbekannten Anruf.
 * - Bugfix: Multiple-Instance check.
 * - Neu: Neue Anzeige von eingehenden Anrufen.
 * - Neu: Neue Statusbar. Unter anderem Anzeige vom Fortschritt der Inverssuche.
 * - Neu: Anrufsimulator
 * - Neu: Land wird zu jeder Telefonnummer mit abgespeichert.
 * - Neu: Bestimmung der MAC-Adresse, um FRITZ!Boxen zu unterscheiden.
 * - Bugfix: Beim Doppelklick in der Anrufliste wird der korrekte Telefonbucheintrag angezeigt.
 * - Bugfix: Inverssuche für viele Rufnummern korrigiert.
 * - Neu: Splash-Screen.
 * - Neu: Alle Inverssuche-Seiten aus Klingeling hinzugefügt.
 * - Bugfix: Suche nach der Stadt anhand der Vorwahl für die Türkei, USA, Österreich und Deutschland
 * - Neu: Fortschrittsanzeige beim Abholen der Anrufliste
 * - Neu: Popup bei keiner Verbindung zur FritzBox entfernt. Stattdessen Anzeige in der neuen Statusbar
 * - Neu: Resize der Spalten in der Anrufliste nun intuitiver.
 * - Bugfix: Sortieren in Telefonbuch funktioniert nun wieder korrekt.
 * - Bugfix: Restart des Anrufmonitors nach Ruhezustand und Standby.
 * - Bugfix: Passwortabfrage beim Start funktioniert wieder.
 * - Neu: Auflösungsabhängige Größe des Bildes im Edit-Modus des Telefonbuchs.
 * - Bugfix: Signal-Handler
 *
 * Strings:
 * 	allow_client_deletelist
 * 	allow_client_docall;
 * 	client_stand_alone
 *  notify_on_calls   // Adapt meaning of this string
 *  picture
 *  picture_desc
 *  picture_files
 *  show_picture_column
 *  accept_fritzbox_communication
 *  new_fritzbox
 *  set_default_fritzbox
 *  show_on_google_maps
 *  dialog_title_callin // New syntax
 *  dialog_title_callout // New syntax
 *  connected_fritz
 *  disconnected_fritz
 *
 * JFritz 0.7.0.1
 * - Funktioniert nun wieder mit Java 1.5
 * - Bugfix: JFrtz-Menü manchmal nicht sichtbar
 * - Bugfix: Rückwärtssuche "Das Telefonbuch"
 * - Bugfix: Auto-Update
 * - Bugfix: Externes Programm bei ausgehendem Anruf
 * - Bugfix: Windows-Installer: Fremde JAR-Dateien werden beim Installieren nicht gelöscht
 *
 * JFritz 0.7.0
 * - Neu: Unterstützung für Fritz!Box 7270, Fritz!Box 7140, Fritz!Box 7141, Fritz!Box 7113, Fritz!Box 5140
 * - Bugfix: Bug beim Herunterfahren / Abmelden unter Linux, Windows behoben
 * - Bugfix: JFritz blockiert das Herunterfahren / Abmelden von OS X nicht mehr
 * - Bugfix: Aussehen von JFritz wird nun wieder gespeichert
 * - Bugfix: Kein plötzlicher Wechsel vom Telefonbuch zur Anrufliste mehr
 * - Neu: Einführung von ServerSenderThreads, jede Verbindung hat eigene Empfänger und Sender-Threads
 * - Neu: Clients können den Anrufmonitor vom Server verwenden
 * - Neu: Networkcode hinzugefügt! JFritz kann nun entweder als Server oder client arbeiten
 * - Bugfix: Neue Kontakte werden jetzt richtig in der Anrufliste dargestellt
 * - Bugfix: Gelöschte Kontakte werden jetzt auch in der Anrufliste entfernt
 * - Bugfix: Geänderte Kontakte werden jetzt auch richtig in der Anrufliste dargestellt
 * - Bugfix: Clientseitige / serverseitige Änderungen im Telefonbuch werden bei allen Clients auch richtig in der Anrufliste dargestellt
 * - Bugfix: NullPointerException beim Charset-Lesen entfernt, Rückwärtssuche funktioniert bei einigen wieder
 * - Neu: JFritz Log-Datein kann jetzt im beliebigen Verzeichnis gespeichert werden
 * - Neu: Neuer Menüpunkt unter "Ansicht" für das Monitoring-Panel
 * - Fix: About-Dialog korrigiert
 * - Bugfix: Zu kleines Fenster bei Popup-Verzögerung behoben
 * - Bugfix: MSN-Filter werden jetzt richtig gespeichert und geladen
 * - Neu: Drei neue Look&Feels
 * - Bugfix: Ubuntu 7.04 trayicon and Sun Java 1.6 funktioniert nun
 * - Neu: Sprache wird beim ersten Start von JFritz automatisch auf Betriebssystemsprache eingestellt
 * - Neu: Rückwärtssuche kann von der Anrufliste aus für eine ausgewählte Seite ausgeführt werden
 * - Neu: Standardmäßiges Einbelden des Bearbeitungsfensters im Telefonbuch
 * - Neu: Debug-Nachrichten können nun unter "Hilfe"-"Debug-Fenster" eingesehen und gespeichert werden
 * - Bugfix: Einstellungsfenster wird zentriert
 * - Bugfix: "Verbindungsgerät" in "MSN/Rufnummer" ändern
 * - Bugfix: Anzeige von "Durchwahl" statt "3" in der Anrufliste
 * - Neu: Anzeige des Ports beim Anrufmonitor
 *
 * JFritz network-v1
 * 	 Neue Strings:
 * 	 no_network_function
 *   network_server_function
 *   network_client_function
 *   client_call_list
 *   client_telephone_book
 *   be_dumb_client
 *   connect_on_startup
 *   server_name
 *   server_login
 *   server_password
 *   server_port
 *   set
 *   listen_on_startup
 *   client_connect_port
 *   max_client_connections
 *   add
 *   remove
 *   network
 *   server_is_listening
 *   connect_to_server
 *   set_client_permissions
 *   allow_client_calllist
 *   allow_client_add_calllist
 *   allow_client_remove_calllist
 *   allow_client_update_calllist
 *   allow_client_phonebook
 *   allow_client_add_phonebook
 *   allow_client_remove_phonebook
 *   allow_client_update_phoneBook
 *   allow_client_callmonitor
 *   allow_client_lookup
 *   allow_client_getcalllist
 *   authentification_failed
 *   connection_server_refused
 *   error_binding_port
 *   start_listening_clients
 *   client_is_connected
 *   client_call_monitor
 *   callerlist_filters
 *   phonebook_filters
 *	 apply_filter_client
 *   set_client_callfilter
 *   username
 *   permissions
 *   close
 *   debug_window
 *   debug_files
 *   save_debug_log
 *
 * JFritz 0.6.2.04
 * - Umstrukturierung des Aufrufs von externen Programmen (noch nicht abgeschlossen)
 * - Neu: Rückwärtssuche erweitert, jetzt können die Regex Ausdrücke beliebige groupiert werden
 * - Bugfix: Rückwärtssuche erkennt die Charset jetzt automatisch
 * - Neu: Rückwärtssuche für Türkei eingebaut
 * - Neu: Rückwärtssuche nach Ort für Türkei eingebaut
 * - Neu: Unterstützung für gemoddete Eumex 300ip (Firmware 15.xx.xx)
 * - Neu: Unterstützung für gemoddete Speedport W 900V (Firmware 34.xx.xx)
 * - Neu: Beliebige Nummer direkt aus JFritz heraus wählen
 * - Bugfix: Rückwärtssuche erkennt die Charset jetzt automatisch
 * - Bugfix: Amtskennzahl richtig verarbeitet beim CallMonitor
 *
 * JFritz 0.6.2.03
 * - Autoupdate korrektur
 * - Leisere Sounds
 * - Doppelklick auf das Trayicon nun möglich
 * - Neu: Rückwärtssuche Engine komplette neu geschrieben. Alle paramter in einer XML-Datei einstellbar
 * - Bugfix: Rückwärtssuche bleibt nicht mehr stehen, falls die Verbindung zum Server hängt
 * - Bugfix: Rückwärtssuche für deutschland wieder angepasst, dastelefonbuch.de und dasoertliche.de eingesetzt
 * - Bugfix: Zu kurze Landesvorwahl
 * - Bugfix: Falsche Rufnummern gelöscht
 * - Bugfix: JFritz verliert Einstellungen
 * - Bugfix: Anrufmonitor funktioniert sporadisch nicht mehr. (Restart alle 5 Minuten)
 * - Bugfix: Wizard speichert IP nun wieder korrekt
 * - Bugfix: Richtiger Quell- und Zielordner für die Backups
 * - INTERN: Getrenntes Speichern von config-properties und state-properties.
 *           config-properties: ip, passwort, optionen ...
 *           state-properties: filter-state, window-position, window-state, column-width...
 * - INTERN: getProperty() gibt config-properties, getStateProperty()
 *           getStatePropery() gibt state-properties, setStateProperty()
 * - INTERN: Shutdown-Thread wird NICHT mehr benutzt
 * - Neue Strings:
 * 		reverse_lookup_dummy
 *
 * JFritz 0.6.2.02
 * - Bugfix: Problem mit der schweizer Rückwärtssuche behoben
 * - Bugfix: Probleme mit der deutschen Rückwärtssuche behoben
 * - Bugfix: Support for english firmware 14.04.26 corrected
 * - Neu: CallbyCall-Vorwahlen jetzt in einer xml-datei ausgelagert
 * - Neu: CallbyCall-Vorwahlen jetzt in einer Datei einstellbar, für jedes Land möglich
 * - Neu: Unterteilung in Handy/Festnetz jetzt in einer Datei einstellbar, für jedes Land möglich
 * - Neu: Eigene Icons für Handybetreiber
 * - Neu: JFritz ordnet jede Nummer eine Pfanne aus einer einstellbaren Datei
 * - Bugfix: Kurzwahlen
 * - Bugfix: Österreichischer Reverselookup
 * - Bugfix: CallMonitor outgoing calls
 * - Bugfix: Reverselookup on mac now run with correct character encoding
 * - Bugfix: Französischer Reverselookup
 * - Bugfix: Rückwärtssuche funktioniert jetzt mit beliebigem Host-Zeichensatz
 * - Bugfix: Rückwärtssuche nach Ort zeigt jetzt Stadtnamen mit Umlauts
 *
 * JFritz 0.6.2.01
 * - Neu: Polnische Sprachdateien aktualisiert
 * - Neu: Italienische Sprachdateien aktualisiert
 * - New: Import english push-service-csv-file
 * - Bugfix: Neuer Eintrag im Telefonbuch nun wieder möglich
 * - Bugfix: JFritz-Menü wird nun korrekt dargestellt
 * - Bugfix: number-Ordner nun mitgeliefert
 * - Bugfix: Autoupdate in richtigen Ordner
 * - Bugfix: Firmwareerkennung korrigiert
 * - Bugfix: HTML-Sonderzeichen beim ReverseLookup
 * - Bugfix: ReverseLookup für ausländische Nummern
 * - Bugfix: Löschen einer Nummer im Telefonbuch
 *
 * Jfritz 0.6.2
 * - Neue Strings:
 *  check_for_new_version_after_start
 *  date_filter.last_week
 *  date_filter.this_week
 *  enable_inet_monitoring
 *  filter_search
 *  inet_usage
 *  monitoring
 *  restart_telefond (only english version)
 *  restart_telefond_desc (only english version)
 *  undo
 *  update_JFritz
 *  Alle Strings in der Datei update_de_DE.properties
 *
 * - Bugfix: örtliche Nummer, die mit 49 beginnen, werden jetzt richtig verarbeitet
 * - Bugfix: Callmonitor schreibt die Ortsvorwahl vor unbekannten Rufnummern nicht mehr
 * - Neu: MonitoringPanel hinzugefügt, soll Internetverbindung und derzeit geführten Anrufen überwachen
 * - Suchfeld in Anrufliste umfasst nun auch die Call-By-Call vorwahlen
 * - Bugfix: Suche nach Rufnummern im internationalen Format
 * - Neu: JFritz-Fenster wird nun korrekt wiederhergestellt (maximiert...). Neues Property: window.state
 * - Neu: Falls Ort per ReverseLookup nicht gefunden wird, wird anhand einer Tabelle der passende Ort zu einer Vorwahl eingetragen werden (Österreich)
 * - Neu: Falls Ort per ReverseLookup nicht gefunden wird, wird anhand einer Tabelle der passende Ort zu einer Vorwahl eingetragen werden Deutschland (SF [ 1315144 ])
 * - Bugfix: Jetzt werden IP-Addressen von den Boxen in der Einstellungen angezeigt. Man kann jetzt Fehlerfrei zwei boxes im gleichen Netz haben.
 * - Neu: Rückwärtssuche für die USA über www.whitepages.com, danke an Reiner Gebhardt
 * - Neu: Menüeintrag ->JFritz aktualisieren
 * - Internationaler FreeCall 00800 (http://www.ip-phone-forum.de/showthread.php?t=111645)
 * - Datumsfilter "aktueller-Tag" sollte auch immer den aktuellen Tag anzeigen. (SF [ 1530172 ])
 * - INTERN: Filter der Anrufliste in neues Package. Abstrakte Klasse CallFilter
 * - INTERN: Statische Methoden in JFritz.java => keine jfritz-Referenzen in den anderen Klassen notwendig
 * - INTERN: Diverse JUnit-TestCases
 * - INTERN: Neue Klasse CallMonitoring, die alle aktuellen Anrufe verwaltet und die Anrufinformation auf den Bildschirm bringt
 * - INTERN: Anrufmonitore in neues Package callmonitor gepackt und umbenannt
 * - INTERN: Anzeige der Anrufe, die vom Anrufmonitor erkannt werden, über Listener. Abholen der Anrufliste nach dem Gesprächsende nun über den DisconnectMonitor
 * - Neu: Unterstützung für die "Labor-Firmware" (Firmwareerkennung und CSV-Import)
 * - Neu: Automatisches Update von JFritz auf neue Version. TODO: Checken, ob es auch mit .so und .dll funktioniert TODO: Am Ende der Update-Prozedur JFritz nicht beenden, sondern neu starten. Blos wie? (mittles eines kleinen zusätlichen programmes, welches die files ersetzt und jfritz neu startet. datenaustausch der programme evtl per kommandozeile. (bastia))
 * - Wahlhilfe: Immer mit Ortsvorwahl wählen (getShortNumber in getAreaNumber verändert)
 * - Neu: Unterstützung für neue englische Firmware xx.04.20
 * - INTERN: Buildfile überarbeitet. TODO: release und junit anpassen
 * - Neu: Rückwärtssuche nicht mehr über DasOertliche.de sondern über dastelefonbuch.de
 * - Bugifx: Französische Rückwärtssuche funktioniert wieder
 * - Neu: Französische Rückwärtssuche nun auch mit Firmenname
 * - Intern: JFritz.java aufgespalten in Main.java und JFritz.java
 * - Autoupdate von JFritz
 * - Nur noch mit Java 1.5 kompatibel
 * - Fenstergröße, -position und -status wird nun korrekt wiederhergestellt
 * - Spaltengröße und -reihenfolge korrekt wiederhergestellt
 * - Bugfix: Telefonnummern werden nun korrekt gespeichert
 * - Bugfix: Importieren von Thunderbird-Einträgen funktioniert nun wieder
 *
 * JFritz 0.6.1
 * - Neue Strings:
 *		browse
 *		save_directory
 *		delete_duplicate_phonebook_entries
 *		delete_duplicate_phonebook_entries_confirm_msg
 *		delete_duplicate_phonebook_entries_inform_msg
 *		box.port
 *		config_wizard.info1
 *		config_wizard.info2
 *		config_wizard.info3
 *		config_wizard.info4
 *		config_wizard
 *		popup_delay
 *      dial_prefix
 *
 * - Intern: Multiple-Instance-Lock nun Dateibasiert und nicht mehr als Property. (JFritz.LOCK_FILE)
 * - Neu: Meldung bei neuer JFritz-Version
 * - Neu: Flaggen werden bei bekannten Ländervorwählen angezeigt anstelle vom Weltkugel, für bekannte Länder siehe PhoneNumber.java
 * - Bugfix: SIP-Routen behalten ihre historische Zuordnung
 * - Neu: Neuer Kommandozeilenparameter: -r, führt eine Rückwärtssuche aus und beendet sich
 * - Neu: Rückwärtssuche für Frankreich über http://www.annuaireinverse.com, wird automatisch aufgerufen
 * - Neu: Rückwärtssuche für die Niederlande über http://www.gebeld.nl/content.asp?zoek=numm, wird automatisch aufgerufen
 * - Neu: Rückwärtssuche für Italien über www.paginebianche.it, wird automatisch aufgerufen
 * - Neu: Rückwärtssuche für die Schweiz über tel.search.ch, JFritz ruft automatisch die richtige Rückwärtssuche auf.
 * - Neu: Dummy-Telefonbucheinträge werden gelöscht, falls ein Eintrag mit derselben Nummer existiert
 * - Neu: Anrufe mit einer AKZ werden jetzt richtig verarbeitet.
 * - Neu: Der Speicherordner kann jetzt frei gewählt werden, bleibt nach dem Beenden erhalten. SF-Tracker [1248965]
 * - Bugfix: Die Sprachauswahlbox zeigt jetzt auch unter Linux Flaggen-Icons an.
 * - Bugfix: Das Telefonbuch wird nach einem erfolgreichen Outlook-Import sofort gespeichert. SF-Tracker [ 1503185 ]
 * - Neu: Zeit, bis Popup-Nachrichten ausgeblendet sind, einstellbar gemacht (Zeit von 0 bedeutet nie schließen) SF-Request Nr: [1340678] [1518330]
 * - Bugfix: JFritz kann jetzt von einem beliebigen Verzeichnis aus aufgerufen (bestätigt unter Linux, Windows, Mac??)
 * - Neu: Rückwärtssuche auch für Handynummern
 * - Neu: Wählhilfe merkt sich den zuletzt benutzen Port
 * - Neu: JFritz kann jetzt beliebige Nummer mit der Wahlhilfe wählen (noch nicht ausführlich getestet, z.B. funktionieren auch die Tastencode?)
 * - Bugfix: Kurzwahlen werden jetzt korrekt geparst beim Abholen der Anrufliste
 * - Neu: Port einstellbar
 * - Neu: Konfigurationswizard für Erstbenutzer
 * - Neu: Logfiles werden jetzt mittels Stream redirection geschrieben (heißt auch die Exceptions werden in den Logfiles aufgenommen :) )
 * - Neu: Entfernen doppelter Einträge beim Telefonbuch
 * - Neu: Automatisches Scrollen zum selektierten Telefonbucheintrag
 * - Neu: Englische Firmware wird unterstützt
 * - Intern: Firmware wird beim Start erkannt und in JFritz.firmware gespeichert. Zugriff nicht mehr über JFritz.getProperties("box.firmware") sondern über JFritz.getFirmware()
 * - Bugfix: Kurzwahlen werden wieder korrekt abgeholt
 * - Bugfix: Standardtelefonnummern können wieder geändert werden
 * - Bugfix: Problem mit dem Holen der Anrufliste behoben
 * - Bugfix: Nebenstellenbezeichnungen und Route können jetzt Sonderzeichen enthalten
 * - Bugfix: Anzeige eines analogen Anrufs beim Anrufmonitor
 * - Bugfix: PersonDialog ("Person editieren") wird nun mittig zum JFritz.JFrame angezeigt - SF.net-Request:[1503523] Adress-/Telefonbuch
 * - Neu: Default- und Close-Button für PersonDialog ("Person editieren"), Icon (JFritz) gesetzt
 * - Bugfix: Wahlhilfe: Anwahl aller analogen Telefone konnte nicht gehen -> Tippfehler in JFritzUtils: JFritz.getMessage("analoge_telephones_all") -> korrigiert in JFritz.getMessage("analog_telephones_all")
 * - Neu: Default-Button bei Rückfrage 'Box-Anruferliste löschen' geändert auf 'Nein'
 * - Neu: Berücksichtigung der Metal-Decorations bei Dialogen
 * - Intern: Funktionen, die mit der Kommunikation mit der FritzBox zu tun hatten, in eine neue Klasse FritzBox exportiert.
 * - Intern: CallDialog: Auswahl der Nummern wiederhergestellt, editierbare JComboBox/JTextField (je nach Anzahl vorhandener Nummern)
 * - Neu: Default- und Close-Button für CallDialog ("Anrufen"), Icon (JFritz) gesetzt
 * - Neu: Überarbeitung der Dialoge bzgl. OK/Cancel, Icon, Position
 *   jfritz.dialogs.config.CallmessageDialog,
 *   jfritz.dialogs.config.ConfigDialog,
 *   jfritz.dialogs.config.FRITZBOXConfigDialog,
 *   jfritz.dialogs.config.SipConfigDialog,
 *   jfritz.dialogs.config.SyslogConfigDialog,
 *   jfritz.dialogs.config.TelnetConfigDialog,
 *   dialogs.config.YacConfigDialog,
 *
 *   jfritz.dialogs.simple.AddressPasswordDialog,
 *   jfritz.dialogs.stats.StatsDialog,
 *
 *   jfritz.callerlist.CallDialog,
 *
 *   jfritz.utils.ImportOutlookContacts,
 *   jfritz.utils.NoticeDialog
 *
 *
 * JFritz 0.6.0
 * - Neue Strings:
 * - Neuer Kommandozeilenparameter: -w, deaktiviert die Kontrolle von mehrfachen Instanzen
 * - Bugfix: Alle internationalen Gespräche werden jetzt erkannt.
 * - Neu: Sprache einstellbar ( <- Wahlhilfe im Telefonbuch funktioniert bei englischer Sprache nicht (Bastian)
 * 								<- TrayMenu angepasst (Benjamin)
 * 								<- komplett geändert, Sprachfiles werden jetzt dynamisch erkannt und können in den Einstellungen ausgewählt werden. (Bastian))
 * - Bugfix: Spracheinstellungen werden gespeichert.
 * - Neu: Verbesserte Anzeige des aus- und eingehenden Verbindungstyps bei verwendung des JFritz-Anrufmonitors im Format "interne MSN (Leitungsart)", z.B. "1234 (ISDN)" oder "1234 (SIP)" bei eingehenden Anrufen oder "56789 (88sdg4@dus.net)" bei ausgehenden
 * - Bugfix: Anrufmonitor zeigt ausgehende und eingehende Anrufe im gleichen Format an
 * - Bugfix: Neues JFritz-Anrufmonitor-Format besser unterstützt, jetzt wieder Anzeige von angerufener MSN
 * - Bugfix: MAC-Handling funktioniert wieder
 * - Bugfix: Wahlhilfe im Telefonbuch funktioniert jetzt bei englischer Sprache (Brian)
 * - Bugfix: Beim Metal-LAF werden jetzt immer die Metal-Decorations verwendet.
 * - Bugfix: Beim Ändern des Look And Feel's werden die Buttons korrekt dargestellt.
 * - Neu: Fritzbox Anrufliste als CSV-Datei importieren
 * - Neu: Thunderbird/Mozilla-Kontakte importieren
 * - Neu: Telefonbuch als CSV-Datei exportieren
 * - Neu: Anruferliste importieren (CSV-Dateien)
 * - Neu: Wahlhilfe (<- funktioniert nicht richtig. Es wird immer der Port vom letzten Versuch benutzt
 *                      Beispiel: ich habe zuletzt ISDN 1 benutzt, will jetzt mit ISDN 2 anrufen, dann wird aber ISDN 1 benutzt.
 *                      Benutze ich dann die Wahlhilfe erneut, wird ISDN 2 benutzt - egal welchen Port ich einstelle. D.h., benutze
 *                      ich ständig die gleichen Ports, fällt es nicht weiter auf.
 *                      Ich denke, das hängt damit zusammen, dass man auf der Weboberfläche erst den Port auswählt, dann übernehmen
 *                      drückt und dann erst die Nummer anklickt. Diesen Vorgang müsste man in JFritz nachbilden.  (KCh)
 *                   <- Eigentlich sollte es auch mit einem direkten URL-Aufruf funktionieren. Machen andere Tools genau so. (Robert)
 *                   <- Kann denn keiner das Verhalten meiner Box nachvollziehen? Ist das evtl. ISDN-spezifisch? Ich kanns es 100%ig reproduzieren (KCh))
 * - Neu: (JFritz)Telefonbuch importieren (XML)
 * - Neu: Manuelle Backups erstellen (Menü und Toolbar)
 * - Neu: per Funktionstaste "F5" Anrufliste aktualisieren
 * - Neu: Suchfunktion für Telefonbuch
 * - Neue Option: Nach Standby oder Ruhezustand die Anrufliste automatisch abholen
 * - Neue Option: Sicherungskopien bei jedem Laden der Anruferliste erstellen
 * - Änderung: Das Durchsuchen der Anruferliste muss nun per [ENTER] gestartet werden.
 * - Bugfix: "Übernehmen" Button im Telefonbuch wird nun anklickbar, wenn man eine Telefonnummer geändert hat.
 * - Bugfix: Sonderzeichen bei "Externes Programm starten" werden korrekt gespeichert
 * - Bugfix: tritt der unwahrscheinliche Fall auf, dass kein Tray-Icon angezeigt wird, der User aber früher einmal
 * 			 (als das Tray-Icon noch verfügbar war) Tray-Messages zu Benachrichtigung ausgewählt hatte, wurde gar kein
 * 			 Anruf mehr signalisiert. Jetzt wird in diesem Fall auf ein PopUp zurückgegriffen.
 * - Bugfix: unvollständige Anzeige des Einstellungsdialoges -> Weiteres
 * - Bugfix: Speicherung der Kommentare
 * - Bugfix: Überschreiben der Rufnummer im Telefonbuch tritt nicht mehr auf
 * - INTERN: Bereitstellen von utils.JFritzClipboard und CallerList.getSelectedCall
 * - INTERN: JDIC-Update auf "JDIC 20050930 Build"
 *
 * JFritz 0.5.5
 * - Nummer und Anschrift können aus der Anrufliste heraus in die Zwischenablage kopiert werden
 * - Schutz vor mehrfachem Programmstart (<- was ist mit Kommandozeilenstart?, =>BS: werden berücksichtigt - enableInstanceControl=false)
 * - Löschfunktionalität für Anrufliste der FRITZ!Box (Menü und Toolbar)
 * - Bugfix: Start auch bei fehlendem Tray
 * - Bugfix: Anrufmonitor arbeitete bei einem Reverselookup einer nicht im Telefonbuch
 *           eingetragenen Person nicht mehr
 * - Bugfix: Eintragen einer über Reverse-Lookup gefundenen Person korrigiert
 * - Neuer Kommandozeilenparameter: -d, --delete_on_box, löscht Anrufliste auf der Box und beendet sich dann (kein GUI)
 * - Neuer Kommandozeilenparameter: -b, --backup, erstellt eine Sicherungskopie von allen XML-Dateien
 * - Neue Option: Sicherungskopien beim Start erstellen
 * - Bugfix: Bei der Suche nach einer Rufnummer werden vor der Zentrale ggf. vorhandene Durchwahlnummern berücksichtigt
 *
 * JFritz 0.5.4
 * - Beim neuen Anrufmonitor auf # achten.
 * - Callmonitor: Beim Ausführen eines externen Programmes werden %Firstname, %Surname, %Compnay ersetzt.
 * - Beim Beenden von JFritz keine Speicherung von Calls und Phonebook mehr
 * - Bei den Einstellungen die MAC weggenommen
 * - Bugfix: Sonderzeichen bei "Externes Programm starten" werden korrekt gespeichert
 * - Watchdog: Anrufmonitor wird nach dem Ruhezustand neu gestartet
 * - Anrufliste wird per CSV und nicht mehr per Webinterface abgeholt
 * - Unterstützung für Firmware xx.04.03
 *
 * JFritz 0.5.3
 * - Bugfix-Anrufmonitor: Nummern werden internationalisiert
 *
 * JFritz 0.5.2
 * - Parameter -n funktioniert wieder
 * - XML-Dateien angepasst. DTDs werden nicht mehr gespeichert. Kann zu Datenverlust kommen
 * - Kompatibel zur Firmware xx.04.01
 * - FRITZ!Box-Anrufmonitor: Abholen der Anrufliste nach dem Auflegen
 *
 * JFritz 0.5.1
 * - Priorität auf 5 erhöht
 * - Kompatibel zur Firmware xx.03.101
 * - Datenverbindungen werden als solche angezeigt
 * - Outlookimport verbessert
 *
 * JFritz 0.5.0
 * - Neuer Anrufmonitor: FRITZ!Box Anrufmonitor
 * - Kompatibel zur Firmware xx.03.99
 * - Einstelloption für "minimieren statt schließen"
 *
 * JFritz 0.4.7
 * - New Feature: Variable Programmpriorität (1..10)
 * - Neuer Kommandozeilenparameter -p5 --priority=5
 * - Kompatibel zur FRITZ!Box 7170
 * - Anzeige der Gesamtgesprächsdauer in Stunden und Minuten
 * - Bugfix: Manche Spalten ließen sich nicht klein genug machen
 * - Bugfix: Kommandozeilenparameter -c funktionierte nicht mehr
 * - Bugfix: Outlook-Import
 * - Bugfix: RESSOURCES: filter_callbycall, filter_sip
 * - Bugfix: Telefonbuchsortierung
 *
 * JFritz 0.4.6
 * - Reset-Button bei den Filtern deaktiviert alle Filter
 * - Neuer Filter: Kontextmenü bei "Verpasste Anrufe"-Filter
 * - Neuer Filter: Kommentarfilter
 * - Neuer Befehl für "Anrufmonitor - Externes Programm starten": %URLENCODE();
 * - Kompatibel zu FritzBox 5010 und 5012
 * - Automatische Erkennung der Firmware
 * - Bugfix: Danisahne-Mod wird richtig erkannt
 * - Bugfix: Outlook-Import (entfernen von Klammern)
 * - Bugfix: Anzeigefehler beim Start behoben
 * - Bugfix: Sortierfunktion beim Telefonbuch korrigiert
 *
 * JFritz 0.4.5
 * - Unterstützung für FRITZ!Box Firmware .85
 * - Unterstützung für FRITZ!Box Firmware .87
 * - Unterstützung für FRITZ!Box Firmware .88
 * - Spalten sind jetzt frei verschiebbar
 * - Kommentarspalte hinzugefügt
 * - Kommentar- und Anschluß-Spalte können ausgeblendet werden
 * - Suche der FritzBox über UPNP/SSDP abschaltbar
 * - Telefonbuch nun nach allen Spalten sortierbar
 * - Beim Export merkt sich JFritz die Verzeichnisse
 * - Drucken der Anrufliste (und Export nach Excel, RTF, PDF, CSV, ...)
 * - Neue Kommandozeilenoption -n: Schaltet die Tray-Unterstützung aus
 * - Direkter Import von Outlook-Kontakten
 * - Datumsfilter unterstützt nun "Gestern"
 * - Unterstützung für die neue Version des Callmessage-Anrufomitors (http://www.evil-dead.org/traymessage/index.php4)
 * - Bugfix: Firmware konnte beim ersten Start nicht erkannt werden
 * - Bugfix: Spaltenbreite wurde nicht korrekt gespeichert
 * - Bugfix: Falsche SIP-ID bei gelöschten Einträgen
 * - Bugfix: Wenn Kurzwahl unbekannt war, wurde eine falsche Rufnummer angezeigt
 * - Bugfix: Anrufliste wird nur gelöscht, wenn mind. 1 Eintrag abgeholt wurde
 *
 * Internal:
 * - SipProvider-Informationen werden nicht mehr in den
 * 	 jfritz.properties.xml sondern in jfritz.sipprovider.xml
 *   gespeichert.
 * - Zugriff auf SipProvider über JFritz.getSIPProviderTableModel()
 *
 * JFritz 0.4.4
 * - CallByCall information is saved (only 010xy and 0100yy)
 * - Added support for MacOSX Application Menu
 * - Telnet: Timeout handling
 * - Telnet-Callmonitor: support for username, password
 * - Syslog-Callmonitor: syslogd and telefond check configurable
 * - Added Callmessage-Callmonitor. See Thread-Nr. 178199 in IPPF
 * - Wait, when no network reachable (On startup, return of standby, ...)
 * - Added context menu to phonebook and callerlist
 * - New Callfilter: Route, Fixed call, CallByCall
 * - New Datefilter: Right click on date filter button
 * - Display more information in status barm Zielfon hör ich "Ihre Nummerwird gehalten...". Bitte Einbauen!! Das ist der Hammer!

 * - Export to XML
 * - Export CallByCall to CSV
 * - Phonenumber with wildcard support (PhoneNumber-Type "main")
 * - Start external Program on incoming call (%Number, %Name, %Called)
 * - Bugfix: Syslog-Monitor get Callerlist on Restart
 * - Bugfix: Check for double entries in Callerlist
 * - Bugfix: Reverselookup on call
 *
 * Internal:
 * - VCard Export moved from CallerTable to PhoneBook
 *
 *
 * JFritz 0.4.2
 * - CallByCall information is saved
 * - Added Phonebookfilter (Private Phonebook)
 * - Callerlist deleteable
 * - Advanced CSV-File
 * - Callmonitor with Telnet, Syslog, YAC
 * - Syslog passthrough
 * - CMD Option -e : Export CSV
 * - CMD Option -c : Clear Callerlist
 * - CMD Option -l : Debug to Logfile
 * - Bugfix: Statistic-Dialog uses box.ip not 192.168.178.1
 * - Bugfix: Compatibility to Java 1.4.2
 * - Bugfix: Passwords with special chars
 * - Bugfix: Some charset bugfixing
 * - Bugfix: Phonebook XML-Saving fixed (UTF-8 coding)
 *
 *
 * JFritz 0.4.0
 * - Systray minimizes JFrame
 * - Mobile filter inverted
 * - Removed participant support in favour of person
 * - Phonebook support
 * - Added commandline option --fetch
 * - Rewrote xml handler for phonebook
 * - Data statistics
 * - Call monitor with sound notification
 * - Crypted password
 * - Option for password check on program start
 * - Option for disabling sounds
 *
 * Internal:
 * - Added PhoneNumber class
 * - Added PhoneType class
 * - Restructured packages
 *
 *
 * JFritz 0.3.6
 * - New mobile phone filter feature
 * - Systray support for Linux/Solaris/Windows
 * - Systray ballon messages for Linux/Solaris/Windows
 * - Browser opening on Unix platforms
 * - Bugfix: Call with same timestamp are collected
 *
 * JFritz 0.3.4
 * - New search filter feature
 * - New date and date range filter feature
 * - Sorting of columns by clicking on column headers
 * - VOIP numbers starting with 49 are now rewritten correctly
 * - SSDP Autodetection of Fritz!Boxes
 * - QuickDial Management
 * - Selection of multiple rows copies VCards to clipboard
 * - Bugfix: Config-Dialog now saves all values correctly
 * - Bugfix: No empty SIP provider after detection
 * - Bugfix: Save-Dialog on export functions
 * - Code rearrangement
 *
 * JFritz 0.3.2:
 * - Saves and restores window position/size
 * - Saves and restores width of table columns
 * - CallTypeFilter works now (thanks to robotniko)
 * - Filter option is saved
 * - Added filter for calls without displayed number
 * - Total duration of calls now displayed in status bar
 *
 * JFritz 0.3.0: Major release
 * - Compatibility for JRE 1.4.2
 * - Severel bugfixes
 *
 * JFritz 0.2.8:
 * - Bugfix: Firmware detection had nasty bug
 * - Bugfix: Firmware detection detects modded firmware properly
 * - Bugfix: RegExps adapted for modded firmware
 * - Support for SIP-Provider for fritzbox fon wlan
 * - Notify users whenn calls have been retrieved
 * - CSV Export
 *
 * JFritz 0.2.6:
 * - Several bugfixes
 * - Support for Fritz!Boxes with modified firmware
 * - Improved config dialog
 * - Improved firmware detection
 * - Initial support für SIP-Provider
 * - Firmware/SIP-Provider are saved in config file
 *
 * JFritz 0.2.4:
 * - Several bugfixes
 * - Improventsment on number resolution
 * - Optimized Reverse Lookup
 *
 * JFritz 0.2.2:
 * - FRITZ!Box FON WLAN works again and is detected automatically.
 * - Target MSN is displayed
 * - Bugfixes for Reverse Lookup (Mobile phone numbers are filtered now)
 * - Nice icons for calltypes (Regular call, Area call, Mobile call)
 * - Several small bugfixes
 *
 * JFritz 0.2.0: Major release
 * - Improved GUI, arranged colours for win32 platform
 * - New ToolBar with nice icons
 * - Bugfix: Not all calls had been retrieved from box
 * - Improved reverse lookup
 * - Automatic box detection (does not yet work perfectly)
 * - Internal class restructuring
 *
 * JFritz 0.1.6:
 * - Calls are now saved in XML format
 * - Support for Fritz!Box 7050
 *
 * JFritz 0.1.0:
 * - Initial version
 */

package de.moonflower.jfritz;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.JOptionPane;

import de.moonflower.jfritz.autoupdate.JFritzUpdate;
import de.moonflower.jfritz.autoupdate.Update;
import de.moonflower.jfritz.dialogs.simple.AddressPasswordDialog;
import de.moonflower.jfritz.exceptions.InvalidFirmwareException;
import de.moonflower.jfritz.exceptions.WrongPasswordException;
import de.moonflower.jfritz.network.NetworkStateMonitor;
import de.moonflower.jfritz.struct.FritzBox;
import de.moonflower.jfritz.struct.Person;
import de.moonflower.jfritz.utils.CLIOption;
import de.moonflower.jfritz.utils.CLIOptions;
import de.moonflower.jfritz.utils.CopyFile;
import de.moonflower.jfritz.utils.Debug;
import de.moonflower.jfritz.utils.DiagSignalHandler;
import de.moonflower.jfritz.utils.Encryption;
import de.moonflower.jfritz.utils.JFritzProperties;
import de.moonflower.jfritz.utils.JFritzUtils;
import de.moonflower.jfritz.utils.ShutdownHook;
import de.moonflower.jfritz.utils.reverselookup.LookupObserver;
import de.moonflower.jfritz.utils.reverselookup.ReverseLookup;

public class Main implements LookupObserver {

	public final static String PROGRAM_NAME = "JFritz"; //$NON-NLS-1$

	public final static String PROGRAM_VERSION = "0.7.1.9"; //$NON-NLS-1$

	public final static String CVS_TAG = "$Id: Main.java,v 1.120 2008/08/25 18:40:57 robotniko Exp $"; //$NON-NLS-1$

	public final static String PROGRAM_URL = "http://www.jfritz.org/"; //$NON-NLS-1$

	public final static String JFRITZ_PROJECT = "all members of the JFritz-Team";

	public final static String PROJECT_ADMIN = "Robert Palmer <robotniko@users.sourceforge.net>"; //$NON-NLS-1$

	public final static String USER_DIR = System.getProperty("user.home")
			+ File.separator + ".jfritz";

	public final static String USER_JFRITZ_FILE = "jfritz.txt";

	public static String SAVE_DIR = System.getProperty("user.dir")
			+ File.separator;

	public static String SAVE_DIR_TEXT = "Save_Directory=";

	public final static String LOCK_FILE = ".lock"; //$NON-NLS-1$

	public final static String CONFIG_PROPERTIES_FILE = "jfritz.properties.xml"; //$NON-NLS-1$

	public final static String STATE_PROPERTIES_FILE = "jfritz.state.properties.xml"; //$NON-NLS-1$

	public static boolean SYSTRAY_SUPPORT = false;

	private static JFritzProperties defaultProperties;

	private static JFritzProperties config_properties;

	private static JFritzProperties state_properties;

	private static ResourceBundle localeMeanings;

	private static ResourceBundle messages;
	private static ResourceBundle en_messages;

	private static boolean showConfWizard;

	private static boolean enableInstanceControl = true;

	private static boolean checkSystray = true;

	private static String jfritzHomedir;

	private static JFritz jfritz;

	private CLIOptions options;

	private static int exitCode = 0;

	private static boolean already_done_shutdown;

	private static Vector<Locale> supported_languages;

	private static ShutdownHook.Handler shutdownHandler;
	private static ShutdownThread shutdownThread;

	public Main(String[] args) {
		System.out.println(PROGRAM_NAME + " v" + PROGRAM_VERSION //$NON-NLS-1$
				+ " (c) 2005-2008 by " + JFRITZ_PROJECT); //$NON-NLS-1$
		Thread.currentThread().setPriority(5);
		Thread.currentThread().setName("JFritz main thread");

		//Catch non-user-initiated VM shutdown
		shutdownHandler = new ShutdownHook.Handler() {
		      public void shutdown( String signal_name ) {
		    	  	Runtime.getRuntime().removeShutdownHook(shutdownThread);
			        Debug.msg( "Core: Caught signal " +signal_name );
			        prepareShutdown(false, true);
//			        Debug.msg("Core: Shutdown signal handler done");
			      }
			    };

	    ShutdownHook.install(shutdownHandler);

		shutdownThread = new ShutdownThread(this);
		Runtime.getRuntime().addShutdownHook(shutdownThread);

		jfritzHomedir = JFritzUtils.getFullPath(".update");
		jfritzHomedir = jfritzHomedir.substring(0, jfritzHomedir.length() - 7);
	}

	/**
	 * Main method for starting JFritz
	 *
	 * LAST MODIFIED: Brian 04.06.06 added option to disable mulitple
	 * instance control added a new parameter switch: -w
	 *
	 * @param args
	 *            Program arguments (-h -v ...)
	 *
	 */
	public static void main(String[] args) {
		Debug.on();
		SplashScreen splash = new SplashScreen();
		splash.setVersion("v" + Main.PROGRAM_VERSION);
		splash.setStatus("Initializing JFritz...");
		already_done_shutdown = false;
		Main main = new Main(args);
		main.initiateCLIParameters();
		main.checkDebugParameters(args);

		// load supported languages
		splash.setStatus("Loading supported languages...");
		loadLanguages();

		// Weitere Initialisierung
		loadSaveDir();

		splash.setStatus("Loading properties...");
		loadProperties();

    	Debug.msg("OS Language: " + System.getProperty("user.language"));
    	Debug.msg("OS Country: " + System.getProperty("user.country"));
		if ( Main.getProperty("locale").equals("") )
		{
			Debug.msg("No language set yet ... Setting language to OS language");
	    	// Check if language is supported. If not switch to english
	    	if ( supported_languages.contains(new Locale(System.getProperty("user.language"),System.getProperty("user.country"))))
	    	{
	        	Main.setProperty("locale", System.getProperty("user.language")+"_"+System.getProperty("user.country"));
	    	} else {
	    		Debug.msg("Your language ist not yet supported.");
	        	Main.setProperty("locale", "en_US");
	    	}
		}
		String loc = Main.getProperty("locale");
		Debug.msg("Selected language: " + loc);

		loadMessages(new Locale(loc.substring(0, loc.indexOf("_")), loc.substring(loc.indexOf("_")+1, loc.length()))); //$NON-NLS-1$,  //$NON-NLS-2$
		loadLocaleMeanings(new Locale("int", "INT"));

		saveUpdateProperties();

		splash.setStatus("Initializing main application...");
		jfritz = new JFritz(main);

		int result = 0;
		jfritz.initNumbers();
		splash.setStatus("Initializing Fritz!Box..");
		try {
			result = jfritz.initFritzBox();
		} catch (WrongPasswordException e1) {
			Debug.err(Main.getMessage("box.wrong_password")); //$NON-NLS-1$
		} catch (IOException e1) {
			Debug.err(Main.getMessage("box.not_found")); //$NON-NLS-1$
		} catch (InvalidFirmwareException e1) {
			Debug.err(Main.getMessage("unknown_firmware")); //$NON-NLS-1$
		}

		if (result == 0)
		{
			splash.setStatus("Loading SIP provider...");
			jfritz.initSipProvider();
		}
		if (result == 0)
		{
			splash.setStatus("Loading quick dials...");
			jfritz.initQuickDials();
		}
		if (result == 0)
		{
			splash.setStatus("Loading caller list and phonebook...");
			jfritz.initCallerListAndPhoneBook();
		}
		if (result == 0)
		{
			splash.setStatus("Initializing call monitor...");
			jfritz.initCallMonitor();
		}
		if (result == 0)
		{
			splash.setStatus("Initializing Client/Server...");
			jfritz.initClientServer();
		}
		if (result == 0)
		{
			splash.setStatus("Setting default look and feel...");
			jfritz.initLookAndFeel();
		}
		if (result == 0)
		{
			main.checkCLIParameters(args);
		}

		splash.setStatus("Checking startup password...");
		String ask = Main.getProperty("jfritz.password", Encryption //$NON-NLS-1$
				.encrypt(JFritz.PROGRAM_SECRET + "")); //$NON-NLS-1$
		String pass = "";
		if (JFritz.getFritzBox() != null)
		{
			pass = JFritz.getFritzBox().getPassword();
		}
		if (!Encryption.decrypt(ask).equals(JFritz.PROGRAM_SECRET + pass)) {
			String password = "";
			while (result == 0 && !password.equals(pass))
			{
				password = main.showPasswordDialog(""); //$NON-NLS-1$
				if (password == null) { // PasswordDialog canceled
					result = 1;
				} else if (!password.equals(pass)) {
					Debug.errDlg(Main.getMessage("box.wrong_password")); //$NON-NLS-1$
					Debug.err(Main.getMessage("box.wrong_password")); //$NON-NLS-1$
				}
			}
		}

		if (result == 0)
		{
			boolean createGui = main.checkInstanceControl();

			if ( createGui ) {
				splash.setStatus("Creating GUI");
				jfritz.createJFrame(showConfWizard);
			}
		}

		splash.dispose();
		Debug.msg("Main is now exiting...");
		if (result != 0)
		{
			main.exit(result);
		}
	}

	/**
	 * Initialisiert die erlaubten Kommandozeilenparameter
	 *
	 */
	private void initiateCLIParameters() {
		options = new CLIOptions();

		options.addOption('h', "help", null, "This short description"); //$NON-NLS-1$,  //$NON-NLS-2$,  //$NON-NLS-3$
		CLIOption verboseOption = new CLIOption('v', "verbose", null,
				"Turn on debug information");
		options.addOption(verboseOption); //$NON-NLS-1$,  //$NON-NLS-2$,  //$NON-NLS-3$
		options.addOption('s', "systray", null, "Turn on systray support"); //$NON-NLS-1$,  //$NON-NLS-2$,  //$NON-NLS-3$
		options.addOption('n', "nosystray", null, "Turn off systray support"); //$NON-NLS-1$,  //$NON-NLS-2$,  //$NON-NLS-3$
		options.addOption('f', "fetch", null, "Fetch new calls and exit"); //$NON-NLS-1$,  //$NON-NLS-2$,  //$NON-NLS-3$
		options.addOption('d', "delete_on_box", null, //$NON-NLS-1$,  //$NON-NLS-2$
				"Delete callerlist of the Fritz!Box."); //$NON-NLS-1$
		options.addOption('b', "backup", null,
				"Creates a backup of all xml-Files in the directory 'backup'"); //$NON-NLS-1$,  //$NON-NLS-2$,  //$NON-NLS-3$
		options.addOption('c', "clear_list", null, //$NON-NLS-1$,  //$NON-NLS-2$
				"Clears Caller List and exit"); //$NON-NLS-1$
		options.addOption('e', "export", "filename", //$NON-NLS-1$,  //$NON-NLS-2$,  //$NON-NLS-3$
				"Fetch calls and export to CSV file."); //$NON-NLS-1$
		options
				.addOption('z', "exportForeign", null, //$NON-NLS-1$,  //$NON-NLS-2$
						"Write phonebooks compatible to BIT FBF Dialer and some other callmonitors."); //$NON-NLS-1$
		options.addOption('l', "logfile", "filename", //$NON-NLS-1$,  //$NON-NLS-2$,  //$NON-NLS-3$
				"Writes debug messages to logfile"); //$NON-NLS-1$,
		options.addOption('p', "priority", "level", //$NON-NLS-1$,  //$NON-NLS-2$,  //$NON-NLS-3$
				"Set program priority [1..10]"); //$NON-NLS-1$
        options.addOption('i',"lang", "language","Set the display language, currently supported: german, english"); //$NON-NLS-1$,  //$NON-NLS-2$,  //$NON-NLS-3$, //$NON-NLS-4$
		options
				.addOption(
						'w',
						"without-control", null, //$NON-NLS-1$,  //$NON-NLS-2$
						"Turns off multiple instance control. DON'T USE, unless you know what your are doing"); //$NON-NLS-1$
		options
				.addOption('r', "reverse-lookup", null,
						"Do a reverse lookup and exit. Can be used together with -e -f and -z");
	}

	/**
	 * Überprüft, ob die -h, -v oder -l Startparameter gesetzt sind
	 *
	 * @param args
	 *            Kommandozeilenargumente
	 */
	private void checkDebugParameters(String[] args) {
		Vector foundOptions = options.parseOptions(args);

		// Checke den help, verbose/debug und log-to-file parameter
		Enumeration en = foundOptions.elements();
		while (en.hasMoreElements()) {
			CLIOption option = (CLIOption) en.nextElement();

			switch (option.getShortOption()) {
			case 'h': //$NON-NLS-1$
				System.out.println("Usage: java -jar jfritz.jar [Options]"); //$NON-NLS-1$
				options.printOptions();
				exit(0);
				break;
			case 'v': //$NON-NLS-1$
				Debug.on();
				break;
			case 'l': //$NON-NLS-1$
				String logFilename = option.getParameter();
				if (logFilename == null || logFilename.equals("")) { //$NON-NLS-1$
					Debug.logToFile("Debuglog.txt");
				} else {
					Debug.logToFile(logFilename);
					break;
				}
			}
		}
	}

	/**
	 * Überprüft die weiteren Kommandozeilenparameter
	 *
	 * @param args
	 *            Kommandozeilenargumente
	 */
	private void checkCLIParameters(String[] args) {
		boolean shutdown = false;
		Debug.msg("Start commandline parsing"); //$NON-NLS-1$
		// Checke alle weiteren Parameter
		Vector foundOptions = options.parseOptions(args);
		Enumeration en = foundOptions.elements();
		while (en.hasMoreElements()) {
			CLIOption option = (CLIOption) en.nextElement();

			switch (option.getShortOption()) {
			case 'b': //$NON-NLS-1$
				doBackup();
				break;
			case 's': //$NON-NLS-1$
				SYSTRAY_SUPPORT = true;
				break;
			case 'n': //$NON-NLS-1$
				checkSystray = false;
				break;
			case 'f':
				shutdown = true;
				Debug.msg("Fetch caller list ..."); //$NON-NLS-1$
				try {
					JFritz.getCallerList().getNewCalls();
				} catch (WrongPasswordException e) {
					Debug.err(e.toString());
					e.printStackTrace();
				} catch (IOException e) {
					Debug.err(e.toString());
					e.printStackTrace();
				} catch (InvalidFirmwareException e) {
					Debug.err(e.toString());
					e.printStackTrace();
				}
				break;
			case 'r':
				doReverseLookup();
				shutdown = true;
				break;
			case 'e':
				String csvFileName = option.getParameter();
				if (csvFileName == null || csvFileName.equals("")) { //$NON-NLS-1$
					System.err.println(getMessage("parameter_not_found")); //$NON-NLS-1$
					exit(0);
				}
				Debug.msg("Exporting Call list (csv) to " + csvFileName); //$NON-NLS-1$
				JFritz.getCallerList().saveToCSVFile(csvFileName, true);
				shutdown = true;
				break;
			case 'z':
				JFritz.getPhonebook().saveToBITFBFDialerFormat("bitbook.dat"); //$NON-NLS-1$
				JFritz.getPhonebook()
						.saveToCallMonitorFormat("CallMonitor.adr"); //$NON-NLS-1$
				shutdown = true;
				break;
			case 'd': //$NON-NLS-1$
				Debug.on();
				clearCallsOnBoxCli();
				shutdown = true;
				break;
			case 'c': //$NON-NLS-1$
				Debug.msg("Clearing Call List"); //$NON-NLS-1$
				JFritz.getCallerList().clearList();
				shutdown = true;
				break;
            case 'i': //$NON-NLS-1$
            	String language = option.getParameter();
            	if(language == null){
            		System.err.println(Main.getMessage("invalid_language")); //$NON-NLS-1$
            		System.err.println("Deutsch: de"); //$NON-NLS-1$
            		System.err.println("English: en"); //$NON-NLS-1$
            		System.err.println("Italian: it"); //$NON-NLS-1$
            		System.err.println("Netherland: nl"); //$NON-NLS-1$
            		System.err.println("Poland: pl"); //$NON-NLS-1$
            		System.err.println("Russia: ru"); //$NON-NLS-1$
            		System.exit(0);
            	}else if(language.equals("english") || language.equals("en")){ //$NON-NLS-1$
            		Main.setProperty("locale", "en_US");
            	}else if(language.equals("german") || language.equals("de")){ //$NON-NLS-1$
            		Main.setProperty("locale", "de_DE");
            	}else if(language.equals("italian") || language.equals("it")){ //$NON-NLS-1$
            		Main.setProperty("locale", "it_IT");
            	}else if(language.equals("netherlands") || language.equals("nl")){ //$NON-NLS-1$
            		Main.setProperty("locale", "nl_NL");
            	}else if(language.equals("poland") || language.equals("pl")){ //$NON-NLS-1$
            		Main.setProperty("locale", "pl_PL");
            	}else if(language.equals("russian") || language.equals("ru")){ //$NON-NLS-1$
            		Main.setProperty("locale", "ru_RU");
            	}else{
            		System.err.println(Main.getMessage("invalid_language")); //$NON-NLS-1$
            		System.err.println("Deutsch: de"); //$NON-NLS-1$
            		System.err.println("English: en"); //$NON-NLS-1$
            		System.err.println("Italian: it"); //$NON-NLS-1$
            		System.err.println("Netherland: nl"); //$NON-NLS-1$
            		System.err.println("Poland: pl"); //$NON-NLS-1$
            		System.err.println("Russia: ru"); //$NON-NLS-1$
            		System.exit(0);
            	}
        		loadMessages(new Locale(Main.getProperty("locale","en_US"))); //$NON-NLS-1$,  //$NON-NLS-2$
            	break;
			case 'w': //$NON-NLS-1$
				enableInstanceControl = false;
				System.err.println("Turning off Multiple instance control!"); //$NON-NLS-1$
				System.err.println("You were warned! Data loss may occur."); //$NON-NLS-1$
				break;
			case 'p': //$NON-NLS-1$
				String priority = option.getParameter();
				if (priority == null || priority.equals("")) { //$NON-NLS-1$
					System.err.println(getMessage("parameter_not_found")); //$NON-NLS-1$
					exit(0);
				} else {
					try {
						int level = Integer.parseInt(priority);
						Thread.currentThread().setPriority(level);
						Debug.msg("Set priority to level " + priority); //$NON-NLS-1$
					} catch (NumberFormatException nfe) {
						System.err
								.println(getMessage("parameter_wrong_priority")); //$NON-NLS-1$
						exit(0);
					} catch (IllegalArgumentException iae) {
						System.err
								.println(getMessage("parameter_wrong_priority")); //$NON-NLS-1$
						exit(0);
					}
					break;
				}
			default:
				break;
			}
		}

		if (shutdown) {
			exit(0);
		}
	}

	/**
	 * Ist die Mehrfachstart-Überprüfung aktiv, so wird ein Dialog angezeigt mit
	 * dem der User JFritz sicher beenden kann.
	 *
	 * @return true, if everything is ok. false if user decided to shutdown jfritz.
	 */
	private boolean checkInstanceControl() {
		boolean result = true;
		if (enableInstanceControl) {
			// check isRunning and exit or set lock
			File f = new File(SAVE_DIR + LOCK_FILE);
			boolean isRunning = f.exists();

			if (!isRunning) {
				Debug.msg("Multiple instance lock: set lock."); //$NON-NLS-1$
				result = true;
				try {
					f.createNewFile();
				} catch (IOException e) {
					Debug.err("Could not set instance lock");
				}
			} else {
				Debug
						.msg("Multiple instance lock: Another instance is already running."); //$NON-NLS-1$
				int answer = JOptionPane.showConfirmDialog(null,
						getMessage("lock_error_dialog1") //$NON-NLS-1$
								+ getMessage("lock_error_dialog2") //$NON-NLS-1$
								+ getMessage("lock_error_dialog3") //$NON-NLS-1$
								+ getMessage("lock_error_dialog4"), //$NON-NLS-1$
						getMessage("information"), JOptionPane.YES_NO_OPTION); //$NON-NLS-1$
				if (answer == JOptionPane.YES_OPTION) {
					Debug
							.msg("Multiple instance lock: User decided to shut down this instance."); //$NON-NLS-1$
					exit(-1);
					result = false;
				} else {
					Debug
							.msg("Multiple instance lock: User decided NOT to shut down this instance."); //$NON-NLS-1$
					result = true;
				}
			}
		}
		return result;
	}

	/**
	 * This function writes a file $HOME/.jfritz/jfritz.txt, which contains the
	 * location of the folder containing jfritz's data If the dir $HOME/.jfritz
	 * does not exist, it is created if the save location isnt a directory, then
	 * the default save directory is used
	 *
	 * @author Brian Jensen
	 *
	 */
	public static void writeSaveDir() {
		try {

			// if $HOME/.jfritz doesn't exist create it
			File file = new File(USER_DIR);
			if (!file.isDirectory() && !file.isFile())
				file.mkdir();

			BufferedWriter bw = new BufferedWriter(new FileWriter(USER_DIR
					+ File.separator + USER_JFRITZ_FILE, false));

			// make sure the user didn't screw something up
			if (!SAVE_DIR.endsWith(File.separator))
				SAVE_DIR = SAVE_DIR + File.separator;

			file = new File(SAVE_DIR);
			if (!file.isDirectory())
				SAVE_DIR = System.getProperty("user.dir") + File.separator;

			bw.write(SAVE_DIR_TEXT + SAVE_DIR);
			bw.newLine();
			bw.close();
			Debug.msg("Successfully wrote save dir to disk");

		} catch (Exception e) {
			Debug
					.err("Error writing save dir to disk, reverting back to default save dir");
			SAVE_DIR = System.getProperty("user.dir") + File.separator;
			// if there was an error, bail out and revert to the default save
			// location
		}
	}

	/**
	 * Funktion reads the user specified save location from a simple text file
	 * If any error occurs the function bails out and uses the current directory
	 * as the save dir, as the functionality was in JFritz < 0.6.0
	 *
	 * @author Brian Jensen
	 *
	 */
	public static void loadSaveDir() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(USER_DIR + File.separator
					+ USER_JFRITZ_FILE));
			String line = br.readLine();
			if (line == null) {
				br.close();
				Debug.msg("File" + USER_DIR + File.separator + USER_JFRITZ_FILE
						+ "empty");
			}
			String[] entries = line.split("=");
			if (!entries[1].equals("")) {
				SAVE_DIR = entries[1];
				File file = new File(SAVE_DIR);
				if (!file.isDirectory())
					SAVE_DIR = System.getProperty("user.dir") + File.separator;
				else if (!SAVE_DIR.endsWith(File.separator))
					SAVE_DIR = SAVE_DIR + File.separator;
			}
			Debug.msg("Save directory: " + SAVE_DIR);
		} catch (FileNotFoundException e) {
			Debug
					.msg("Error processing the user save location(File not found), using defaults");
			// If something happens, just bail out and use the standard dir
		} catch (IOException ioe) {
			Debug
					.msg("Error processing the user save location, using defaults");
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ioe) {
				Debug.msg("Error closing stream");
			}
		}
	}

	protected static void doBackup() {
		CopyFile backup = new CopyFile();
		backup.copy(SAVE_DIR, "xml"); //$NON-NLS-1$,  //$NON-NLS-2$
	}

	/**
	 *
	 */
	public static void clearCallsOnBoxCli() {
		Debug.msg("Clearing callerlist on box."); //$NON-NLS-1$
		loadProperties();
		try {
			Exception ex = null;
			FritzBox fritzBox = new FritzBox(getProperty(
					"box.address", "192.168.178.1"), Encryption //$NON-NLS-1$,  //$NON-NLS-2$
					.decrypt(getProperty("box.password", Encryption //$NON-NLS-1$
							.encrypt(""))), getProperty("box.port", "80"), ex); //$NON-NLS-1$
			if ( ex != null )
			{
				try {
					throw ex;
				} catch (Exception e)
				{
					Debug.err("Error: " + e.getLocalizedMessage());
				}
			}
			fritzBox.clearListOnFritzBox();
			Debug.msg("Clearing done"); //$NON-NLS-1$
		} catch (WrongPasswordException e) {
			Debug.err("Wrong password, can not delete callerlist on Box."); //$NON-NLS-1$
			e.printStackTrace();
		} catch (IOException e) {
			Debug
					.err("IOException while deleting callerlist on box (wrong IP-address?)."); //$NON-NLS-1$
			e.printStackTrace();
//		} catch (InvalidFirmwareException e) {
//			Debug.err("Invalid firmware, can not delete callerlist on Box."); //$NON-NLS-1$
//			e.printStackTrace();
		}
	}


	/**
	 * The function is called mostly from the mac quit handler code to
	 * safely end jfritz when the program should be terminated
	 * either through user input or through a system event (logoff / restart ..)
	 *
	 * @param i the exit code
	 */
	public void exit(int i) {
		Debug.msg("Main.exit(" + i + ")");
		exitCode = i;
	  	Runtime.getRuntime().removeShutdownHook(shutdownThread);
		prepareShutdown(false, false);
	}

	public void closeOpenConnections(){
		Debug.msg("Closing all open network connections");

		String networkType = Main.getProperty("network.type", "0");

		if(networkType.equals("1") && NetworkStateMonitor.isListening())
			NetworkStateMonitor.stopServer();

		else if(networkType.equals("2") && NetworkStateMonitor.isConnectedToServer())
			NetworkStateMonitor.stopClient();

	}


	/**
	 * Loads properties from xml files
	 */
	public static void loadProperties() {
		defaultProperties = new JFritzProperties();

		// Default properties
		defaultProperties.setProperty("box.address", "192.168.178.1");//$NON-NLS-1$, //$NON-NLS-2$
		defaultProperties.setProperty("box.password", Encryption.encrypt(""));//$NON-NLS-1$, //$NON-NLS-2$
		defaultProperties.setProperty("box.port", "80");//$NON-NLS-1$, //$NON-NLS-2$
		defaultProperties.setProperty("country.prefix", "00");//$NON-NLS-1$, //$NON-NLS-2$
		defaultProperties.setProperty("area.prefix", "0");//$NON-NLS-1$, //$NON-NLS-2$
		defaultProperties.setProperty("country.code", "+49");//$NON-NLS-1$, //$NON-NLS-2$
		defaultProperties.setProperty("area.code", "441");//$NON-NLS-1$, //$NON-NLS-2$
		defaultProperties.setProperty("fetch.timer", "5");//$NON-NLS-1$, //$NON-NLS-2$

		config_properties = new JFritzProperties(defaultProperties);

		try {
			config_properties.loadFromXML(Main.SAVE_DIR + CONFIG_PROPERTIES_FILE);
		} catch (FileNotFoundException e) {
			Debug.err("File " + Main.SAVE_DIR + CONFIG_PROPERTIES_FILE //$NON-NLS-1$
					+ " not found => showing config wizard"); //$NON-NLS-1$
			showConfWizard = true;
		} catch (IOException ioe) {
			Debug.err("File " + Main.SAVE_DIR + CONFIG_PROPERTIES_FILE //$NON-NLS-1$
					+ " not readable => showing config wizard"); //$NON-NLS-1$
			showConfWizard = true;
		}

		state_properties = new JFritzProperties();
		try {
			state_properties.loadFromXML(Main.SAVE_DIR + STATE_PROPERTIES_FILE);
		} catch (FileNotFoundException e) {
			Debug.err("File " + Main.SAVE_DIR + STATE_PROPERTIES_FILE //$NON-NLS-1$
					+ " not found. Using default values."); //$NON-NLS-1$
		} catch (IOException ioe) {
			Debug.err("File " + Main.SAVE_DIR + STATE_PROPERTIES_FILE //$NON-NLS-1$
					+ " not readable. Using default values."); //$NON-NLS-1$
		}

		replaceOldProperties();

	}

	/**
	 * Replace old property values with new one
	 *
	 */
	private static void replaceOldProperties() {
		// TODO: Kopieren einiger Einstellungen in State-Properties
//		saveProperties();
	}

	/**
	 * Saves config properties to xml files
	 * ip, password, options
	 */
	public static void saveConfigProperties() {
		try {
			Debug.msg("Save config properties"); //$NON-NLS-1$
			config_properties.storeToXML(Main.SAVE_DIR + CONFIG_PROPERTIES_FILE);
		} catch (IOException e) {
			Debug.err("Couldn't save config properties"); //$NON-NLS-1$
		}
	}

	/**
	 * Saves state properties to xml files
	 * window-state, filter-state ...
	 */
	public static void saveStateProperties() {
		try {
			Debug.msg("Save state properties"); //$NON-NLS-1$
			state_properties.storeToXML(Main.SAVE_DIR + STATE_PROPERTIES_FILE);
			Debug.msg("Save state properties done"); //$NON-NLS-1$
		} catch (IOException e) {
			Debug.err("Couldn't save state properties"); //$NON-NLS-1$
		}
	}

	/**
	 * Get state properties with default value
	 * @param property
	 *            Property to get the value from
	 * @param defaultValue
	 *            Default value to be returned if property does not exist
	 * @return Returns value of a specific property
	 */
	public static String getStateProperty(String property, String defaultValue) {
		return state_properties.getProperty(property, defaultValue);
	}

	/**
	 * Get state properties
	 * @param property
	 *            Property to get the value from
	 * @return Returns value of a specific property
	 */
	public static String getStateProperty(String property) {
		return getStateProperty(property, ""); //$NON-NLS-1$
	}

	/**
	 * Get config properties with default value
	 * @param property
	 *            Property to get the value from
	 * @param defaultValue
	 *            Default value to be returned if property does not exist
	 * @return Returns value of a specific property
	 */
	public static String getProperty(String property, String defaultValue) {
		return config_properties.getProperty(property, defaultValue);
	}

	/**
	 * Get config properties
	 * @param property
	 *            Property to get the value from
	 * @return Returns value of a specific property
	 */
	public static String getProperty(String property) {
		return getProperty(property, ""); //$NON-NLS-1$
	}

	/**
	 * Sets a config property to a specific value
	 *
	 * @param property
	 *            Property to be set
	 * @param value
	 *            Value of property
	 */
	public static void setProperty(String property, String value) {
		config_properties.setProperty(property, value);
	}

	/**
	 * Sets a config property to a specific value
	 *
	 * @param property
	 *            Property to be set
	 * @param value
	 *            Value of property
	 */
	public static void setProperty(String property, boolean value) {
		config_properties.setProperty(property, String.valueOf(value));
	}

	/**
	 * Sets a state property to a specific value
	 *
	 * @param property
	 *            Property to be set
	 * @param value
	 *            Value of property
	 */
	public static void setStateProperty(String property, String value) {
		state_properties.setProperty(property, value);
	}

	/**
	 * Sets a state property to a specific value
	 *
	 * @param property
	 *            Property to be set
	 * @param value
	 *            Value of property
	 */
	public static void setStateProperty(String property, boolean value) {
		state_properties.setProperty(property, String.valueOf(value));
	}

	/**
	 * Removes a config property
	 *
	 * @param property
	 *            Property to be removed
	 */
	public static void removeProperty(String property) {
		config_properties.remove(property);
	}

	/**
	 * Removes a state property
	 *
	 * @param property
	 *            Property to be removed
	 */
	public static void removeStateProperty(String property) {
		state_properties.remove(property);
	}

	/**
	 * Loads resource messages
	 *
	 * @param locale
	 */
	public static void loadMessages(Locale locale) {
		try {
			Debug.msg("Loading locale: " + locale);
			en_messages = ResourceBundle.getBundle("jfritz", new Locale("en","US"));//$NON-NLS-1$
			messages = ResourceBundle.getBundle("jfritz", locale);//$NON-NLS-1$
		} catch (MissingResourceException e) {
			Debug
					.err("Can't find i18n resource! (\"jfritz_" + locale + ".properties\")");//$NON-NLS-1$
			JOptionPane.showMessageDialog(null, Main.PROGRAM_NAME + " v"//$NON-NLS-1$
					+ Main.PROGRAM_VERSION
					+ "\n\nCannot find the language file \"jfritz_" + locale
					+ ".properties\"!" + "\nProgram will exit!");//$NON-NLS-1$
		}
	}

	/**
	 * Loads locale meanings
	 *
	 * @param locale
	 */
	private static void loadLocaleMeanings(Locale locale) {
		try {
			localeMeanings = ResourceBundle.getBundle("languages", locale);//$NON-NLS-1$
		} catch (MissingResourceException e) {
			Debug.err("Can't find locale Meanings resource!");//$NON-NLS-1$
		}
	}

	/**
	 * @return Returns an internationalized message. Last modified: 26.04.06 by
	 *         Bastian
	 */
	public static String getMessage(String msg) {
		String i18n = ""; //$NON-NLS-1$
		try {
			if (!messages.getString(msg).equals("")) {
				i18n = messages.getString(msg);
			} else {
				i18n = msg;
			}
		} catch (MissingResourceException e) {
			Debug.err("Can't find resource string for " + msg); //$NON-NLS-1$
			i18n = en_messages.getString(msg);
		}
		return i18n;
	}

	/**
	 * @return Returns the meanings of a locale abbreviation.
	 */
	public static String getLocaleMeaning(String msg) {
		String localeMeaning = ""; //$NON-NLS-1$
		try {
			if (!localeMeanings.getString(msg).equals("")) {
				localeMeaning = localeMeanings.getString(msg);
			} else {
				localeMeaning = msg;
			}
		} catch (MissingResourceException e) {
			Debug.err("Can't find resource string for " + msg); //$NON-NLS-1$
			localeMeaning = msg;
		} catch (NullPointerException e) {
			Debug.err("Can't find locale Meanings file"); //$NON-NLS-1$
			localeMeaning = msg;
		}
		return localeMeaning;
	}

	public static boolean isInstanceControlEnabled() {
		return enableInstanceControl;
	}

	/**
	 * Checks for systray availability
	 */
	public static boolean checkForSystraySupport() {
		if (!checkSystray)
			return false;
		String os = System.getProperty("os.name"); //$NON-NLS-1$
		if (os.equals("Linux") || os.equals("Solaris") //$NON-NLS-1$,  //$NON-NLS-2$
				|| os.startsWith("Windows")) { //$NON-NLS-1$
			SYSTRAY_SUPPORT = true;
		}
		return SYSTRAY_SUPPORT;
	}

	public static String getHomeDirectory() {
		return jfritzHomedir;
	}

	public JFritz getJfritz() {
		return jfritz;
	}

	/**
	 * Speichert die Einstellungen für das automatische Update von JFritz
	 *
	 */
	public static void saveUpdateProperties() {
		JFritzUpdate jfritzUpdate = new JFritzUpdate(false);
		Update update = new Update(jfritzUpdate.getPropertiesDirectory());
		update.loadSettings();
		update.setProgramVersion(PROGRAM_VERSION);
		update.setLocale(getProperty("locale"));
		update.setUpdateOnStart(JFritzUtils.parseBoolean(Main.getProperty(
				"option.checkNewVersionAfterStart", "false")));
		update.saveSettings();
	}

	private void showActiveThreads()
	{
			Debug.msg("Active Threads: " + Thread.activeCount());
			Thread[] threadarray = new Thread[Thread.activeCount()];
			int threadCount = Thread.enumerate(threadarray);
			Debug.msg("Threads: " + threadCount);
			for (int i=0; i<threadCount; i++)
			{
				Debug.msg("ID: " + i);
				Debug.msg("Name: " +  threadarray[i].getName());
				Debug.msg("Class: " + threadarray[i].getClass().toString());
				Debug.msg("State: " +  threadarray[i].getState());
				Debug.msg("Daemon: " + threadarray[i].isDaemon());
				Debug.msg("Thread group: " + threadarray[i].getThreadGroup());
				Debug.msg("Thread priority: " + threadarray[i].getPriority());
				Debug.msg("---");
			}
	}

	private void wakeupActiveThreads()
	{
			Thread[] threadarray = new Thread[Thread.activeCount()];
			int threadCount = Thread.enumerate(threadarray);
			Thread t = Thread.currentThread();
			for (int i=0; i<threadCount; i++)
			{
				if (t != threadarray[i] && i==8) {
					Debug.msg("Waking up thread: " + i);
					Debug.msg("Name: " +  threadarray[i].getName());
					Debug.msg("Class: " + threadarray[i].getClass().toString());
					Debug.msg("State: " +  threadarray[i].getState());
					Debug.msg("Daemon: " + threadarray[i].isDaemon());
					Debug.msg("Thread group: " + threadarray[i].getThreadGroup());
					Debug.msg("Thread priority: " + threadarray[i].getPriority());
					Debug.msg("---");
					threadarray[i].interrupt();
				}
			}
	}

	public void prepareShutdown(boolean shutdownThread, boolean shutdownHook) {
		try {
		if ( !already_done_shutdown )
		{
			showActiveThreads();
			already_done_shutdown = true;
			Debug.msg("Shutting down JFritz..."); //$NON-NLS-1$
			closeOpenConnections();
			Debug.msg("Releasing lock");
			if (exitCode != -1 && Main.isInstanceControlEnabled()) {
				File f = new File(Main.SAVE_DIR + Main.LOCK_FILE);
				if (f.exists())
				{
		    	    Debug.msg("Prepare Shutdown: 8");
					f.delete();
				}
				Debug.msg("Multiple instance lock: release lock."); //$NON-NLS-1$
			}

			// This must be the last call, after disposing JFritzWindow nothing
			// is executed at windows-shutdown
			if ( jfritz != null ) {
				jfritz.prepareShutdown(shutdownThread, shutdownHook);
			}
			showActiveThreads();
			Frame[] frames = Frame.getFrames();
			for (int i=0; i< frames.length; i++)
			{
				Debug.msg("Frame: " + frames[i]);
				Debug.msg("Frame name: " + frames[i].getName());
				Debug.msg("Frame visible: " + frames[i].isVisible());
				Debug.msg("Frame displayable: " + frames[i].isDisplayable());
				Debug.msg("---");
			}
		}
		} catch (InterruptedException e) {
        	Thread.currentThread().interrupt();
		}
	}

	/**
	 * function does a command line lookup, gathers all unkown entries
	 *
	 */
	private void doReverseLookup(){
		ReverseLookup.lookup(JFritz.getCallerList().getAllUnknownEntries(false), this, true);
		try{
			ReverseLookup.thread.join();
		}catch(InterruptedException e){
        	Thread.currentThread().interrupt();
		}

	}

	/**
	 * adds the results to the phonebook and saves
	 */
	public void personsFound(Vector<Person> persons){
		if ( persons != null )
			JFritz.getPhonebook().addEntries(persons);
	}

	/**
	 * is called to give progress information
	 */
	public void percentOfLookupDone(float f){
		//TODO: Update the status here!
	}

	/**
	 * is called to save progress
	 */
	public void saveFoundEntries(Vector<Person> persons) {
		if ( persons != null )
			JFritz.getPhonebook().addEntries(persons);
	}

	private static void loadLanguages()
	{
		supported_languages = new Vector<Locale>();
		supported_languages.add(new Locale("de","DE"));
		supported_languages.add(new Locale("en","US"));
		supported_languages.add(new Locale("it","IT"));
		supported_languages.add(new Locale("nl","NL"));
		supported_languages.add(new Locale("pl","PL"));
		supported_languages.add(new Locale("ru","RU"));
	}

	/**
	 * Shows the password dialog
	 *
	 * @param old_password
	 * @return new_password
	 */
	public String showPasswordDialog(String old_password) {
		String password = null;
		AddressPasswordDialog p = new AddressPasswordDialog(null, true);
		p.setPass(old_password);

		if (p.showDialog()) {
			password = p.getPass();
		}
		p.dispose();
		p = null;
		return password;
	}
}