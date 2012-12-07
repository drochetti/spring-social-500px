package org.springframework.social.fivepx.api;

import lombok.Data;

@Data
public class OperationResult {

	private Integer status;

	private String message;

	private String error;

}
