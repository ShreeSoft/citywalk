package com.citywalk.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "service")
public class AppService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6322391305308594505L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "image_path")
	private String imagePath;
	
	@Column(name = "status")
	private Integer status;
	
	public AppService() {
		super();
	}

	public AppService(Integer id, String name, String imagePath, Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.imagePath = imagePath;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Service [serviceid=" + id + ", name=" + name + ", imagePath=" + imagePath + ", status=" + status + "]";
	}
	
	
	
	

}
