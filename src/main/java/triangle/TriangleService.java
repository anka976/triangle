package triangle;

import org.springframework.stereotype.Service;

import triangle.dto.TriangleDto;

/**
 * Created by anna.kulikova on 11/10/2016.
 */
@Service
public class TriangleService {
    private enum TRIANGLE {EQUILATERAL, ISOSCELES, SCALENE}

    public TriangleDto getTriangle(Double a, Double b, Double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Triangle sides should be greater than zero");
        }

        int eqCounter = 0;
        String triangle = null;

        if (a.equals(b)) {
            eqCounter++;
        }

        if (b.equals(c)) {
            eqCounter++;
        }

        if (c.equals(a)) {
            eqCounter++;
        }

        switch (eqCounter) {
        case 1:
            triangle = TRIANGLE.ISOSCELES.name();
            break;
        case 2:
        case 3:
            triangle = TRIANGLE.EQUILATERAL.name();
            break;
        default:
            triangle = TRIANGLE.SCALENE.name();
            break;
        }

        return new TriangleDto(triangle);
    }
}
