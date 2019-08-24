package MidProject;

import java.util.ArrayList;

/**
 * @name : 나다윤
 * @date : 2019. 5. 7.
 * @description : dto 생성
 */

public class MovieDto {

	private int m_id;
	private String m_name;
	private int m_location;
	private int m_time;
	private String m_day;
	private int m_runningtime;
	private int num_of_people; // 5/10 - 이민호가 추가함
	private ArrayList<String> m_seat;

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public ArrayList<String> getM_seat() {
		return m_seat;
	}

	public int getNum_of_people() {
		return num_of_people;
	}

	public void setNum_of_people(int num_of_people) {
		this.num_of_people = num_of_people;
	}

	public void setM_seat(ArrayList<String> m_seat) {
		this.m_seat = m_seat;
	}

	public int getM_runningtime() {
		return m_runningtime;
	}

	public void setM_runningtime(int m_runningtime) {
		this.m_runningtime = m_runningtime;
	}

	@Override
	public String toString() {
		return "MovieDto [m_id=" + m_id + ", m_name=" + m_name + ", m_location=" + m_location + ", m_time=" + m_time
				+ ", m_day=" + m_day + ", m_runningtime=" + m_runningtime + ", m_seat=" + m_seat + "]";
	}

	public String getM_name() {
		return m_name;
	}

	public int getM_location() {
		return m_location;
	}

	public int getM_time() {
		return m_time;
	}

	public String getM_day() {
		return m_day;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public void setM_location(int m_location) {
		this.m_location = m_location;
	}

	public void setM_time(int m_time) {
		this.m_time = m_time;
	}

	public void setM_day(String m_day) {
		this.m_day = m_day;
	}

	public String getM_locationString() { // 이민호 2019.05.13 seat table 추가
		return Integer.toString(m_location);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof MovieDto) {
			MovieDto m = (MovieDto) obj;
			if (m.getM_day() == m_day)
				return true;
		}
		return false;
	}

}
