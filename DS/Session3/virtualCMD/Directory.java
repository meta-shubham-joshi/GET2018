package virtualCMD;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * class having the functionality of the directory.
 * @author shubhamjoshi
 *
 */
class Directory {
    private String name;
    private Directory parent;
    private String path = "";
    private Date timeStamp;
    private List<Directory> listOfSubDirectories;

    /**
     * Constructor to initialise the name and parent of a directory.
     * @params name- name of the directory.
     * @params parent- parent directory name.
     */
    public Directory(String name, Directory parent, String path) {
        this.name = name;
        this.parent = parent;
        this.path = path;
        timeStamp = new Date();
        listOfSubDirectories = new ArrayList<Directory>();
    }
    
    /**
     * @return the path
     */
    public String getPath(){
    	return this.path;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the parent
     */
    public Directory getParent() {
        return parent;
    }

    /**
     * @return the timeStamp
     */
    public Date getTimeStamp() {
        return timeStamp;
    }

    /**
     * @return the listOfSubDirectories
     */
    public List<Directory> getListOfSubDirectories() {
        return listOfSubDirectories;
    }

    /**
     * Adding the directory to the subdirectory.
     */
    public void addItem(Directory item) {
        listOfSubDirectories.add(item);
    }

}
