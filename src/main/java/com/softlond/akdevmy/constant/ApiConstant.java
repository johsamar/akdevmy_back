package com.softlond.akdevmy.constant;

public final class ApiConstant {

	//General REST verbs
	public static final String CREATE = "/create";
	public static final String FIND_BY_ID = "/findById/{id}";
	public static final String LIST = "/list";
	public static final String DELETE = "/delete/{id}";
	public static final String UPDATE = "/update/{id}";
	
    //Courses
    public static final String LIST_BY_NAME = "/search";
    
    //Modules
    public static final String ADD_CLASS = "/{moduleId}/class";
    public static final String DELETE_CLASS = "/{moduleId}/class/{classId}";
    public static final String UPDATE_CLASS = "/{moduleId}/class/{classId}";
}
