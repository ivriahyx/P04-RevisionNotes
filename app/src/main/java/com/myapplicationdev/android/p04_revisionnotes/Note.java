package com.myapplicationdev.android.p04_revisionnotes;

public class Note {

	private int id;
    private String notesContent;
    private int stars;

    public Note(int id, String notesContent, int stars) {
        this.id = id;
        this.notesContent = notesContent;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotesContent() {
        return notesContent;
    }

    public void setNotesContent(String notesContent) {
        this.notesContent = notesContent;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
