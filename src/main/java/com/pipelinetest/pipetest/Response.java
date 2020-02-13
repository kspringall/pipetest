package com.pipelinetest.pipetest;

public class Response {

    private final long id;
    private final String message;

    public Response(long id) {
        this.id = id;
        this.message = "";
    }

    public Response(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getMessage() { return message; }

    // Creating toString
    @Override
    public String toString()
    {
        return "{id="
                + id
                + ", message=\""
                + message + "\"}";
    }

}

