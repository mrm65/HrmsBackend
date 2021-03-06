package kodlamaio.hrms.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertFilter {

	private List<Integer> cityId;
	private List<Integer> jobTitleId;
	private List<Integer> workTimeId;
	private List<Integer> workTypeId;
}
