package gitlet;

// TODO: any imports you need here

import java.io.File;
import java.io.Serializable;
import java.util.*; // TODO: You'll likely use this in this class
import static gitlet.Repository.*;
import static gitlet.Utils.*;


/**
 * Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 * @author TODO
 */
public class Commit implements Serializable {
    /**
     * TODO: add instance variables here.
     *
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /**
     * The message of this Commit.
     */
    private String message;
    private HashMap<String, File> files;
    private Date date;
    private Commit parent;
    private File thisCommit;
    private String sha;

    public String branch;
    private Commit(String message, Date date, Commit parent, String sha) {
        this.message = message;
        this.date = date;
        this.parent = parent;
        this.sha = sha;
    }

    public Commit initCommit() {
        Date newDate = new Date(0);
        String startMessage = "initial commit";
        String branch = "master";
        Commit parent = null;
        String sha = sha1(newDate.toString(), startMessage, branch);
        Commit newCommit = new Commit(startMessage, newDate, parent, sha);
        thisCommit = join(CWD, sha, ".txt");
        writeObject(thisCommit, newCommit);
        return newCommit;
    }

    public void saveCommit() {
        writeObject(thisCommit, this);
    }
    /* TODO: fill in the rest of this class. */

    public File getFile(String sha) {
        return files.getOrDefault(sha, null);
    }
}
