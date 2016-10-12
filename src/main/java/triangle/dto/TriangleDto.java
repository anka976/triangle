package triangle.dto;

/**
 * Triangle type dto for rest service
 *
 * Created by anna.kulikova on 11/10/2016.
 */
public class TriangleDto {

    private String message;

    public TriangleDto(String message) {
        this.message = message;
    }

    /**
     * Triangle type description
     * @return String EQUILATERAL, ISOSCELES or SCALENE
     * @see triangle.TriangleService.TRIANGLE
     */
    public String getMessage() {
        return message;
    }
}
