package triangle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import triangle.dto.ErrorDto;
import triangle.dto.TriangleDto;

/**
 * Rest controller
 * Created by anna.kulikova on 11/10/2016.
 */
@RestController
public class TriangleController {

    @Autowired
    TriangleService triangleService;

    /**
     * Computes triangle type by it sides lengths
     *
     * @param a positive number for the triangle side length
     * @param b positive number for the triangle side length
     * @param c positive number for the triangle side length
     * @return TriangleDto with message whether the triangle is EQUILATERAL, ISOSCELES or SCALENE
     * @throws NumberFormatException if a,b or c are not numbers
     * @see TriangleDto
     */
    @RequestMapping(value = "/triangle", method = RequestMethod.GET)
    public TriangleDto triangle(
            @RequestParam(name = "a", defaultValue = "0") Double a,
            @RequestParam(name = "b", defaultValue = "0") Double b,
            @RequestParam(name = "c", defaultValue = "0") Double c) {

        return triangleService.getTriangle(a, b, c);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public
    @ResponseBody
    ErrorDto handleInvalidInput(Exception ex) {
        return new ErrorDto(ex.getMessage());
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public
    @ResponseBody
    ErrorDto handleInvalidNumberFormat(Exception ex) {
        return new ErrorDto("Invalid number format! " + ex.getCause()
                .getMessage()
                .replaceAll("\"", "") + ". Use '.' as decimal separator");
    }
}
