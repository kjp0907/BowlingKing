package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

/**
 * Created by Tacademy on 2017-03-02.
 */

public class ResWhisperModel {
    int code;
    String message;
    NotesData notesData;

    public ResWhisperModel(int code, String message, NotesData notesData) {
        this.code = code;
        this.message = message;
        this.notesData = notesData;
    }

    @Override
    public String toString() {
        return "ResWhisperModel{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", notesData=" + notesData +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotesData getNotesData() {
        return notesData;
    }

    public void setNotesData(NotesData notesData) {
        this.notesData = notesData;
    }
}
