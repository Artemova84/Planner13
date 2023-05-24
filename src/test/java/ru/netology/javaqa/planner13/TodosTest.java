package ru.netology.javaqa.planner13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTodosTest() {
        Todos todos = new Todos();
        Task[] expected = {};
        Task[] actual = todos.search("дождичка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTodosTest2() {
        SimpleTask simpleTask = new SimpleTask(7, "Найти работу");
        Todos todos = new Todos();
        todos.add(simpleTask);
        Task[] expected = {simpleTask};
        Task[] actual = todos.search("работу");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTodosTest3() {
        Todos todos = new Todos();
        Meeting meeting = new Meeting(
                777,
                "Трудности бытия",
                "Новая жизнь",
                "После дождичка в четверг");
        todos.add(meeting);
        Task[] expected = {};
        Task[] actual = todos.search("После дождичка в четверг");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTodosTest4() {
        Todos todos = new Todos();
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(66, subtasks);
        todos.add(epic);
        Task[] expected = {epic};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }
}
