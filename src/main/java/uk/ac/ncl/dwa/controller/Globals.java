package uk.ac.ncl.dwa.controller;

import uk.ac.ncl.dwa.model.Instructors;
import uk.ac.ncl.dwa.model.Rooms;
import uk.ac.ncl.dwa.model.Workshops;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * This is a singleton and if you don't like singletons you can f*&£ off.
 * It is the only way to make things work reliably and without confusing
 * complexity.
 */
public class Globals {
    static Globals globals;
    Boolean dirty = false;
    Workshops workshops = new Workshops();
    Rooms rooms = new Rooms();
    Instructors instructors = new Instructors();
    String connectionString;
    Hashtable<String, DirtyRows> dirtyRows = new Hashtable<>();
    Set<Integer> editedRows = new HashSet<>();
    Set<Integer> insertedRows = new HashSet<>();

    /**
     * Dummy contructor to prevent instantiation.
     */
    private Globals() {
    }

    /**
     * Returns the single instance of the Globals class.
     *
     * @return the single instance of Globals
     */
    public static Globals getInstance() {
        if (globals == null) {
            globals = new Globals();
            globals.dirtyRows.put("workshops", new DirtyRows());
            globals.dirtyRows.put("rooms", new DirtyRows());
            globals.dirtyRows.put("instructors", new DirtyRows());
        }
        return globals;
    }


    public Boolean getDirty() {
        return dirty;
    }

    public void setDirty(Boolean dirty) {
        this.dirty = dirty;
    }

    public Set<Integer> getEditedRows(String key) {
        return dirtyRows.get(key).getEditedRows();
    }

    public Workshops getWorkshops() {
        return workshops;
    }

    public void setWorkshops(Workshops workshops) {
        this.workshops = workshops;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public Set<Integer> getInsertedRows(String key) {
        return dirtyRows.get(key).getInsertedRows();
    }

    public Rooms getRooms() {
        return rooms;
    }

    public Instructors getInstructors() {
        return instructors;
    }
}
