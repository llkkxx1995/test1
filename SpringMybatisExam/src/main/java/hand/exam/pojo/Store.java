package hand.exam.pojo;

import java.util.Date;

public class Store {
    private Byte store_id;

    private Byte manager_staffId;

    private Short address_id;

    private Date last_update;

	public Byte getStore_id() {
		return store_id;
	}

	public void setStore_id(Byte store_id) {
		this.store_id = store_id;
	}

	public Byte getManager_staffId() {
		return manager_staffId;
	}

	public void setManager_staffId(Byte manager_staffId) {
		this.manager_staffId = manager_staffId;
	}

	public Short getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Short address_id) {
		this.address_id = address_id;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

    
}