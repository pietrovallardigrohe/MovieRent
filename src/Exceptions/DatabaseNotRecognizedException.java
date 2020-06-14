package Exceptions;

public class DatabaseNotRecognizedException extends RuntimeException{

    private String database;

    public DatabaseNotRecognizedException(String database) {
        this.database = database;
    }

    @Override
    public String toString() {
        return String.format("Database not recognized, received: \"%s\"", database);
    }

}
