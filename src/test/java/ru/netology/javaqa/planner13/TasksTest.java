package ru.netology.javaqa.planner13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void matchesSimpleTaskTest() {
        SimpleTask simpleTask = new SimpleTask(7, "Найти работу");
        Assertions.assertTrue(simpleTask.matches("Найти работу"));
        Assertions.assertFalse(simpleTask.matches("Приготовить суп"));
    }

    @Test
    public void matchesMeetingTest() {
        Meeting meeting = new Meeting(
                777,
                "Трудности бытия",
                "Новая жизнь",
                "После дождичка в четверг"
        );
        Assertions.assertTrue(meeting.matches("жизнь"));
        Assertions.assertFalse(meeting.matches("суп"));
    }

    @Test
    public void matchesEpicTest() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(66, subtasks);
        Assertions.assertTrue(epic.matches("Хлеб"));
        Assertions.assertFalse(epic.matches("суп"));
    }
}
