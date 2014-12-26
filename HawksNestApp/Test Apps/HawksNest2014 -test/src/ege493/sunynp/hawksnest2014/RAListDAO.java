package ege493.sunynp.hawksnest2014;

import org.json.JSONObject;

public class RAListDAO {
	
	
	private int id;
	private String name;
	private String dorm;
	private String room;
	private String ext;
	
	public static RAListDAO fromJson(String json){
		RAListDAO dao = new RAListDAO();
		// extract values from JSON and set properties on dao
		return dao;
	}
	
	public JSONObject toJson(){
		JSONObject json = new JSONObject();
		// populate json data
		return json;
	}
	
	
	public RAListDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RAListDAO(int id, String name, String dorm, String room, String ext) {
		super();
		this.id = id;
		this.name = name;
		this.dorm = dorm;
		this.room = room;
		this.ext = ext;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDorm() {
		return dorm;
	}

	public void setDorm(String dorm) {
		this.dorm = dorm;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dorm == null) ? 0 : dorm.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RAListDAO other = (RAListDAO) obj;
		if (dorm == null) {
			if (other.dorm != null)
				return false;
		} else if (!dorm.equals(other.dorm))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RAListDAO [id=" + id + ", name=" + name + ", dorm=" + dorm
				+ ", room=" + room + ", ext=" + ext + "]";
	}
	
	
	

}
