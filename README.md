# Ingegneria del software

Progetto del corso di ingegneria del software del professor Combi @ UniVr - A.A 2021-2022
Pietro Dudine
Davide Rossignolo


## Consegna:

Si vuole progettare un sistema informatico di una agenzia che fornisce servizi di supporto alla ricerca di lavoro stagionale. I lavoratori interessati possono iscriversi al servizio, rivolgendosi agli sportelli dell’agenzia. Il sistema **deve permettere la gestione delle anagrafiche e la ricerca di lavoratori stagionali**, nei settori dell’agricoltura e del turismo.
I responsabili del servizio, dipendenti dell’agenzia, inseriscono i dati dei lavoratori. 
Per ogni lavoratore vengono memorizzati i **dati anagrafici** (nome, cognome, luogo e data di nascita, nazionalità), indirizzo, recapito telefonico personale (se presente), email, le eventuali **specializzazioni/esperienze precedenti** (bagnino, barman, istruttore di nuoto, viticoltore, floricultore), lingue parlate, il tipo di patente di guida e se automunito. Sono inoltre memorizzati i **periodi e le zone** (comuni), per i quali il lavoratore è disponibile. Di ogni lavoratore si memorizzano anche le informazioni di **almeno una persona da avvisare in caso di urgenza**: nome, cognome, telefono, indirizzo email.
I dipendenti dell’agenzia devono autenticarsi per poter accedere al sistema e inserire i dati dei lavoratori. Il sistema permette ai dipendenti dell’agenzia di aggiornare le anagrafiche con tutti i lavori che i lavoratori stagionali hanno svolto negli ultimi 5 anni. Per ogni lavoro svolto vanno registrati: periodo, nome dell’azienda, mansioni svolte, luogo di lavoro, retribuzione lorda giornaliera. 
Per i dipendenti dell’agenzia si memorizzano i dati anagrafici, l’indirizzo email, il telefono e le credenziali di accesso (login e password).
Una volta registrate le informazioni sui lavoratori, il **personale dell’agenzia può effettuare ricerche** rispetto a possibili profili richiesti. In particolare, il sistema deve permettere ai dipendenti di effettuare ricerche per lavoratore, per lingue parlate, periodo di disponibilità, mansioni indicate, luogo di residenza, disponibilità di auto/patente di guida. **Il sistema deve permettere di effettuare ricerche complesse**, attraverso la specifica di differenti condizioni di ricerca (sia in AND che in OR).
