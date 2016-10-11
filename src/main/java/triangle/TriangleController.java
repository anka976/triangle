package triangle;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import triangle.dto.ErrorDto;
import triangle.dto.TriangleDto;

/**
 * Created by anna.kulikova on 11/10/2016.
 */
@RestController
public class TriangleController {

    @Autowired
    TriangleService triangleService;

    @RequestMapping("/triangle")
    public TriangleDto triangle(
            @RequestParam(name = "a", defaultValue = "0") String a,
            @RequestParam(name = "b", defaultValue = "0") String b,
            @RequestParam(name = "c", defaultValue = "0") String c) throws ParseException {
        DecimalFormat formatter = (DecimalFormat) DecimalFormat.getInstance(Locale.US);

        return triangleService.getTriangle(
                formatter.parse(a).doubleValue(),
                formatter.parse(b).doubleValue(),
                formatter.parse(c).doubleValue());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public
    @ResponseBody
    ErrorDto handleInvalidInput(Exception ex) {
        return new ErrorDto(ex.getMessage());
    }

    @ExceptionHandler(ParseException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public
    @ResponseBody
    ErrorDto handleInvalidNumberFormat(Exception ex) {
        return new ErrorDto("Invalid number format! " + ex.getMessage() + " Use '.' as decimal separator");
    }
}
