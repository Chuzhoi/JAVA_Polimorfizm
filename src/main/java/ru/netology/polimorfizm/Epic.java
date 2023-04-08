package ru.netology.polimorfizm;
public class Epic extends Task {
    private String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // заполнение своих полей
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String task : subtasks) {
            if (task.contains(query)) {
                return true;
            }
        }

        return false;
    }
}
