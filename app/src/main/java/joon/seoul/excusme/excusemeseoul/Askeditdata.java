package joon.seoul.excusme.excusemeseoul;

public class Askeditdata {

    String title;
    String body;
    String writerID;
    String contextID;

    public Askeditdata(String title, String body, String writerID, String contextID) {
        this.title = title;
        this.body = body;
        this.writerID = writerID;
        this.contextID = contextID;
    }

    private Askeditdata(){

    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getWriterID() {
        return writerID;
    }

    public String getContextID() {
        return contextID;
    }
}
