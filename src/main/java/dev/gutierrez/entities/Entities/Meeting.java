package dev.gutierrez.entities.Entities;

public class Meeting {
    private int meeting_id;
    private String address;
    private int time;
    private String summary;

    public Meeting() {
    }

    public Meeting(int meeting_id, String address, int time, String summary) {
        this.meeting_id = meeting_id;
        this.address = address;
        this.time = time;
        this.summary = summary;
    }

    public int getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(int meeting_id) {
        this.meeting_id = meeting_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meeting_id=" + meeting_id +
                ", address='" + address + '\'' +
                ", time=" + time +
                ", summary='" + summary + '\'' +
                '}';
    }
}
