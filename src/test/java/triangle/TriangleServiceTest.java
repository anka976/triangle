package triangle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test for TriangleService
 * Created by anna.kulikova on 12/10/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TriangleServiceTest {
    @InjectMocks
    TriangleService triangleService;

    @Test
    public void getTriangle() {
        assertEquals(
                "Triangle should be EQUILATERAL",
                triangleService.getTriangle(1d, 1d, 1d).getMessage(),
                TriangleService.TRIANGLE.EQUILATERAL.name());
        assertEquals(
                "Triangle should be ISOSCELES",
                triangleService.getTriangle(1d, 1d, 2d).getMessage(),
                TriangleService.TRIANGLE.ISOSCELES.name());

        assertEquals(
                "Triangle should be ISOSCELES",
                triangleService.getTriangle(2d, 1d, 2d).getMessage(),
                TriangleService.TRIANGLE.ISOSCELES.name());

        assertEquals(
                "Triangle should be SCALENE",
                triangleService.getTriangle(2d, 1d, 3d).getMessage(),
                TriangleService.TRIANGLE.SCALENE.name());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTriangleShouldThrowErrorOnNegativeInput() {
        triangleService.getTriangle(1d, -1d, 1d).getMessage();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTriangleShouldThrowErrorOnZeroInput() {
        triangleService.getTriangle(1d, 1d, 0d).getMessage();
    }

    @Test(expected = NullPointerException.class)
    public void getTriangleShouldThrowErrorOnNullInput() {
        triangleService.getTriangle(1d, null, 0d).getMessage();
    }

}