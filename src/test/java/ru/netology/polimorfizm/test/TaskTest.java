package ru.netology.polimorfizm.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.polimorfizm.*;

public class TaskTest {

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
    public void simpleTaskTrueTest() {

        SimpleTask simpleTask = new SimpleTask(4, "Сделать домашку");

        Todos todos = new Todos();
        todos.add(simpleTask);

        boolean expected = true;
        boolean actual = simpleTask.matches("Сделать");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void simpleTaskFalseTest() {

        SimpleTask simpleTask = new SimpleTask(4, "Сделать домашку");

        Todos todos = new Todos();
        todos.add(simpleTask);

        boolean expected = false;
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void EpicTrueTest() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Булка"};
        Epic epic = new Epic(55, subtasks);


        Todos todos = new Todos();
        todos.add(epic);

        boolean expected = true;
        boolean actual = epic.matches("Булка");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void EpicFalseTest() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Булка"};
        Epic epic = new Epic(55, subtasks);


        Todos todos = new Todos();
        todos.add(epic);

        boolean expected = false;
        boolean actual = epic.matches("Картошка");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void MeetingTrueTest() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        boolean expected = true;
        boolean actual = meeting.matches("Приложение");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void MeetingFalseTest() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        boolean expected = false;
        boolean actual = meeting.matches("Булка");
        Assertions.assertEquals(expected, actual);

    }

}








