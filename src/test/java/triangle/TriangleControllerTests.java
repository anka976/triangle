package triangle;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Test for TriangleController
 * Created by anna.kulikova on 11/10/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TriangleControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void noParamTriangleShouldThrowCustomError() throws Exception {
        this.mockMvc.perform(get("/triangle"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Triangle sides should be greater than zero"));
    }

    @Test
    public void zeroParamTriangleShouldThrowCustomError() throws Exception {
        this.mockMvc.perform(get("/triangle").param("a", "0").param("b", "1").param("c", "2"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Triangle sides should be greater than zero"));
    }

    @Test
    public void negativeParamTriangleShouldThrowCustomError() throws Exception {
        this.mockMvc.perform(get("/triangle").param("a", "-1").param("b", "1").param("c", "2"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Triangle sides should be greater than zero"));
    }

    @Test
    public void invalidParamTriangleShouldThrowCustomError() throws Exception {
        this.mockMvc.perform(get("/triangle").param("a", "1,6").param("b", "1").param("c", "2"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value(
                        "Invalid number format! For input string: 1,6. Use '.' as decimal separator"));
    }

    @Test
    public void paramTriangleShouldReturnOK() throws Exception {
        this.mockMvc.perform(get("/greeting").param("a", "16").param("b", "1").param("c", "2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
