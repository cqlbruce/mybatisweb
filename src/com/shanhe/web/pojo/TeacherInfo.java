package com.shanhe.web.pojo;

import java.util.List;

public class TeacherInfo {

    private String id ;

    private String name ;
    
    private List<StudentInfo> list ; 
    
    public List<StudentInfo> getList() {
		return list;
	}

	public void setList(List<StudentInfo> list) {
		this.list = list;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
