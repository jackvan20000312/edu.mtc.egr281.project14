package project14;

public class UnknownColorException extends Exception {
	private static final long serialVersionUID = 1L;

public UnknownColorException() {
      super("Unknown Color!");
  }

  public UnknownColorException(String message) {
      super(message);
  }
}