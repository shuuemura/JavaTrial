package jp.co.netprotections.dto;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class MemberJudgeResponseDto {
	private List<MemberJudgeResultDto> judgedCandidatesResultList;
}