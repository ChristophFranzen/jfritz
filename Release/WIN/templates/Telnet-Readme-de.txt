Ab Firmwareversion xx.03.96 ist auf der FritzBox schon ein Anrufmonitor integriert. 
F�r diesen Anrufmonitor (FRITZ!Box-Anrufmonitor) wird kein Telnet-Zugang ben�tigt.

F�r �ltere Firmwareversionen und die �lteren Anrufmonitore (Telnet-, Syslog-,YAC- und Callmessage-Anrufmonitor) wird ein Telnetzugang zur FritzBox ben�tigt.
1. Auf http://fritz.box gehen.
2. Bei fritz.box->System->Firmware-Update die telnet-ar7login-reset-debug.tar (befindet sich im JFritz-Installationsverzeichnis) ausw�hlen, und Firmware-Update starten. Es erscheint die Meldung "Update fehlgeschlagen. Kein Fehler", und die Box startet automatisch neu.
3. Nun l�uft alles wieder wie gewohnt, au�erdem ist Telnet aktiv, und es wird beim Anmelden per telnet das gleiche Passwort abgefragt, welches in der html-Oberfl�che eingerichtet wurde. Auch nach einem Neustart der FritzBox wird der Telnet-daemon wieder gestartet.
4. Um den Telnet-Zugang wieder zu deaktivieren (aus welchem Grund auch immer...), mit Telnet anmelden und
echo > /var/flash/debug.cfg
/sbin/reboot
eingeben