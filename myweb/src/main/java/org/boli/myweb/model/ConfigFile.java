package org.boli.myweb.model;

public class ConfigFile {

	String username;

	String rolename;

	String fileName;

	String filePath;

	public ConfigFile() {
	}

	public ConfigFile(String username, String rolename, String fileName, String filePath) {
		this.username = username;
		this.rolename = rolename;
		this.fileName = fileName;
		this.filePath = filePath;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
