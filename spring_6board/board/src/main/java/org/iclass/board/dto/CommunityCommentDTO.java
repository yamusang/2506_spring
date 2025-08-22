package org.iclass.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommunityCommentDTO {
	private int idx;
	private int mref;
	private String writer;
	@NotBlank(message = "필수값입니다.")
	@Pattern(regexp = "^.{5,}$", message = "5글자 이상입니다.")
	private String content;
	// private Date createdAt; // 문자열 변환 출력 yyyy-MM-dd
	private String regDate;
	private String ip;

}
