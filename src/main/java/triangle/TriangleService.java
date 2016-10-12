package triangle;

import org.springframework.stereotype.Service;

import triangle.dto.TriangleDto;

/**
 * Created by anna.kulikova on 11/10/2016.
 */
@Service
public class TriangleService {
    /**
     * Triangle types: EQUILATERAL, ISOSCELES or SCALENE
     */
    enum TRIANGLE {
        EQUILATERAL, ISOSCELES, SCALENE
    }

    /**
     * Computes triangle type by it sides lengths
     *
     * @param a positive number for the triangle side length
     * @param b positive number for the triangle side length
     * @param c positive number for the triangle side length
     * @return TriangleDto with message whether the triangle is EQUILATERAL, ISOSCELES or SCALENE
     * @throws IllegalArgumentException if sides are not positive
     * @throws NullPointerException     if sides are null
     * @see TriangleDto
     */
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
