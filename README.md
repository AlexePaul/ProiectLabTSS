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
2. Lungimea parolei trebuie să fie peste 8 caractere
3. Parola trebuie să conțină:
   - cel puțin o literă mare `[A-Z]`
   - cel puțin o literă mică `[a-z]`
   - cel puțin o cifră `[0-9]`
   - cel puțin un caracter special `[!@#$%^&*]`
