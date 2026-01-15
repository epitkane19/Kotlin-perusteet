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
