import java.util.ArrayList;
import java.util.List;

public class Events {
    private String eventName;
    private String eventDate;
    private String eventLocation;
    public List<String> participants;

    public Events(String eventName, String eventDate, String eventLocation) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.participants = new ArrayList<>();
    }

    public String getEventName() {
        return eventName;
    }

    public String  getEventDate() {
        return eventDate;
    }
    public String getEventLocation() {
        return eventLocation;
    }
    public List<String> getParticipants() {
        return participants;
    }

    public void addParticipant(String participantName) {
        participants.add(participantName);
    }

    public void displayEventDetails() {
        System.out.println("--------------------OUR EVENT----------------------");
        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Event Location: " + eventLocation);
    }
}
