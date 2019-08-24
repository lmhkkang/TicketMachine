package MidProject;

/**
 * @name : �̹�ȣ
 * @date : 2019. 5. 8.
 * @description : �����޴� DTO
 */

public class SnackDto {
	static final int popcornID = 1;
	static final int cokeID = 2;
	static final int hotDogID = 3;
	static final int beerID = 4;
	private int popcornAmount;
	private int hotdogAmount;
	private int cokeAmount;
	private int beerAmount;
	private int snackTotalCharge;

	// �⺻������
	public SnackDto() {
	}

	// ���� �ֵ��� �ݶ� ���� ������ �޴� ������
	public SnackDto(int popcornAmount, int hotdogAmount, int cokeAmount, int beerAmount) {
		this.popcornAmount = popcornAmount;
		this.hotdogAmount = hotdogAmount;
		this.cokeAmount = cokeAmount;
		this.beerAmount = beerAmount;
	}

	public int getPopcornAmount() {
		return popcornAmount;
	}

	public void setPopcornAmount(int popcornAmount) {
		this.popcornAmount = popcornAmount;
	}

	public int getHotdogAmount() {
		return hotdogAmount;
	}

	public void setHotdogAmount(int hotdogAmount) {
		this.hotdogAmount = hotdogAmount;
	}

	public int getCokeAmount() {
		return cokeAmount;
	}

	public void setCokeAmount(int cokeAmount) {
		this.cokeAmount = cokeAmount;
	}

	public int getBeerAmount() {
		return beerAmount;
	}

	public void setBeerAmount(int beerAmount) {
		this.beerAmount = beerAmount;
	}

	public int getSnackTotalCharge() {
		return snackTotalCharge;
	}

	public void setSnackTotalCharge(int snackTotalCharge) {
		this.snackTotalCharge = snackTotalCharge;
	}
}
