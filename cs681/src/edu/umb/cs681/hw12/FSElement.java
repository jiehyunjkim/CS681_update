package edu.umb.cs681.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;


class FileSystem{
	private static FileSystem INSTANCE = new FileSystem();
	private FileSystem() { }
	
	private static FileSystem getFileSystem() {
		return INSTANCE;}
	
	public LinkedList<Directory> getRootDirs() {
		return null;
	}
	public void appendRootDir() {
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
	private FSElement child;
	private LinkedList<FSElement> children;
	private int count;
	public int size;
	
	Directory(Directory parent, String name, int size, LocalDateTime creationTime){
		super(parent, name, size, creationTime);
	}

	private LinkedList<FSElement> getChildren(){
		return this.children;
	};
	private void appendChild() {
		this.children.add(child);
		child.setParent(this);
	};
	private int countChildren() {
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
	private FSElement children(){
		return this.child;
	};
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