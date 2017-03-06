package com.example.tacademy.bowlingkingproject.Server.ReviseServer;

import java.util.ArrayList;

/**
 * Created by Tacademy on 2017-03-02.
 */

public class NotesData {
    int totalPage;
    int currentPage;
    int rowsPerPage;
    ArrayList<NotesDataData> data;

    public NotesData(int totalPage, int currentPage, int rowsPerPage, ArrayList<NotesDataData> data) {
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.rowsPerPage = rowsPerPage;
        this.data = data;
    }

    @Override
    public String toString() {
        return "NotesData{" +
                "data=" + data +
                ", rowsPerPage=" + rowsPerPage +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                '}';
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public ArrayList<NotesDataData> getData() {
        return data;
    }

    public void setData(ArrayList<NotesDataData> data) {
        this.data = data;
    }
}
