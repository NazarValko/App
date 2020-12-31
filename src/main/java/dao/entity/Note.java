package dao.entity;


import java.util.Date;
import java.util.Objects;

public class Note {
    private long id;
    private long userId;
    private String note;
    private Date createdAt;

    public Note() {
    }

    public Note(long id, long userId, String note, Date createdAt) {
        this.id = id;
        this.userId = userId;
        this.note = note;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", userId=" + userId +
                ", note='" + note + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note1 = (Note) o;
        return id == note1.id &&
                userId == note1.userId &&
                Objects.equals(note, note1.note) &&
                Objects.equals(createdAt, note1.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, note, createdAt);
    }
}

