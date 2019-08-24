package MidProject;

/**
 * @author KITRI
 * @name : 홍사명 @date : 2019. 5. 8.
 * @description : 조회관련 DTO
 */

public class TicketDto {

	private int tId;
	private String phone;
	private int numOfPeople;
	private int charge;
	private int mId;

	public TicketDto() {
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getPhone() {
		return phone;
	}

	public TicketDto(int tId, String phone, int numOfPeople, int charge, int mId) {

		this.tId = tId;
		this.phone = phone;
		this.numOfPeople = numOfPeople;
		this.charge = charge;
		this.mId = mId;
	}

	@Override
	public String toString() {
		return "TicketDto [tId=" + tId + ", phone=" + phone + ", numOfPeople=" + numOfPeople + ", charge=" + charge
				+ ", mId=" + mId + "]";
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getNumOfPeople() {
		return numOfPeople;
	}

	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}
}