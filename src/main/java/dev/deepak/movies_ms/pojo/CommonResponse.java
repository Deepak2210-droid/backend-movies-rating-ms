package dev.deepak.movies_ms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class CommonResponse {

	String status;
	String message;

}
