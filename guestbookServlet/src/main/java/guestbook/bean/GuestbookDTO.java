package guestbook.bean;

import java.util.Date;

import lombok.Data;

@Data
public class GuestbookDTO {

	private String name;
	private String email;
	private String website;
	private String title;
	private String content;
	private int seq;
	private Date logtime;
}
