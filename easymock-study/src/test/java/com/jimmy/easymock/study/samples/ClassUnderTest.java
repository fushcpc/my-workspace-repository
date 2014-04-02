package com.jimmy.easymock.study.samples;

public class ClassUnderTest {
    private Collaborator listener;

    public void setListener(Collaborator listener) {
        this.listener = listener;
    }

    public void addDocument(String title, byte[] document) {
    }

    public boolean removeDocument(String title) {
        listener.documentRemoved(title);
        return true;
    }

    public boolean removeDocuments(String[] titles) {
        return false;
    }

}
