package com.epitkane19.week1.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.epitkane19.week1.viewmodel.TaskViewModel
import com.epitkane19.week1.model.Task
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen(
    taskViewModel: TaskViewModel,
    navigateToBack: () -> Unit
) {
    val tasks = taskViewModel.tasks
    val groupedTasks = tasks.groupBy { it.dueDate ?: "No date" }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Calendar") },
                navigationIcon = {
                    IconButton(onClick = navigateToBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            groupedTasks.forEach { (date, tasksForDate) ->
                item {
                    Text(
                        text = date,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                items(tasksForDate) { task ->
                    CalendarTaskRow(task)
                }
            }
        }
    }
}

@Composable
fun CalendarTaskRow(task: Task) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(task.title, style = MaterialTheme.typography.bodyLarge)
        task.description?.let {
            Text(it, style = MaterialTheme.typography.bodySmall)
        }
    }
}

