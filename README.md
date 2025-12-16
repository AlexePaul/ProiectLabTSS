# TSS Proiect laborator

## Validator de Parolă

## Alexe Vasile Paul, Grupa 505 (BDTS)

### Descrierea Proiectului

Acest proiect implementează un validator de parolă care verifică dacă o parolă introdusă de utilizator respectă anumite criterii de securitate. Acesta primește un string, reprezentând parola, și returnează un `boolean` care reprezintă dacă parola este validă sau nu.

### Input

Input-ul este un șir de caractere `string`. Validatorul primește o singură intrare: parola introdusă de utilizator, reprezentată ca un `string`.

### Output

Output-ul este un boolean `true/false`. Validatorul returnează `true` dacă parola este validă conform criteriilor specificate și `false` în caz contrar.

### Criterii de Validare

Parola este considerată validă dacă îndeplinește următoarele condiții:

1. Parola nu trebuie să fie `null`
2. Lungimea parolei trebuie să fie intre 8 și 20 de caractere (inclusiv) `8 <= length <= 20`
3. Parola trebuie să conțină:
   - cel puțin o literă mare `[A-Z]`
   - cel puțin o literă mică `[a-z]`
   - cel puțin o cifră `[0-9]`
   - cel puțin un caracter special `[!@#$%^&*]`

### Cerinta 1: Generarea datelor de test

#### a) Equivalence Partitioning

Pentru a testa validatorul de parolă, am identificat următoarele partiții de echivalență (EP):


| ID  | Parolă                    | Partiție acoperită          | Rezultat așteptat |
| --- | -------------------------- | ----------------------------- | ------------------ |
| EP1 | null                       | EP1 (parolă null)            | false              |
| EP2 | "Ab1!"                     | EP2 (lungime < 8)             | false              |
| EP3 | "Ab1!abcdabcdabcdabcdabcd" | EP3 (lungime > 20)            | false              |
| EP4 | "ab1!abcd"                 | EP4 (fără literă mare)     | false              |
| EP5 | "AB1!ABCD"                 | EP5 (fără literă mică)    | false              |
| EP6 | "Abc!abcd"                 | EP6 (fără cifră)           | false              |
| EP7 | "Ab1abcdE"                 | EP7 (fără caracter special) | false              |
| EP8 | "Ab1!abcd"                 | EP8 (toate valide)            | true               |

Fiecare partiție de echivalență a fost reprezentată printr-un singur caz de test, presupunând că toate valorile din aceeași clasă sunt tratate identic de către program.

Fiecare caz de test din tabelul de mai sus va fi implementat în clasa [PasswordValidatorEPTest](./PasswordValidator/src/test/java/validator/PasswordValidatorEPTest.java) folosind JUnit.

#### b) Boundary Value Analysis

Boundary Value Analysis testează valorile de la limitele intervalului de intrare, deoarece acestea sunt punctele critice unde apar cele mai multe erori.

Criteriu testat: lungimea parolei este intre 8 si 20 de caractere (inclusiv). `8 <= length <= 20`


| Test ID | Parolă exemplu         | Lungime | Rezultat |
| ------- | ----------------------- | ------- | -------- |
| BVA1    | "Ab1!abc"               | 7       | false    |
| BVA2    | "Ab1!abcd"              | 8       | true     |
| BVA3    | "Ab1!abcde"             | 9       | true     |
| BVA4    | "Ab1!abcdefghijklmno"   | 19      | true     |
| BVA5    | "Ab1!abcdefghijklmnop"  | 20      | true     |
| BVA6    | "Ab1!abcdefghijklmnopq" | 21      | false    |

Toate celelalte condiții (litere, cifre, caractere speciale) sunt respectate în aceste exemple, pentru a testa strict limita lungimii parolei.

Fiecare caz de test din tabelul de mai sus va fi implementat în clasa [PasswordValidatorBVATest](./PasswordValidator/src/test/java/validator/PasswordValidatorBVATest.java) folosind JUnit.

#### c) Cause–Effect Graphing

Cause–Effect Graphing se folosește pentru a transforma cerințele funcționale într-un graf logic care leagă cauzele (input-uri/condiții) de efecte (output/decizii).

- Cause (C) = condiție de intrare
- Effect (E) = rezultat așteptat

##### Cauze (input conditions)


| Cod cauză | Descriere                           |
| ---------- | ----------------------------------- |
| C1         | Parola este null                    |
| C2         | Lungimea parolei < 8                |
| C3         | Lungimea parolei > 20               |
| C4         | Parola nu conține literă mare     |
| C5         | Parola nu conține literă mică    |
| C6         | Parola nu conține cifră           |
| C7         | Parola nu conține caracter special |

##### Efect (output)


| Cod efect | Descriere                     |
| --------- | ----------------------------- |
| E1        | Parola este invalidă (false) |
| E2        | Parola este validă (true)    |

##### Tabel de decizie


| Test ID | C1 | C2 | C3 | C4 | C5 | C6 | C7 | E1 (false) | E2 (true) | Parolă exemplu             |
| ------- | -- | -- | -- | -- | -- | -- | -- | ---------- | --------- | --------------------------- |
| CE1     | 1  | 0  | 0  | 0  | 0  | 0  | 0  | 1          | 0         | null                        |
| CE2     | 0  | 1  | 0  | 0  | 0  | 0  | 0  | 1          | 0         | "Ab1!a"                     |
| CE3     | 0  | 0  | 1  | 0  | 0  | 0  | 0  | 1          | 0         | "Ab1!abcdefghijklmnopqrstu" |
| CE4     | 0  | 0  | 0  | 1  | 0  | 0  | 0  | 1          | 0         | "ab1!abcd"                  |
| CE5     | 0  | 0  | 0  | 0  | 1  | 0  | 0  | 1          | 0         | "AB1!ABCD"                  |
| CE6     | 0  | 0  | 0  | 0  | 0  | 1  | 0  | 1          | 0         | "Abc!abcd"                  |
| CE7     | 0  | 0  | 0  | 0  | 0  | 0  | 1  | 1          | 0         | "Ab1abcdE"                  |
| CE8     | 0  | 0  | 0  | 0  | 0  | 0  | 0  | 0          | 1         | "Ab1!abcd"                  |

Fiecare caz de test din tabelul de mai sus va fi implementat în clasa [PasswordValidatorCETest](./PasswordValidator/src/test/java/validator/PasswordValidatorCEGTest.java) folosind JUnit.

### Cerinta 2: Calcularea acoperirii testelor si comentarea rezultatelor

#### a) Calcularea acoperirii testelor


| Set Teste | Instructions Covered | % Instructions | Branches Covered | % Branches | Lines Covered | % Lines | Complexity Covered | % Complexity |
| --------- | -------------------- | -------------- | ---------------- | ---------- | ------------- | ------- | ------------------ | ------------ |
| EP        | 78                   | 96.3%          | 23               | 95.8%      | 21            | 95.5%   | 12                 | 85.7%        |
| BVA       | 75                   | 92.6%          | 18               | 75.0%      | 20            | 90.9%   | 7                  | 50.0%        |
| CEG       | 78                   | 96.3%          | 23               | 95.8%      | 21            | 95.5%   | 12                 | 85.7%        |

Pentru a calcula acoperirea testelor, am rulat individual fiecare fisier de test folosind comenzile:

- `mvn clean test -Dtest=PasswordValidatorEPTest -Djacoco.destFile=target/jacoco-ep.exec`
- `mvn clean test -Dtest=PasswordValidatorBVATest -Djacoco.destFile=target/jacoco-bva.exec`
- `mvn clean test -Dtest=PasswordValidatorCEGTest -Djacoco.destFile=target/jacoco-ceg.exec`

Aceste comenzi generează fișiere de execuție JaCoCo (`.exec`) pentru fiecare set de teste. Pentru a genera rapoartele de acoperire, am folosit comanda:

- `mvn jacoco:report -Djacoco.dataFile="target/jacoco-ep.exec"`
- `mvn jacoco:report -Djacoco.dataFile="target/jacoco-bva.exec"`
- `mvn jacoco:report -Djacoco.dataFile="target/jacoco-ceg.exec"`

Rapoartele de acoperire au fost generate în format HTML și pot fi găsite în directoarele:

- [./PasswordValidator/CoverageCalculations/EP/jacoco/index.html](./PasswordValidator/CoverageCalculations/EP/jacoco/index.html) - pentru Equivalence Partitioning
- [./PasswordValidator/CoverageCalculations/BVA/jacoco/index.html](./PasswordValidator/CoverageCalculations/BVA/jacoco/index.html) - pentru Boundary Value Analysis
- [./PasswordValidator/CoverageCalculations/CEG/jacoco/index.html](./PasswordValidator/CoverageCalculations/CEG/jacoco/index.html) - pentru Cause–Effect Graphing

#### b) Concluzii

Pentru aceasta aplicatie, fiind una relativ simpla, toate cele trei tehnici de testare au oferit o acoperire ridicata a codului sursa.

Consider ca motivul pentru aceasta acoperire ridicata este faptul ca singurul mod prin care aplicatia va returna valoarea `true`, acceptand astfel o parola ca fiind valida, este daca trece prin toate liniile din codul sursa fara a returna mai devreme cu `false`.

In concluzie, in momentul in care un test are ca `input` o parola valida, va face astfel acoperirea sa fie ridicata. Fiecare set de teste contine si o parola valida, astfel ajungem in situatia in care fiecare metoda de testare are coverage aproape 100% (in cazul acestei aplicatii, motivul de ce totusi nu ajunge niciuna din cele 3 la 100% este faptul ca nu este testat constructorul clasei, metoda fiind statica).

Putem in schimb sa observam ca desi toate cele 3 metode de testare au obtinut valori mari pentru acoperire, in cazul `BVA` aceste valori sunt putin mai mici. Acest fapt se datoreaza lipsei testarii cazului cu `password=null`, deoarece am testat doar lungimi 7, 8, 9, 19, 20, 21.
