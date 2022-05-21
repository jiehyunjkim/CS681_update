package edu.umb.cs681.hw15;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;


class FileSystem{
	private static FileSystem INSTANCE;
    ConcurrentLinkedQueue<Directory> directory = new ConcurrentLinkedQueue<>();
	
	private static FileSystem getFileSystem() {
		if (INSTANCE == null) {
			INSTANCE = new FileSystem();
		}
		return INSTANCE;}
	
	public ConcurrentLinkedQueue<Directory>  getRootDirs() {
		return this.directory;
	}
	public void appendRootDir(Directory root) {
		directory.add(root);
	}
}

abstract class FSElement{
	public String name;
	public int size;
	public LocalDateTime creationTime;
	private Directory parent;
	
	public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
	}
	
	public FSElement() {};
	public Directory getParent() {
		return this.parent;
	}
	public void setParent(Directory par) {
		this.parent = par;
	}
	public int getSize() { return this.size; }
	public boolean isDirectory() {
		return true;
	}
	
}


class Directory extends FSElement{
	ConcurrentLinkedQueue<FSElement> children;
	private FileSystem filesystem;
	
	Directory(Directory parent, String name, int size, LocalDateTime creationTime){
		super(parent, name, size, creationTime);
		
		children = new ConcurrentLinkedQueue<>();
	}

	private ConcurrentLinkedQueue<FSElement> getChildren(){
		return this.children;
	};
	private void appendChild(FSElement ac) {
		this.children.add(ac);
	};
	private int countChildren() {	
		int count = 0;
		return count;
	};
	private String getName() {
		return this.name;
	}
	public int getSize() {
		return this.size;
	}
	public LocalDateTime getCreationTime() {
		return this.creationTime;
	}
	private LinkedList<Directory> getSubDirectories(){
		return null;
	}
	private LinkedList<File> getFiles(){
		return null;
	}
	private int getTotalSize() {
		return size;
	};
	public boolean isDirectory() {
		return true;
	}
}

class File extends FSElement{
	File(Directory parent, String name, int size, LocalDateTime creationTime){
		super(parent, name, size, creationTime);
	}
	
	public boolean isDirectory() {
		return false;
	}
}