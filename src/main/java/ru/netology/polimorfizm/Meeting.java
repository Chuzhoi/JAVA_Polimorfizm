package ru.netology.polimorfizm;
public class Meeting extends Task {
    private String topic;
    private String project;
    private String start;

    public Meeting(int id, String topic, String project, String start) {
        super(id); // вызов родительского конструктора
        this.topic = topic;// заполнение своих полей
        this.project = project;
        this.start = start;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }

}

