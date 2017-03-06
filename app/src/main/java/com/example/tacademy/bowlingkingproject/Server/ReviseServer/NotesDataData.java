package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-03-02.
 */

public class NotesDataData {
    int noteId;
    String noteDate; // "2017/02/12 04:12:00"
    String noteContent;
    //int fromUserIx;
    String fromUserIx;
    String fromUserName;
    //int toUserIx;
    String toUserIx;
    String toUserName;


    public NotesDataData(int noteId, String noteDate, String noteContent, String fromUserIx, String fromUserName, String toUserIx, String toUserName) {
        this.noteId = noteId;
        this.noteDate = noteDate;
        this.noteContent = noteContent;
        this.fromUserIx = fromUserIx;
        this.fromUserName = fromUserName;
        this.toUserIx = toUserIx;
        this.toUserName = toUserName;
    }

    @Override
    public String toString() {
        return "NotesDataData{" +
                "noteId=" + noteId +
                ", noteDate='" + noteDate + '\'' +
                ", noteContent='" + noteContent + '\'' +
                ", fromUserIx='" + fromUserIx + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", toUserIx='" + toUserIx + '\'' +
                ", toUserName='" + toUserName + '\'' +
                '}';
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public String getFromUserIx() {
        return fromUserIx;
    }

    public void setFromUserIx(String fromUserIx) {
        this.fromUserIx = fromUserIx;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getToUserIx() {
        return toUserIx;
    }

    public void setToUserIx(String toUserIx) {
        this.toUserIx = toUserIx;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }
}
