package ru.ugfeld.id.lec5.web.model.responses;

public class ErrorResponse extends Response{
	
	private String message;
	private int errorCode = -1;
	
	public ErrorResponse( )
	{
		setStatus( "fail" );
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
