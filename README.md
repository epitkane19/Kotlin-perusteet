# Viikkotehtävä 1 Kotlin-perusteet

## Datamalli

Sovelluksessa käytetään `Task`-data classia, joka kuvaa yksittäisen tehtävän:

```kotlin
data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val priority: Int,
    val dueDate: String,
    val done: Boolean
)
```

Sovellus sisältää seuraavat Kotlin-funktiot:

```kotlin
addTask(list, task) //lisää taskin
removeTask(list, id) //poistaa taskin
toggleDone(list, id) //vaihtaa tilaa
filterByDone(list, done) //suodattaa taskit tilan mukaan
sortByDueDate(list) //järjestää tehtävät eräpäivän mukaan
```

Videodemo week1:

https://youtu.be/Hqd4p1nCbls?si=xil7WXYfwOqRg5fg

# Viikkotehtävä 2 Kotlin-perusteet: ViewModel

Composessa tila määrittää mitä käyttöliittymä näyttää eli kun se muuttuu, Compose automaattisesti päivittää UI:n vastaamaan uutta tilaa.

ViewModel on parempi kuin pelkkä remember sillä se säilyttää paremmin sovelluksen dataa. Remember unohtaa datan kun composable poistuu ruudulta, esim. puhelinta kääntäessä. ViewModel säilyttää dataa vaikka composable häviää ja luodaan uudestaan.

Videodemo week2:

https://youtu.be/ShRT1eF2pLs?si=Y1h4av4dge9ntOnG

# Viikkotehtävä 3 Kotlin-perusteet: MVVM-arkkitehtuuri

MVVM on Model-View-ViewModel arkkitehtuurimalli, jossa sovellus jaetaan kolmeen eri edellä mainittuun kerrokseen. Model sisältää dataluokat ja logiikan, View sisältää Jetpack Compose-pohjaisen käyttöliittymän ja ViewModel yhdistää Modelin ja Viewin. ViewModel myös sisältää funktiot kuten addTask ja removeTask. MVVM on hyödyllinen Compose-sovelluksissa sillä UI pysyy yksinkertaisena Composen tilapohjaisuuden vuoksi. Muutokset koodiin on myös helpompi toteuttaa sillä MVVM tarjoaa selkeän kerrosjaon.

StateFlow on Kotlinin mutableStateOf tavoin toinen tapa hoitaa tilanhallinta. Se sisältää aina viimeisimmän arvon ja lähettää uuden arvon kaikille kuuntelijoille.

Videodemo week3:

https://youtu.be/vYCKQIqI860?si=xMmtbyvzO6dOh0iM

# Viikkotehtävä 4 Kotlin-perusteet: Navigaatio

Navigointi mahdollistaa eri ruuduilla liikkumisen sovelluksessa. Compose tarvitsee navigaatio-komponentin mikä määrittelee mikä ruutu on sillä hetkellä olemassa ja miten siirrytään toiseen.

NavController ohjaa siirtymisen toiselle ruudulle ja NavHost ylläpitää nykyistä ruutua. Yhdessä ne luovat navigointi-komponentin.

Navigointi home screenin ja calendar screenin välillä hoidetaan simppelillä napilla. Icons paketista löytyy kalenterikuvake mistä napsauttamalla pääsee kalenteriruudulle. Sieltä voi palata takaisin joko painamalla nuolinäppäintä tai puhelimen omaa back buttonia.

Arkkitehtuuri:

Koska molemmat ruudut käyttävät samaa ViewModelia (TaskViewModel), myös tieto välittyy niiden välillä helposti sillä päivitetty tieto näkyy automaattisesti myös toiselle ruudulle.

Toteutus:

CalendarScreen saa taskit seuraavalla komennolla ViewModelista ja ne sitten sortataan määräajan mukaan:
```kotlin
val tasks = taskViewModel.tasks
val groupedTasks = tasks.groupBy { it.dueDate ?: "No date" }
```
Syntyneestä mapista luodaan sitten luettava lista.

AddTaskDialog toiminto lainaa vähän muokattua koodia aikaisemman viikon edit task toiminnosta (DetailScreen) mutta sille ei ole tehty erillistä tiedostoa, vaan se on lisätty HomeScreen tiedoston loppuun. Molemmat käyttävät AlertDialog templatea eli määritellään title, description ja dueDate sekä TextFieldit jokaiselle. confirmButton toiminto hoitaa napit tallentamiselle, poistamiselle ja peruuttamiselle.

Videodemo week4:

https://www.youtube.com/watch?v=AalT3C4qWWE
