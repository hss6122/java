package bean;

public class PlaceMemberDTO {
	String id;
	String seatdayno;
	String title;
	String category;
	String price;
	String contents;
	String photo;
	String sale;
	String itemnum;
	String itemcode;
	String seatok;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSeatdayno() {
		return seatdayno;
	}
	public void setSeatdayno(String seatdayno) {
		this.seatdayno = seatdayno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public String getItemnum() {
		return itemnum;
	}
	public void setItemnum(String itemnum) {
		this.itemnum = itemnum;
	}
	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	public String getSeatok() {
		return seatok;
	}
	public void setSeatok(String seatok) {
		this.seatok = seatok;
	}
	@Override
	public String toString() {
		return "PlaceMemberDTO [id=" + id + ", seatdayno=" + seatdayno + ", title=" + title + ", category=" + category
				+ ", price=" + price + ", contents=" + contents + ", photo=" + photo + ", sale=" + sale + ", itemnum="
				+ itemnum + ", itemcode=" + itemcode + ", seatok=" + seatok + "]";
	}
	

	
}
