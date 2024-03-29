package com.tjpu.bean;


public class ClassroomModel  {
	private Integer id;
	private String num;
	private String roomname;
	private String roomplace;
	private String roomtype;
    private String roomcapacity;
    private String realcapacity;
    private String address;
    private String note;
    private Integer isavaible;
	private Integer deleted;
    public ClassroomModel(){}
    public ClassroomModel (Integer id, String num, String roomtype,String roomCapacity, String realCapacity){
    	this.id = id;
    	this.num = num;
    	this.roomcapacity = roomCapacity;
    	this.realcapacity = realCapacity;
    	this.roomtype = roomtype;
    }
    
    public ClassroomModel (Integer id, String num, String roomtype,String roomCapacity, String realCapacity, String address){
    	this.id = id;
    	this.num = num;
    	this.roomcapacity = roomCapacity;
    	this.realcapacity = realCapacity;
    	this.roomtype = roomtype;
    	this.address = address;
    }
    
	public String getRoomcapacity() {
		return roomcapacity;
	}

	public void setRoomcapacity(String roomcapacity) {
		this.roomcapacity = roomcapacity;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	
	public String getRoomname() {
		return this.roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	
	public String getRoomplace() {
		return this.roomplace;
	}

	public void setRoomplace(String roomplace) {
		this.roomplace = roomplace;
	}

	
	public String getRoomtype() {
		return this.roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getRealcapacity() {
		return realcapacity;
	}

	public void setRealcapacity(String realcapacity) {
		this.realcapacity = realcapacity;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getIsavaible() {
		return isavaible;
	}
	public void setIsavaible(Integer isavaible) {
		this.isavaible = isavaible;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

}