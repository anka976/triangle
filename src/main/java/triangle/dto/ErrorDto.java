package triangle.dto;

/**
 * Error dto for rest JSON
 * Created by anna.kulikova on 11/10/2016.
 */
public class ErrorDto {
    private String error;

    public ErrorDto(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
