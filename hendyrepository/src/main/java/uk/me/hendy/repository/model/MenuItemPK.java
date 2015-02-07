package uk.me.hendy.repository.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MenuItemPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String menuName;
	private int menuSeq;
	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}
	/**
	 * @param menuName the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * @return the menuSeq
	 */
	public int getMenuSeq() {
		return menuSeq;
	}
	/**
	 * @param menuSeq the menuSeq to set
	 */
	public void setMenuSeq(int menuSeq) {
		this.menuSeq = menuSeq;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result + menuSeq;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItemPK other = (MenuItemPK) obj;
		if (menuName == null) {
			if (other.menuName != null)
				return false;
		} else if (!menuName.equals(other.menuName))
			return false;
		if (menuSeq != other.menuSeq)
			return false;
		return true;
	}

}
