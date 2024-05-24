package lessons.java.models;

public class ReceiverModel {
    final String title;
    final String id;

    ReceiverModel(String id, String title) {
        this.id = id;
        this.title = title;
    }
    @Override
    public String toString() {
        return "ReceiverModel{" +
                "title='" + title + '\'' +
                ", id='" + id + '\'' +
                '}';
    }



}
