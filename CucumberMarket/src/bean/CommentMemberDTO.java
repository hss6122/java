package bean;

public class CommentMemberDTO {
	String cs;
	String seller;
	String consumer;
	String comment;
	String score;
	
	public String getCs() {
		return cs;
	}
	public void setCs(String cs) {
		this.cs = cs;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getConsumer() {
		return consumer;
	}
	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "CommentMemberDTO [cs=" + cs + ", seller=" + seller + ", consumer=" + consumer + ", comment=" + comment
				+ ", score=" + score + "]";
	}

}
