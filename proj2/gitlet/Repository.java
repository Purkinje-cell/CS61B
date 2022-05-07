package gitlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import gitlet.*;

import static gitlet.Commit.*;
import static gitlet.Utils.*;
import gitlet.GitletException.*;
// TODO: any imports you need here

/** Represents a gitlet repository.
 *  this class declares all the gitlet repository file structure
 *  does at a high level.
 *
 *  @author Purkinje-Cell
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");
    /** directory to save stage files*/
    public static final File STAGED_DIR = join(GITLET_DIR, "staged");
    /* directory to save removed files*/
    public static final File REMOVE_DIR = join(GITLET_DIR, "removed");
    /* directory to save history versions of files*/
    public static final File BLOB_DIR = join(GITLET_DIR, "blob");
    /* directory to save commitments */
    public static final File COMMIT_DIR = join(GITLET_DIR, "commit");

    public static Commit currentCommit;
    /* TODO: fill in the rest of this class. */

    /*initialize the gitlet repository*/
    public static void init() {
        if (!GITLET_DIR.isDirectory()) {
            GITLET_DIR.mkdir();
            STAGED_DIR.mkdir();
            REMOVE_DIR.mkdir();
            BLOB_DIR.mkdir();
            COMMIT_DIR.mkdir();
            currentCommit = currentCommit.initCommit();
        } else {
            throw new GitletException("A Gitlet version-control system already exists in the current directory.");
        }
    }

    public static void add(String filename) throws IOException {
        File addFile = join(STAGED_DIR, filename);
        File currentFile = join(CWD, filename);
        if (currentCommit.getFile(sha1(filename)) != null) {

        } else {
            addFile.createNewFile();
            writeContents(addFile, readContentsAsString(currentFile));
        }

    }

    public static void commit(String message) {

    }
}
