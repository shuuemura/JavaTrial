package jp.co.netprotections.dto;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@NotBlank
@Getter
@Setter
public class MemberJudgeRequestDto {
	private String memberName;
	private int eventPlanning;
	private int cogitation;
	private int coordination;
	private int programmingAbility;
	private int infrastructureKnowledge;
}
