# O projektu

**DPPnews** poskytuje **aplikační rozhraní** v podobě **RESTful webových služeb**, které zprostředkovává přístup k datům o mimořádných událostech v pražské hromadné dopravě.

Informace o mimořádných událostech jsou získávány z webových stránek Dopravního podniku hlavního města Prahy. Jejich aktuálnost zaručuje stále se opakující načítání stránek, které probíhá každou minutu. Informace o každé nové mimořádnosti či o změně stavu některé z aktuálně trvajících jsou pak mimo jiné publikovány na Twitter účtu [@DPPnews](http://twitter.com/DPPnews).

Veškerá data jsou archivována, takže je možné získat přehled mimořádných událostí v libovolném dni roku, a to 4. listopadem 2011 počínaje.

Výkonná aplikace je napsaná v programovacím jazyce Java a je provozována na platformě Google App Engine.

# Co zde najdete?

Najdete zde dokumentaci k DPPnews, issue tracking a zdrojové kódy výkonné aplikace, včetně ontologie popisující mimořádné události v hromadné dopravě.

# Jak začít

Nejprve si pročtěte dokumentaci na této [wiki](https://github.com/jirimasek/DPPnews/wiki).
Na stránce [RESTful zdroje](https://github.com/jirimasek/DPPnews/wiki) najdete adresy jednotlivých zdrojů webové služby, podporované parametry, datové typy apod. Základní URI DPPnews API je http://dpp-news.appspot.com/api/v1/.
Pokud narazíte na chybu, napište prosím chybový report.