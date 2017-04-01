package com.citywalk.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 7944542256960862502L;//this id useful in serialization and deserialization process

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "order_by")
	private String orderBy;

	@Column(name = "ordered_product")
	private String orderedProduct;
	
	public Order() {
		super();
	}

	public Order(Integer id, String orderBy, String orderedProduct) {
		super();
		this.id = id;
		this.orderBy = orderBy;
		this.orderedProduct = orderedProduct;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrderedProduct() {
		return orderedProduct;
	}

	public void setOrderedProduct(String orderedProduct) {
		this.orderedProduct = orderedProduct;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + id + ", orderBy=" + orderBy + ", orderedProduct=" + orderedProduct + "]";
	}
}