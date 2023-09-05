package com.emailApi.Utility;

import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author Azo-hub
 * @github (https://github.com/Azo-hub)
 * @since 2020
 */

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CustomHttpResponse {
	
	protected String timeStamp;
	protected int statusCode;
	protected HttpStatus status;
	protected String message;
	protected String developerMessage;
	protected String path;
	protected String requestMethod;
	protected Map<?, ?> data;
	

}
